import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import MarkService from '@/entities/mark/mark.service';
import { IMark } from '@/shared/model/mark.model';

import StdService from '@/entities/std/std.service';
import { IStd } from '@/shared/model/std.model';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import { ICountry, Country } from '@/shared/model/country.model';
import CountryService from './country.service';

const validations: any = {
  country: {
    countryNo: {
      maxLength: maxLength(10),
    },
    enName: {
      maxLength: maxLength(100),
    },
    chName: {
      maxLength: maxLength(100),
    },
  },
};

@Component({
  validations,
})
export default class CountryUpdate extends Vue {
  @Inject('countryService') private countryService: () => CountryService;
  @Inject('alertService') private alertService: () => AlertService;

  public country: ICountry = new Country();

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('markService') private markService: () => MarkService;

  public marks: IMark[] = [];

  @Inject('stdService') private stdService: () => StdService;

  public stds: IStd[] = [];

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.countryId) {
        vm.retrieveCountry(to.params.countryId);
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
    this.country.stds = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.country.id) {
      this.countryService()
        .update(this.country)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.country.updated', { param: param.id });
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
      this.countryService()
        .create(this.country)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.country.created', { param: param.id });
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

  public retrieveCountry(countryId): void {
    this.countryService()
      .find(countryId)
      .then(res => {
        this.country = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.cerfService()
      .retrieve()
      .then(res => {
        this.cerfs = res.data;
      });
    this.markService()
      .retrieve()
      .then(res => {
        this.marks = res.data;
      });
    this.stdService()
      .retrieve()
      .then(res => {
        this.stds = res.data;
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
