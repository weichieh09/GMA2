<template>
  <div>
    <h2 id="page-heading" data-cy="FeeDescHeading">
      <span v-text="$t('gma2App.feeDesc.home.title')" id="fee-desc-heading">Fee Descs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.feeDesc.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FeeDescCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-fee-desc"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.feeDesc.home.createLabel')"> Create a new Fee Desc </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && feeDescs && feeDescs.length === 0">
      <span v-text="$t('gma2App.feeDesc.home.notFound')">No feeDescs found</span>
    </div>
    <div class="table-responsive" v-if="feeDescs && feeDescs.length > 0">
      <table class="table table-striped" aria-describedby="feeDescs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCd')">
              <span v-text="$t('gma2App.feeDesc.feeCd')">Fee Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDesc')">
              <span v-text="$t('gma2App.feeDesc.feeDesc')">Fee Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.feeDesc.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.feeDesc.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="feeDesc in feeDescs" :key="feeDesc.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FeeDescView', params: { feeDescId: feeDesc.id } }">{{ feeDesc.id }}</router-link>
            </td>
            <td>{{ feeDesc.feeCd }}</td>
            <td>{{ feeDesc.feeDesc }}</td>
            <td>{{ feeDesc.lstMtnUsr }}</td>
            <td>{{ feeDesc.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'FeeDescView', params: { feeDescId: feeDesc.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'FeeDescEdit', params: { feeDescId: feeDesc.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(feeDesc)"
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
        ><span id="gma2App.feeDesc.delete.question" data-cy="feeDescDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-feeDesc-heading" v-text="$t('gma2App.feeDesc.delete.question', { id: removeId })">
          Are you sure you want to delete this Fee Desc?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-feeDesc"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFeeDesc()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="feeDescs && feeDescs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./fee-desc.component.ts"></script>
