<template>
  <div>
    <h2 id="page-heading" data-cy="MnfctrHeading">
      <span v-text="$t('gma2App.mnfctr.home.title')" id="mnfctr-heading">Mnfctrs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.mnfctr.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'MnfctrCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-mnfctr"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.mnfctr.home.createLabel')"> Create a new Mnfctr </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && mnfctrs && mnfctrs.length === 0">
      <span v-text="$t('gma2App.mnfctr.home.notFound')">No mnfctrs found</span>
    </div>
    <div class="table-responsive" v-if="mnfctrs && mnfctrs.length > 0">
      <table class="table table-striped" aria-describedby="mnfctrs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uniNo')">
              <span v-text="$t('gma2App.mnfctr.uniNo')">Uni No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uniNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrNmEn')">
              <span v-text="$t('gma2App.mnfctr.mnfctrNmEn')">Mnfctr Nm En</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrNmEn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mnfctrNmCh')">
              <span v-text="$t('gma2App.mnfctr.mnfctrNmCh')">Mnfctr Nm Ch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mnfctrNmCh'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contact')">
              <span v-text="$t('gma2App.mnfctr.contact')">Contact</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contact'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eamil')">
              <span v-text="$t('gma2App.mnfctr.eamil')">Eamil</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eamil'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addr')">
              <span v-text="$t('gma2App.mnfctr.addr')">Addr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tel')">
              <span v-text="$t('gma2App.mnfctr.tel')">Tel</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tel'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.mnfctr.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.mnfctr.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mnfctr in mnfctrs" :key="mnfctr.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'MnfctrView', params: { mnfctrId: mnfctr.id } }">{{ mnfctr.id }}</router-link>
            </td>
            <td>{{ mnfctr.uniNo }}</td>
            <td>{{ mnfctr.mnfctrNmEn }}</td>
            <td>{{ mnfctr.mnfctrNmCh }}</td>
            <td>{{ mnfctr.contact }}</td>
            <td>{{ mnfctr.eamil }}</td>
            <td>{{ mnfctr.addr }}</td>
            <td>{{ mnfctr.tel }}</td>
            <td>{{ mnfctr.lstMtnUsr }}</td>
            <td>{{ mnfctr.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MnfctrView', params: { mnfctrId: mnfctr.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'MnfctrEdit', params: { mnfctrId: mnfctr.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mnfctr)"
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
        ><span id="gma2App.mnfctr.delete.question" data-cy="mnfctrDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-mnfctr-heading" v-text="$t('gma2App.mnfctr.delete.question', { id: removeId })">
          Are you sure you want to delete this Mnfctr?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-mnfctr"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMnfctr()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="mnfctrs && mnfctrs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./mnfctr.component.ts"></script>
