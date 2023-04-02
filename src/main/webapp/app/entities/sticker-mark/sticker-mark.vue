<template>
  <div>
    <h2 id="page-heading" data-cy="StickerMarkHeading">
      <span v-text="$t('gma2App.stickerMark.home.title')" id="sticker-mark-heading">Sticker Marks</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.stickerMark.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'StickerMarkCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-sticker-mark"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.stickerMark.home.createLabel')"> Create a new Sticker Mark </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && stickerMarks && stickerMarks.length === 0">
      <span v-text="$t('gma2App.stickerMark.home.notFound')">No stickerMarks found</span>
    </div>
    <div class="table-responsive" v-if="stickerMarks && stickerMarks.length > 0">
      <table class="table table-striped" aria-describedby="stickerMarks">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('relType')">
              <span v-text="$t('gma2App.stickerMark.relType')">Rel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'relType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sticker.id')">
              <span v-text="$t('gma2App.stickerMark.sticker')">Sticker</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sticker.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mark.id')">
              <span v-text="$t('gma2App.stickerMark.mark')">Mark</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mark.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="stickerMark in stickerMarks" :key="stickerMark.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'StickerMarkView', params: { stickerMarkId: stickerMark.id } }">{{ stickerMark.id }}</router-link>
            </td>
            <td>{{ stickerMark.relType }}</td>
            <td>
              <div v-if="stickerMark.sticker">
                <router-link :to="{ name: 'StickerView', params: { stickerId: stickerMark.sticker.id } }">{{
                  stickerMark.sticker.id
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="stickerMark.mark">
                <router-link :to="{ name: 'MarkView', params: { markId: stickerMark.mark.id } }">{{ stickerMark.mark.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'StickerMarkView', params: { stickerMarkId: stickerMark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'StickerMarkEdit', params: { stickerMarkId: stickerMark.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(stickerMark)"
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
        ><span id="gma2App.stickerMark.delete.question" data-cy="stickerMarkDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-stickerMark-heading" v-text="$t('gma2App.stickerMark.delete.question', { id: removeId })">
          Are you sure you want to delete this Sticker Mark?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-stickerMark"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeStickerMark()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="stickerMarks && stickerMarks.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./sticker-mark.component.ts"></script>
