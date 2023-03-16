import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IStsDesc } from '@/shared/model/sts-desc.model';
import StsDescService from './sts-desc.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class StsDescDetails extends mixins(JhiDataUtils) {
  @Inject('stsDescService') private stsDescService: () => StsDescService;
  @Inject('alertService') private alertService: () => AlertService;

  public stsDesc: IStsDesc = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stsDescId) {
        vm.retrieveStsDesc(to.params.stsDescId);
      }
    });
  }

  public retrieveStsDesc(stsDescId) {
    this.stsDescService()
      .find(stsDescId)
      .then(res => {
        this.stsDesc = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
