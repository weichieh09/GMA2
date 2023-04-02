import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStickerMark } from '@/shared/model/sticker-mark.model';
import StickerMarkService from './sticker-mark.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class StickerMarkDetails extends Vue {
  @Inject('stickerMarkService') private stickerMarkService: () => StickerMarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public stickerMark: IStickerMark = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.stickerMarkId) {
        vm.retrieveStickerMark(to.params.stickerMarkId);
      }
    });
  }

  public retrieveStickerMark(stickerMarkId) {
    this.stickerMarkService()
      .find(stickerMarkId)
      .then(res => {
        this.stickerMark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
