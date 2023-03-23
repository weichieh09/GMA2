<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.std.home.createOrEditLabel" data-cy="StdCreateUpdateHeading" v-text="$t('gma2App.std.home.createOrEditLabel')">
          Create or edit a Std
        </h2>
        <div>
          <div class="form-group" v-if="std.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="std.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdNo')" for="std-stdNo">Std No</label>
            <input
              type="text"
              class="form-control"
              name="stdNo"
              id="std-stdNo"
              data-cy="stdNo"
              :class="{ valid: !$v.std.stdNo.$invalid, invalid: $v.std.stdNo.$invalid }"
              v-model="$v.std.stdNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdVer')" for="std-stdVer">Std Ver</label>
            <input
              type="text"
              class="form-control"
              name="stdVer"
              id="std-stdVer"
              data-cy="stdVer"
              :class="{ valid: !$v.std.stdVer.$invalid, invalid: $v.std.stdVer.$invalid }"
              v-model="$v.std.stdVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.name')" for="std-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="std-name"
              data-cy="name"
              :class="{ valid: !$v.std.name.$invalid, invalid: $v.std.name.$invalid }"
              v-model="$v.std.name.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.status')" for="std-status">Status</label>
            <input
              type="text"
              class="form-control"
              name="status"
              id="std-status"
              data-cy="status"
              :class="{ valid: !$v.std.status.$invalid, invalid: $v.std.status.$invalid }"
              v-model="$v.std.status.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.fee')" for="std-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="std-fee"
              data-cy="fee"
              :class="{ valid: !$v.std.fee.$invalid, invalid: $v.std.fee.$invalid }"
              v-model.number="$v.std.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.issuDt')" for="std-issuDt">Issu Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-issuDt"
                  v-model="$v.std.issuDt.$model"
                  name="issuDt"
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
                id="std-issuDt"
                data-cy="issuDt"
                type="text"
                class="form-control"
                name="issuDt"
                :class="{ valid: !$v.std.issuDt.$invalid, invalid: $v.std.issuDt.$invalid }"
                v-model="$v.std.issuDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.expDt')" for="std-expDt">Exp Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-expDt"
                  v-model="$v.std.expDt.$model"
                  name="expDt"
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
                id="std-expDt"
                data-cy="expDt"
                type="text"
                class="form-control"
                name="expDt"
                :class="{ valid: !$v.std.expDt.$invalid, invalid: $v.std.expDt.$invalid }"
                v-model="$v.std.expDt.$model"
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
            :disabled="$v.std.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./std-update.component.ts"></script>
