import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IProd2Std, Prod2Std } from '@/shared/model/prod-2-std.model';
import Prod2StdService from './prod-2-std.service';

const validations: any = {
  prod2Std: {
    prodId: {},
    mnfctrId: {},
    stdNo: {},
    stdVer: {},
    stsCd: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class Prod2StdUpdate extends Vue {
  @Inject('prod2StdService') private prod2StdService: () => Prod2StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Std: IProd2Std = new Prod2Std();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2StdId) {
        vm.retrieveProd2Std(to.params.prod2StdId);
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
    if (this.prod2Std.id) {
      this.prod2StdService()
        .update(this.prod2Std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Std.updated', { param: param.id });
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
      this.prod2StdService()
        .create(this.prod2Std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod2Std.created', { param: param.id });
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

  public retrieveProd2Std(prod2StdId): void {
    this.prod2StdService()
      .find(prod2StdId)
      .then(res => {
        this.prod2Std = res;
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
