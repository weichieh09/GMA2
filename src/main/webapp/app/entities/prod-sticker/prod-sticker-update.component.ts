import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import StickerService from '@/entities/sticker/sticker.service';
import { ISticker } from '@/shared/model/sticker.model';

import { IProdSticker, ProdSticker } from '@/shared/model/prod-sticker.model';
import ProdStickerService from './prod-sticker.service';

const validations: any = {
  prodSticker: {
    relType: {
      maxLength: maxLength(100),
    },
  },
};

@Component({
  validations,
})
export default class ProdStickerUpdate extends Vue {
  @Inject('prodStickerService') private prodStickerService: () => ProdStickerService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodSticker: IProdSticker = new ProdSticker();

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];

  @Inject('stickerService') private stickerService: () => StickerService;

  public stickers: ISticker[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodStickerId) {
        vm.retrieveProdSticker(to.params.prodStickerId);
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
  }

  public save(): void {
    this.isSaving = true;
    if (this.prodSticker.id) {
      this.prodStickerService()
        .update(this.prodSticker)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prodSticker.updated', { param: param.id });
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
      this.prodStickerService()
        .create(this.prodSticker)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prodSticker.created', { param: param.id });
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

  public retrieveProdSticker(prodStickerId): void {
    this.prodStickerService()
      .find(prodStickerId)
      .then(res => {
        this.prodSticker = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.prodService()
      .retrieve()
      .then(res => {
        this.prods = res.data;
      });
    this.stickerService()
      .retrieve()
      .then(res => {
        this.stickers = res.data;
      });
  }
}
