<template>
  <div>
    <h2 id="page-heading" data-cy="ProdFeeHeading">
      <span v-text="$t('gma2App.prodFee.home.title')" id="prod-fee-heading">Prod Fees</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.prodFee.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProdFeeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-prod-fee"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.prodFee.home.createLabel')"> Create a new Prod Fee </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && prodFees && prodFees.length === 0">
      <span v-text="$t('gma2App.prodFee.home.notFound')">No prodFees found</span>
    </div>
    <div class="table-responsive" v-if="prodFees && prodFees.length > 0">
      <table class="table table-striped" aria-describedby="prodFees">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.prodFee.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeType')">
              <span v-text="$t('gma2App.prodFee.feeType')">Fee Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prod.id')">
              <span v-text="$t('gma2App.prodFee.prod')">Prod</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prod.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prodFee in prodFees" :key="prodFee.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProdFeeView', params: { prodFeeId: prodFee.id } }">{{ prodFee.id }}</router-link>
            </td>
            <td>{{ prodFee.fee }}</td>
            <td>{{ prodFee.feeType }}</td>
            <td>
              <div v-if="prodFee.prod">
                <router-link :to="{ name: 'ProdView', params: { prodId: prodFee.prod.id } }">{{ prodFee.prod.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProdFeeView', params: { prodFeeId: prodFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ProdFeeEdit', params: { prodFeeId: prodFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(prodFee)"
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
        ><span id="gma2App.prodFee.delete.question" data-cy="prodFeeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-prodFee-heading" v-text="$t('gma2App.prodFee.delete.question', { id: removeId })">
          Are you sure you want to delete this Prod Fee?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-prodFee"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProdFee()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="prodFees && prodFees.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-fee.component.ts"></script>
