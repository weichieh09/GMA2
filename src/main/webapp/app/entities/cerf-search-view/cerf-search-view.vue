<template>
  <div>
    <h2 id="page-heading" data-cy="CerfSearchViewHeading">
      <span v-text="$t('gma2App.cerfSearchView.home.title')" id="cerf-search-view-heading">Cerf Search Views</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerfSearchView.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfSearchViews && cerfSearchViews.length === 0">
      <span v-text="$t('gma2App.cerfSearchView.home.notFound')">No cerfSearchViews found</span>
    </div>
    <div class="table-responsive" v-if="cerfSearchViews && cerfSearchViews.length > 0">
      <table class="table table-striped" aria-describedby="cerfSearchViews">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerfSearchView.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerfSearchView.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCd')">
              <span v-text="$t('gma2App.cerfSearchView.feeCd')">Fee Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDesc')">
              <span v-text="$t('gma2App.cerfSearchView.feeDesc')">Fee Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.cerfSearchView.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.cerfSearchView.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaDesc')">
              <span v-text="$t('gma2App.cerfSearchView.areaDesc')">Area Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.cerfSearchView.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsDesc')">
              <span v-text="$t('gma2App.cerfSearchView.stsDesc')">Sts Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.cerfSearchView.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrNmCh')">
              <span v-text="$t('gma2App.cerfSearchView.mnfctrNmCh')">Mnfctr Nm Ch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrNmCh'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.cerfSearchView.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrId')">
              <span v-text="$t('gma2App.cerfSearchView.mnfctrId')">Mnfctr Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fctyId')">
              <span v-text="$t('gma2App.cerfSearchView.fctyId')">Fcty Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fctyId'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerfSearchView in cerfSearchViews" :key="cerfSearchView.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfSearchViewView', params: { cerfSearchViewId: cerfSearchView.id } }">{{
                cerfSearchView.id
              }}</router-link>
            </td>
            <td>{{ cerfSearchView.cerfNo }}</td>
            <td>{{ cerfSearchView.cerfVer }}</td>
            <td>{{ cerfSearchView.feeCd }}</td>
            <td>{{ cerfSearchView.feeDesc }}</td>
            <td>{{ cerfSearchView.fee }}</td>
            <td>{{ cerfSearchView.areaCd }}</td>
            <td>{{ cerfSearchView.areaDesc }}</td>
            <td>{{ cerfSearchView.stsCd }}</td>
            <td>{{ cerfSearchView.stsDesc }}</td>
            <td>{{ cerfSearchView.applId }}</td>
            <td>{{ cerfSearchView.mnfctrNmCh }}</td>
            <td>{{ cerfSearchView.prodId }}</td>
            <td>{{ cerfSearchView.mnfctrId }}</td>
            <td>{{ cerfSearchView.fctyId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CerfSearchViewView', params: { cerfSearchViewId: cerfSearchView.id } }"
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
        ><span id="gma2App.cerfSearchView.delete.question" data-cy="cerfSearchViewDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerfSearchView-heading" v-text="$t('gma2App.cerfSearchView.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf Search View?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerfSearchView"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerfSearchView()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfSearchViews && cerfSearchViews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-search-view.component.ts"></script>
