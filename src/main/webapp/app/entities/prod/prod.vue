<template>
  <div>
    <h2 id="page-heading" data-cy="ProdHeading">
      <span v-text="$t('gma2App.prod.home.title')" id="prod-heading">Prods</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.prod.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProdCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-prod">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.prod.home.createLabel')"> Create a new Prod </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && prods && prods.length === 0">
      <span v-text="$t('gma2App.prod.home.notFound')">No prods found</span>
    </div>
    <div class="table-responsive" v-if="prods && prods.length > 0">
      <table class="table table-striped" aria-describedby="prods">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodId')">
              <span v-text="$t('gma2App.prod.prodId')">Prod Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrId')">
              <span v-text="$t('gma2App.prod.mnfctrId')">Mnfctr Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodNmCh')">
              <span v-text="$t('gma2App.prod.prodNmCh')">Prod Nm Ch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodNmCh'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prodNmEn')">
              <span v-text="$t('gma2App.prod.prodNmEn')">Prod Nm En</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prodNmEn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hsCd')">
              <span v-text="$t('gma2App.prod.hsCd')">Hs Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cccCd')">
              <span v-text="$t('gma2App.prod.cccCd')">Ccc Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cccCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.prod.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.prod.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prod in prods" :key="prod.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProdView', params: { prodId: prod.id } }">{{ prod.id }}</router-link>
            </td>
            <td>{{ prod.prodId }}</td>
            <td>{{ prod.mnfctrId }}</td>
            <td>{{ prod.prodNmCh }}</td>
            <td>{{ prod.prodNmEn }}</td>
            <td>{{ prod.hsCd }}</td>
            <td>{{ prod.cccCd }}</td>
            <td>{{ prod.lstMtnUsr }}</td>
            <td>{{ prod.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProdView', params: { prodId: prod.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ProdEdit', params: { prodId: prod.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(prod)"
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
        ><span id="gma2App.prod.delete.question" data-cy="prodDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-prod-heading" v-text="$t('gma2App.prod.delete.question', { id: removeId })">
          Are you sure you want to delete this Prod?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-prod"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProd()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="prods && prods.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod.component.ts"></script>
