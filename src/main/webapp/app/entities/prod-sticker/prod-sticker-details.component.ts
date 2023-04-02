import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProdSticker } from '@/shared/model/prod-sticker.model';
import ProdStickerService from './prod-sticker.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ProdStickerDetails extends Vue {
  @Inject('prodStickerService') private prodStickerService: () => ProdStickerService;
  @Inject('alertService') private alertService: () => AlertService;

  public prodSticker: IProdSticker = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.prodStickerId) {
        vm.retrieveProdSticker(to.params.prodStickerId);
      }
    });
  }

  public retrieveProdSticker(prodStickerId) {
    this.prodStickerService()
      .find(prodStickerId)
      .then(res => {
        this.prodSticker = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
