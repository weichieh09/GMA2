<template>
  <div>
    <h2 id="page-heading" data-cy="CerfHeading">
      <span v-text="$t('gma2App.cerf.home.title')" id="cerf-heading">Cerfs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerf.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CerfCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-cerf">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cerf.home.createLabel')"> Create a new Cerf </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfs && cerfs.length === 0">
      <span v-text="$t('gma2App.cerf.home.notFound')">No cerfs found</span>
    </div>
    <div class="table-responsive" v-if="cerfs && cerfs.length > 0">
      <table class="table table-striped" aria-describedby="cerfs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerf.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerf.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.cerf.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.cerf.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.cerf.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfTag')">
              <span v-text="$t('gma2App.cerf.cerfTag')">Cerf Tag</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfTag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('issuDt')">
              <span v-text="$t('gma2App.cerf.issuDt')">Issu Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'issuDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfExpDt')">
              <span v-text="$t('gma2App.cerf.cerfExpDt')">Cerf Exp Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfExpDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('remainDays')">
              <span v-text="$t('gma2App.cerf.remainDays')">Remain Days</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remainDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upldFile')">
              <span v-text="$t('gma2App.cerf.upldFile')">Upld File</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upldFile'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.cerf.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.cerf.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerf in cerfs" :key="cerf.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }">{{ cerf.id }}</router-link>
            </td>
            <td>{{ cerf.cerfNo }}</td>
            <td>{{ cerf.cerfVer }}</td>
            <td>{{ cerf.areaCd }}</td>
            <td>{{ cerf.stsCd }}</td>
            <td>{{ cerf.applId }}</td>
            <td>{{ cerf.cerfTag }}</td>
            <td>{{ cerf.issuDt }}</td>
            <td>{{ cerf.cerfExpDt }}</td>
            <td>{{ cerf.remainDays }}</td>
            <td>
              <a v-if="cerf.upldFile" v-on:click="openFile(cerf.upldFileContentType, cerf.upldFile)" v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="cerf.upldFile">{{ cerf.upldFileContentType }}, {{ byteSize(cerf.upldFile) }}</span>
            </td>
            <td>{{ cerf.lstMtnUsr }}</td>
            <td>{{ cerf.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfEdit', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerf)"
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
        ><span id="gma2App.cerf.delete.question" data-cy="cerfDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerf-heading" v-text="$t('gma2App.cerf.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerf"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerf()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfs && cerfs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf.component.ts"></script>
