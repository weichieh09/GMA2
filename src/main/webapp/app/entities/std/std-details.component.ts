import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStd } from '@/shared/model/std.model';
import StdService from './std.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class StdDetails extends Vue {
  @Inject('stdService') private stdService: () => StdService;
  @Inject('alertService') private alertService: () => AlertService;

  public std: IStd = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stdId) {
        vm.retrieveStd(to.params.stdId);
      }
    });
  }

  public retrieveStd(stdId) {
    this.stdService()
      .find(stdId)
      .then(res => {
        this.std = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
