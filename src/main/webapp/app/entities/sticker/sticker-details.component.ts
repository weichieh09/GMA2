import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISticker } from '@/shared/model/sticker.model';
import StickerService from './sticker.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class StickerDetails extends mixins(JhiDataUtils) {
  @Inject('stickerService') private stickerService: () => StickerService;
  @Inject('alertService') private alertService: () => AlertService;

  public sticker: ISticker = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stickerId) {
        vm.retrieveSticker(to.params.stickerId);
      }
    });
  }

  public retrieveSticker(stickerId) {
    this.stickerService()
      .find(stickerId)
      .then(res => {
        this.sticker = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
