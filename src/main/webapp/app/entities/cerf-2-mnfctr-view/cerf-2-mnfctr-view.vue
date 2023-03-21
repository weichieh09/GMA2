<template>
  <div>
    <h2 id="page-heading" data-cy="Cerf2MnfctrViewHeading">
      <span v-text="$t('gma2App.cerf2MnfctrView.home.title')" id="cerf-2-mnfctr-view-heading">Cerf 2 Mnfctr Views</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerf2MnfctrView.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerf2MnfctrViews && cerf2MnfctrViews.length === 0">
      <span v-text="$t('gma2App.cerf2MnfctrView.home.notFound')">No cerf2MnfctrViews found</span>
    </div>
    <div class="table-responsive" v-if="cerf2MnfctrViews && cerf2MnfctrViews.length > 0">
      <table class="table table-striped" aria-describedby="cerf2MnfctrViews">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerf2MnfctrView.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerf2MnfctrView.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('area')">
              <span v-text="$t('gma2App.cerf2MnfctrView.area')">Area</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'area'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sts')">
              <span v-text="$t('gma2App.cerf2MnfctrView.sts')">Sts</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sts'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('issuDt')">
              <span v-text="$t('gma2App.cerf2MnfctrView.issuDt')">Issu Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'issuDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('remainDays')">
              <span v-text="$t('gma2App.cerf2MnfctrView.remainDays')">Remain Days</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remainDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.cerf2MnfctrView.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrNmCh')">
              <span v-text="$t('gma2App.cerf2MnfctrView.mnfctrNmCh')">Mnfctr Nm Ch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrNmCh'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upldFile')">
              <span v-text="$t('gma2App.cerf2MnfctrView.upldFile')">Upld File</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upldFile'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imageFile')">
              <span v-text="$t('gma2App.cerf2MnfctrView.imageFile')">Image File</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imageFile'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.cerf2MnfctrView.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.cerf2MnfctrView.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerf2MnfctrView in cerf2MnfctrViews" :key="cerf2MnfctrView.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Cerf2MnfctrViewView', params: { cerf2MnfctrViewId: cerf2MnfctrView.id } }">{{
                cerf2MnfctrView.id
              }}</router-link>
            </td>
            <td>{{ cerf2MnfctrView.cerfNo }}</td>
            <td>{{ cerf2MnfctrView.cerfVer }}</td>
            <td>{{ cerf2MnfctrView.area }}</td>
            <td>{{ cerf2MnfctrView.sts }}</td>
            <td>{{ cerf2MnfctrView.issuDt }}</td>
            <td>{{ cerf2MnfctrView.remainDays }}</td>
            <td>{{ cerf2MnfctrView.applId }}</td>
            <td>{{ cerf2MnfctrView.mnfctrNmCh }}</td>
            <td>
              <a
                v-if="cerf2MnfctrView.upldFile"
                v-on:click="openFile(cerf2MnfctrView.upldFileContentType, cerf2MnfctrView.upldFile)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="cerf2MnfctrView.upldFile"
                >{{ cerf2MnfctrView.upldFileContentType }}, {{ byteSize(cerf2MnfctrView.upldFile) }}</span
              >
            </td>
            <td>
              <a v-if="cerf2MnfctrView.imageFile" v-on:click="openFile(cerf2MnfctrView.imageFileContentType, cerf2MnfctrView.imageFile)">
                <img
                  v-bind:src="'data:' + cerf2MnfctrView.imageFileContentType + ';base64,' + cerf2MnfctrView.imageFile"
                  style="max-height: 30px"
                  alt="cerf2MnfctrView image"
                />
              </a>
              <span v-if="cerf2MnfctrView.imageFile"
                >{{ cerf2MnfctrView.imageFileContentType }}, {{ byteSize(cerf2MnfctrView.imageFile) }}</span
              >
            </td>
            <td>{{ cerf2MnfctrView.lstMtnUsr }}</td>
            <td>{{ cerf2MnfctrView.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'Cerf2MnfctrViewView', params: { cerf2MnfctrViewId: cerf2MnfctrView.id } }"
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
        ><span id="gma2App.cerf2MnfctrView.delete.question" data-cy="cerf2MnfctrViewDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerf2MnfctrView-heading" v-text="$t('gma2App.cerf2MnfctrView.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf 2 Mnfctr View?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerf2MnfctrView"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerf2MnfctrView()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerf2MnfctrViews && cerf2MnfctrViews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-mnfctr-view.component.ts"></script>
