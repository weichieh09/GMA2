import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMnfctr } from '@/shared/model/mnfctr.model';
import MnfctrService from './mnfctr.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class MnfctrDetails extends Vue {
  @Inject('mnfctrService') private mnfctrService: () => MnfctrService;
  @Inject('alertService') private alertService: () => AlertService;

  public mnfctr: IMnfctr = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mnfctrId) {
        vm.retrieveMnfctr(to.params.mnfctrId);
      }
    });
  }

  public retrieveMnfctr(mnfctrId) {
    this.mnfctrService()
      .find(mnfctrId)
      .then(res => {
        this.mnfctr = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
