<template>
  <div>
    <h2 id="page-heading" data-cy="CerfFeeHeading">
      <span v-text="$t('gma2App.cerfFee.home.title')" id="cerf-fee-heading">Cerf Fees</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('gma2App.cerfFee.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'CerfFeeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-cerf-fee"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('gma2App.cerfFee.home.createLabel')"> Create a new Cerf Fee </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cerfFees && cerfFees.length === 0">
      <span v-text="$t('gma2App.cerfFee.home.notFound')">No cerfFees found</span>
    </div>
    <div class="table-responsive" v-if="cerfFees && cerfFees.length > 0">
      <table class="table table-striped" aria-describedby="cerfFees">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfNo')">
              <span v-text="$t('gma2App.cerfFee.cerfNo')">Cerf No</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfVer')">
              <span v-text="$t('gma2App.cerfFee.cerfVer')">Cerf Ver</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfVer'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cerfTag')">
              <span v-text="$t('gma2App.cerfFee.cerfTag')">Cerf Tag</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cerfTag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('areaCd')">
              <span v-text="$t('gma2App.cerfFee.areaCd')">Area Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('applId')">
              <span v-text="$t('gma2App.cerfFee.applId')">Appl Id</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'applId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stsCd')">
              <span v-text="$t('gma2App.cerfFee.stsCd')">Sts Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stsCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeCd')">
              <span v-text="$t('gma2App.cerfFee.feeCd')">Fee Cd</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeCd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('feeDt')">
              <span v-text="$t('gma2App.cerfFee.feeDt')">Fee Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'feeDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fee')">
              <span v-text="$t('gma2App.cerfFee.fee')">Fee</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fee'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('curr')">
              <span v-text="$t('gma2App.cerfFee.curr')">Curr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'curr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnUsr')">
              <span v-text="$t('gma2App.cerfFee.lstMtnUsr')">Lst Mtn Usr</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnUsr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lstMtnDt')">
              <span v-text="$t('gma2App.cerfFee.lstMtnDt')">Lst Mtn Dt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lstMtnDt'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cerfFee in cerfFees" :key="cerfFee.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CerfFeeView', params: { cerfFeeId: cerfFee.id } }">{{ cerfFee.id }}</router-link>
            </td>
            <td>{{ cerfFee.cerfNo }}</td>
            <td>{{ cerfFee.cerfVer }}</td>
            <td>{{ cerfFee.cerfTag }}</td>
            <td>{{ cerfFee.areaCd }}</td>
            <td>{{ cerfFee.applId }}</td>
            <td>{{ cerfFee.stsCd }}</td>
            <td>{{ cerfFee.feeCd }}</td>
            <td>{{ cerfFee.feeDt }}</td>
            <td>{{ cerfFee.fee }}</td>
            <td>{{ cerfFee.curr }}</td>
            <td>{{ cerfFee.lstMtnUsr }}</td>
            <td>{{ cerfFee.lstMtnDt }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CerfFeeView', params: { cerfFeeId: cerfFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfFeeEdit', params: { cerfFeeId: cerfFee.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerfFee)"
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
        ><span id="gma2App.cerfFee.delete.question" data-cy="cerfFeeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-cerfFee-heading" v-text="$t('gma2App.cerfFee.delete.question', { id: removeId })">
          Are you sure you want to delete this Cerf Fee?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-cerfFee"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCerfFee()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="cerfFees && cerfFees.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-fee.component.ts"></script>
