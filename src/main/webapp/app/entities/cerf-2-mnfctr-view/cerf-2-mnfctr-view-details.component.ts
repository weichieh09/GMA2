import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICerf2MnfctrView } from '@/shared/model/cerf-2-mnfctr-view.model';
import Cerf2MnfctrViewService from './cerf-2-mnfctr-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Cerf2MnfctrViewDetails extends mixins(JhiDataUtils) {
  @Inject('cerf2MnfctrViewService') private cerf2MnfctrViewService: () => Cerf2MnfctrViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf2MnfctrView: ICerf2MnfctrView = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerf2MnfctrViewId) {
        vm.retrieveCerf2MnfctrView(to.params.cerf2MnfctrViewId);
      }
    });
  }

  public retrieveCerf2MnfctrView(cerf2MnfctrViewId) {
    this.cerf2MnfctrViewService()
      .find(cerf2MnfctrViewId)
      .then(res => {
        this.cerf2MnfctrView = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
