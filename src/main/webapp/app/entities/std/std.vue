<template>
  <div>
    <h2 id="page-heading" data-cy="StdHeading">
      <span v-text="$t('gma2App.std.home.title')" id="std-heading">Stds</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.std.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'StdCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-std">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.std.home.createLabel')"> Create a new Std </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && stds && stds.length === 0">
      <span v-text="$t('gma2App.std.home.notFound')">No stds found</span>
    </div>
    <div class="table-responsive" v-if="stds && stds.length > 0">
      <table class="table table-striped" aria-describedby="stds">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdNo')">
              <span v-text="$t('gma2App.std.stdNo')">Std No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdVer')">
              <span v-text="$t('gma2App.std.stdVer')">Std Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.std.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdCd')">
              <span v-text="$t('gma2App.std.stdCd')">Std Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdNm')">
              <span v-text="$t('gma2App.std.stdNm')">Std Nm</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdNm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdExpDt')">
              <span v-text="$t('gma2App.std.stdExpDt')">Std Exp Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdExpDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('remainDays')">
              <span v-text="$t('gma2App.std.remainDays')">Remain Days</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remainDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.std.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.std.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="std in stds" :key="std.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
            </td>
            <td>{{ std.stdNo }}</td>
            <td>{{ std.stdVer }}</td>
            <td>{{ std.stsCd }}</td>
            <td>{{ std.stdCd }}</td>
            <td>{{ std.stdNm }}</td>
            <td>{{ std.stdExpDt }}</td>
            <td>{{ std.remainDays }}</td>
            <td>{{ std.lstMtnUsr }}</td>
            <td>{{ std.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'StdView', params: { stdId: std.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'StdEdit', params: { stdId: std.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(std)"
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
        ><span id="gma2App.std.delete.question" data-cy="stdDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-std-heading" v-text="$t('gma2App.std.delete.question', { id: removeId })">
          Are you sure you want to delete this Std?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-std"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeStd()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="stds && stds.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./std.component.ts"></script>
