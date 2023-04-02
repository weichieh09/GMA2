<template>
  <div>
    <h2 id="page-heading" data-cy="FeeProdCerfCompanyHeading">
      <span v-text="$t('gma2App.feeProdCerfCompany.home.title')" id="fee-prod-cerf-company-heading">Fee Prod Cerf Companies</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.feeProdCerfCompany.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FeeProdCerfCompanyCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-fee-prod-cerf-company"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.feeProdCerfCompany.home.createLabel')"> Create a new Fee Prod Cerf Company </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && feeProdCerfCompanies && feeProdCerfCompanies.length === 0">
      <span v-text="$t('gma2App.feeProdCerfCompany.home.notFound')">No feeProdCerfCompanies found</span>
    </div>
    <div class="table-responsive" v-if="feeProdCerfCompanies && feeProdCerfCompanies.length > 0">
      <table class="table table-striped" aria-describedby="feeProdCerfCompanies">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.feeProdCerfCompany.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeType')">
              <span v-text="$t('gma2App.feeProdCerfCompany.feeType')">Fee Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.feeProdCerfCompany.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prod.id')">
              <span v-text="$t('gma2App.feeProdCerfCompany.prod')">Prod</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prod.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerf.id')">
              <span v-text="$t('gma2App.feeProdCerfCompany.cerf')">Cerf</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerf.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('company.id')">
              <span v-text="$t('gma2App.feeProdCerfCompany.company')">Company</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'company.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="feeProdCerfCompany in feeProdCerfCompanies" :key="feeProdCerfCompany.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FeeProdCerfCompanyView', params: { feeProdCerfCompanyId: feeProdCerfCompany.id } }">{{
                feeProdCerfCompany.id
              }}</router-link>
            </td>
            <td>{{ feeProdCerfCompany.fee }}</td>
            <td>{{ feeProdCerfCompany.feeType }}</td>
            <td>{{ feeProdCerfCompany.feeDt }}</td>
            <td>
              <div v-if="feeProdCerfCompany.prod">
                <router-link :to="{ name: 'ProdView', params: { prodId: feeProdCerfCompany.prod.id } }">{{
                  feeProdCerfCompany.prod.id
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="feeProdCerfCompany.cerf">
                <router-link :to="{ name: 'CerfView', params: { cerfId: feeProdCerfCompany.cerf.id } }">{{
                  feeProdCerfCompany.cerf.id
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="feeProdCerfCompany.company">
                <router-link :to="{ name: 'CompanyView', params: { companyId: feeProdCerfCompany.company.id } }">{{
                  feeProdCerfCompany.company.id
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'FeeProdCerfCompanyView', params: { feeProdCerfCompanyId: feeProdCerfCompany.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'FeeProdCerfCompanyEdit', params: { feeProdCerfCompanyId: feeProdCerfCompany.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(feeProdCerfCompany)"
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
        ><span
          id="gma2App.feeProdCerfCompany.delete.question"
          data-cy="feeProdCerfCompanyDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-feeProdCerfCompany-heading" v-text="$t('gma2App.feeProdCerfCompany.delete.question', { id: removeId })">
          Are you sure you want to delete this Fee Prod Cerf Company?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-feeProdCerfCompany"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFeeProdCerfCompany()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="feeProdCerfCompanies && feeProdCerfCompanies.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./fee-prod-cerf-company.component.ts"></script>
