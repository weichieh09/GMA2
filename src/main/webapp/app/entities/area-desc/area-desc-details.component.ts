import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAreaDesc } from '@/shared/model/area-desc.model';
import AreaDescService from './area-desc.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class AreaDescDetails extends Vue {
  @Inject('areaDescService') private areaDescService: () => AreaDescService;
  @Inject('alertService') private alertService: () => AlertService;

  public areaDesc: IAreaDesc = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.areaDescId) {
        vm.retrieveAreaDesc(to.params.areaDescId);
      }
    });
  }

  public retrieveAreaDesc(areaDescId) {
    this.areaDescService()
      .find(areaDescId)
      .then(res => {
        this.areaDesc = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
