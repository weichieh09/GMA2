import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProd2Std } from '@/shared/model/prod-2-std.model';
import Prod2StdService from './prod-2-std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Prod2StdDetails extends Vue {
  @Inject('prod2StdService') private prod2StdService: () => Prod2StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Std: IProd2Std = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2StdId) {
        vm.retrieveProd2Std(to.params.prod2StdId);
      }
    });
  }

  public retrieveProd2Std(prod2StdId) {
    this.prod2StdService()
      .find(prod2StdId)
      .then(res => {
        this.prod2Std = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
