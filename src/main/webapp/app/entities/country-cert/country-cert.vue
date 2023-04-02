<template>
  <div>
    <h2 id="page-heading" data-cy="CountryCertHeading">
      <span v-text="$t('gma2App.countryCert.home.title')" id="country-cert-heading">Country Certs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.countryCert.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CountryCertCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-country-cert"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.countryCert.home.createLabel')"> Create a new Country Cert </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && countryCerts && countryCerts.length === 0">
      <span v-text="$t('gma2App.countryCert.home.notFound')">No countryCerts found</span>
    </div>
    <div class="table-responsive" v-if="countryCerts && countryCerts.length > 0">
      <table class="table table-striped" aria-describedby="countryCerts">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('relType')">
              <span v-text="$t('gma2App.countryCert.relType')">Rel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'relType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('country.id')">
              <span v-text="$t('gma2App.countryCert.country')">Country</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'country.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerf.id')">
              <span v-text="$t('gma2App.countryCert.cerf')">Cerf</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerf.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="countryCert in countryCerts" :key="countryCert.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CountryCertView', params: { countryCertId: countryCert.id } }">{{ countryCert.id }}</router-link>
            </td>
            <td>{{ countryCert.relType }}</td>
            <td>
              <div v-if="countryCert.country">
                <router-link :to="{ name: 'CountryView', params: { countryId: countryCert.country.id } }">{{
                  countryCert.country.id
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="countryCert.cerf">
                <router-link :to="{ name: 'CerfView', params: { cerfId: countryCert.cerf.id } }">{{ countryCert.cerf.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CountryCertView', params: { countryCertId: countryCert.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CountryCertEdit', params: { countryCertId: countryCert.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(countryCert)"
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
        ><span id="gma2App.countryCert.delete.question" data-cy="countryCertDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-countryCert-heading" v-text="$t('gma2App.countryCert.delete.question', { id: removeId })">
          Are you sure you want to delete this Country Cert?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-countryCert"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCountryCert()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="countryCerts && countryCerts.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./country-cert.component.ts"></script>
