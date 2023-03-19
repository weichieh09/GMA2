import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICerfSearchView } from '@/shared/model/cerf-search-view.model';
import CerfSearchViewService from './cerf-search-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfSearchViewDetails extends mixins(JhiDataUtils) {
  @Inject('cerfSearchViewService') private cerfSearchViewService: () => CerfSearchViewService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfSearchView: ICerfSearchView = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfSearchViewId) {
        vm.retrieveCerfSearchView(to.params.cerfSearchViewId);
      }
    });
  }

  public retrieveCerfSearchView(cerfSearchViewId) {
    this.cerfSearchViewService()
      .find(cerfSearchViewId)
      .then(res => {
        this.cerfSearchView = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
