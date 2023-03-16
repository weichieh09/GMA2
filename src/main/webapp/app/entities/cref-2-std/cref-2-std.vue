<template>
  <div>
    <h2 id="page-heading" data-cy="Cref2StdHeading">
      <span v-text="$t('gma2App.cref2Std.home.title')" id="cref-2-std-heading">Cref 2 Stds</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cref2Std.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'Cref2StdCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-cref-2-std"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cref2Std.home.createLabel')"> Create a new Cref 2 Std </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cref2Stds && cref2Stds.length === 0">
      <span v-text="$t('gma2App.cref2Std.home.notFound')">No cref2Stds found</span>
    </div>
    <div class="table-responsive" v-if="cref2Stds && cref2Stds.length > 0">
      <table class="table table-striped" aria-describedby="cref2Stds">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cref2Std.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cref2Std.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.cref2Std.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.cref2Std.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfTag')">
              <span v-text="$t('gma2App.cref2Std.cerfTag')">Cerf Tag</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfTag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdNo')">
              <span v-text="$t('gma2App.cref2Std.stdNo')">Std No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stdVer')">
              <span v-text="$t('gma2App.cref2Std.stdVer')">Std Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stdVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.cref2Std.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.cref2Std.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.cref2Std.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cref2Std in cref2Stds" :key="cref2Std.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'Cref2StdView', params: { cref2StdId: cref2Std.id } }">{{ cref2Std.id }}</router-link>
            </td>
            <td>{{ cref2Std.cerfNo }}</td>
            <td>{{ cref2Std.cerfVer }}</td>
            <td>{{ cref2Std.areaCd }}</td>
            <td>{{ cref2Std.applId }}</td>
            <td>{{ cref2Std.cerfTag }}</td>
            <td>{{ cref2Std.stdNo }}</td>
            <td>{{ cref2Std.stdVer }}</td>
            <td>{{ cref2Std.stsCd }}</td>
            <td>{{ cref2Std.lstMtnUsr }}</td>
            <td>{{ cref2Std.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'Cref2StdView', params: { cref2StdId: cref2Std.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'Cref2StdEdit', params: { cref2StdId: cref2Std.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cref2Std)"
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
        ><span id="gma2App.cref2Std.delete.question" data-cy="cref2StdDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cref2Std-heading" v-text="$t('gma2App.cref2Std.delete.question', { id: removeId })">
          Are you sure you want to delete this Cref 2 Std?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cref2Std"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCref2Std()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cref2Stds && cref2Stds.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cref-2-std.component.ts"></script>
