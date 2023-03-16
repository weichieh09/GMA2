<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cerfImg.home.createOrEditLabel"
          data-cy="CerfImgCreateUpdateHeading"
          v-text="$t('gma2App.cerfImg.home.createOrEditLabel')"
        >
          Create or edit a CerfImg
        </h2>
        <div>
          <div class="form-group" v-if="cerfImg.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerfImg.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfImg.cerfTag')" for="cerf-img-cerfTag">Cerf Tag</label>
            <input
              type="text"
              class="form-control"
              name="cerfTag"
              id="cerf-img-cerfTag"
              data-cy="cerfTag"
              :class="{ valid: !$v.cerfImg.cerfTag.$invalid, invalid: $v.cerfImg.cerfTag.$invalid }"
              v-model="$v.cerfImg.cerfTag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfImg.imageFile')" for="cerf-img-imageFile">Image File</label>
            <div>
              <img
                v-bind:src="'data:' + cerfImg.imageFileContentType + ';base64,' + cerfImg.imageFile"
                style="max-height: 100px"
                v-if="cerfImg.imageFile"
                alt="cerfImg image"
              />
              <div v-if="cerfImg.imageFile" class="form-text text-danger clearfix">
                <span class="pull-left">{{ cerfImg.imageFileContentType }}, {{ byteSize(cerfImg.imageFile) }}</span>
                <button
                  type="button"
                  v-on:click="clearInputImage('imageFile', 'imageFileContentType', 'file_imageFile')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_imageFile"
                id="file_imageFile"
                data-cy="imageFile"
                v-on:change="setFileData($event, cerfImg, 'imageFile', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="imageFile"
              id="cerf-img-imageFile"
              data-cy="imageFile"
              :class="{ valid: !$v.cerfImg.imageFile.$invalid, invalid: $v.cerfImg.imageFile.$invalid }"
              v-model="$v.cerfImg.imageFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="imageFileContentType"
              id="cerf-img-imageFileContentType"
              v-model="cerfImg.imageFileContentType"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfImg.lstMtnUsr')" for="cerf-img-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="cerf-img-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.cerfImg.lstMtnUsr.$invalid, invalid: $v.cerfImg.lstMtnUsr.$invalid }"
              v-model="$v.cerfImg.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfImg.lstMtnDt')" for="cerf-img-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-img-lstMtnDt"
                  v-model="$v.cerfImg.lstMtnDt.$model"
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
                id="cerf-img-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.cerfImg.lstMtnDt.$invalid, invalid: $v.cerfImg.lstMtnDt.$invalid }"
                v-model="$v.cerfImg.lstMtnDt.$model"
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
            :disabled="$v.cerfImg.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-img-update.component.ts"></script>
