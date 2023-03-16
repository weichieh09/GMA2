import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IAreaDesc, AreaDesc } from '@/shared/model/area-desc.model';
import AreaDescService from './area-desc.service';

const validations: any = {
  areaDesc: {
    areaCd: {},
    areaDesc: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class AreaDescUpdate extends Vue {
  @Inject('areaDescService') private areaDescService: () => AreaDescService;
  @Inject('alertService') private alertService: () => AlertService;

  public areaDesc: IAreaDesc = new AreaDesc();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.areaDescId) {
        vm.retrieveAreaDesc(to.params.areaDescId);
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
    if (this.areaDesc.id) {
      this.areaDescService()
        .update(this.areaDesc)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.areaDesc.updated', { param: param.id });
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
      this.areaDescService()
        .create(this.areaDesc)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.areaDesc.created', { param: param.id });
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

  public retrieveAreaDesc(areaDescId): void {
    this.areaDescService()
      .find(areaDescId)
      .then(res => {
        this.areaDesc = res;
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
