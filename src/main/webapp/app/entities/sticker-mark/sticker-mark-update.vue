<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.stickerMark.home.createOrEditLabel"
          data-cy="StickerMarkCreateUpdateHeading"
          v-text="$t('gma2App.stickerMark.home.createOrEditLabel')"
        >
          Create or edit a StickerMark
        </h2>
        <div>
          <div class="form-group" v-if="stickerMark.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="stickerMark.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stickerMark.relType')" for="sticker-mark-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="sticker-mark-relType"
              data-cy="relType"
              :class="{ valid: !$v.stickerMark.relType.$invalid, invalid: $v.stickerMark.relType.$invalid }"
              v-model="$v.stickerMark.relType.$model"
            />
            <div v-if="$v.stickerMark.relType.$anyDirty && $v.stickerMark.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.stickerMark.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stickerMark.sticker')" for="sticker-mark-sticker">Sticker</label>
            <select class="form-control" id="sticker-mark-sticker" data-cy="sticker" name="sticker" v-model="stickerMark.sticker">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="stickerMark.sticker && stickerOption.id === stickerMark.sticker.id ? stickerMark.sticker : stickerOption"
                v-for="stickerOption in stickers"
                :key="stickerOption.id"
              >
                {{ stickerOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.stickerMark.mark')" for="sticker-mark-mark">Mark</label>
            <select class="form-control" id="sticker-mark-mark" data-cy="mark" name="mark" v-model="stickerMark.mark">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="stickerMark.mark && markOption.id === stickerMark.mark.id ? stickerMark.mark : markOption"
                v-for="markOption in marks"
                :key="markOption.id"
              >
                {{ markOption.id }}
              </option>
            </select>
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
            :disabled="$v.stickerMark.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./sticker-mark-update.component.ts"></script>
