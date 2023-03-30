<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.sticker.home.createOrEditLabel"
          data-cy="StickerCreateUpdateHeading"
          v-text="$t('gma2App.sticker.home.createOrEditLabel')"
        >
          Create or edit a Sticker
        </h2>
        <div>
          <div class="form-group" v-if="sticker.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="sticker.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.sticker.stickerNo')" for="sticker-stickerNo">Sticker No</label>
            <input
              type="text"
              class="form-control"
              name="stickerNo"
              id="sticker-stickerNo"
              data-cy="stickerNo"
              :class="{ valid: !$v.sticker.stickerNo.$invalid, invalid: $v.sticker.stickerNo.$invalid }"
              v-model="$v.sticker.stickerNo.$model"
            />
            <div v-if="$v.sticker.stickerNo.$anyDirty && $v.sticker.stickerNo.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.sticker.stickerNo.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.sticker.img')" for="sticker-img">Img</label>
            <div>
              <img
                v-bind:src="'data:' + sticker.imgContentType + ';base64,' + sticker.img"
                style="max-height: 100px"
                v-if="sticker.img"
                alt="sticker image"
              />
              <div v-if="sticker.img" class="form-text text-danger clearfix">
                <span class="pull-left">{{ sticker.imgContentType }}, {{ byteSize(sticker.img) }}</span>
                <button
                  type="button"
                  v-on:click="clearInputImage('img', 'imgContentType', 'file_img')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_img"
                id="file_img"
                data-cy="img"
                v-on:change="setFileData($event, sticker, 'img', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="img"
              id="sticker-img"
              data-cy="img"
              :class="{ valid: !$v.sticker.img.$invalid, invalid: $v.sticker.img.$invalid }"
              v-model="$v.sticker.img.$model"
            />
            <input type="hidden" class="form-control" name="imgContentType" id="sticker-imgContentType" v-model="sticker.imgContentType" />
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
            :disabled="$v.sticker.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./sticker-update.component.ts"></script>
