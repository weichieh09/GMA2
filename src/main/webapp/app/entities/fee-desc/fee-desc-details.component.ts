import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFeeDesc } from '@/shared/model/fee-desc.model';
import FeeDescService from './fee-desc.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FeeDescDetails extends Vue {
  @Inject('feeDescService') private feeDescService: () => FeeDescService;
  @Inject('alertService') private alertService: () => AlertService;

  public feeDesc: IFeeDesc = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.feeDescId) {
        vm.retrieveFeeDesc(to.params.feeDescId);
      }
    });
  }

  public retrieveFeeDesc(feeDescId) {
    this.feeDescService()
      .find(feeDescId)
      .then(res => {
        this.feeDesc = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
