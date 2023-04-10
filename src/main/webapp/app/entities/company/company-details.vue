<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form">
        <h2>檢視</h2>
        <div>
          <div class="form-group" v-if="company.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="company.id" disabled />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.companyNo')" for="company-companyNo">Company No</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="companyNo"
              id="company-companyNo"
              data-cy="companyNo"
              :class="{ valid: !$v.company.companyNo.$invalid, invalid: $v.company.companyNo.$invalid }"
              v-model="$v.company.companyNo.$model"
            />
            <div v-if="$v.company.companyNo.$anyDirty && $v.company.companyNo.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.company.companyNo.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.enName')" for="company-enName">En Name</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="enName"
              id="company-enName"
              data-cy="enName"
              :class="{ valid: !$v.company.enName.$invalid, invalid: $v.company.enName.$invalid }"
              v-model="$v.company.enName.$model"
            />
            <div v-if="$v.company.enName.$anyDirty && $v.company.enName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.company.enName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.chName')" for="company-chName">Ch Name</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="chName"
              id="company-chName"
              data-cy="chName"
              :class="{ valid: !$v.company.chName.$invalid, invalid: $v.company.chName.$invalid }"
              v-model="$v.company.chName.$model"
            />
            <div v-if="$v.company.chName.$anyDirty && $v.company.chName.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.company.chName.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.tel')" for="company-tel">Tel</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="tel"
              id="company-tel"
              data-cy="tel"
              :class="{ valid: !$v.company.tel.$invalid, invalid: $v.company.tel.$invalid }"
              v-model="$v.company.tel.$model"
            />
            <div v-if="$v.company.tel.$anyDirty && $v.company.tel.$invalid">
              <small class="form-text text-danger" v-if="!$v.company.tel.maxLength" v-text="$t('entity.validation.maxlength', { max: 20 })">
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.addr')" for="company-addr">Addr</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="addr"
              id="company-addr"
              data-cy="addr"
              :class="{ valid: !$v.company.addr.$invalid, invalid: $v.company.addr.$invalid }"
              v-model="$v.company.addr.$model"
            />
            <div v-if="$v.company.addr.$anyDirty && $v.company.addr.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.company.addr.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.company.email')" for="company-email">Email</label>
            <input
            disabled
              type="text"
              class="form-control"
              name="email"
              id="company-email"
              data-cy="email"
              :class="{ valid: !$v.company.email.$invalid, invalid: $v.company.email.$invalid }"
              v-model="$v.company.email.$model"
            />
            <div v-if="$v.company.email.$anyDirty && $v.company.email.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.company.email.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 50 })"
              >
                This field cannot be longer than 50 characters.
              </small>
            </div>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <b-icon icon="arrow-left" />&nbsp;<span>返回</span>
          </button>
          <!-- <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.company.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button> -->
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./company-details.component.ts"></script>
