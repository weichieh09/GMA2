import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import AlertService from '@/shared/alert/alert.service';

import { ICerfImg, CerfImg } from '@/shared/model/cerf-img.model';
import CerfImgService from './cerf-img.service';

const validations: any = {
  cerfImg: {
    cerfTag: {},
    imageFile: {},
    lstMtnUsr: {},
    lstMtnDt: {},
  },
};

@Component({
  validations,
})
export default class CerfImgUpdate extends mixins(JhiDataUtils) {
  @Inject('cerfImgService') private cerfImgService: () => CerfImgService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfImg: ICerfImg = new CerfImg();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfImgId) {
        vm.retrieveCerfImg(to.params.cerfImgId);
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
    if (this.cerfImg.id) {
      this.cerfImgService()
        .update(this.cerfImg)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfImg.updated', { param: param.id });
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
      this.cerfImgService()
        .create(this.cerfImg)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfImg.created', { param: param.id });
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

  public retrieveCerfImg(cerfImgId): void {
    this.cerfImgService()
      .find(cerfImgId)
      .then(res => {
        this.cerfImg = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.cerfImg && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.cerfImg, field)) {
        this.cerfImg[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.cerfImg, fieldContentType)) {
        this.cerfImg[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
