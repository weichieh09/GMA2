import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerfProd } from '@/shared/model/cerf-prod.model';
import CerfProdService from './cerf-prod.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfProdDetails extends Vue {
  @Inject('cerfProdService') private cerfProdService: () => CerfProdService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfProd: ICerfProd = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfProdId) {
        vm.retrieveCerfProd(to.params.cerfProdId);
      }
    });
  }

  public retrieveCerfProd(cerfProdId) {
    this.cerfProdService()
      .find(cerfProdId)
      .then(res => {
        this.cerfProd = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
