import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerf2StdView } from '@/shared/model/cerf-2-std-view.model';
import Cerf2StdViewService from './cerf-2-std-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Cerf2StdViewDetails extends Vue {
  @Inject('cerf2StdViewService') private cerf2StdViewService: () => Cerf2StdViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf2StdView: ICerf2StdView = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerf2StdViewId) {
        vm.retrieveCerf2StdView(to.params.cerf2StdViewId);
      }
    });
  }

  public retrieveCerf2StdView(cerf2StdViewId) {
    this.cerf2StdViewService()
      .find(cerf2StdViewId)
      .then(res => {
        this.cerf2StdView = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
