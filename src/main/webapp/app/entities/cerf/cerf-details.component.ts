import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICerf } from '@/shared/model/cerf.model';
import CerfService from './cerf.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfDetails extends mixins(JhiDataUtils) {
  @Inject('cerfService') private cerfService: () => CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerf: ICerf = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfId) {
        vm.retrieveCerf(to.params.cerfId);
      }
    });
  }

  public retrieveCerf(cerfId) {
    this.cerfService()
      .find(cerfId)
      .then(res => {
        this.cerf = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
