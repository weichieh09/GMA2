import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import CompanyService from '@/entities/company/company.service';
import { ICompany } from '@/shared/model/company.model';

import { ICerfCompany, CerfCompany } from '@/shared/model/cerf-company.model';
import CerfCompanyService from './cerf-company.service';

const validations: any = {
  cerfCompany: {
    relType: {
      maxLength: maxLength(100),
    },
  },
};

@Component({
  validations,
})
export default class CerfCompanyUpdate extends Vue {
  @Inject('cerfCompanyService') private cerfCompanyService: () => CerfCompanyService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfCompany: ICerfCompany = new CerfCompany();

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('companyService') private companyService: () => CompanyService;

  public companies: ICompany[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfCompanyId) {
        vm.retrieveCerfCompany(to.params.cerfCompanyId);
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
    if (this.cerfCompany.id) {
      this.cerfCompanyService()
        .update(this.cerfCompany)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfCompany.updated', { param: param.id });
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
      this.cerfCompanyService()
        .create(this.cerfCompany)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.cerfCompany.created', { param: param.id });
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

  public retrieveCerfCompany(cerfCompanyId): void {
    this.cerfCompanyService()
      .find(cerfCompanyId)
      .then(res => {
        this.cerfCompany = res;
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
    this.companyService()
      .retrieve()
      .then(res => {
        this.companies = res.data;
      });
  }
}
