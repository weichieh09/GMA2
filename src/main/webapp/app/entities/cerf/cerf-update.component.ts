import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfProdService from '@/entities/cerf-prod/cerf-prod.service';
import { ICerfProd } from '@/shared/model/cerf-prod.model';

import CerfStdService from '@/entities/cerf-std/cerf-std.service';
import { ICerfStd } from '@/shared/model/cerf-std.model';

import CerfMarkService from '@/entities/cerf-mark/cerf-mark.service';
import { ICerfMark } from '@/shared/model/cerf-mark.model';

import CerfCompanyService from '@/entities/cerf-company/cerf-company.service';
import { ICerfCompany } from '@/shared/model/cerf-company.model';

import FeeProdCerfCompanyService from '@/entities/fee-prod-cerf-company/fee-prod-cerf-company.service';
import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';

import CountryCertService from '@/entities/country-cert/country-cert.service';
import { ICountryCert } from '@/shared/model/country-cert.model';

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

  @Inject('cerfProdService') private cerfProdService: () => CerfProdService;

  public cerfProds: ICerfProd[] = [];

  @Inject('cerfStdService') private cerfStdService: () => CerfStdService;

  public cerfStds: ICerfStd[] = [];

  @Inject('cerfMarkService') private cerfMarkService: () => CerfMarkService;

  public cerfMarks: ICerfMark[] = [];

  @Inject('cerfCompanyService') private cerfCompanyService: () => CerfCompanyService;

  public cerfCompanies: ICerfCompany[] = [];

  @Inject('feeProdCerfCompanyService') private feeProdCerfCompanyService: () => FeeProdCerfCompanyService;

  public feeProdCerfCompanies: IFeeProdCerfCompany[] = [];

  @Inject('countryCertService') private countryCertService: () => CountryCertService;

  public countryCerts: ICountryCert[] = [];
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
    this.cerfProdService()
      .retrieve()
      .then(res => {
        this.cerfProds = res.data;
      });
    this.cerfStdService()
      .retrieve()
      .then(res => {
        this.cerfStds = res.data;
      });
    this.cerfMarkService()
      .retrieve()
      .then(res => {
        this.cerfMarks = res.data;
      });
    this.cerfCompanyService()
      .retrieve()
      .then(res => {
        this.cerfCompanies = res.data;
      });
    this.feeProdCerfCompanyService()
      .retrieve()
      .then(res => {
        this.feeProdCerfCompanies = res.data;
      });
    this.countryCertService()
      .retrieve()
      .then(res => {
        this.countryCerts = res.data;
      });
  }
}
