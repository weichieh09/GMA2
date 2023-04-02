import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';
import FeeProdCerfCompanyService from './fee-prod-cerf-company.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FeeProdCerfCompanyDetails extends Vue {
  @Inject('feeProdCerfCompanyService') private feeProdCerfCompanyService: () => FeeProdCerfCompanyService;
  @Inject('alertService') private alertService: () => AlertService;

  public feeProdCerfCompany: IFeeProdCerfCompany = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.feeProdCerfCompanyId) {
        vm.retrieveFeeProdCerfCompany(to.params.feeProdCerfCompanyId);
      }
    });
  }

  public retrieveFeeProdCerfCompany(feeProdCerfCompanyId) {
    this.feeProdCerfCompanyService()
      .find(feeProdCerfCompanyId)
      .then(res => {
        this.feeProdCerfCompany = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
