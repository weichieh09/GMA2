<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.prod2Cerf.home.createOrEditLabel"
          data-cy="Prod2CerfCreateUpdateHeading"
          v-text="$t('gma2App.prod2Cerf.home.createOrEditLabel')"
        >
          Create or edit a Prod2Cerf
        </h2>
        <div>
          <div class="form-group" v-if="prod2Cerf.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prod2Cerf.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.prodId')" for="prod-2-cerf-prodId">Prod Id</label>
            <input
              type="text"
              class="form-control"
              name="prodId"
              id="prod-2-cerf-prodId"
              data-cy="prodId"
              :class="{ valid: !$v.prod2Cerf.prodId.$invalid, invalid: $v.prod2Cerf.prodId.$invalid }"
              v-model="$v.prod2Cerf.prodId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.mnfctrId')" for="prod-2-cerf-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="prod-2-cerf-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.prod2Cerf.mnfctrId.$invalid, invalid: $v.prod2Cerf.mnfctrId.$invalid }"
              v-model="$v.prod2Cerf.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.cerfNo')" for="prod-2-cerf-cerfNo">Cerf No</label>
            <input
              type="text"
              class="form-control"
              name="cerfNo"
              id="prod-2-cerf-cerfNo"
              data-cy="cerfNo"
              :class="{ valid: !$v.prod2Cerf.cerfNo.$invalid, invalid: $v.prod2Cerf.cerfNo.$invalid }"
              v-model="$v.prod2Cerf.cerfNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.cerfVer')" for="prod-2-cerf-cerfVer">Cerf Ver</label>
            <input
              type="text"
              class="form-control"
              name="cerfVer"
              id="prod-2-cerf-cerfVer"
              data-cy="cerfVer"
              :class="{ valid: !$v.prod2Cerf.cerfVer.$invalid, invalid: $v.prod2Cerf.cerfVer.$invalid }"
              v-model="$v.prod2Cerf.cerfVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.applId')" for="prod-2-cerf-applId">Appl Id</label>
            <input
              type="text"
              class="form-control"
              name="applId"
              id="prod-2-cerf-applId"
              data-cy="applId"
              :class="{ valid: !$v.prod2Cerf.applId.$invalid, invalid: $v.prod2Cerf.applId.$invalid }"
              v-model="$v.prod2Cerf.applId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.areaCd')" for="prod-2-cerf-areaCd">Area Cd</label>
            <input
              type="text"
              class="form-control"
              name="areaCd"
              id="prod-2-cerf-areaCd"
              data-cy="areaCd"
              :class="{ valid: !$v.prod2Cerf.areaCd.$invalid, invalid: $v.prod2Cerf.areaCd.$invalid }"
              v-model="$v.prod2Cerf.areaCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.cerfTag')" for="prod-2-cerf-cerfTag">Cerf Tag</label>
            <input
              type="text"
              class="form-control"
              name="cerfTag"
              id="prod-2-cerf-cerfTag"
              data-cy="cerfTag"
              :class="{ valid: !$v.prod2Cerf.cerfTag.$invalid, invalid: $v.prod2Cerf.cerfTag.$invalid }"
              v-model="$v.prod2Cerf.cerfTag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.stsCd')" for="prod-2-cerf-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="prod-2-cerf-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.prod2Cerf.stsCd.$invalid, invalid: $v.prod2Cerf.stsCd.$invalid }"
              v-model="$v.prod2Cerf.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.lstMtnUsr')" for="prod-2-cerf-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="prod-2-cerf-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.prod2Cerf.lstMtnUsr.$invalid, invalid: $v.prod2Cerf.lstMtnUsr.$invalid }"
              v-model="$v.prod2Cerf.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Cerf.lstMtnDt')" for="prod-2-cerf-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-2-cerf-lstMtnDt"
                  v-model="$v.prod2Cerf.lstMtnDt.$model"
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
                id="prod-2-cerf-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.prod2Cerf.lstMtnDt.$invalid, invalid: $v.prod2Cerf.lstMtnDt.$invalid }"
                v-model="$v.prod2Cerf.lstMtnDt.$model"
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
            :disabled="$v.prod2Cerf.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-2-cerf-update.component.ts"></script>
