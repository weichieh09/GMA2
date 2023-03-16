import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICerfImg } from '@/shared/model/cerf-img.model';
import CerfImgService from './cerf-img.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfImgDetails extends mixins(JhiDataUtils) {
  @Inject('cerfImgService') private cerfImgService: () => CerfImgService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfImg: ICerfImg = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfImgId) {
        vm.retrieveCerfImg(to.params.cerfImgId);
      }
    });
  }

  public retrieveCerfImg(cerfImgId) {
    this.cerfImgService()
      .find(cerfImgId)
      .then(res => {
        this.cerfImg = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
