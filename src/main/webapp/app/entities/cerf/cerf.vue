<template>
  <div>
    <h2 id="page-heading" data-cy="CerfHeading">
      <span v-text="$t('gma2App.cerf.home.title')" id="cerf-heading">Cerfs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerf.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CerfCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-cerf">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cerf.home.createLabel')"> Create a new Cerf </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfs && cerfs.length === 0">
      <span v-text="$t('gma2App.cerf.home.notFound')">No cerfs found</span>
    </div>
    <div class="table-responsive" v-if="cerfs && cerfs.length > 0">
      <table class="table table-striped" aria-describedby="cerfs">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.cerfNo')">Cerf No</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.cerfVer')">Cerf Ver</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.status')">Status</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.pdf')">Pdf</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.applId')">Appl Id</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.fctyId')">Fcty Id</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.mnfctrId')">Mnfctr Id</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.issuDt')">Issu Dt</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.expDt')">Exp Dt</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.prod')">Prod</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.std')">Std</span></th>
            <th scope="row"><span v-text="$t('gma2App.cerf.country')">Country</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerf in cerfs" :key="cerf.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }">{{ cerf.id }}</router-link>
            </td>
            <td>{{ cerf.cerfNo }}</td>
            <td>{{ cerf.cerfVer }}</td>
            <td>{{ cerf.status }}</td>
            <td>
              <a v-if="cerf.pdf" v-on:click="openFile(cerf.pdfContentType, cerf.pdf)" v-text="$t('entity.action.open')">open</a>
              <span v-if="cerf.pdf">{{ cerf.pdfContentType }}, {{ byteSize(cerf.pdf) }}</span>
            </td>
            <td>{{ cerf.applId }}</td>
            <td>{{ cerf.fctyId }}</td>
            <td>{{ cerf.mnfctrId }}</td>
            <td>{{ cerf.issuDt }}</td>
            <td>{{ cerf.expDt }}</td>
            <td>
              <span v-for="(prod, i) in cerf.prods" :key="prod.id"
                >{{ i > 0 ? ', ' : '' }}
                <router-link class="form-control-static" :to="{ name: 'ProdView', params: { prodId: prod.id } }">{{ prod.id }}</router-link>
              </span>
            </td>
            <td>
              <span v-for="(std, i) in cerf.stds" :key="std.id"
                >{{ i > 0 ? ', ' : '' }}
                <router-link class="form-control-static" :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
              </span>
            </td>
            <td>
              <div v-if="cerf.country">
                <router-link :to="{ name: 'CountryView', params: { countryId: cerf.country.id } }">{{ cerf.country.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfEdit', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerf)"
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
        ><span id="gma2App.cerf.delete.question" data-cy="cerfDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerf-heading" v-text="$t('gma2App.cerf.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerf"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerf()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cerf.component.ts"></script>
