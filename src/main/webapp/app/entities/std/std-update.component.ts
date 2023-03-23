import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import ProdService from '@/entities/prod/prod.service';
import { IProd } from '@/shared/model/prod.model';

import CerfService from '@/entities/cerf/cerf.service';
import { ICerf } from '@/shared/model/cerf.model';

import CountryService from '@/entities/country/country.service';
import { ICountry } from '@/shared/model/country.model';

import { IStd, Std } from '@/shared/model/std.model';
import StdService from './std.service';

const validations: any = {
  std: {
    stdNo: {},
    stdVer: {},
    name: {},
    status: {},
    fee: {},
    issuDt: {},
    expDt: {},
  },
};

@Component({
  validations,
})
export default class StdUpdate extends Vue {
  @Inject('stdService') private stdService: () => StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public std: IStd = new Std();

  @Inject('prodService') private prodService: () => ProdService;

  public prods: IProd[] = [];

  @Inject('cerfService') private cerfService: () => CerfService;

  public cerfs: ICerf[] = [];

  @Inject('countryService') private countryService: () => CountryService;

  public countries: ICountry[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stdId) {
        vm.retrieveStd(to.params.stdId);
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
    if (this.std.id) {
      this.stdService()
        .update(this.std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.std.updated', { param: param.id });
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
      this.stdService()
        .create(this.std)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('gma2App.std.created', { param: param.id });
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

  public retrieveStd(stdId): void {
    this.stdService()
      .find(stdId)
      .then(res => {
        this.std = res;
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
    this.countryService()
      .retrieve()
      .then(res => {
        this.countries = res.data;
      });
  }
}
