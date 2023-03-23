<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.company.home.createOrEditLabel"
          data-cy="CompanyCreateUpdateHeading"
          v-text="$t('gma2App.company.home.createOrEditLabel')"
        >
          Create or edit a Company
        </h2>
        <div>
          <div class="form-group" v-if="company.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="company.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.name')" for="company-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="company-name"
              data-cy="name"
              :class="{ valid: !$v.company.name.$invalid, invalid: $v.company.name.$invalid }"
              v-model="$v.company.name.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.tel')" for="company-tel">Tel</label>
            <input
              type="text"
              class="form-control"
              name="tel"
              id="company-tel"
              data-cy="tel"
              :class="{ valid: !$v.company.tel.$invalid, invalid: $v.company.tel.$invalid }"
              v-model="$v.company.tel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.addr')" for="company-addr">Addr</label>
            <input
              type="text"
              class="form-control"
              name="addr"
              id="company-addr"
              data-cy="addr"
              :class="{ valid: !$v.company.addr.$invalid, invalid: $v.company.addr.$invalid }"
              v-model="$v.company.addr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.email')" for="company-email">Email</label>
            <input
              type="text"
              class="form-control"
              name="email"
              id="company-email"
              data-cy="email"
              :class="{ valid: !$v.company.email.$invalid, invalid: $v.company.email.$invalid }"
              v-model="$v.company.email.$model"
            />
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
            :disabled="$v.company.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./company-update.component.ts"></script>
