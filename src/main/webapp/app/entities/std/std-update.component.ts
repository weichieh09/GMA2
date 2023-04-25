import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdStdService from '@/entities/prod-std/prod-std.service';
import { IProdStd } from '@/shared/model/prod-std.model';

import CerfStdService from '@/entities/cerf-std/cerf-std.service';
import { ICerfStd } from '@/shared/model/cerf-std.model';

import CountryStdService from '@/entities/country-std/country-std.service';
import { ICountryStd } from '@/shared/model/country-std.model';

import { IStd, Std } from '@/shared/model/std.model';
import StdService from './std.service';

const validations: any = {
  std: {
    stdNo: {
      maxLength: maxLength(20),
    },
    stdVer: {},
    enName: {},
    chName: {},
    status: {
      maxLength: maxLength(10),
    },
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

  @Inject('prodStdService') private prodStdService: () => ProdStdService;

  public prodStds: IProdStd[] = [];

  @Inject('cerfStdService') private cerfStdService: () => CerfStdService;

  public cerfStds: ICerfStd[] = [];

  @Inject('countryStdService') private countryStdService: () => CountryStdService;

  public countryStds: ICountryStd[] = [];
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
    this.prodStdService()
      .retrieve()
      .then(res => {
        this.prodStds = res.data;
      });
    this.cerfStdService()
      .retrieve()
      .then(res => {
        this.cerfStds = res.data;
      });
    this.countryStdService()
      .retrieve()
      .then(res => {
        this.countryStds = res.data;
      });
  }
}
