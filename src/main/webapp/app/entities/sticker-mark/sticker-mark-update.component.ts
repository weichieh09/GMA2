import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import StickerService from '@/entities/sticker/sticker.service';
import { ISticker } from '@/shared/model/sticker.model';

import MarkService from '@/entities/mark/mark.service';
import { IMark } from '@/shared/model/mark.model';

import { IStickerMark, StickerMark } from '@/shared/model/sticker-mark.model';
import StickerMarkService from './sticker-mark.service';

const validations: any = {
  stickerMark: {
    relType: {
      maxLength: maxLength(100),
    },
  },
};

@Component({
  validations,
})
export default class StickerMarkUpdate extends Vue {
  @Inject('stickerMarkService') private stickerMarkService: () => StickerMarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public stickerMark: IStickerMark = new StickerMark();

  @Inject('stickerService') private stickerService: () => StickerService;

  public stickers: ISticker[] = [];

  @Inject('markService') private markService: () => MarkService;

  public marks: IMark[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stickerMarkId) {
        vm.retrieveStickerMark(to.params.stickerMarkId);
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
    if (this.stickerMark.id) {
      this.stickerMarkService()
        .update(this.stickerMark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.stickerMark.updated', { param: param.id });
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
      this.stickerMarkService()
        .create(this.stickerMark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.stickerMark.created', { param: param.id });
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

  public retrieveStickerMark(stickerMarkId): void {
    this.stickerMarkService()
      .find(stickerMarkId)
      .then(res => {
        this.stickerMark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.stickerService()
      .retrieve()
      .then(res => {
        this.stickers = res.data;
      });
    this.markService()
      .retrieve()
      .then(res => {
        this.marks = res.data;
      });
  }
}
