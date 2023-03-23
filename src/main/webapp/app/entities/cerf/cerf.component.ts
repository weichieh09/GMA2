import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICerf } from '@/shared/model/cerf.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import CerfService from './cerf.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Cerf extends mixins(JhiDataUtils) {
  @Inject('cerfService') private cerfService: () => CerfService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public cerfs: ICerf[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCerfs();
  }

  public clear(): void {
    this.retrieveAllCerfs();
  }

  public retrieveAllCerfs(): void {
    this.isFetching = true;
    this.cerfService()
      .retrieve()
      .then(
        res => {
          this.cerfs = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: ICerf): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCerf(): void {
    this.cerfService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('gma2App.cerf.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCerfs();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
