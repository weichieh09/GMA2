import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import AlertService from '@/shared/alert/alert.service';

import { ICerf, Cerf } from '@/shared/model/cerf.model';
import CerfService from './cerf.service';

const validations: any = {
  cerf: {
    cerfNo: {},
    cerfVer: {},
    areaCd: {},
    stsCd: {},
    applId: {},
    cerfTag: {},
    issuDt: {},
    cerfExpDt: {},
    remainDays: {},
    upldFile: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class CerfUpdate extends mixins(JhiDataUtils) {
  @Inject('cerfService') private cerfService: () => CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf: ICerf = new Cerf();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfId) {
        vm.retrieveCerf(to.params.cerfId);
      }
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
    if (this.cerf.id) {
      this.cerfService()
        .update(this.cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerf.updated', { param: param.id });
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
      this.cerfService()
        .create(this.cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerf.created', { param: param.id });
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

  public retrieveCerf(cerfId): void {
    this.cerfService()
      .find(cerfId)
      .then(res => {
        this.cerf = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
