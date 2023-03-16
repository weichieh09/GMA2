import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IStdFee, StdFee } from '@/shared/model/std-fee.model';
import StdFeeService from './std-fee.service';

const validations: any = {
  stdFee: {
    prodId: {},
    mnfctrId: {},
    stdNo: {},
    stdVer: {},
    stsCd: {},
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
export default class StdFeeUpdate extends Vue {
  @Inject('stdFeeService') private stdFeeService: () => StdFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public stdFee: IStdFee = new StdFee();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stdFeeId) {
        vm.retrieveStdFee(to.params.stdFeeId);
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
    if (this.stdFee.id) {
      this.stdFeeService()
        .update(this.stdFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.stdFee.updated', { param: param.id });
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
      this.stdFeeService()
        .create(this.stdFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.stdFee.created', { param: param.id });
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

  public retrieveStdFee(stdFeeId): void {
    this.stdFeeService()
      .find(stdFeeId)
      .then(res => {
        this.stdFee = res;
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
