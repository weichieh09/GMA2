import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IProd } from '@/shared/model/prod.model';

import ProdService from './prod.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Prod extends Vue {
  @Inject('prodService') private prodService: () => ProdService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public prods: IProd[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllProds();
  }

  public clear(): void {
    this.retrieveAllProds();
  }

  public retrieveAllProds(): void {
    this.isFetching = true;
    this.prodService()
      .retrieve()
      .then(
        res => {
          this.prods = res.data;
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

  public prepareRemove(instance: IProd): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeProd(): void {
    this.prodService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('gma2App.prod.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllProds();
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
