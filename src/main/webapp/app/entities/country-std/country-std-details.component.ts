import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICountryStd } from '@/shared/model/country-std.model';
import CountryStdService from './country-std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CountryStdDetails extends Vue {
  @Inject('countryStdService') private countryStdService: () => CountryStdService;
  @Inject('alertService') private alertService: () => AlertService;

  public countryStd: ICountryStd = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.countryStdId) {
        vm.retrieveCountryStd(to.params.countryStdId);
      }
    });
  }

  public retrieveCountryStd(countryStdId) {
    this.countryStdService()
      .find(countryStdId)
      .then(res => {
        this.countryStd = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
