<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cerfMark.home.createOrEditLabel"
          data-cy="CerfMarkCreateUpdateHeading"
          v-text="$t('gma2App.cerfMark.home.createOrEditLabel')"
        >
          Create or edit a CerfMark
        </h2>
        <div>
          <div class="form-group" v-if="cerfMark.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerfMark.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfMark.relType')" for="cerf-mark-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="cerf-mark-relType"
              data-cy="relType"
              :class="{ valid: !$v.cerfMark.relType.$invalid, invalid: $v.cerfMark.relType.$invalid }"
              v-model="$v.cerfMark.relType.$model"
            />
            <div v-if="$v.cerfMark.relType.$anyDirty && $v.cerfMark.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cerfMark.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfMark.cerf')" for="cerf-mark-cerf">Cerf</label>
            <select class="form-control" id="cerf-mark-cerf" data-cy="cerf" name="cerf" v-model="cerfMark.cerf">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfMark.cerf && cerfOption.id === cerfMark.cerf.id ? cerfMark.cerf : cerfOption"
                v-for="cerfOption in cerfs"
                :key="cerfOption.id"
              >
                {{ cerfOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfMark.mark')" for="cerf-mark-mark">Mark</label>
            <select class="form-control" id="cerf-mark-mark" data-cy="mark" name="mark" v-model="cerfMark.mark">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfMark.mark && markOption.id === cerfMark.mark.id ? cerfMark.mark : markOption"
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
            :disabled="$v.cerfMark.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-mark-update.component.ts"></script>
