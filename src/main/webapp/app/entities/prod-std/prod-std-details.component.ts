import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProdStd } from '@/shared/model/prod-std.model';
import ProdStdService from './prod-std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProdStdDetails extends Vue {
  @Inject('prodStdService') private prodStdService: () => ProdStdService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodStd: IProdStd = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodStdId) {
        vm.retrieveProdStd(to.params.prodStdId);
      }
    });
  }

  public retrieveProdStd(prodStdId) {
    this.prodStdService()
      .find(prodStdId)
      .then(res => {
        this.prodStd = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
