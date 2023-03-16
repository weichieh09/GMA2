import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStdFee } from '@/shared/model/std-fee.model';
import StdFeeService from './std-fee.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class StdFeeDetails extends Vue {
  @Inject('stdFeeService') private stdFeeService: () => StdFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public stdFee: IStdFee = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stdFeeId) {
        vm.retrieveStdFee(to.params.stdFeeId);
      }
    });
  }

  public retrieveStdFee(stdFeeId) {
    this.stdFeeService()
      .find(stdFeeId)
      .then(res => {
        this.stdFee = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
