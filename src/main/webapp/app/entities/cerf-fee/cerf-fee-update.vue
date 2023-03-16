<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cerfFee.home.createOrEditLabel"
          data-cy="CerfFeeCreateUpdateHeading"
          v-text="$t('gma2App.cerfFee.home.createOrEditLabel')"
        >
          Create or edit a CerfFee
        </h2>
        <div>
          <div class="form-group" v-if="cerfFee.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerfFee.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.cerfNo')" for="cerf-fee-cerfNo">Cerf No</label>
            <input
              type="text"
              class="form-control"
              name="cerfNo"
              id="cerf-fee-cerfNo"
              data-cy="cerfNo"
              :class="{ valid: !$v.cerfFee.cerfNo.$invalid, invalid: $v.cerfFee.cerfNo.$invalid }"
              v-model="$v.cerfFee.cerfNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.cerfVer')" for="cerf-fee-cerfVer">Cerf Ver</label>
            <input
              type="text"
              class="form-control"
              name="cerfVer"
              id="cerf-fee-cerfVer"
              data-cy="cerfVer"
              :class="{ valid: !$v.cerfFee.cerfVer.$invalid, invalid: $v.cerfFee.cerfVer.$invalid }"
              v-model="$v.cerfFee.cerfVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.cerfTag')" for="cerf-fee-cerfTag">Cerf Tag</label>
            <input
              type="text"
              class="form-control"
              name="cerfTag"
              id="cerf-fee-cerfTag"
              data-cy="cerfTag"
              :class="{ valid: !$v.cerfFee.cerfTag.$invalid, invalid: $v.cerfFee.cerfTag.$invalid }"
              v-model="$v.cerfFee.cerfTag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.areaCd')" for="cerf-fee-areaCd">Area Cd</label>
            <input
              type="text"
              class="form-control"
              name="areaCd"
              id="cerf-fee-areaCd"
              data-cy="areaCd"
              :class="{ valid: !$v.cerfFee.areaCd.$invalid, invalid: $v.cerfFee.areaCd.$invalid }"
              v-model="$v.cerfFee.areaCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.applId')" for="cerf-fee-applId">Appl Id</label>
            <input
              type="text"
              class="form-control"
              name="applId"
              id="cerf-fee-applId"
              data-cy="applId"
              :class="{ valid: !$v.cerfFee.applId.$invalid, invalid: $v.cerfFee.applId.$invalid }"
              v-model="$v.cerfFee.applId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.stsCd')" for="cerf-fee-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="cerf-fee-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.cerfFee.stsCd.$invalid, invalid: $v.cerfFee.stsCd.$invalid }"
              v-model="$v.cerfFee.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.feeCd')" for="cerf-fee-feeCd">Fee Cd</label>
            <input
              type="text"
              class="form-control"
              name="feeCd"
              id="cerf-fee-feeCd"
              data-cy="feeCd"
              :class="{ valid: !$v.cerfFee.feeCd.$invalid, invalid: $v.cerfFee.feeCd.$invalid }"
              v-model="$v.cerfFee.feeCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.feeDt')" for="cerf-fee-feeDt">Fee Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-fee-feeDt"
                  v-model="$v.cerfFee.feeDt.$model"
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
                id="cerf-fee-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.cerfFee.feeDt.$invalid, invalid: $v.cerfFee.feeDt.$invalid }"
                v-model="$v.cerfFee.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.fee')" for="cerf-fee-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="cerf-fee-fee"
              data-cy="fee"
              :class="{ valid: !$v.cerfFee.fee.$invalid, invalid: $v.cerfFee.fee.$invalid }"
              v-model.number="$v.cerfFee.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.curr')" for="cerf-fee-curr">Curr</label>
            <input
              type="text"
              class="form-control"
              name="curr"
              id="cerf-fee-curr"
              data-cy="curr"
              :class="{ valid: !$v.cerfFee.curr.$invalid, invalid: $v.cerfFee.curr.$invalid }"
              v-model="$v.cerfFee.curr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.lstMtnUsr')" for="cerf-fee-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="cerf-fee-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.cerfFee.lstMtnUsr.$invalid, invalid: $v.cerfFee.lstMtnUsr.$invalid }"
              v-model="$v.cerfFee.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfFee.lstMtnDt')" for="cerf-fee-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-fee-lstMtnDt"
                  v-model="$v.cerfFee.lstMtnDt.$model"
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
                id="cerf-fee-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.cerfFee.lstMtnDt.$invalid, invalid: $v.cerfFee.lstMtnDt.$invalid }"
                v-model="$v.cerfFee.lstMtnDt.$model"
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
            :disabled="$v.cerfFee.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-fee-update.component.ts"></script>
