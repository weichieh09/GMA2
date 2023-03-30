<template>
  <div>
    <h2 id="page-heading" data-cy="FeeHeading">
      <span v-text="$t('gma2App.fee.home.title')" id="fee-heading">Fees</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.fee.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FeeCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-fee">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.fee.home.createLabel')"> Create a new Fee </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && fees && fees.length === 0">
      <span v-text="$t('gma2App.fee.home.notFound')">No fees found</span>
    </div>
    <div class="table-responsive" v-if="fees && fees.length > 0">
      <table class="table table-striped" aria-describedby="fees">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.fee.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeType')">
              <span v-text="$t('gma2App.fee.feeType')">Fee Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.fee.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prod.id')">
              <span v-text="$t('gma2App.fee.prod')">Prod</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prod.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerf.id')">
              <span v-text="$t('gma2App.fee.cerf')">Cerf</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerf.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('company.id')">
              <span v-text="$t('gma2App.fee.company')">Company</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'company.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="fee in fees" :key="fee.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FeeView', params: { feeId: fee.id } }">{{ fee.id }}</router-link>
            </td>
            <td>{{ fee.fee }}</td>
            <td>{{ fee.feeType }}</td>
            <td>{{ fee.feeDt }}</td>
            <td>
              <div v-if="fee.prod">
                <router-link :to="{ name: 'ProdView', params: { prodId: fee.prod.id } }">{{ fee.prod.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="fee.cerf">
                <router-link :to="{ name: 'CerfView', params: { cerfId: fee.cerf.id } }">{{ fee.cerf.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="fee.company">
                <router-link :to="{ name: 'CompanyView', params: { companyId: fee.company.id } }">{{ fee.company.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'FeeView', params: { feeId: fee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'FeeEdit', params: { feeId: fee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(fee)"
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
        ><span id="gma2App.fee.delete.question" data-cy="feeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-fee-heading" v-text="$t('gma2App.fee.delete.question', { id: removeId })">
          Are you sure you want to delete this Fee?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-fee"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFee()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="fees && fees.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./fee.component.ts"></script>
