import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProd2Cerf, Prod2Cerf } from '@/shared/model/prod-2-cerf.model';
import Prod2CerfService from './prod-2-cerf.service';

const validations: any = {
  prod2Cerf: {
    prodId: {},
    mnfctrId: {},
    cerfNo: {},
    cerfVer: {},
    applId: {},
    areaCd: {},
    cerfTag: {},
    stsCd: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class Prod2CerfUpdate extends Vue {
  @Inject('prod2CerfService') private prod2CerfService: () => Prod2CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Cerf: IProd2Cerf = new Prod2Cerf();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2CerfId) {
        vm.retrieveProd2Cerf(to.params.prod2CerfId);
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
    if (this.prod2Cerf.id) {
      this.prod2CerfService()
        .update(this.prod2Cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Cerf.updated', { param: param.id });
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
      this.prod2CerfService()
        .create(this.prod2Cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Cerf.created', { param: param.id });
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

  public retrieveProd2Cerf(prod2CerfId): void {
    this.prod2CerfService()
      .find(prod2CerfId)
      .then(res => {
        this.prod2Cerf = res;
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
