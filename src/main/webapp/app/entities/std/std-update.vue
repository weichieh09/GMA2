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
            <label class="form-control-label" v-text="$t('gma2App.std.stsCd')" for="std-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="std-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.std.stsCd.$invalid, invalid: $v.std.stsCd.$invalid }"
              v-model="$v.std.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdCd')" for="std-stdCd">Std Cd</label>
            <input
              type="text"
              class="form-control"
              name="stdCd"
              id="std-stdCd"
              data-cy="stdCd"
              :class="{ valid: !$v.std.stdCd.$invalid, invalid: $v.std.stdCd.$invalid }"
              v-model="$v.std.stdCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdNm')" for="std-stdNm">Std Nm</label>
            <input
              type="text"
              class="form-control"
              name="stdNm"
              id="std-stdNm"
              data-cy="stdNm"
              :class="{ valid: !$v.std.stdNm.$invalid, invalid: $v.std.stdNm.$invalid }"
              v-model="$v.std.stdNm.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdExpDt')" for="std-stdExpDt">Std Exp Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-stdExpDt"
                  v-model="$v.std.stdExpDt.$model"
                  name="stdExpDt"
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
                id="std-stdExpDt"
                data-cy="stdExpDt"
                type="text"
                class="form-control"
                name="stdExpDt"
                :class="{ valid: !$v.std.stdExpDt.$invalid, invalid: $v.std.stdExpDt.$invalid }"
                v-model="$v.std.stdExpDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.remainDays')" for="std-remainDays">Remain Days</label>
            <input
              type="number"
              class="form-control"
              name="remainDays"
              id="std-remainDays"
              data-cy="remainDays"
              :class="{ valid: !$v.std.remainDays.$invalid, invalid: $v.std.remainDays.$invalid }"
              v-model.number="$v.std.remainDays.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.lstMtnUsr')" for="std-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="std-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.std.lstMtnUsr.$invalid, invalid: $v.std.lstMtnUsr.$invalid }"
              v-model="$v.std.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.lstMtnDt')" for="std-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="std-lstMtnDt"
                  v-model="$v.std.lstMtnDt.$model"
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
                id="std-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.std.lstMtnDt.$invalid, invalid: $v.std.lstMtnDt.$invalid }"
                v-model="$v.std.lstMtnDt.$model"
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
