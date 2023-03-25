import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import { IProdFee, ProdFee } from '@/shared/model/prod-fee.model';
import ProdFeeService from './prod-fee.service';

const validations: any = {
  prodFee: {
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
export default class ProdFeeUpdate extends Vue {
  @Inject('prodFeeService') private prodFeeService: () => ProdFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodFee: IProdFee = new ProdFee();

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodFeeId) {
        vm.retrieveProdFee(to.params.prodFeeId);
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
    if (this.prodFee.id) {
      this.prodFeeService()
        .update(this.prodFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prodFee.updated', { param: param.id });
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
      this.prodFeeService()
        .create(this.prodFee)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.prodFee.created', { param: param.id });
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

  public retrieveProdFee(prodFeeId): void {
    this.prodFeeService()
      .find(prodFeeId)
      .then(res => {
        this.prodFee = res;
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
  }
}
