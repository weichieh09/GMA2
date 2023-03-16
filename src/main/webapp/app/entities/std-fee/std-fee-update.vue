<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.stdFee.home.createOrEditLabel"
          data-cy="StdFeeCreateUpdateHeading"
          v-text="$t('gma2App.stdFee.home.createOrEditLabel')"
        >
          Create or edit a StdFee
        </h2>
        <div>
          <div class="form-group" v-if="stdFee.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="stdFee.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.prodId')" for="std-fee-prodId">Prod Id</label>
            <input
              type="text"
              class="form-control"
              name="prodId"
              id="std-fee-prodId"
              data-cy="prodId"
              :class="{ valid: !$v.stdFee.prodId.$invalid, invalid: $v.stdFee.prodId.$invalid }"
              v-model="$v.stdFee.prodId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.mnfctrId')" for="std-fee-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="std-fee-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.stdFee.mnfctrId.$invalid, invalid: $v.stdFee.mnfctrId.$invalid }"
              v-model="$v.stdFee.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.stdNo')" for="std-fee-stdNo">Std No</label>
            <input
              type="text"
              class="form-control"
              name="stdNo"
              id="std-fee-stdNo"
              data-cy="stdNo"
              :class="{ valid: !$v.stdFee.stdNo.$invalid, invalid: $v.stdFee.stdNo.$invalid }"
              v-model="$v.stdFee.stdNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.stdVer')" for="std-fee-stdVer">Std Ver</label>
            <input
              type="text"
              class="form-control"
              name="stdVer"
              id="std-fee-stdVer"
              data-cy="stdVer"
              :class="{ valid: !$v.stdFee.stdVer.$invalid, invalid: $v.stdFee.stdVer.$invalid }"
              v-model="$v.stdFee.stdVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.stsCd')" for="std-fee-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="std-fee-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.stdFee.stsCd.$invalid, invalid: $v.stdFee.stsCd.$invalid }"
              v-model="$v.stdFee.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.feeCd')" for="std-fee-feeCd">Fee Cd</label>
            <input
              type="text"
              class="form-control"
              name="feeCd"
              id="std-fee-feeCd"
              data-cy="feeCd"
              :class="{ valid: !$v.stdFee.feeCd.$invalid, invalid: $v.stdFee.feeCd.$invalid }"
              v-model="$v.stdFee.feeCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.feeDt')" for="std-fee-feeDt">Fee Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-fee-feeDt"
                  v-model="$v.stdFee.feeDt.$model"
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
                id="std-fee-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.stdFee.feeDt.$invalid, invalid: $v.stdFee.feeDt.$invalid }"
                v-model="$v.stdFee.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.fee')" for="std-fee-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="std-fee-fee"
              data-cy="fee"
              :class="{ valid: !$v.stdFee.fee.$invalid, invalid: $v.stdFee.fee.$invalid }"
              v-model.number="$v.stdFee.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.curr')" for="std-fee-curr">Curr</label>
            <input
              type="text"
              class="form-control"
              name="curr"
              id="std-fee-curr"
              data-cy="curr"
              :class="{ valid: !$v.stdFee.curr.$invalid, invalid: $v.stdFee.curr.$invalid }"
              v-model="$v.stdFee.curr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.lstMtnUsr')" for="std-fee-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="std-fee-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.stdFee.lstMtnUsr.$invalid, invalid: $v.stdFee.lstMtnUsr.$invalid }"
              v-model="$v.stdFee.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stdFee.lstMtnDt')" for="std-fee-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-fee-lstMtnDt"
                  v-model="$v.stdFee.lstMtnDt.$model"
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
                id="std-fee-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.stdFee.lstMtnDt.$invalid, invalid: $v.stdFee.lstMtnDt.$invalid }"
                v-model="$v.stdFee.lstMtnDt.$model"
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
            :disabled="$v.stdFee.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./std-fee-update.component.ts"></script>
