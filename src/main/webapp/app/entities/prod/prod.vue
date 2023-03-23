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
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.prodNo')">Prod No</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.name')">Name</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.hsCode')">Hs Code</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.cccCode')">Ccc Code</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.country')">Country</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.std')">Std</span></th>
            <th scope="row"><span v-text="$t('gma2App.prod.mark')">Mark</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="prod in prods" :key="prod.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProdView', params: { prodId: prod.id } }">{{ prod.id }}</router-link>
            </td>
            <td>{{ prod.prodNo }}</td>
            <td>{{ prod.name }}</td>
            <td>{{ prod.hsCode }}</td>
            <td>{{ prod.cccCode }}</td>
            <td>
              <span v-for="(country, i) in prod.countries" :key="country.id"
                >{{ i > 0 ? ', ' : '' }}
                <router-link class="form-control-static" :to="{ name: 'CountryView', params: { countryId: country.id } }">{{
                  country.id
                }}</router-link>
              </span>
            </td>
            <td>
              <span v-for="(std, i) in prod.stds" :key="std.id"
                >{{ i > 0 ? ', ' : '' }}
                <router-link class="form-control-static" :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
              </span>
            </td>
            <td>
              <span v-for="(mark, i) in prod.marks" :key="mark.id"
                >{{ i > 0 ? ', ' : '' }}
                <router-link class="form-control-static" :to="{ name: 'MarkView', params: { markId: mark.id } }">{{ mark.id }}</router-link>
              </span>
            </td>
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
  </div>
</template>

<script lang="ts" src="./prod.component.ts"></script>
