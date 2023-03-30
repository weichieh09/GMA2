import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IMark } from '@/shared/model/mark.model';
import MarkService from './mark.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class MarkDetails extends mixins(JhiDataUtils) {
  @Inject('markService') private markService: () => MarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public mark: IMark = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.markId) {
        vm.retrieveMark(to.params.markId);
      }
    });
  }

  public retrieveMark(markId) {
    this.markService()
      .find(markId)
      .then(res => {
        this.mark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
