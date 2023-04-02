<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.countryStd.home.createOrEditLabel"
          data-cy="CountryStdCreateUpdateHeading"
          v-text="$t('gma2App.countryStd.home.createOrEditLabel')"
        >
          Create or edit a CountryStd
        </h2>
        <div>
          <div class="form-group" v-if="countryStd.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="countryStd.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryStd.relType')" for="country-std-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="country-std-relType"
              data-cy="relType"
              :class="{ valid: !$v.countryStd.relType.$invalid, invalid: $v.countryStd.relType.$invalid }"
              v-model="$v.countryStd.relType.$model"
            />
            <div v-if="$v.countryStd.relType.$anyDirty && $v.countryStd.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.countryStd.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryStd.country')" for="country-std-country">Country</label>
            <select class="form-control" id="country-std-country" data-cy="country" name="country" v-model="countryStd.country">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="countryStd.country && countryOption.id === countryStd.country.id ? countryStd.country : countryOption"
                v-for="countryOption in countries"
                :key="countryOption.id"
              >
                {{ countryOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryStd.std')" for="country-std-std">Std</label>
            <select class="form-control" id="country-std-std" data-cy="std" name="std" v-model="countryStd.std">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="countryStd.std && stdOption.id === countryStd.std.id ? countryStd.std : stdOption"
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
            :disabled="$v.countryStd.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./country-std-update.component.ts"></script>
