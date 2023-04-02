<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.countryMark.home.createOrEditLabel"
          data-cy="CountryMarkCreateUpdateHeading"
          v-text="$t('gma2App.countryMark.home.createOrEditLabel')"
        >
          Create or edit a CountryMark
        </h2>
        <div>
          <div class="form-group" v-if="countryMark.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="countryMark.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryMark.relType')" for="country-mark-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="country-mark-relType"
              data-cy="relType"
              :class="{ valid: !$v.countryMark.relType.$invalid, invalid: $v.countryMark.relType.$invalid }"
              v-model="$v.countryMark.relType.$model"
            />
            <div v-if="$v.countryMark.relType.$anyDirty && $v.countryMark.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.countryMark.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryMark.country')" for="country-mark-country">Country</label>
            <select class="form-control" id="country-mark-country" data-cy="country" name="country" v-model="countryMark.country">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="countryMark.country && countryOption.id === countryMark.country.id ? countryMark.country : countryOption"
                v-for="countryOption in countries"
                :key="countryOption.id"
              >
                {{ countryOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.countryMark.mark')" for="country-mark-mark">Mark</label>
            <select class="form-control" id="country-mark-mark" data-cy="mark" name="mark" v-model="countryMark.mark">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="countryMark.mark && markOption.id === countryMark.mark.id ? countryMark.mark : markOption"
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
            :disabled="$v.countryMark.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./country-mark-update.component.ts"></script>
