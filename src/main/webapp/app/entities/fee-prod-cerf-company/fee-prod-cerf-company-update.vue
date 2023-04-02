<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.feeProdCerfCompany.home.createOrEditLabel"
          data-cy="FeeProdCerfCompanyCreateUpdateHeading"
          v-text="$t('gma2App.feeProdCerfCompany.home.createOrEditLabel')"
        >
          Create or edit a FeeProdCerfCompany
        </h2>
        <div>
          <div class="form-group" v-if="feeProdCerfCompany.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="feeProdCerfCompany.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.fee')" for="fee-prod-cerf-company-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="fee-prod-cerf-company-fee"
              data-cy="fee"
              :class="{ valid: !$v.feeProdCerfCompany.fee.$invalid, invalid: $v.feeProdCerfCompany.fee.$invalid }"
              v-model.number="$v.feeProdCerfCompany.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.feeType')" for="fee-prod-cerf-company-feeType"
              >Fee Type</label
            >
            <input
              type="text"
              class="form-control"
              name="feeType"
              id="fee-prod-cerf-company-feeType"
              data-cy="feeType"
              :class="{ valid: !$v.feeProdCerfCompany.feeType.$invalid, invalid: $v.feeProdCerfCompany.feeType.$invalid }"
              v-model="$v.feeProdCerfCompany.feeType.$model"
            />
            <div v-if="$v.feeProdCerfCompany.feeType.$anyDirty && $v.feeProdCerfCompany.feeType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.feeProdCerfCompany.feeType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 10 })"
              >
                This field cannot be longer than 10 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.feeDt')" for="fee-prod-cerf-company-feeDt"
              >Fee Dt</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="fee-prod-cerf-company-feeDt"
                  v-model="$v.feeProdCerfCompany.feeDt.$model"
                  name="feeDt"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="fee-prod-cerf-company-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.feeProdCerfCompany.feeDt.$invalid, invalid: $v.feeProdCerfCompany.feeDt.$invalid }"
                v-model="$v.feeProdCerfCompany.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.prod')" for="fee-prod-cerf-company-prod">Prod</label>
            <select class="form-control" id="fee-prod-cerf-company-prod" data-cy="prod" name="prod" v-model="feeProdCerfCompany.prod">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="
                  feeProdCerfCompany.prod && prodOption.id === feeProdCerfCompany.prod.id ? feeProdCerfCompany.prod : prodOption
                "
                v-for="prodOption in prods"
                :key="prodOption.id"
              >
                {{ prodOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.cerf')" for="fee-prod-cerf-company-cerf">Cerf</label>
            <select class="form-control" id="fee-prod-cerf-company-cerf" data-cy="cerf" name="cerf" v-model="feeProdCerfCompany.cerf">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="
                  feeProdCerfCompany.cerf && cerfOption.id === feeProdCerfCompany.cerf.id ? feeProdCerfCompany.cerf : cerfOption
                "
                v-for="cerfOption in cerfs"
                :key="cerfOption.id"
              >
                {{ cerfOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.feeProdCerfCompany.company')" for="fee-prod-cerf-company-company"
              >Company</label
            >
            <select
              class="form-control"
              id="fee-prod-cerf-company-company"
              data-cy="company"
              name="company"
              v-model="feeProdCerfCompany.company"
            >
              <option v-bind:value="null"></option>
              <option
                v-bind:value="
                  feeProdCerfCompany.company && companyOption.id === feeProdCerfCompany.company.id
                    ? feeProdCerfCompany.company
                    : companyOption
                "
                v-for="companyOption in companies"
                :key="companyOption.id"
              >
                {{ companyOption.id }}
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
            :disabled="$v.feeProdCerfCompany.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./fee-prod-cerf-company-update.component.ts"></script>
