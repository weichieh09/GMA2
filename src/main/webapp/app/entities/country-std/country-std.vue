<template>
  <div>
    <h2 id="page-heading" data-cy="CountryStdHeading">
      <span v-text="$t('gma2App.countryStd.home.title')" id="country-std-heading">Country Stds</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.countryStd.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CountryStdCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-country-std"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.countryStd.home.createLabel')"> Create a new Country Std </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && countryStds && countryStds.length === 0">
      <span v-text="$t('gma2App.countryStd.home.notFound')">No countryStds found</span>
    </div>
    <div class="table-responsive" v-if="countryStds && countryStds.length > 0">
      <table class="table table-striped" aria-describedby="countryStds">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('relType')">
              <span v-text="$t('gma2App.countryStd.relType')">Rel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'relType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('country.id')">
              <span v-text="$t('gma2App.countryStd.country')">Country</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'country.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('std.id')">
              <span v-text="$t('gma2App.countryStd.std')">Std</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'std.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="countryStd in countryStds" :key="countryStd.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CountryStdView', params: { countryStdId: countryStd.id } }">{{ countryStd.id }}</router-link>
            </td>
            <td>{{ countryStd.relType }}</td>
            <td>
              <div v-if="countryStd.country">
                <router-link :to="{ name: 'CountryView', params: { countryId: countryStd.country.id } }">{{
                  countryStd.country.id
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="countryStd.std">
                <router-link :to="{ name: 'StdView', params: { stdId: countryStd.std.id } }">{{ countryStd.std.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CountryStdView', params: { countryStdId: countryStd.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CountryStdEdit', params: { countryStdId: countryStd.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(countryStd)"
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
        ><span id="gma2App.countryStd.delete.question" data-cy="countryStdDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-countryStd-heading" v-text="$t('gma2App.countryStd.delete.question', { id: removeId })">
          Are you sure you want to delete this Country Std?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-countryStd"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCountryStd()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="countryStds && countryStds.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./country-std.component.ts"></script>
