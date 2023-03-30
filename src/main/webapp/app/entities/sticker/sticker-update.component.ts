import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import MarkService from '@/entities/mark/mark.service';
import { IMark } from '@/shared/model/mark.model';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import { ISticker, Sticker } from '@/shared/model/sticker.model';
import StickerService from './sticker.service';

const validations: any = {
  sticker: {
    stickerNo: {
      maxLength: maxLength(20),
    },
    img: {},
  },
};

@Component({
  validations,
})
export default class StickerUpdate extends mixins(JhiDataUtils) {
  @Inject('stickerService') private stickerService: () => StickerService;
  @Inject('alertService') private alertService: () => AlertService;

  public sticker: ISticker = new Sticker();

  @Inject('markService') private markService: () => MarkService;

  public marks: IMark[] = [];

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stickerId) {
        vm.retrieveSticker(to.params.stickerId);
      }
      vm.initRelationships();
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
    this.sticker.marks = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.sticker.id) {
      this.stickerService()
        .update(this.sticker)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.sticker.updated', { param: param.id });
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
      this.stickerService()
        .create(this.sticker)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.sticker.created', { param: param.id });
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

  public retrieveSticker(stickerId): void {
    this.stickerService()
      .find(stickerId)
      .then(res => {
        this.sticker = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.sticker && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.sticker, field)) {
        this.sticker[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.sticker, fieldContentType)) {
        this.sticker[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {
    this.markService()
      .retrieve()
      .then(res => {
        this.marks = res.data;
      });
    this.prodService()
      .retrieve()
      .then(res => {
        this.prods = res.data;
      });
  }

  public getSelected(selectedVals, option): any {
    if (selectedVals) {
      return selectedVals.find(value => option.id === value.id) ?? option;
    }
    return option;
  }
}
