import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProd2Fcty, Prod2Fcty } from '@/shared/model/prod-2-fcty.model';
import Prod2FctyService from './prod-2-fcty.service';

const validations: any = {
  prod2Fcty: {
    prodId: {},
    mnfctrId: {},
    fctyId: {},
    inspectDt: {},
    discontinueFg: {},
    discontinueDesc: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class Prod2FctyUpdate extends Vue {
  @Inject('prod2FctyService') private prod2FctyService: () => Prod2FctyService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Fcty: IProd2Fcty = new Prod2Fcty();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2FctyId) {
        vm.retrieveProd2Fcty(to.params.prod2FctyId);
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
    if (this.prod2Fcty.id) {
      this.prod2FctyService()
        .update(this.prod2Fcty)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Fcty.updated', { param: param.id });
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
      this.prod2FctyService()
        .create(this.prod2Fcty)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Fcty.created', { param: param.id });
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

  public retrieveProd2Fcty(prod2FctyId): void {
    this.prod2FctyService()
      .find(prod2FctyId)
      .then(res => {
        this.prod2Fcty = res;
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
