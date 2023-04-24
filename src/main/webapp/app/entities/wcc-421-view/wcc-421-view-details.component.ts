import { Component, Vue, Inject } from 'vue-property-decorator';

import { IWcc421View } from '@/shared/model/wcc-421-view.model';
import Wcc421ViewService from './wcc-421-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Wcc421ViewDetails extends Vue {
  @Inject('wcc421ViewService') private wcc421ViewService: () => Wcc421ViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public wcc421View: IWcc421View = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.wcc421ViewId) {
        vm.retrieveWcc421View(to.params.wcc421ViewId);
      }
    });
  }

  public retrieveWcc421View(wcc421ViewId) {
    this.wcc421ViewService()
      .find(wcc421ViewId)
      .then(res => {
        this.wcc421View = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
