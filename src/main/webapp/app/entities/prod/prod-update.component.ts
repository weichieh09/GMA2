import { Component, Vue, Inject } from 'vue-property-decorator';

import { maxLength } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';

import ProdCountryService from '@/entities/prod-country/prod-country.service';
import { IProdCountry } from '@/shared/model/prod-country.model';

import ProdStdService from '@/entities/prod-std/prod-std.service';
import { IProdStd } from '@/shared/model/prod-std.model';

import CerfProdService from '@/entities/cerf-prod/cerf-prod.service';
import { ICerfProd } from '@/shared/model/cerf-prod.model';

import FeeProdCerfCompanyService from '@/entities/fee-prod-cerf-company/fee-prod-cerf-company.service';
import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';

import ProdStickerService from '@/entities/prod-sticker/prod-sticker.service';
import { IProdSticker } from '@/shared/model/prod-sticker.model';

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

  @Inject('prodCountryService') private prodCountryService: () => ProdCountryService;

  public prodCountries: IProdCountry[] = [];

  @Inject('prodStdService') private prodStdService: () => ProdStdService;

  public prodStds: IProdStd[] = [];

  @Inject('cerfProdService') private cerfProdService: () => CerfProdService;

  public cerfProds: ICerfProd[] = [];

  @Inject('feeProdCerfCompanyService') private feeProdCerfCompanyService: () => FeeProdCerfCompanyService;

  public feeProdCerfCompanies: IFeeProdCerfCompany[] = [];

  @Inject('prodStickerService') private prodStickerService: () => ProdStickerService;

  public prodStickers: IProdSticker[] = [];
  public isSaving = false;
  public currentLanguage = '';
  public prodStickerList = [];

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodId) {
        vm.retrieveProd(to.params.prodId);
      }
      // vm.initRelationships();
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
    this.prod.prodStickerList = this.prodStickerList;
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
        this.prodStickerList = res.prodStickerList;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.prodCountryService()
      .retrieve()
      .then(res => {
        this.prodCountries = res.data;
      });
    this.prodStdService()
      .retrieve()
      .then(res => {
        this.prodStds = res.data;
      });
    this.cerfProdService()
      .retrieve()
      .then(res => {
        this.cerfProds = res.data;
      });
    this.feeProdCerfCompanyService()
      .retrieve()
      .then(res => {
        this.feeProdCerfCompanies = res.data;
      });
    this.prodStickerService()
      .retrieve()
      .then(res => {
        this.prodStickers = res.data;
      });
  }

  public setPdfData(event, isImage): void {
    if (event && event.target.files && event.target.files[0]) {
      const file = event.target.files[0];
      if (isImage && !/^image\//.test(file.type)) {
        return;
      }
      this.toBase64(file, base64Data => {
        const prodSticker = {
          img: base64Data,
          imgContentType: file.type,
        };
        this.prodStickerList.push(prodSticker as never);
      });
    }
  }

  public toBase64(file, cb) {
    const fileReader = new FileReader();
    fileReader.readAsDataURL(file);
    fileReader.onload = (e: any) => {
      const base64Data = e.target.result.substring(e.target.result.indexOf('base64,') + 'base64,'.length);
      cb(base64Data);
    };
  }

  public openFile(contentType, data) {
    const byteCharacters = atob(data);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    const blob = new Blob([byteArray], {
      type: contentType,
    });
    const objectURL = URL.createObjectURL(blob);
    const win = window.open(objectURL);
    if (win) {
      win.onload = () => URL.revokeObjectURL(objectURL);
    }
  }

  public removeProdSticker(index) {
    this.prodStickerList.splice(index, 1);
  }
}
