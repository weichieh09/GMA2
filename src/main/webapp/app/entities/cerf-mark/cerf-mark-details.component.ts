import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerfMark } from '@/shared/model/cerf-mark.model';
import CerfMarkService from './cerf-mark.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfMarkDetails extends Vue {
  @Inject('cerfMarkService') private cerfMarkService: () => CerfMarkService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfMark: ICerfMark = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfMarkId) {
        vm.retrieveCerfMark(to.params.cerfMarkId);
      }
    });
  }

  public retrieveCerfMark(cerfMarkId) {
    this.cerfMarkService()
      .find(cerfMarkId)
      .then(res => {
        this.cerfMark = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
