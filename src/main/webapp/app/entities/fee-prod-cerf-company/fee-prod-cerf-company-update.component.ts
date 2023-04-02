import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import CompanyService from '@/entities/company/company.service';
import { ICompany } from '@/shared/model/company.model';

import { IFeeProdCerfCompany, FeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';
import FeeProdCerfCompanyService from './fee-prod-cerf-company.service';

const validations: any = {
  feeProdCerfCompany: {
    fee: {},
    feeType: {
      maxLength: maxLength(10),
    },
    feeDt: {},
  },
};

@Component({
  validations,
})
export default class FeeProdCerfCompanyUpdate extends Vue {
  @Inject('feeProdCerfCompanyService') private feeProdCerfCompanyService: () => FeeProdCerfCompanyService;
  @Inject('alertService') private alertService: () => AlertService;

  public feeProdCerfCompany: IFeeProdCerfCompany = new FeeProdCerfCompany();

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('companyService') private companyService: () => CompanyService;

  public companies: ICompany[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.feeProdCerfCompanyId) {
        vm.retrieveFeeProdCerfCompany(to.params.feeProdCerfCompanyId);
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
    if (this.feeProdCerfCompany.id) {
      this.feeProdCerfCompanyService()
        .update(this.feeProdCerfCompany)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.feeProdCerfCompany.updated', { param: param.id });
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
      this.feeProdCerfCompanyService()
        .create(this.feeProdCerfCompany)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.feeProdCerfCompany.created', { param: param.id });
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

  public retrieveFeeProdCerfCompany(feeProdCerfCompanyId): void {
    this.feeProdCerfCompanyService()
      .find(feeProdCerfCompanyId)
      .then(res => {
        this.feeProdCerfCompany = res;
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
