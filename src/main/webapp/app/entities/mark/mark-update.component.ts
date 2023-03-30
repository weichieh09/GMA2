import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CountryService from '@/entities/country/country.service';
import { ICountry } from '@/shared/model/country.model';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import StickerService from '@/entities/sticker/sticker.service';
import { ISticker } from '@/shared/model/sticker.model';

import { IMark, Mark } from '@/shared/model/mark.model';
import MarkService from './mark.service';

const validations: any = {
  mark: {
    markNo: {
      maxLength: maxLength(20),
    },
    enName: {
      maxLength: maxLength(100),
    },
    chName: {
      maxLength: maxLength(100),
    },
    img: {},
  },
};

@Component({
  validations,
})
export default class MarkUpdate extends mixins(JhiDataUtils) {
  @Inject('markService') private markService: () => MarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public mark: IMark = new Mark();

  @Inject('countryService') private countryService: () => CountryService;

  public countries: ICountry[] = [];

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('stickerService') private stickerService: () => StickerService;

  public stickers: ISticker[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.markId) {
        vm.retrieveMark(to.params.markId);
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
    if (this.mark.id) {
      this.markService()
        .update(this.mark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mark.updated', { param: param.id });
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
      this.markService()
        .create(this.mark)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.mark.created', { param: param.id });
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

  public retrieveMark(markId): void {
    this.markService()
      .find(markId)
      .then(res => {
        this.mark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.mark && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.mark, field)) {
        this.mark[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.mark, fieldContentType)) {
        this.mark[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {
    this.countryService()
      .retrieve()
      .then(res => {
        this.countries = res.data;
      });
    this.cerfService()
      .retrieve()
      .then(res => {
        this.cerfs = res.data;
      });
    this.stickerService()
      .retrieve()
      .then(res => {
        this.stickers = res.data;
      });
  }
}
