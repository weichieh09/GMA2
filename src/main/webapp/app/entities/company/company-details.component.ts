import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfCompanyService from '@/entities/cerf-company/cerf-company.service';
import { ICerfCompany } from '@/shared/model/cerf-company.model';

import FeeProdCerfCompanyService from '@/entities/fee-prod-cerf-company/fee-prod-cerf-company.service';
import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';

import { ICompany, Company } from '@/shared/model/company.model';
import CompanyService from './company.service';

const validations: any = {
  company: {
    companyNo: {
      maxLength: maxLength(20),
    },
    enName: {
      maxLength: maxLength(100),
    },
    chName: {
      maxLength: maxLength(100),
    },
    tel: {
      maxLength: maxLength(20),
    },
    addr: {
      maxLength: maxLength(100),
    },
    email: {
      maxLength: maxLength(50),
    },
  },
};

@Component({
  validations,
})
export default class CompanyUpdate extends Vue {
  @Inject('companyService') private companyService: () => CompanyService;
  @Inject('alertService') private alertService: () => AlertService;

  public company: ICompany = new Company();

  @Inject('cerfCompanyService') private cerfCompanyService: () => CerfCompanyService;

  public cerfCompanies: ICerfCompany[] = [];

  @Inject('feeProdCerfCompanyService') private feeProdCerfCompanyService: () => FeeProdCerfCompanyService;

  public feeProdCerfCompanies: IFeeProdCerfCompany[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.companyId) {
        vm.retrieveCompany(to.params.companyId);
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
    if (this.company.id) {
      this.companyService()
        .update(this.company)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.company.updated', { param: param.id });
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
      this.companyService()
        .create(this.company)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.company.created', { param: param.id });
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

  public retrieveCompany(companyId): void {
    this.companyService()
      .find(companyId)
      .then(res => {
        this.company = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    // this.cerfCompanyService()
    //   .retrieve()
    //   .then(res => {
    //     this.cerfCompanies = res.data;
    //   });
    // this.feeProdCerfCompanyService()
    //   .retrieve()
    //   .then(res => {
    //     this.feeProdCerfCompanies = res.data;
    //   });
  }
}
