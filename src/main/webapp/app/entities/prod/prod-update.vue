<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.prod.home.createOrEditLabel" data-cy="ProdCreateUpdateHeading" v-text="$t('gma2App.prod.home.createOrEditLabel')">
          Create or edit a Prod
        </h2>
        <div>
          <div class="form-group" v-if="prod.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prod.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.prodId')" for="prod-prodId">Prod Id</label>
            <input
              type="text"
              class="form-control"
              name="prodId"
              id="prod-prodId"
              data-cy="prodId"
              :class="{ valid: !$v.prod.prodId.$invalid, invalid: $v.prod.prodId.$invalid }"
              v-model="$v.prod.prodId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.mnfctrId')" for="prod-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="prod-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.prod.mnfctrId.$invalid, invalid: $v.prod.mnfctrId.$invalid }"
              v-model="$v.prod.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.prodNmCh')" for="prod-prodNmCh">Prod Nm Ch</label>
            <input
              type="text"
              class="form-control"
              name="prodNmCh"
              id="prod-prodNmCh"
              data-cy="prodNmCh"
              :class="{ valid: !$v.prod.prodNmCh.$invalid, invalid: $v.prod.prodNmCh.$invalid }"
              v-model="$v.prod.prodNmCh.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.prodNmEn')" for="prod-prodNmEn">Prod Nm En</label>
            <input
              type="text"
              class="form-control"
              name="prodNmEn"
              id="prod-prodNmEn"
              data-cy="prodNmEn"
              :class="{ valid: !$v.prod.prodNmEn.$invalid, invalid: $v.prod.prodNmEn.$invalid }"
              v-model="$v.prod.prodNmEn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.hsCd')" for="prod-hsCd">Hs Cd</label>
            <input
              type="text"
              class="form-control"
              name="hsCd"
              id="prod-hsCd"
              data-cy="hsCd"
              :class="{ valid: !$v.prod.hsCd.$invalid, invalid: $v.prod.hsCd.$invalid }"
              v-model="$v.prod.hsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.cccCd')" for="prod-cccCd">Ccc Cd</label>
            <input
              type="text"
              class="form-control"
              name="cccCd"
              id="prod-cccCd"
              data-cy="cccCd"
              :class="{ valid: !$v.prod.cccCd.$invalid, invalid: $v.prod.cccCd.$invalid }"
              v-model="$v.prod.cccCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.lstMtnUsr')" for="prod-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="prod-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.prod.lstMtnUsr.$invalid, invalid: $v.prod.lstMtnUsr.$invalid }"
              v-model="$v.prod.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.lstMtnDt')" for="prod-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-lstMtnDt"
                  v-model="$v.prod.lstMtnDt.$model"
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
                id="prod-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.prod.lstMtnDt.$invalid, invalid: $v.prod.lstMtnDt.$invalid }"
                v-model="$v.prod.lstMtnDt.$model"
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
            :disabled="$v.prod.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-update.component.ts"></script>
