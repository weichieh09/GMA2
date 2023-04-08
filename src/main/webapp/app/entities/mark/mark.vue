<template>
  <div>
    <h2 id="page-heading" data-cy="MarkHeading">
      <span v-text="$t('gma2App.mark.home.title')" id="mark-heading">Marks</span>
      <div class="d-flex justify-content-end">
        <!-- <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.mark.home.refreshListLabel')">Refresh List</span>
        </button> -->
        <router-link :to="{ name: 'MarkCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-mark">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.mark.home.createLabel')"> Create a new Mark </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && marks && marks.length === 0">
      <span v-text="$t('gma2App.mark.home.notFound')">No marks found</span>
    </div>
    <div class="table-responsive" v-if="marks && marks.length > 0">
      <table class="table table-striped" aria-describedby="marks">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('markNo')">
              <span v-text="$t('gma2App.mark.markNo')">Mark No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'markNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chName')">
              <span v-text="$t('gma2App.mark.chName')">Ch Name</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enName')">
              <span v-text="$t('gma2App.mark.enName')">En Name</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enName'"></jhi-sort-indicator>
            </th>
            <th scope="row">
              <span v-text="$t('gma2App.mark.img')">Img</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mark in marks" :key="mark.id" data-cy="entityTable">
            <td>{{ mark.id }}</td>
            <td>{{ mark.markNo }}</td>
            <td>{{ mark.chName }}</td>
            <td>{{ mark.enName }}</td>
            <td>
              <a v-if="mark.img" v-on:click="openFile(mark.imgContentType, mark.img)">
                <img v-bind:src="'data:' + mark.imgContentType + ';base64,' + mark.img" style="max-height: 30px" alt="mark image" />
              </a>
              <span v-if="mark.img">{{ mark.imgContentType }}, {{ byteSize(mark.img) }}</span>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <!-- <router-link :to="{ name: 'MarkView', params: { markId: mark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link> -->
                <router-link :to="{ name: 'MarkEdit', params: { markId: mark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mark)"
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
        ><span id="gma2App.mark.delete.question" data-cy="markDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-mark-heading" v-text="$t('gma2App.mark.delete.question', { id: removeId })">
          Are you sure you want to delete this Mark?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-mark"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMark()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="marks && marks.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./mark.component.ts"></script>
