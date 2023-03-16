import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMnfctrFee } from '@/shared/model/mnfctr-fee.model';
import MnfctrFeeService from './mnfctr-fee.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class MnfctrFeeDetails extends Vue {
  @Inject('mnfctrFeeService') private mnfctrFeeService: () => MnfctrFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public mnfctrFee: IMnfctrFee = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mnfctrFeeId) {
        vm.retrieveMnfctrFee(to.params.mnfctrFeeId);
      }
    });
  }

  public retrieveMnfctrFee(mnfctrFeeId) {
    this.mnfctrFeeService()
      .find(mnfctrFeeId)
      .then(res => {
        this.mnfctrFee = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
