<template>
  <div>
    <h2 id="page-heading" data-cy="Cerf2ProdViewHeading">
      <span v-text="$t('gma2App.cerf2ProdView.home.title')" id="cerf-2-prod-view-heading">Cerf 2 Prod Views</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerf2ProdView.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerf2ProdViews && cerf2ProdViews.length === 0">
      <span v-text="$t('gma2App.cerf2ProdView.home.notFound')">No cerf2ProdViews found</span>
    </div>
    <div class="table-responsive" v-if="cerf2ProdViews && cerf2ProdViews.length > 0">
      <table class="table table-striped" aria-describedby="cerf2ProdViews">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerf2ProdView.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerf2ProdView.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.cerf2ProdView.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodNmCh')">
              <span v-text="$t('gma2App.cerf2ProdView.prodNmCh')">Prod Nm Ch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodNmCh'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerf2ProdView in cerf2ProdViews" :key="cerf2ProdView.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Cerf2ProdViewView', params: { cerf2ProdViewId: cerf2ProdView.id } }">{{
                cerf2ProdView.id
              }}</router-link>
            </td>
            <td>{{ cerf2ProdView.cerfNo }}</td>
            <td>{{ cerf2ProdView.cerfVer }}</td>
            <td>{{ cerf2ProdView.prodId }}</td>
            <td>{{ cerf2ProdView.prodNmCh }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'Cerf2ProdViewView', params: { cerf2ProdViewId: cerf2ProdView.id } }"
                  custom
                  v-slot="{ navigate }"
                >
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
        ><span id="gma2App.cerf2ProdView.delete.question" data-cy="cerf2ProdViewDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerf2ProdView-heading" v-text="$t('gma2App.cerf2ProdView.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf 2 Prod View?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerf2ProdView"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerf2ProdView()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerf2ProdViews && cerf2ProdViews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-prod-view.component.ts"></script>
