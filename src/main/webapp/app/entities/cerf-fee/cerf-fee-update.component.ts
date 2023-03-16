import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { ICerfFee, CerfFee } from '@/shared/model/cerf-fee.model';
import CerfFeeService from './cerf-fee.service';

const validations: any = {
  cerfFee: {
    cerfNo: {},
    cerfVer: {},
    cerfTag: {},
    areaCd: {},
    applId: {},
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
export default class CerfFeeUpdate extends Vue {
  @Inject('cerfFeeService') private cerfFeeService: () => CerfFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfFee: ICerfFee = new CerfFee();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfFeeId) {
        vm.retrieveCerfFee(to.params.cerfFeeId);
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
    if (this.cerfFee.id) {
      this.cerfFeeService()
        .update(this.cerfFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfFee.updated', { param: param.id });
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
      this.cerfFeeService()
        .create(this.cerfFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfFee.created', { param: param.id });
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

  public retrieveCerfFee(cerfFeeId): void {
    this.cerfFeeService()
      .find(cerfFeeId)
      .then(res => {
        this.cerfFee = res;
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
