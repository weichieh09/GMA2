import { Component, Vue, Inject } from 'vue-property-decorator';

import { IWcc412View } from '@/shared/model/wcc-412-view.model';
import Wcc412ViewService from './wcc-412-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Wcc412ViewDetails extends Vue {
  @Inject('wcc412ViewService') private wcc412ViewService: () => Wcc412ViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public wcc412View: IWcc412View = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.wcc412ViewId) {
        vm.retrieveWcc412View(to.params.wcc412ViewId);
      }
    });
  }

  public retrieveWcc412View(wcc412ViewId) {
    this.wcc412ViewService()
      .find(wcc412ViewId)
      .then(res => {
        this.wcc412View = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
