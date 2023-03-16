<template>
  <div>
    <h2 id="page-heading" data-cy="StdFeeHeading">
      <span v-text="$t('gma2App.stdFee.home.title')" id="std-fee-heading">Std Fees</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.stdFee.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'StdFeeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-std-fee"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.stdFee.home.createLabel')"> Create a new Std Fee </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && stdFees && stdFees.length === 0">
      <span v-text="$t('gma2App.stdFee.home.notFound')">No stdFees found</span>
    </div>
    <div class="table-responsive" v-if="stdFees && stdFees.length > 0">
      <table class="table table-striped" aria-describedby="stdFees">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.stdFee.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrId')">
              <span v-text="$t('gma2App.stdFee.mnfctrId')">Mnfctr Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdNo')">
              <span v-text="$t('gma2App.stdFee.stdNo')">Std No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdVer')">
              <span v-text="$t('gma2App.stdFee.stdVer')">Std Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.stdFee.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCd')">
              <span v-text="$t('gma2App.stdFee.feeCd')">Fee Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.stdFee.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.stdFee.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('curr')">
              <span v-text="$t('gma2App.stdFee.curr')">Curr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'curr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.stdFee.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.stdFee.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="stdFee in stdFees" :key="stdFee.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'StdFeeView', params: { stdFeeId: stdFee.id } }">{{ stdFee.id }}</router-link>
            </td>
            <td>{{ stdFee.prodId }}</td>
            <td>{{ stdFee.mnfctrId }}</td>
            <td>{{ stdFee.stdNo }}</td>
            <td>{{ stdFee.stdVer }}</td>
            <td>{{ stdFee.stsCd }}</td>
            <td>{{ stdFee.feeCd }}</td>
            <td>{{ stdFee.feeDt }}</td>
            <td>{{ stdFee.fee }}</td>
            <td>{{ stdFee.curr }}</td>
            <td>{{ stdFee.lstMtnUsr }}</td>
            <td>{{ stdFee.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'StdFeeView', params: { stdFeeId: stdFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'StdFeeEdit', params: { stdFeeId: stdFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(stdFee)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="gma2App.stdFee.delete.question" data-cy="stdFeeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-stdFee-heading" v-text="$t('gma2App.stdFee.delete.question', { id: removeId })">
          Are you sure you want to delete this Std Fee?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-stdFee"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeStdFee()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="stdFees && stdFees.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./std-fee.component.ts"></script>
