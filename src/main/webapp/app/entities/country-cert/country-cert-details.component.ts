import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICountryCert } from '@/shared/model/country-cert.model';
import CountryCertService from './country-cert.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CountryCertDetails extends Vue {
  @Inject('countryCertService') private countryCertService: () => CountryCertService;
  @Inject('alertService') private alertService: () => AlertService;

  public countryCert: ICountryCert = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.countryCertId) {
        vm.retrieveCountryCert(to.params.countryCertId);
      }
    });
  }

  public retrieveCountryCert(countryCertId) {
    this.countryCertService()
      .find(countryCertId)
      .then(res => {
        this.countryCert = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
