import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import MarkService from '@/entities/mark/mark.service';
import { IMark } from '@/shared/model/mark.model';

import { ICerfMark, CerfMark } from '@/shared/model/cerf-mark.model';
import CerfMarkService from './cerf-mark.service';

const validations: any = {
  cerfMark: {
    relType: {
      maxLength: maxLength(100),
    },
  },
};

@Component({
  validations,
})
export default class CerfMarkUpdate extends Vue {
  @Inject('cerfMarkService') private cerfMarkService: () => CerfMarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfMark: ICerfMark = new CerfMark();

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('markService') private markService: () => MarkService;

  public marks: IMark[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfMarkId) {
        vm.retrieveCerfMark(to.params.cerfMarkId);
      }
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.cerfMark.id) {
      this.cerfMarkService()
        .update(this.cerfMark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfMark.updated', { param: param.id });
          return (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.cerfMarkService()
        .create(this.cerfMark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfMark.created', { param: param.id });
          (this.$root as any).$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveCerfMark(cerfMarkId): void {
    this.cerfMarkService()
      .find(cerfMarkId)
      .then(res => {
        this.cerfMark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.cerfService()
      .retrieve()
      .then(res => {
        this.cerfs = res.data;
      });
    this.markService()
      .retrieve()
      .then(res => {
        this.marks = res.data;
      });
  }
}
