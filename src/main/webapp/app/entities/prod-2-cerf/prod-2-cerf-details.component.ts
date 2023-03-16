import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProd2Cerf } from '@/shared/model/prod-2-cerf.model';
import Prod2CerfService from './prod-2-cerf.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Prod2CerfDetails extends Vue {
  @Inject('prod2CerfService') private prod2CerfService: () => Prod2CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Cerf: IProd2Cerf = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2CerfId) {
        vm.retrieveProd2Cerf(to.params.prod2CerfId);
      }
    });
  }

  public retrieveProd2Cerf(prod2CerfId) {
    this.prod2CerfService()
      .find(prod2CerfId)
      .then(res => {
        this.prod2Cerf = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
