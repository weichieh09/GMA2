import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerfFee } from '@/shared/model/cerf-fee.model';
import CerfFeeService from './cerf-fee.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfFeeDetails extends Vue {
  @Inject('cerfFeeService') private cerfFeeService: () => CerfFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfFee: ICerfFee = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfFeeId) {
        vm.retrieveCerfFee(to.params.cerfFeeId);
      }
    });
  }

  public retrieveCerfFee(cerfFeeId) {
    this.cerfFeeService()
      .find(cerfFeeId)
      .then(res => {
        this.cerfFee = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
