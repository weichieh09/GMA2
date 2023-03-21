import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICerfView } from '@/shared/model/cerf-view.model';
import CerfViewService from './cerf-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfViewDetails extends mixins(JhiDataUtils) {
  @Inject('cerfViewService') private cerfViewService: () => CerfViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfView: ICerfView = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfViewId) {
        vm.retrieveCerfView(to.params.cerfViewId);
      }
    });
  }

  public retrieveCerfView(cerfViewId) {
    this.cerfViewService()
      .find(cerfViewId)
      .then(res => {
        this.cerfView = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
