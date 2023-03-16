<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.mnfctrFee.home.createOrEditLabel"
          data-cy="MnfctrFeeCreateUpdateHeading"
          v-text="$t('gma2App.mnfctrFee.home.createOrEditLabel')"
        >
          Create or edit a MnfctrFee
        </h2>
        <div>
          <div class="form-group" v-if="mnfctrFee.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mnfctrFee.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.fctyId')" for="mnfctr-fee-fctyId">Fcty Id</label>
            <input
              type="text"
              class="form-control"
              name="fctyId"
              id="mnfctr-fee-fctyId"
              data-cy="fctyId"
              :class="{ valid: !$v.mnfctrFee.fctyId.$invalid, invalid: $v.mnfctrFee.fctyId.$invalid }"
              v-model="$v.mnfctrFee.fctyId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.feeCd')" for="mnfctr-fee-feeCd">Fee Cd</label>
            <input
              type="text"
              class="form-control"
              name="feeCd"
              id="mnfctr-fee-feeCd"
              data-cy="feeCd"
              :class="{ valid: !$v.mnfctrFee.feeCd.$invalid, invalid: $v.mnfctrFee.feeCd.$invalid }"
              v-model="$v.mnfctrFee.feeCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.feeDt')" for="mnfctr-fee-feeDt">Fee Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="mnfctr-fee-feeDt"
                  v-model="$v.mnfctrFee.feeDt.$model"
                  name="feeDt"
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
                id="mnfctr-fee-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.mnfctrFee.feeDt.$invalid, invalid: $v.mnfctrFee.feeDt.$invalid }"
                v-model="$v.mnfctrFee.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.fee')" for="mnfctr-fee-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="mnfctr-fee-fee"
              data-cy="fee"
              :class="{ valid: !$v.mnfctrFee.fee.$invalid, invalid: $v.mnfctrFee.fee.$invalid }"
              v-model.number="$v.mnfctrFee.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.curr')" for="mnfctr-fee-curr">Curr</label>
            <input
              type="text"
              class="form-control"
              name="curr"
              id="mnfctr-fee-curr"
              data-cy="curr"
              :class="{ valid: !$v.mnfctrFee.curr.$invalid, invalid: $v.mnfctrFee.curr.$invalid }"
              v-model="$v.mnfctrFee.curr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.lstMtnUsr')" for="mnfctr-fee-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="mnfctr-fee-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.mnfctrFee.lstMtnUsr.$invalid, invalid: $v.mnfctrFee.lstMtnUsr.$invalid }"
              v-model="$v.mnfctrFee.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctrFee.lstMtnDt')" for="mnfctr-fee-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="mnfctr-fee-lstMtnDt"
                  v-model="$v.mnfctrFee.lstMtnDt.$model"
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
                id="mnfctr-fee-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.mnfctrFee.lstMtnDt.$invalid, invalid: $v.mnfctrFee.lstMtnDt.$invalid }"
                v-model="$v.mnfctrFee.lstMtnDt.$model"
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
            :disabled="$v.mnfctrFee.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./mnfctr-fee-update.component.ts"></script>
