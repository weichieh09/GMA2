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
  private sendStdId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public stds: IStd[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllStds();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllStds();
  }

  public retrieveAllStds(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.stdService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.stds = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
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

  public prepareSendMail(instance: IStd): void {
    this.sendStdId = instance.id;
    if (<any>this.$refs.sendMail) {
      (<any>this.$refs.sendMail).show();
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

  public sendStd(): void {
    const req = {
      stdId: this.sendStdId,
    };
    this.stdService()
      .sendMail(req)
      .then(() => {
        const message = 'MAIL 寄出成功';
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: '發送結果',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
        this.sendStdId = null;
        this.retrieveAllStds();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public sort(): Array<any> {
    const result = [this.propOrder + ',' + (this.reverse ? 'desc' : 'asc')];
    if (this.propOrder !== 'id') {
      result.push('id');
    }
    return result;
  }

  public loadPage(page: number): void {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  public transition(): void {
    this.retrieveAllStds();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
    (<any>this.$refs.sendMail).hide();
  }
}
