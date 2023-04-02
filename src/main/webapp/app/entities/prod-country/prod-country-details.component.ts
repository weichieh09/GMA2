import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProdCountry } from '@/shared/model/prod-country.model';
import ProdCountryService from './prod-country.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProdCountryDetails extends Vue {
  @Inject('prodCountryService') private prodCountryService: () => ProdCountryService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodCountry: IProdCountry = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodCountryId) {
        vm.retrieveProdCountry(to.params.prodCountryId);
      }
    });
  }

  public retrieveProdCountry(prodCountryId) {
    this.prodCountryService()
      .find(prodCountryId)
      .then(res => {
        this.prodCountry = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
