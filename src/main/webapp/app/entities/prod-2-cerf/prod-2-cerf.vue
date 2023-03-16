<template>
  <div>
    <h2 id="page-heading" data-cy="Prod2CerfHeading">
      <span v-text="$t('gma2App.prod2Cerf.home.title')" id="prod-2-cerf-heading">Prod 2 Cerfs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.prod2Cerf.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'Prod2CerfCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-prod-2-cerf"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.prod2Cerf.home.createLabel')"> Create a new Prod 2 Cerf </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && prod2Cerfs && prod2Cerfs.length === 0">
      <span v-text="$t('gma2App.prod2Cerf.home.notFound')">No prod2Cerfs found</span>
    </div>
    <div class="table-responsive" v-if="prod2Cerfs && prod2Cerfs.length > 0">
      <table class="table table-striped" aria-describedby="prod2Cerfs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.prod2Cerf.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrId')">
              <span v-text="$t('gma2App.prod2Cerf.mnfctrId')">Mnfctr Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.prod2Cerf.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.prod2Cerf.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.prod2Cerf.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.prod2Cerf.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfTag')">
              <span v-text="$t('gma2App.prod2Cerf.cerfTag')">Cerf Tag</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfTag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.prod2Cerf.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.prod2Cerf.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.prod2Cerf.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prod2Cerf in prod2Cerfs" :key="prod2Cerf.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Prod2CerfView', params: { prod2CerfId: prod2Cerf.id } }">{{ prod2Cerf.id }}</router-link>
            </td>
            <td>{{ prod2Cerf.prodId }}</td>
            <td>{{ prod2Cerf.mnfctrId }}</td>
            <td>{{ prod2Cerf.cerfNo }}</td>
            <td>{{ prod2Cerf.cerfVer }}</td>
            <td>{{ prod2Cerf.applId }}</td>
            <td>{{ prod2Cerf.areaCd }}</td>
            <td>{{ prod2Cerf.cerfTag }}</td>
            <td>{{ prod2Cerf.stsCd }}</td>
            <td>{{ prod2Cerf.lstMtnUsr }}</td>
            <td>{{ prod2Cerf.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'Prod2CerfView', params: { prod2CerfId: prod2Cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'Prod2CerfEdit', params: { prod2CerfId: prod2Cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(prod2Cerf)"
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
        ><span id="gma2App.prod2Cerf.delete.question" data-cy="prod2CerfDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-prod2Cerf-heading" v-text="$t('gma2App.prod2Cerf.delete.question', { id: removeId })">
          Are you sure you want to delete this Prod 2 Cerf?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-prod2Cerf"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProd2Cerf()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="prod2Cerfs && prod2Cerfs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-2-cerf.component.ts"></script>
