<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cref2Std.home.createOrEditLabel"
          data-cy="Cref2StdCreateUpdateHeading"
          v-text="$t('gma2App.cref2Std.home.createOrEditLabel')"
        >
          Create or edit a Cref2Std
        </h2>
        <div>
          <div class="form-group" v-if="cref2Std.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cref2Std.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.cerfNo')" for="cref-2-std-cerfNo">Cerf No</label>
            <input
              type="text"
              class="form-control"
              name="cerfNo"
              id="cref-2-std-cerfNo"
              data-cy="cerfNo"
              :class="{ valid: !$v.cref2Std.cerfNo.$invalid, invalid: $v.cref2Std.cerfNo.$invalid }"
              v-model="$v.cref2Std.cerfNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.cerfVer')" for="cref-2-std-cerfVer">Cerf Ver</label>
            <input
              type="text"
              class="form-control"
              name="cerfVer"
              id="cref-2-std-cerfVer"
              data-cy="cerfVer"
              :class="{ valid: !$v.cref2Std.cerfVer.$invalid, invalid: $v.cref2Std.cerfVer.$invalid }"
              v-model="$v.cref2Std.cerfVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.areaCd')" for="cref-2-std-areaCd">Area Cd</label>
            <input
              type="text"
              class="form-control"
              name="areaCd"
              id="cref-2-std-areaCd"
              data-cy="areaCd"
              :class="{ valid: !$v.cref2Std.areaCd.$invalid, invalid: $v.cref2Std.areaCd.$invalid }"
              v-model="$v.cref2Std.areaCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.applId')" for="cref-2-std-applId">Appl Id</label>
            <input
              type="text"
              class="form-control"
              name="applId"
              id="cref-2-std-applId"
              data-cy="applId"
              :class="{ valid: !$v.cref2Std.applId.$invalid, invalid: $v.cref2Std.applId.$invalid }"
              v-model="$v.cref2Std.applId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.cerfTag')" for="cref-2-std-cerfTag">Cerf Tag</label>
            <input
              type="text"
              class="form-control"
              name="cerfTag"
              id="cref-2-std-cerfTag"
              data-cy="cerfTag"
              :class="{ valid: !$v.cref2Std.cerfTag.$invalid, invalid: $v.cref2Std.cerfTag.$invalid }"
              v-model="$v.cref2Std.cerfTag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.stdNo')" for="cref-2-std-stdNo">Std No</label>
            <input
              type="text"
              class="form-control"
              name="stdNo"
              id="cref-2-std-stdNo"
              data-cy="stdNo"
              :class="{ valid: !$v.cref2Std.stdNo.$invalid, invalid: $v.cref2Std.stdNo.$invalid }"
              v-model="$v.cref2Std.stdNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.stdVer')" for="cref-2-std-stdVer">Std Ver</label>
            <input
              type="text"
              class="form-control"
              name="stdVer"
              id="cref-2-std-stdVer"
              data-cy="stdVer"
              :class="{ valid: !$v.cref2Std.stdVer.$invalid, invalid: $v.cref2Std.stdVer.$invalid }"
              v-model="$v.cref2Std.stdVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.stsCd')" for="cref-2-std-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="cref-2-std-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.cref2Std.stsCd.$invalid, invalid: $v.cref2Std.stsCd.$invalid }"
              v-model="$v.cref2Std.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.lstMtnUsr')" for="cref-2-std-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="cref-2-std-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.cref2Std.lstMtnUsr.$invalid, invalid: $v.cref2Std.lstMtnUsr.$invalid }"
              v-model="$v.cref2Std.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cref2Std.lstMtnDt')" for="cref-2-std-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cref-2-std-lstMtnDt"
                  v-model="$v.cref2Std.lstMtnDt.$model"
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
                id="cref-2-std-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.cref2Std.lstMtnDt.$invalid, invalid: $v.cref2Std.lstMtnDt.$invalid }"
                v-model="$v.cref2Std.lstMtnDt.$model"
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
            :disabled="$v.cref2Std.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cref-2-std-update.component.ts"></script>
