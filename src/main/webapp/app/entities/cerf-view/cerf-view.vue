<template>
  <div>
    <h2 id="page-heading" data-cy="CerfViewHeading">
      <span v-text="$t('gma2App.cerfView.home.title')" id="cerf-view-heading">Cerf Views</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerfView.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfViews && cerfViews.length === 0">
      <span v-text="$t('gma2App.cerfView.home.notFound')">No cerfViews found</span>
    </div>
    <div class="table-responsive" v-if="cerfViews && cerfViews.length > 0">
      <table class="table table-striped" aria-describedby="cerfViews">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerfView.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerfView.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.cerfView.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDesc')">
              <span v-text="$t('gma2App.cerfView.feeDesc')">Fee Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.cerfView.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('msg01')">
              <span v-text="$t('gma2App.cerfView.msg01')">Msg 01</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'msg01'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerfView in cerfViews" :key="cerfView.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfViewView', params: { cerfViewId: cerfView.id } }">{{ cerfView.id }}</router-link>
            </td>
            <td>{{ cerfView.cerfNo }}</td>
            <td>{{ cerfView.cerfVer }}</td>
            <td>{{ cerfView.feeDt }}</td>
            <td>{{ cerfView.feeDesc }}</td>
            <td>{{ cerfView.fee }}</td>
            <td>{{ cerfView.msg01 }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfViewView', params: { cerfViewId: cerfView.id } }" custom v-slot="{ navigate }">
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
        ><span id="gma2App.cerfView.delete.question" data-cy="cerfViewDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerfView-heading" v-text="$t('gma2App.cerfView.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf View?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerfView"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerfView()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfViews && cerfViews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-view.component.ts"></script>
