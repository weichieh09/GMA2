<template>
  <div>
    <h2 id="page-heading" data-cy="AreaDescHeading">
      <span v-text="$t('gma2App.areaDesc.home.title')" id="area-desc-heading">Area Descs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.areaDesc.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'AreaDescCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-area-desc"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.areaDesc.home.createLabel')"> Create a new Area Desc </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && areaDescs && areaDescs.length === 0">
      <span v-text="$t('gma2App.areaDesc.home.notFound')">No areaDescs found</span>
    </div>
    <div class="table-responsive" v-if="areaDescs && areaDescs.length > 0">
      <table class="table table-striped" aria-describedby="areaDescs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.areaDesc.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaDesc')">
              <span v-text="$t('gma2App.areaDesc.areaDesc')">Area Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.areaDesc.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.areaDesc.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="areaDesc in areaDescs" :key="areaDesc.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'AreaDescView', params: { areaDescId: areaDesc.id } }">{{ areaDesc.id }}</router-link>
            </td>
            <td>{{ areaDesc.areaCd }}</td>
            <td>{{ areaDesc.areaDesc }}</td>
            <td>{{ areaDesc.lstMtnUsr }}</td>
            <td>{{ areaDesc.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'AreaDescView', params: { areaDescId: areaDesc.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'AreaDescEdit', params: { areaDescId: areaDesc.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(areaDesc)"
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
        ><span id="gma2App.areaDesc.delete.question" data-cy="areaDescDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-areaDesc-heading" v-text="$t('gma2App.areaDesc.delete.question', { id: removeId })">
          Are you sure you want to delete this Area Desc?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-areaDesc"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeAreaDesc()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="areaDescs && areaDescs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./area-desc.component.ts"></script>
