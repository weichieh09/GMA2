<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.mnfctr.home.createOrEditLabel"
          data-cy="MnfctrCreateUpdateHeading"
          v-text="$t('gma2App.mnfctr.home.createOrEditLabel')"
        >
          Create or edit a Mnfctr
        </h2>
        <div>
          <div class="form-group" v-if="mnfctr.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mnfctr.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.uniNo')" for="mnfctr-uniNo">Uni No</label>
            <input
              type="text"
              class="form-control"
              name="uniNo"
              id="mnfctr-uniNo"
              data-cy="uniNo"
              :class="{ valid: !$v.mnfctr.uniNo.$invalid, invalid: $v.mnfctr.uniNo.$invalid }"
              v-model="$v.mnfctr.uniNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.mnfctrNmEn')" for="mnfctr-mnfctrNmEn">Mnfctr Nm En</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrNmEn"
              id="mnfctr-mnfctrNmEn"
              data-cy="mnfctrNmEn"
              :class="{ valid: !$v.mnfctr.mnfctrNmEn.$invalid, invalid: $v.mnfctr.mnfctrNmEn.$invalid }"
              v-model="$v.mnfctr.mnfctrNmEn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.mnfctrNmCh')" for="mnfctr-mnfctrNmCh">Mnfctr Nm Ch</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrNmCh"
              id="mnfctr-mnfctrNmCh"
              data-cy="mnfctrNmCh"
              :class="{ valid: !$v.mnfctr.mnfctrNmCh.$invalid, invalid: $v.mnfctr.mnfctrNmCh.$invalid }"
              v-model="$v.mnfctr.mnfctrNmCh.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.contact')" for="mnfctr-contact">Contact</label>
            <input
              type="text"
              class="form-control"
              name="contact"
              id="mnfctr-contact"
              data-cy="contact"
              :class="{ valid: !$v.mnfctr.contact.$invalid, invalid: $v.mnfctr.contact.$invalid }"
              v-model="$v.mnfctr.contact.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.eamil')" for="mnfctr-eamil">Eamil</label>
            <input
              type="text"
              class="form-control"
              name="eamil"
              id="mnfctr-eamil"
              data-cy="eamil"
              :class="{ valid: !$v.mnfctr.eamil.$invalid, invalid: $v.mnfctr.eamil.$invalid }"
              v-model="$v.mnfctr.eamil.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.addr')" for="mnfctr-addr">Addr</label>
            <input
              type="text"
              class="form-control"
              name="addr"
              id="mnfctr-addr"
              data-cy="addr"
              :class="{ valid: !$v.mnfctr.addr.$invalid, invalid: $v.mnfctr.addr.$invalid }"
              v-model="$v.mnfctr.addr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.tel')" for="mnfctr-tel">Tel</label>
            <input
              type="text"
              class="form-control"
              name="tel"
              id="mnfctr-tel"
              data-cy="tel"
              :class="{ valid: !$v.mnfctr.tel.$invalid, invalid: $v.mnfctr.tel.$invalid }"
              v-model="$v.mnfctr.tel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.lstMtnUsr')" for="mnfctr-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="mnfctr-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.mnfctr.lstMtnUsr.$invalid, invalid: $v.mnfctr.lstMtnUsr.$invalid }"
              v-model="$v.mnfctr.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mnfctr.lstMtnDt')" for="mnfctr-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="mnfctr-lstMtnDt"
                  v-model="$v.mnfctr.lstMtnDt.$model"
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
                id="mnfctr-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.mnfctr.lstMtnDt.$invalid, invalid: $v.mnfctr.lstMtnDt.$invalid }"
                v-model="$v.mnfctr.lstMtnDt.$model"
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
            :disabled="$v.mnfctr.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./mnfctr-update.component.ts"></script>
