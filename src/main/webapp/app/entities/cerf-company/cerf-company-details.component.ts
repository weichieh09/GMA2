import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICerfCompany } from '@/shared/model/cerf-company.model';
import CerfCompanyService from './cerf-company.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class CerfCompanyDetails extends Vue {
  @Inject('cerfCompanyService') private cerfCompanyService: () => CerfCompanyService;
  @Inject('alertService') private alertService: () => AlertService;

  public cerfCompany: ICerfCompany = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfCompanyId) {
        vm.retrieveCerfCompany(to.params.cerfCompanyId);
      }
    });
  }

  public retrieveCerfCompany(cerfCompanyId) {
    this.cerfCompanyService()
      .find(cerfCompanyId)
      .then(res => {
        this.cerfCompany = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
