import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IMnfctrFee, MnfctrFee } from '@/shared/model/mnfctr-fee.model';
import MnfctrFeeService from './mnfctr-fee.service';

const validations: any = {
  mnfctrFee: {
    fctyId: {},
    feeCd: {},
    feeDt: {},
    fee: {},
    curr: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class MnfctrFeeUpdate extends Vue {
  @Inject('mnfctrFeeService') private mnfctrFeeService: () => MnfctrFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public mnfctrFee: IMnfctrFee = new MnfctrFee();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mnfctrFeeId) {
        vm.retrieveMnfctrFee(to.params.mnfctrFeeId);
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
    if (this.mnfctrFee.id) {
      this.mnfctrFeeService()
        .update(this.mnfctrFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mnfctrFee.updated', { param: param.id });
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
      this.mnfctrFeeService()
        .create(this.mnfctrFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mnfctrFee.created', { param: param.id });
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

  public retrieveMnfctrFee(mnfctrFeeId): void {
    this.mnfctrFeeService()
      .find(mnfctrFeeId)
      .then(res => {
        this.mnfctrFee = res;
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
