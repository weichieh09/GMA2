import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICerf2MnfctrView } from '@/shared/model/cerf-2-mnfctr-view.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import Cerf2MnfctrViewService from './cerf-2-mnfctr-view.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Cerf2MnfctrView extends mixins(JhiDataUtils) {
  @Inject('cerf2MnfctrViewService') private cerf2MnfctrViewService: () => Cerf2MnfctrViewService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public cerf2MnfctrViews: ICerf2MnfctrView[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCerf2MnfctrViews();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllCerf2MnfctrViews();
  }

  public retrieveAllCerf2MnfctrViews(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.cerf2MnfctrViewService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.cerf2MnfctrViews = res.data;
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
    this.retrieveAllCerf2MnfctrViews();
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
