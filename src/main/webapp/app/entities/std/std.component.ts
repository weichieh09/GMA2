import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IStd } from '@/shared/model/std.model';

import StdService from './std.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Std extends Vue {
  @Inject('stdService') private stdService: () => StdService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public stds: IStd[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllStds();
  }

  public clear(): void {
    this.retrieveAllStds();
  }

  public retrieveAllStds(): void {
    this.isFetching = true;
    this.stdService()
      .retrieve()
      .then(
        res => {
          this.stds = res.data;
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

  public prepareRemove(instance: IStd): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeStd(): void {
    this.stdService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('gma2App.std.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllStds();
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
