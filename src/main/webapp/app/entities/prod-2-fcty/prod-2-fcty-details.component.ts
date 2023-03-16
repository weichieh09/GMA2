import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IProd2Fcty } from '@/shared/model/prod-2-fcty.model';
import Prod2FctyService from './prod-2-fcty.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class Prod2FctyDetails extends mixins(JhiDataUtils) {
  @Inject('prod2FctyService') private prod2FctyService: () => Prod2FctyService;
  @Inject('alertService') private alertService: () => AlertService;

  public prod2Fcty: IProd2Fcty = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prod2FctyId) {
        vm.retrieveProd2Fcty(to.params.prod2FctyId);
      }
    });
  }

  public retrieveProd2Fcty(prod2FctyId) {
    this.prod2FctyService()
      .find(prod2FctyId)
      .then(res => {
        this.prod2Fcty = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
