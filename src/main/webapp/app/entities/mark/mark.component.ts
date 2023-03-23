import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMark } from '@/shared/model/mark.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import MarkService from './mark.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Mark extends mixins(JhiDataUtils) {
  @Inject('markService') private markService: () => MarkService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public marks: IMark[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMarks();
  }

  public clear(): void {
    this.retrieveAllMarks();
  }

  public retrieveAllMarks(): void {
    this.isFetching = true;
    this.markService()
      .retrieve()
      .then(
        res => {
          this.marks = res.data;
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

  public prepareRemove(instance: IMark): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeMark(): void {
    this.markService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('gma2App.mark.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllMarks();
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
