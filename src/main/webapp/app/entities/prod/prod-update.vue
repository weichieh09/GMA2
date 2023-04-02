<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.prod.home.createOrEditLabel" data-cy="ProdCreateUpdateHeading" v-text="$t('gma2App.prod.home.createOrEditLabel')">
          Create or edit a Prod
        </h2>
        <div>
          <div class="form-group" v-if="prod.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prod.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.prodNo')" for="prod-prodNo">Prod No</label>
            <input
              type="text"
              class="form-control"
              name="prodNo"
              id="prod-prodNo"
              data-cy="prodNo"
              :class="{ valid: !$v.prod.prodNo.$invalid, invalid: $v.prod.prodNo.$invalid }"
              v-model="$v.prod.prodNo.$model"
            />
            <div v-if="$v.prod.prodNo.$anyDirty && $v.prod.prodNo.$invalid">
              <small class="form-text text-danger" v-if="!$v.prod.prodNo.maxLength" v-text="$t('entity.validation.maxlength', { max: 30 })">
                This field cannot be longer than 30 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.enName')" for="prod-enName">En Name</label>
            <input
              type="text"
              class="form-control"
              name="enName"
              id="prod-enName"
              data-cy="enName"
              :class="{ valid: !$v.prod.enName.$invalid, invalid: $v.prod.enName.$invalid }"
              v-model="$v.prod.enName.$model"
            />
            <div v-if="$v.prod.enName.$anyDirty && $v.prod.enName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.prod.enName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.chName')" for="prod-chName">Ch Name</label>
            <input
              type="text"
              class="form-control"
              name="chName"
              id="prod-chName"
              data-cy="chName"
              :class="{ valid: !$v.prod.chName.$invalid, invalid: $v.prod.chName.$invalid }"
              v-model="$v.prod.chName.$model"
            />
            <div v-if="$v.prod.chName.$anyDirty && $v.prod.chName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.prod.chName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.hsCode')" for="prod-hsCode">Hs Code</label>
            <input
              type="text"
              class="form-control"
              name="hsCode"
              id="prod-hsCode"
              data-cy="hsCode"
              :class="{ valid: !$v.prod.hsCode.$invalid, invalid: $v.prod.hsCode.$invalid }"
              v-model="$v.prod.hsCode.$model"
            />
            <div v-if="$v.prod.hsCode.$anyDirty && $v.prod.hsCode.$invalid">
              <small class="form-text text-danger" v-if="!$v.prod.hsCode.maxLength" v-text="$t('entity.validation.maxlength', { max: 20 })">
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod.cccCode')" for="prod-cccCode">Ccc Code</label>
            <input
              type="text"
              class="form-control"
              name="cccCode"
              id="prod-cccCode"
              data-cy="cccCode"
              :class="{ valid: !$v.prod.cccCode.$invalid, invalid: $v.prod.cccCode.$invalid }"
              v-model="$v.prod.cccCode.$model"
            />
            <div v-if="$v.prod.cccCode.$anyDirty && $v.prod.cccCode.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.prod.cccCode.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
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
            :disabled="$v.prod.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-update.component.ts"></script>
