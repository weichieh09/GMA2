import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import CompanyService from '@/entities/company/company.service';
import { ICompany } from '@/shared/model/company.model';

import { IFee, Fee } from '@/shared/model/fee.model';
import FeeService from './fee.service';

const validations: any = {
  fee: {
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
export default class FeeUpdate extends Vue {
  @Inject('feeService') private feeService: () => FeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public fee: IFee = new Fee();

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
      if (to.params.feeId) {
        vm.retrieveFee(to.params.feeId);
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
    if (this.fee.id) {
      this.feeService()
        .update(this.fee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.fee.updated', { param: param.id });
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
      this.feeService()
        .create(this.fee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.fee.created', { param: param.id });
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

  public retrieveFee(feeId): void {
    this.feeService()
      .find(feeId)
      .then(res => {
        this.fee = res;
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
