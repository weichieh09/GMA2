<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.stsDesc.home.createOrEditLabel"
          data-cy="StsDescCreateUpdateHeading"
          v-text="$t('gma2App.stsDesc.home.createOrEditLabel')"
        >
          Create or edit a StsDesc
        </h2>
        <div>
          <div class="form-group" v-if="stsDesc.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="stsDesc.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stsDesc.stsCd')" for="sts-desc-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="sts-desc-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.stsDesc.stsCd.$invalid, invalid: $v.stsDesc.stsCd.$invalid }"
              v-model="$v.stsDesc.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stsDesc.stsDesc')" for="sts-desc-stsDesc">Sts Desc</label>
            <textarea
              class="form-control"
              name="stsDesc"
              id="sts-desc-stsDesc"
              data-cy="stsDesc"
              :class="{ valid: !$v.stsDesc.stsDesc.$invalid, invalid: $v.stsDesc.stsDesc.$invalid }"
              v-model="$v.stsDesc.stsDesc.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stsDesc.lstMtnUsr')" for="sts-desc-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="sts-desc-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.stsDesc.lstMtnUsr.$invalid, invalid: $v.stsDesc.lstMtnUsr.$invalid }"
              v-model="$v.stsDesc.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stsDesc.lstMtnDt')" for="sts-desc-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="sts-desc-lstMtnDt"
                  v-model="$v.stsDesc.lstMtnDt.$model"
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
                id="sts-desc-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.stsDesc.lstMtnDt.$invalid, invalid: $v.stsDesc.lstMtnDt.$invalid }"
                v-model="$v.stsDesc.lstMtnDt.$model"
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
            :disabled="$v.stsDesc.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./sts-desc-update.component.ts"></script>
