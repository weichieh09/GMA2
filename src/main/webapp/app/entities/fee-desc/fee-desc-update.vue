<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.feeDesc.home.createOrEditLabel"
          data-cy="FeeDescCreateUpdateHeading"
          v-text="$t('gma2App.feeDesc.home.createOrEditLabel')"
        >
          Create or edit a FeeDesc
        </h2>
        <div>
          <div class="form-group" v-if="feeDesc.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="feeDesc.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeDesc.feeCd')" for="fee-desc-feeCd">Fee Cd</label>
            <input
              type="text"
              class="form-control"
              name="feeCd"
              id="fee-desc-feeCd"
              data-cy="feeCd"
              :class="{ valid: !$v.feeDesc.feeCd.$invalid, invalid: $v.feeDesc.feeCd.$invalid }"
              v-model="$v.feeDesc.feeCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeDesc.feeDesc')" for="fee-desc-feeDesc">Fee Desc</label>
            <input
              type="text"
              class="form-control"
              name="feeDesc"
              id="fee-desc-feeDesc"
              data-cy="feeDesc"
              :class="{ valid: !$v.feeDesc.feeDesc.$invalid, invalid: $v.feeDesc.feeDesc.$invalid }"
              v-model="$v.feeDesc.feeDesc.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeDesc.lstMtnUsr')" for="fee-desc-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="fee-desc-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.feeDesc.lstMtnUsr.$invalid, invalid: $v.feeDesc.lstMtnUsr.$invalid }"
              v-model="$v.feeDesc.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeDesc.lstMtnDt')" for="fee-desc-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="fee-desc-lstMtnDt"
                  v-model="$v.feeDesc.lstMtnDt.$model"
                  name="lstMtnDt"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="fee-desc-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.feeDesc.lstMtnDt.$invalid, invalid: $v.feeDesc.lstMtnDt.$invalid }"
                v-model="$v.feeDesc.lstMtnDt.$model"
              />
            </b-input-group>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.feeDesc.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./fee-desc-update.component.ts"></script>
