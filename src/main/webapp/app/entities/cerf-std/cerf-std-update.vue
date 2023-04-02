<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cerfStd.home.createOrEditLabel"
          data-cy="CerfStdCreateUpdateHeading"
          v-text="$t('gma2App.cerfStd.home.createOrEditLabel')"
        >
          Create or edit a CerfStd
        </h2>
        <div>
          <div class="form-group" v-if="cerfStd.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerfStd.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfStd.relType')" for="cerf-std-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="cerf-std-relType"
              data-cy="relType"
              :class="{ valid: !$v.cerfStd.relType.$invalid, invalid: $v.cerfStd.relType.$invalid }"
              v-model="$v.cerfStd.relType.$model"
            />
            <div v-if="$v.cerfStd.relType.$anyDirty && $v.cerfStd.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cerfStd.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfStd.cerf')" for="cerf-std-cerf">Cerf</label>
            <select class="form-control" id="cerf-std-cerf" data-cy="cerf" name="cerf" v-model="cerfStd.cerf">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfStd.cerf && cerfOption.id === cerfStd.cerf.id ? cerfStd.cerf : cerfOption"
                v-for="cerfOption in cerfs"
                :key="cerfOption.id"
              >
                {{ cerfOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfStd.std')" for="cerf-std-std">Std</label>
            <select class="form-control" id="cerf-std-std" data-cy="std" name="std" v-model="cerfStd.std">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfStd.std && stdOption.id === cerfStd.std.id ? cerfStd.std : stdOption"
                v-for="stdOption in stds"
                :key="stdOption.id"
              >
                {{ stdOption.id }}
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
            :disabled="$v.cerfStd.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-std-update.component.ts"></script>
