import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfCompanyService from '@/entities/cerf-company/cerf-company.service';
import { ICerfCompany } from '@/shared/model/cerf-company.model';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import StdService from '@/entities/std/std.service';
import { IStd } from '@/shared/model/std.model';

import CountryService from '@/entities/country/country.service';
import { ICountry } from '@/shared/model/country.model';

import { ICerf, Cerf } from '@/shared/model/cerf.model';
import CerfService from './cerf.service';

const validations: any = {
  cerf: {
    cerfNo: {
      maxLength: maxLength(30),
    },
    cerfVer: {
      maxLength: maxLength(20),
    },
    status: {
      maxLength: maxLength(10),
    },
    pdf: {},
    issuDt: {},
    expDt: {},
  },
};

@Component({
  validations,
})
export default class CerfUpdate extends mixins(JhiDataUtils) {
  @Inject('cerfService') private cerfService: () => CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf: ICerf = new Cerf();

  @Inject('cerfCompanyService') private cerfCompanyService: () => CerfCompanyService;

  public cerfCompanies: ICerfCompany[] = [];

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];

  @Inject('stdService') private stdService: () => StdService;

  public stds: IStd[] = [];

  @Inject('countryService') private countryService: () => CountryService;

  public countries: ICountry[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfId) {
        vm.retrieveCerf(to.params.cerfId);
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
    this.cerf.prods = [];
    this.cerf.stds = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.cerf.id) {
      this.cerfService()
        .update(this.cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerf.updated', { param: param.id });
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
      this.cerfService()
        .create(this.cerf)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerf.created', { param: param.id });
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

  public retrieveCerf(cerfId): void {
    this.cerfService()
      .find(cerfId)
      .then(res => {
        this.cerf = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.cerfCompanyService()
      .retrieve()
      .then(res => {
        this.cerfCompanies = res.data;
      });
    this.prodService()
      .retrieve()
      .then(res => {
        this.prods = res.data;
      });
    this.stdService()
      .retrieve()
      .then(res => {
        this.stds = res.data;
      });
    this.countryService()
      .retrieve()
      .then(res => {
        this.countries = res.data;
      });
  }

  public getSelected(selectedVals, option): any {
    if (selectedVals) {
      return selectedVals.find(value => option.id === value.id) ?? option;
    }
    return option;
  }
}
