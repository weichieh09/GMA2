<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.cerfProd.home.createOrEditLabel"
          data-cy="CerfProdCreateUpdateHeading"
          v-text="$t('gma2App.cerfProd.home.createOrEditLabel')"
        >
          Create or edit a CerfProd
        </h2>
        <div>
          <div class="form-group" v-if="cerfProd.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerfProd.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfProd.relType')" for="cerf-prod-relType">Rel Type</label>
            <input
              type="text"
              class="form-control"
              name="relType"
              id="cerf-prod-relType"
              data-cy="relType"
              :class="{ valid: !$v.cerfProd.relType.$invalid, invalid: $v.cerfProd.relType.$invalid }"
              v-model="$v.cerfProd.relType.$model"
            />
            <div v-if="$v.cerfProd.relType.$anyDirty && $v.cerfProd.relType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cerfProd.relType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfProd.cerf')" for="cerf-prod-cerf">Cerf</label>
            <select class="form-control" id="cerf-prod-cerf" data-cy="cerf" name="cerf" v-model="cerfProd.cerf">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfProd.cerf && cerfOption.id === cerfProd.cerf.id ? cerfProd.cerf : cerfOption"
                v-for="cerfOption in cerfs"
                :key="cerfOption.id"
              >
                {{ cerfOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerfProd.prod')" for="cerf-prod-prod">Prod</label>
            <select class="form-control" id="cerf-prod-prod" data-cy="prod" name="prod" v-model="cerfProd.prod">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerfProd.prod && prodOption.id === cerfProd.prod.id ? cerfProd.prod : prodOption"
                v-for="prodOption in prods"
                :key="prodOption.id"
              >
                {{ prodOption.id }}
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
            :disabled="$v.cerfProd.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-prod-update.component.ts"></script>
