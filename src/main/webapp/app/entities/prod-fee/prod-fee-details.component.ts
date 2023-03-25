import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProdFee } from '@/shared/model/prod-fee.model';
import ProdFeeService from './prod-fee.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProdFeeDetails extends Vue {
  @Inject('prodFeeService') private prodFeeService: () => ProdFeeService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodFee: IProdFee = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodFeeId) {
        vm.retrieveProdFee(to.params.prodFeeId);
      }
    });
  }

  public retrieveProdFee(prodFeeId) {
    this.prodFeeService()
      .find(prodFeeId)
      .then(res => {
        this.prodFee = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
