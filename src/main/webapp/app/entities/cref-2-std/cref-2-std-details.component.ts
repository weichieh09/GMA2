import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICref2Std } from '@/shared/model/cref-2-std.model';
import Cref2StdService from './cref-2-std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Cref2StdDetails extends Vue {
  @Inject('cref2StdService') private cref2StdService: () => Cref2StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public cref2Std: ICref2Std = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cref2StdId) {
        vm.retrieveCref2Std(to.params.cref2StdId);
      }
    });
  }

  public retrieveCref2Std(cref2StdId) {
    this.cref2StdService()
      .find(cref2StdId)
      .then(res => {
        this.cref2Std = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
