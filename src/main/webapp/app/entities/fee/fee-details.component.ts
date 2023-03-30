import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFee } from '@/shared/model/fee.model';
import FeeService from './fee.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FeeDetails extends Vue {
  @Inject('feeService') private feeService: () => FeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public fee: IFee = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.feeId) {
        vm.retrieveFee(to.params.feeId);
      }
    });
  }

  public retrieveFee(feeId) {
    this.feeService()
      .find(feeId)
      .then(res => {
        this.fee = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
