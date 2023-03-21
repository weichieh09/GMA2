import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICerf2ProdView } from '@/shared/model/cerf-2-prod-view.model';

import Cerf2ProdViewService from './cerf-2-prod-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Cerf2ProdView extends Vue {
  @Inject('cerf2ProdViewService') private cerf2ProdViewService: () => Cerf2ProdViewService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public cerf2ProdViews: ICerf2ProdView[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCerf2ProdViews();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllCerf2ProdViews();
  }

  public retrieveAllCerf2ProdViews(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.cerf2ProdViewService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.cerf2ProdViews = res.data;
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
    this.retrieveAllCerf2ProdViews();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
