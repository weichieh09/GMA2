import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IMnfctr, Mnfctr } from '@/shared/model/mnfctr.model';
import MnfctrService from './mnfctr.service';

const validations: any = {
  mnfctr: {
    uniNo: {},
    mnfctrNmEn: {},
    mnfctrNmCh: {},
    contact: {},
    eamil: {},
    addr: {},
    tel: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class MnfctrUpdate extends Vue {
  @Inject('mnfctrService') private mnfctrService: () => MnfctrService;
  @Inject('alertService') private alertService: () => AlertService;

  public mnfctr: IMnfctr = new Mnfctr();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mnfctrId) {
        vm.retrieveMnfctr(to.params.mnfctrId);
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
    if (this.mnfctr.id) {
      this.mnfctrService()
        .update(this.mnfctr)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mnfctr.updated', { param: param.id });
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
      this.mnfctrService()
        .create(this.mnfctr)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mnfctr.created', { param: param.id });
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

  public retrieveMnfctr(mnfctrId): void {
    this.mnfctrService()
      .find(mnfctrId)
      .then(res => {
        this.mnfctr = res;
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
