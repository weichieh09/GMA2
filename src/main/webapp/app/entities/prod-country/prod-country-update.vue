<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.prodCountry.home.createOrEditLabel"
          data-cy="ProdCountryCreateUpdateHeading"
          v-text="$t('gma2App.prodCountry.home.createOrEditLabel')"
        >
          Create or edit a ProdCountry
        </h2>
        <div>
          <div class="form-group" v-if="prodCountry.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prodCountry.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodCountry.relType')" for="prod-country-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="prod-country-relType"
              data-cy="relType"
              :class="{ valid: !$v.prodCountry.relType.$invalid, invalid: $v.prodCountry.relType.$invalid }"
              v-model="$v.prodCountry.relType.$model"
            />
            <div v-if="$v.prodCountry.relType.$anyDirty && $v.prodCountry.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.prodCountry.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodCountry.prod')" for="prod-country-prod">Prod</label>
            <select class="form-control" id="prod-country-prod" data-cy="prod" name="prod" v-model="prodCountry.prod">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="prodCountry.prod && prodOption.id === prodCountry.prod.id ? prodCountry.prod : prodOption"
                v-for="prodOption in prods"
                :key="prodOption.id"
              >
                {{ prodOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodCountry.country')" for="prod-country-country">Country</label>
            <select class="form-control" id="prod-country-country" data-cy="country" name="country" v-model="prodCountry.country">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="prodCountry.country && countryOption.id === prodCountry.country.id ? prodCountry.country : countryOption"
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
            :disabled="$v.prodCountry.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-country-update.component.ts"></script>
