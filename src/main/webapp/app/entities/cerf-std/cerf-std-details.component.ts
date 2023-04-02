import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerfStd } from '@/shared/model/cerf-std.model';
import CerfStdService from './cerf-std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfStdDetails extends Vue {
  @Inject('cerfStdService') private cerfStdService: () => CerfStdService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfStd: ICerfStd = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfStdId) {
        vm.retrieveCerfStd(to.params.cerfStdId);
      }
    });
  }

  public retrieveCerfStd(cerfStdId) {
    this.cerfStdService()
      .find(cerfStdId)
      .then(res => {
        this.cerfStd = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
