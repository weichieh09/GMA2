import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { ICref2Std, Cref2Std } from '@/shared/model/cref-2-std.model';
import Cref2StdService from './cref-2-std.service';

const validations: any = {
  cref2Std: {
    cerfNo: {},
    cerfVer: {},
    areaCd: {},
    applId: {},
    cerfTag: {},
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
export default class Cref2StdUpdate extends Vue {
  @Inject('cref2StdService') private cref2StdService: () => Cref2StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public cref2Std: ICref2Std = new Cref2Std();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cref2StdId) {
        vm.retrieveCref2Std(to.params.cref2StdId);
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
    if (this.cref2Std.id) {
      this.cref2StdService()
        .update(this.cref2Std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cref2Std.updated', { param: param.id });
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
      this.cref2StdService()
        .create(this.cref2Std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cref2Std.created', { param: param.id });
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

  public retrieveCref2Std(cref2StdId): void {
    this.cref2StdService()
      .find(cref2StdId)
      .then(res => {
        this.cref2Std = res;
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
