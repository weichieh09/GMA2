<template>
  <div>
    <h2 id="page-heading" data-cy="CerfMarkHeading">
      <span v-text="$t('gma2App.cerfMark.home.title')" id="cerf-mark-heading">Cerf Marks</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerfMark.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CerfMarkCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-cerf-mark"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cerfMark.home.createLabel')"> Create a new Cerf Mark </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfMarks && cerfMarks.length === 0">
      <span v-text="$t('gma2App.cerfMark.home.notFound')">No cerfMarks found</span>
    </div>
    <div class="table-responsive" v-if="cerfMarks && cerfMarks.length > 0">
      <table class="table table-striped" aria-describedby="cerfMarks">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('relType')">
              <span v-text="$t('gma2App.cerfMark.relType')">Rel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'relType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerf.id')">
              <span v-text="$t('gma2App.cerfMark.cerf')">Cerf</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerf.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mark.id')">
              <span v-text="$t('gma2App.cerfMark.mark')">Mark</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mark.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerfMark in cerfMarks" :key="cerfMark.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfMarkView', params: { cerfMarkId: cerfMark.id } }">{{ cerfMark.id }}</router-link>
            </td>
            <td>{{ cerfMark.relType }}</td>
            <td>
              <div v-if="cerfMark.cerf">
                <router-link :to="{ name: 'CerfView', params: { cerfId: cerfMark.cerf.id } }">{{ cerfMark.cerf.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="cerfMark.mark">
                <router-link :to="{ name: 'MarkView', params: { markId: cerfMark.mark.id } }">{{ cerfMark.mark.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfMarkView', params: { cerfMarkId: cerfMark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfMarkEdit', params: { cerfMarkId: cerfMark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerfMark)"
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
        ><span id="gma2App.cerfMark.delete.question" data-cy="cerfMarkDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerfMark-heading" v-text="$t('gma2App.cerfMark.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf Mark?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerfMark"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerfMark()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfMarks && cerfMarks.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-mark.component.ts"></script>
