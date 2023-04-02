import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICountryMark } from '@/shared/model/country-mark.model';
import CountryMarkService from './country-mark.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CountryMarkDetails extends Vue {
  @Inject('countryMarkService') private countryMarkService: () => CountryMarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public countryMark: ICountryMark = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.countryMarkId) {
        vm.retrieveCountryMark(to.params.countryMarkId);
      }
    });
  }

  public retrieveCountryMark(countryMarkId) {
    this.countryMarkService()
      .find(countryMarkId)
      .then(res => {
        this.countryMark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
