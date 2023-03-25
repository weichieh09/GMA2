import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdFeeService from '@/entities/prod-fee/prod-fee.service';
import { IProdFee } from '@/shared/model/prod-fee.model';

import CountryService from '@/entities/country/country.service';
import { ICountry } from '@/shared/model/country.model';

import StdService from '@/entities/std/std.service';
import { IStd } from '@/shared/model/std.model';

import MarkService from '@/entities/mark/mark.service';
import { IMark } from '@/shared/model/mark.model';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import { IProd, Prod } from '@/shared/model/prod.model';
import ProdService from './prod.service';

const validations: any = {
  prod: {
    prodNo: {
      maxLength: maxLength(30),
    },
    enName: {
      maxLength: maxLength(100),
    },
    chName: {
      maxLength: maxLength(100),
    },
    hsCode: {
      maxLength: maxLength(20),
    },
    cccCode: {
      maxLength: maxLength(20),
    },
  },
};

@Component({
  validations,
})
export default class ProdUpdate extends Vue {
  @Inject('prodService') private prodService: () => ProdService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod: IProd = new Prod();

  @Inject('prodFeeService') private prodFeeService: () => ProdFeeService;

  public prodFees: IProdFee[] = [];

  @Inject('countryService') private countryService: () => CountryService;

  public countries: ICountry[] = [];

  @Inject('stdService') private stdService: () => StdService;

  public stds: IStd[] = [];

  @Inject('markService') private markService: () => MarkService;

  public marks: IMark[] = [];

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodId) {
        vm.retrieveProd(to.params.prodId);
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
    this.prod.countries = [];
    this.prod.stds = [];
    this.prod.marks = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.prod.id) {
      this.prodService()
        .update(this.prod)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod.updated', { param: param.id });
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
      this.prodService()
        .create(this.prod)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prod.created', { param: param.id });
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

  public retrieveProd(prodId): void {
    this.prodService()
      .find(prodId)
      .then(res => {
        this.prod = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.prodFeeService()
      .retrieve()
      .then(res => {
        this.prodFees = res.data;
      });
    this.countryService()
      .retrieve()
      .then(res => {
        this.countries = res.data;
      });
    this.stdService()
      .retrieve()
      .then(res => {
        this.stds = res.data;
      });
    this.markService()
      .retrieve()
      .then(res => {
        this.marks = res.data;
      });
    this.cerfService()
      .retrieve()
      .then(res => {
        this.cerfs = res.data;
      });
  }

  public getSelected(selectedVals, option): any {
    if (selectedVals) {
      return selectedVals.find(value => option.id === value.id) ?? option;
    }
    return option;
  }
}
