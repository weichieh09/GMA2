<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.areaDesc.home.createOrEditLabel"
          data-cy="AreaDescCreateUpdateHeading"
          v-text="$t('gma2App.areaDesc.home.createOrEditLabel')"
        >
          Create or edit a AreaDesc
        </h2>
        <div>
          <div class="form-group" v-if="areaDesc.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="areaDesc.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.areaDesc.areaCd')" for="area-desc-areaCd">Area Cd</label>
            <input
              type="text"
              class="form-control"
              name="areaCd"
              id="area-desc-areaCd"
              data-cy="areaCd"
              :class="{ valid: !$v.areaDesc.areaCd.$invalid, invalid: $v.areaDesc.areaCd.$invalid }"
              v-model="$v.areaDesc.areaCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.areaDesc.areaDesc')" for="area-desc-areaDesc">Area Desc</label>
            <input
              type="text"
              class="form-control"
              name="areaDesc"
              id="area-desc-areaDesc"
              data-cy="areaDesc"
              :class="{ valid: !$v.areaDesc.areaDesc.$invalid, invalid: $v.areaDesc.areaDesc.$invalid }"
              v-model="$v.areaDesc.areaDesc.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.areaDesc.lstMtnUsr')" for="area-desc-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="area-desc-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.areaDesc.lstMtnUsr.$invalid, invalid: $v.areaDesc.lstMtnUsr.$invalid }"
              v-model="$v.areaDesc.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.areaDesc.lstMtnDt')" for="area-desc-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="area-desc-lstMtnDt"
                  v-model="$v.areaDesc.lstMtnDt.$model"
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
                id="area-desc-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.areaDesc.lstMtnDt.$invalid, invalid: $v.areaDesc.lstMtnDt.$invalid }"
                v-model="$v.areaDesc.lstMtnDt.$model"
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
            :disabled="$v.areaDesc.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./area-desc-update.component.ts"></script>
