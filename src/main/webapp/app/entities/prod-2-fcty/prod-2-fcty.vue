<template>
  <div>
    <h2 id="page-heading" data-cy="Prod2FctyHeading">
      <span v-text="$t('gma2App.prod2Fcty.home.title')" id="prod-2-fcty-heading">Prod 2 Fcties</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.prod2Fcty.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'Prod2FctyCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-prod-2-fcty"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.prod2Fcty.home.createLabel')"> Create a new Prod 2 Fcty </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && prod2Fcties && prod2Fcties.length === 0">
      <span v-text="$t('gma2App.prod2Fcty.home.notFound')">No prod2Fcties found</span>
    </div>
    <div class="table-responsive" v-if="prod2Fcties && prod2Fcties.length > 0">
      <table class="table table-striped" aria-describedby="prod2Fcties">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.prod2Fcty.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrId')">
              <span v-text="$t('gma2App.prod2Fcty.mnfctrId')">Mnfctr Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fctyId')">
              <span v-text="$t('gma2App.prod2Fcty.fctyId')">Fcty Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fctyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inspectDt')">
              <span v-text="$t('gma2App.prod2Fcty.inspectDt')">Inspect Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inspectDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discontinueFg')">
              <span v-text="$t('gma2App.prod2Fcty.discontinueFg')">Discontinue Fg</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discontinueFg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discontinueDesc')">
              <span v-text="$t('gma2App.prod2Fcty.discontinueDesc')">Discontinue Desc</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discontinueDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.prod2Fcty.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.prod2Fcty.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prod2Fcty in prod2Fcties" :key="prod2Fcty.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Prod2FctyView', params: { prod2FctyId: prod2Fcty.id } }">{{ prod2Fcty.id }}</router-link>
            </td>
            <td>{{ prod2Fcty.prodId }}</td>
            <td>{{ prod2Fcty.mnfctrId }}</td>
            <td>{{ prod2Fcty.fctyId }}</td>
            <td>{{ prod2Fcty.inspectDt }}</td>
            <td>{{ prod2Fcty.discontinueFg }}</td>
            <td>{{ prod2Fcty.discontinueDesc }}</td>
            <td>{{ prod2Fcty.lstMtnUsr }}</td>
            <td>{{ prod2Fcty.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'Prod2FctyView', params: { prod2FctyId: prod2Fcty.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'Prod2FctyEdit', params: { prod2FctyId: prod2Fcty.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(prod2Fcty)"
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
        ><span id="gma2App.prod2Fcty.delete.question" data-cy="prod2FctyDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-prod2Fcty-heading" v-text="$t('gma2App.prod2Fcty.delete.question', { id: removeId })">
          Are you sure you want to delete this Prod 2 Fcty?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-prod2Fcty"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProd2Fcty()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="prod2Fcties && prod2Fcties.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-2-fcty.component.ts"></script>
