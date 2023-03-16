<template>
  <div>
    <h2 id="page-heading" data-cy="MnfctrFeeHeading">
      <span v-text="$t('gma2App.mnfctrFee.home.title')" id="mnfctr-fee-heading">Mnfctr Fees</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.mnfctrFee.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'MnfctrFeeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-mnfctr-fee"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.mnfctrFee.home.createLabel')"> Create a new Mnfctr Fee </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && mnfctrFees && mnfctrFees.length === 0">
      <span v-text="$t('gma2App.mnfctrFee.home.notFound')">No mnfctrFees found</span>
    </div>
    <div class="table-responsive" v-if="mnfctrFees && mnfctrFees.length > 0">
      <table class="table table-striped" aria-describedby="mnfctrFees">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fctyId')">
              <span v-text="$t('gma2App.mnfctrFee.fctyId')">Fcty Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fctyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCd')">
              <span v-text="$t('gma2App.mnfctrFee.feeCd')">Fee Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.mnfctrFee.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.mnfctrFee.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('curr')">
              <span v-text="$t('gma2App.mnfctrFee.curr')">Curr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'curr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.mnfctrFee.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.mnfctrFee.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mnfctrFee in mnfctrFees" :key="mnfctrFee.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MnfctrFeeView', params: { mnfctrFeeId: mnfctrFee.id } }">{{ mnfctrFee.id }}</router-link>
            </td>
            <td>{{ mnfctrFee.fctyId }}</td>
            <td>{{ mnfctrFee.feeCd }}</td>
            <td>{{ mnfctrFee.feeDt }}</td>
            <td>{{ mnfctrFee.fee }}</td>
            <td>{{ mnfctrFee.curr }}</td>
            <td>{{ mnfctrFee.lstMtnUsr }}</td>
            <td>{{ mnfctrFee.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MnfctrFeeView', params: { mnfctrFeeId: mnfctrFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'MnfctrFeeEdit', params: { mnfctrFeeId: mnfctrFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mnfctrFee)"
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
        ><span id="gma2App.mnfctrFee.delete.question" data-cy="mnfctrFeeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-mnfctrFee-heading" v-text="$t('gma2App.mnfctrFee.delete.question', { id: removeId })">
          Are you sure you want to delete this Mnfctr Fee?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-mnfctrFee"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMnfctrFee()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="mnfctrFees && mnfctrFees.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./mnfctr-fee.component.ts"></script>
