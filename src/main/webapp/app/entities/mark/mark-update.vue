<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.mark.home.createOrEditLabel" data-cy="MarkCreateUpdateHeading" v-text="$t('gma2App.mark.home.createOrEditLabel')">
          Create or edit a Mark
        </h2>
        <div>
          <div class="form-group" v-if="mark.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mark.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mark.markNo')" for="mark-markNo">Mark No</label>
            <input
              type="text"
              class="form-control"
              name="markNo"
              id="mark-markNo"
              data-cy="markNo"
              :class="{ valid: !$v.mark.markNo.$invalid, invalid: $v.mark.markNo.$invalid }"
              v-model="$v.mark.markNo.$model"
            />
            <div v-if="$v.mark.markNo.$anyDirty && $v.mark.markNo.$invalid">
              <small class="form-text text-danger" v-if="!$v.mark.markNo.maxLength" v-text="$t('entity.validation.maxlength', { max: 20 })">
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mark.enName')" for="mark-enName">En Name</label>
            <input
              type="text"
              class="form-control"
              name="enName"
              id="mark-enName"
              data-cy="enName"
              :class="{ valid: !$v.mark.enName.$invalid, invalid: $v.mark.enName.$invalid }"
              v-model="$v.mark.enName.$model"
            />
            <div v-if="$v.mark.enName.$anyDirty && $v.mark.enName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.mark.enName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mark.chName')" for="mark-chName">Ch Name</label>
            <input
              type="text"
              class="form-control"
              name="chName"
              id="mark-chName"
              data-cy="chName"
              :class="{ valid: !$v.mark.chName.$invalid, invalid: $v.mark.chName.$invalid }"
              v-model="$v.mark.chName.$model"
            />
            <div v-if="$v.mark.chName.$anyDirty && $v.mark.chName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.mark.chName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mark.img')" for="mark-img">Img</label>
            <div>
              <img
                v-bind:src="'data:' + mark.imgContentType + ';base64,' + mark.img"
                style="max-height: 100px"
                v-if="mark.img"
                alt="mark image"
              />
              <div v-if="mark.img" class="form-text text-danger clearfix">
                <span class="pull-left">{{ mark.imgContentType }}, {{ byteSize(mark.img) }}</span>
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
                v-on:change="setFileData($event, mark, 'img', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="img"
              id="mark-img"
              data-cy="img"
              :class="{ valid: !$v.mark.img.$invalid, invalid: $v.mark.img.$invalid }"
              v-model="$v.mark.img.$model"
            />
            <input type="hidden" class="form-control" name="imgContentType" id="mark-imgContentType" v-model="mark.imgContentType" />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.mark.country')" for="mark-country">Country</label>
            <select class="form-control" id="mark-country" data-cy="country" name="country" v-model="mark.country">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="mark.country && countryOption.id === mark.country.id ? mark.country : countryOption"
                v-for="countryOption in countries"
                :key="countryOption.id"
              >
                {{ countryOption.id }}
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
            :disabled="$v.mark.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./mark-update.component.ts"></script>
