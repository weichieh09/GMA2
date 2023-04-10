<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form">
        <h2>檢視</h2>
        <div>
          <div class="form-group" v-if="std.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="std.id" disabled />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdNo')" for="std-stdNo">Std No</label>
            <input disabled type="text" class="form-control" name="stdNo" id="std-stdNo" data-cy="stdNo"
              :class="{ valid: !$v.std.stdNo.$invalid, invalid: $v.std.stdNo.$invalid }" v-model="$v.std.stdNo.$model" />
            <div v-if="$v.std.stdNo.$anyDirty && $v.std.stdNo.$invalid">
              <small class="form-text text-danger" v-if="!$v.std.stdNo.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })">
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.stdVer')" for="std-stdVer">Std Ver</label>
            <input disabled type="text" class="form-control" name="stdVer" id="std-stdVer" data-cy="stdVer"
              :class="{ valid: !$v.std.stdVer.$invalid, invalid: $v.std.stdVer.$invalid }"
              v-model="$v.std.stdVer.$model" />
            <div v-if="$v.std.stdVer.$anyDirty && $v.std.stdVer.$invalid">
              <small class="form-text text-danger" v-if="!$v.std.stdVer.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })">
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.enName')" for="std-enName">En Name</label>
            <input disabled type="text" class="form-control" name="enName" id="std-enName" data-cy="enName"
              :class="{ valid: !$v.std.enName.$invalid, invalid: $v.std.enName.$invalid }"
              v-model="$v.std.enName.$model" />
            <div v-if="$v.std.enName.$anyDirty && $v.std.enName.$invalid">
              <small class="form-text text-danger" v-if="!$v.std.enName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })">
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.chName')" for="std-chName">Ch Name</label>
            <input disabled type="text" class="form-control" name="chName" id="std-chName" data-cy="chName"
              :class="{ valid: !$v.std.chName.$invalid, invalid: $v.std.chName.$invalid }"
              v-model="$v.std.chName.$model" />
            <div v-if="$v.std.chName.$anyDirty && $v.std.chName.$invalid">
              <small class="form-text text-danger" v-if="!$v.std.chName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })">
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.status')" for="std-status">Status</label>
            <input disabled type="text" class="form-control" name="status" id="std-status" data-cy="status"
              :class="{ valid: !$v.std.status.$invalid, invalid: $v.std.status.$invalid }"
              v-model="$v.std.status.$model" />
            <div v-if="$v.std.status.$anyDirty && $v.std.status.$invalid">
              <small class="form-text text-danger" v-if="!$v.std.status.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 10 })">
                This field cannot be longer than 10 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.issuDt')" for="std-issuDt">Issu Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker disabled aria-controls="std-issuDt" v-model="$v.std.issuDt.$model" name="issuDt"
                  class="form-control" :locale="currentLanguage" button-only today-button reset-button close-button>
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input disabled id="std-issuDt" data-cy="issuDt" type="text" class="form-control" name="issuDt"
                :class="{ valid: !$v.std.issuDt.$invalid, invalid: $v.std.issuDt.$invalid }"
                v-model="$v.std.issuDt.$model" />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.std.expDt')" for="std-expDt">Exp Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker disabled aria-controls="std-expDt" v-model="$v.std.expDt.$model" name="expDt"
                  class="form-control" :locale="currentLanguage" button-only today-button reset-button close-button>
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input disabled id="std-expDt" data-cy="expDt" type="text" class="form-control" name="expDt"
                :class="{ valid: !$v.std.expDt.$invalid, invalid: $v.std.expDt.$invalid }"
                v-model="$v.std.expDt.$model" />
            </b-input-group>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary"
            v-on:click="previousState()">
            <b-icon icon="arrow-left" />&nbsp;<span>返回</span>
          </button>
          <!-- <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.std.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button> -->
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./std-details.component.ts"></script>
