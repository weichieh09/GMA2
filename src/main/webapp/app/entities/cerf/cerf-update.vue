<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.cerf.home.createOrEditLabel" data-cy="CerfCreateUpdateHeading" v-text="$t('gma2App.cerf.home.createOrEditLabel')">
          Create or edit a Cerf
        </h2>
        <div>
          <div class="form-group" v-if="cerf.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerf.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfNo')" for="cerf-cerfNo">Cerf No</label>
            <input
              type="text"
              class="form-control"
              name="cerfNo"
              id="cerf-cerfNo"
              data-cy="cerfNo"
              :class="{ valid: !$v.cerf.cerfNo.$invalid, invalid: $v.cerf.cerfNo.$invalid }"
              v-model="$v.cerf.cerfNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfVer')" for="cerf-cerfVer">Cerf Ver</label>
            <input
              type="text"
              class="form-control"
              name="cerfVer"
              id="cerf-cerfVer"
              data-cy="cerfVer"
              :class="{ valid: !$v.cerf.cerfVer.$invalid, invalid: $v.cerf.cerfVer.$invalid }"
              v-model="$v.cerf.cerfVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.areaCd')" for="cerf-areaCd">Area Cd</label>
            <input
              type="text"
              class="form-control"
              name="areaCd"
              id="cerf-areaCd"
              data-cy="areaCd"
              :class="{ valid: !$v.cerf.areaCd.$invalid, invalid: $v.cerf.areaCd.$invalid }"
              v-model="$v.cerf.areaCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.stsCd')" for="cerf-stsCd">Sts Cd</label>
            <input
              type="text"
              class="form-control"
              name="stsCd"
              id="cerf-stsCd"
              data-cy="stsCd"
              :class="{ valid: !$v.cerf.stsCd.$invalid, invalid: $v.cerf.stsCd.$invalid }"
              v-model="$v.cerf.stsCd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.applId')" for="cerf-applId">Appl Id</label>
            <input
              type="text"
              class="form-control"
              name="applId"
              id="cerf-applId"
              data-cy="applId"
              :class="{ valid: !$v.cerf.applId.$invalid, invalid: $v.cerf.applId.$invalid }"
              v-model="$v.cerf.applId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfTag')" for="cerf-cerfTag">Cerf Tag</label>
            <input
              type="text"
              class="form-control"
              name="cerfTag"
              id="cerf-cerfTag"
              data-cy="cerfTag"
              :class="{ valid: !$v.cerf.cerfTag.$invalid, invalid: $v.cerf.cerfTag.$invalid }"
              v-model="$v.cerf.cerfTag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.issuDt')" for="cerf-issuDt">Issu Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-issuDt"
                  v-model="$v.cerf.issuDt.$model"
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
                id="cerf-issuDt"
                data-cy="issuDt"
                type="text"
                class="form-control"
                name="issuDt"
                :class="{ valid: !$v.cerf.issuDt.$invalid, invalid: $v.cerf.issuDt.$invalid }"
                v-model="$v.cerf.issuDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfExpDt')" for="cerf-cerfExpDt">Cerf Exp Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-cerfExpDt"
                  v-model="$v.cerf.cerfExpDt.$model"
                  name="cerfExpDt"
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
                id="cerf-cerfExpDt"
                data-cy="cerfExpDt"
                type="text"
                class="form-control"
                name="cerfExpDt"
                :class="{ valid: !$v.cerf.cerfExpDt.$invalid, invalid: $v.cerf.cerfExpDt.$invalid }"
                v-model="$v.cerf.cerfExpDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.remainDays')" for="cerf-remainDays">Remain Days</label>
            <input
              type="number"
              class="form-control"
              name="remainDays"
              id="cerf-remainDays"
              data-cy="remainDays"
              :class="{ valid: !$v.cerf.remainDays.$invalid, invalid: $v.cerf.remainDays.$invalid }"
              v-model.number="$v.cerf.remainDays.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.upldFile')" for="cerf-upldFile">Upld File</label>
            <div>
              <div v-if="cerf.upldFile" class="form-text text-danger clearfix">
                <a class="pull-left" v-on:click="openFile(cerf.upldFileContentType, cerf.upldFile)" v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left">{{ cerf.upldFileContentType }}, {{ byteSize(cerf.upldFile) }}</span>
                <button
                  type="button"
                  v-on:click="
                    cerf.upldFile = null;
                    cerf.upldFileContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_upldFile"
                id="file_upldFile"
                data-cy="upldFile"
                v-on:change="setFileData($event, cerf, 'upldFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="upldFile"
              id="cerf-upldFile"
              data-cy="upldFile"
              :class="{ valid: !$v.cerf.upldFile.$invalid, invalid: $v.cerf.upldFile.$invalid }"
              v-model="$v.cerf.upldFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="upldFileContentType"
              id="cerf-upldFileContentType"
              v-model="cerf.upldFileContentType"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.lstMtnUsr')" for="cerf-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="cerf-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.cerf.lstMtnUsr.$invalid, invalid: $v.cerf.lstMtnUsr.$invalid }"
              v-model="$v.cerf.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.lstMtnDt')" for="cerf-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-lstMtnDt"
                  v-model="$v.cerf.lstMtnDt.$model"
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
                id="cerf-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.cerf.lstMtnDt.$invalid, invalid: $v.cerf.lstMtnDt.$invalid }"
                v-model="$v.cerf.lstMtnDt.$model"
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
            :disabled="$v.cerf.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-update.component.ts"></script>
