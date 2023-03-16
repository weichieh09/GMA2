<template>
  <div>
    <h2 id="page-heading" data-cy="CerfImgHeading">
      <span v-text="$t('gma2App.cerfImg.home.title')" id="cerf-img-heading">Cerf Imgs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerfImg.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CerfImgCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-cerf-img"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cerfImg.home.createLabel')"> Create a new Cerf Img </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfImgs && cerfImgs.length === 0">
      <span v-text="$t('gma2App.cerfImg.home.notFound')">No cerfImgs found</span>
    </div>
    <div class="table-responsive" v-if="cerfImgs && cerfImgs.length > 0">
      <table class="table table-striped" aria-describedby="cerfImgs">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfTag')">
              <span v-text="$t('gma2App.cerfImg.cerfTag')">Cerf Tag</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfTag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imageFile')">
              <span v-text="$t('gma2App.cerfImg.imageFile')">Image File</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imageFile'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.cerfImg.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.cerfImg.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerfImg in cerfImgs" :key="cerfImg.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfImgView', params: { cerfImgId: cerfImg.id } }">{{ cerfImg.id }}</router-link>
            </td>
            <td>{{ cerfImg.cerfTag }}</td>
            <td>
              <a v-if="cerfImg.imageFile" v-on:click="openFile(cerfImg.imageFileContentType, cerfImg.imageFile)">
                <img
                  v-bind:src="'data:' + cerfImg.imageFileContentType + ';base64,' + cerfImg.imageFile"
                  style="max-height: 30px"
                  alt="cerfImg image"
                />
              </a>
              <span v-if="cerfImg.imageFile">{{ cerfImg.imageFileContentType }}, {{ byteSize(cerfImg.imageFile) }}</span>
            </td>
            <td>{{ cerfImg.lstMtnUsr }}</td>
            <td>{{ cerfImg.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfImgView', params: { cerfImgId: cerfImg.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfImgEdit', params: { cerfImgId: cerfImg.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerfImg)"
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
        ><span id="gma2App.cerfImg.delete.question" data-cy="cerfImgDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerfImg-heading" v-text="$t('gma2App.cerfImg.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf Img?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerfImg"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerfImg()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfImgs && cerfImgs.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-img.component.ts"></script>
