import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerf2ProdView } from '@/shared/model/cerf-2-prod-view.model';
import Cerf2ProdViewService from './cerf-2-prod-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Cerf2ProdViewDetails extends Vue {
  @Inject('cerf2ProdViewService') private cerf2ProdViewService: () => Cerf2ProdViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf2ProdView: ICerf2ProdView = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerf2ProdViewId) {
        vm.retrieveCerf2ProdView(to.params.cerf2ProdViewId);
      }
    });
  }

  public retrieveCerf2ProdView(cerf2ProdViewId) {
    this.cerf2ProdViewService()
      .find(cerf2ProdViewId)
      .then(res => {
        this.cerf2ProdView = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
