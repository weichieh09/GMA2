<template>
  <div>
    <h2 id="page-heading" data-cy="ProdStickerHeading">
      <span v-text="$t('gma2App.prodSticker.home.title')" id="prod-sticker-heading">Prod Stickers</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.prodSticker.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'ProdStickerCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-prod-sticker"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.prodSticker.home.createLabel')"> Create a new Prod Sticker </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && prodStickers && prodStickers.length === 0">
      <span v-text="$t('gma2App.prodSticker.home.notFound')">No prodStickers found</span>
    </div>
    <div class="table-responsive" v-if="prodStickers && prodStickers.length > 0">
      <table class="table table-striped" aria-describedby="prodStickers">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('relType')">
              <span v-text="$t('gma2App.prodSticker.relType')">Rel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'relType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prod.id')">
              <span v-text="$t('gma2App.prodSticker.prod')">Prod</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prod.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sticker.id')">
              <span v-text="$t('gma2App.prodSticker.sticker')">Sticker</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sticker.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prodSticker in prodStickers" :key="prodSticker.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProdStickerView', params: { prodStickerId: prodSticker.id } }">{{ prodSticker.id }}</router-link>
            </td>
            <td>{{ prodSticker.relType }}</td>
            <td>
              <div v-if="prodSticker.prod">
                <router-link :to="{ name: 'ProdView', params: { prodId: prodSticker.prod.id } }">{{ prodSticker.prod.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="prodSticker.sticker">
                <router-link :to="{ name: 'StickerView', params: { stickerId: prodSticker.sticker.id } }">{{
                  prodSticker.sticker.id
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProdStickerView', params: { prodStickerId: prodSticker.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ProdStickerEdit', params: { prodStickerId: prodSticker.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(prodSticker)"
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
        ><span id="gma2App.prodSticker.delete.question" data-cy="prodStickerDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-prodSticker-heading" v-text="$t('gma2App.prodSticker.delete.question', { id: removeId })">
          Are you sure you want to delete this Prod Sticker?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-prodSticker"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProdSticker()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="prodStickers && prodStickers.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-sticker.component.ts"></script>
