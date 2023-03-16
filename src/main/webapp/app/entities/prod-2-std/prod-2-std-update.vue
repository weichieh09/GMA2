<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.prod2Std.home.createOrEditLabel"
          data-cy="Prod2StdCreateUpdateHeading"
          v-text="$t('gma2App.prod2Std.home.createOrEditLabel')"
        >
          Create or edit a Prod2Std
        </h2>
        <div>
          <div class="form-group" v-if="prod2Std.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prod2Std.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.prodId')" for="prod-2-std-prodId">Prod Id</label>
            <input
              type="text"
              class="form-control"
              name="prodId"
              id="prod-2-std-prodId"
              data-cy="prodId"
              :class="{ valid: !$v.prod2Std.prodId.$invalid, invalid: $v.prod2Std.prodId.$invalid }"
              v-model="$v.prod2Std.prodId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.mnfctrId')" for="prod-2-std-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="prod-2-std-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.prod2Std.mnfctrId.$invalid, invalid: $v.prod2Std.mnfctrId.$invalid }"
              v-model="$v.prod2Std.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.stdNo')" for="prod-2-std-stdNo">Std No</label>
            <input
              type="text"
              class="form-control"
              name="stdNo"
              id="prod-2-std-stdNo"
              data-cy="stdNo"
              :class="{ valid: !$v.prod2Std.stdNo.$invalid, invalid: $v.prod2Std.stdNo.$invalid }"
              v-model="$v.prod2Std.stdNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.stdVer')" for="prod-2-std-stdVer">Std Ver</label>
            <input
              type="text"
              class="form-control"
              name="stdVer"
              id="prod-2-std-stdVer"
              data-cy="stdVer"
              :class="{ valid: !$v.prod2Std.stdVer.$invalid, invalid: $v.prod2Std.stdVer.$invalid }"
              v-model="$v.prod2Std.stdVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.stsCd')" for="prod-2-std-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="prod-2-std-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.prod2Std.stsCd.$invalid, invalid: $v.prod2Std.stsCd.$invalid }"
              v-model="$v.prod2Std.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.lstMtnUsr')" for="prod-2-std-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="prod-2-std-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.prod2Std.lstMtnUsr.$invalid, invalid: $v.prod2Std.lstMtnUsr.$invalid }"
              v-model="$v.prod2Std.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Std.lstMtnDt')" for="prod-2-std-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-2-std-lstMtnDt"
                  v-model="$v.prod2Std.lstMtnDt.$model"
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
                id="prod-2-std-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.prod2Std.lstMtnDt.$invalid, invalid: $v.prod2Std.lstMtnDt.$invalid }"
                v-model="$v.prod2Std.lstMtnDt.$model"
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
            :disabled="$v.prod2Std.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-2-std-update.component.ts"></script>
