<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.country.home.createOrEditLabel"
          data-cy="CountryCreateUpdateHeading"
          v-text="$t('gma2App.country.home.createOrEditLabel')"
        >
          Create or edit a Country
        </h2>
        <div>
          <div class="form-group" v-if="country.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="country.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.country.countryNo')" for="country-countryNo">Country No</label>
            <input
              type="text"
              class="form-control"
              name="countryNo"
              id="country-countryNo"
              data-cy="countryNo"
              :class="{ valid: !$v.country.countryNo.$invalid, invalid: $v.country.countryNo.$invalid }"
              v-model="$v.country.countryNo.$model"
            />
            <div v-if="$v.country.countryNo.$anyDirty && $v.country.countryNo.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.country.countryNo.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 10 })"
              >
                This field cannot be longer than 10 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.country.enName')" for="country-enName">En Name</label>
            <input
              type="text"
              class="form-control"
              name="enName"
              id="country-enName"
              data-cy="enName"
              :class="{ valid: !$v.country.enName.$invalid, invalid: $v.country.enName.$invalid }"
              v-model="$v.country.enName.$model"
            />
            <div v-if="$v.country.enName.$anyDirty && $v.country.enName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.country.enName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.country.chName')" for="country-chName">Ch Name</label>
            <input
              type="text"
              class="form-control"
              name="chName"
              id="country-chName"
              data-cy="chName"
              :class="{ valid: !$v.country.chName.$invalid, invalid: $v.country.chName.$invalid }"
              v-model="$v.country.chName.$model"
            />
            <div v-if="$v.country.chName.$anyDirty && $v.country.chName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.country.chName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label v-text="$t('gma2App.country.std')" for="country-std">Std</label>
            <select
              class="form-control"
              id="country-stds"
              data-cy="std"
              multiple
              name="std"
              v-if="country.stds !== undefined"
              v-model="country.stds"
            >
              <option v-bind:value="getSelected(country.stds, stdOption)" v-for="stdOption in stds" :key="stdOption.id">
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
            :disabled="$v.country.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./country-update.component.ts"></script>
