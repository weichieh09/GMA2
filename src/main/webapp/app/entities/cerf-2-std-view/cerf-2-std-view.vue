<template>
  <div>
    <h2 id="page-heading" data-cy="Cerf2StdViewHeading">
      <span v-text="$t('gma2App.cerf2StdView.home.title')" id="cerf-2-std-view-heading">Cerf 2 Std Views</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerf2StdView.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerf2StdViews && cerf2StdViews.length === 0">
      <span v-text="$t('gma2App.cerf2StdView.home.notFound')">No cerf2StdViews found</span>
    </div>
    <div class="table-responsive" v-if="cerf2StdViews && cerf2StdViews.length > 0">
      <table class="table table-striped" aria-describedby="cerf2StdViews">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerf2StdView.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerf2StdView.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdNo')">
              <span v-text="$t('gma2App.cerf2StdView.stdNo')">Std No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdVer')">
              <span v-text="$t('gma2App.cerf2StdView.stdVer')">Std Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdVer'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerf2StdView in cerf2StdViews" :key="cerf2StdView.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Cerf2StdViewView', params: { cerf2StdViewId: cerf2StdView.id } }">{{
                cerf2StdView.id
              }}</router-link>
            </td>
            <td>{{ cerf2StdView.cerfNo }}</td>
            <td>{{ cerf2StdView.cerfVer }}</td>
            <td>{{ cerf2StdView.stdNo }}</td>
            <td>{{ cerf2StdView.stdVer }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'Cerf2StdViewView', params: { cerf2StdViewId: cerf2StdView.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="gma2App.cerf2StdView.delete.question" data-cy="cerf2StdViewDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerf2StdView-heading" v-text="$t('gma2App.cerf2StdView.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf 2 Std View?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerf2StdView"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerf2StdView()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerf2StdViews && cerf2StdViews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-std-view.component.ts"></script>
