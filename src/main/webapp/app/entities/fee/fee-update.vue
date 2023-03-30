<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.fee.home.createOrEditLabel" data-cy="FeeCreateUpdateHeading" v-text="$t('gma2App.fee.home.createOrEditLabel')">
          Create or edit a Fee
        </h2>
        <div>
          <div class="form-group" v-if="fee.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fee.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.fee')" for="fee-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="fee-fee"
              data-cy="fee"
              :class="{ valid: !$v.fee.fee.$invalid, invalid: $v.fee.fee.$invalid }"
              v-model.number="$v.fee.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.feeType')" for="fee-feeType">Fee Type</label>
            <input
              type="text"
              class="form-control"
              name="feeType"
              id="fee-feeType"
              data-cy="feeType"
              :class="{ valid: !$v.fee.feeType.$invalid, invalid: $v.fee.feeType.$invalid }"
              v-model="$v.fee.feeType.$model"
            />
            <div v-if="$v.fee.feeType.$anyDirty && $v.fee.feeType.$invalid">
              <small class="form-text text-danger" v-if="!$v.fee.feeType.maxLength" v-text="$t('entity.validation.maxlength', { max: 10 })">
                This field cannot be longer than 10 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.feeDt')" for="fee-feeDt">Fee Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="fee-feeDt"
                  v-model="$v.fee.feeDt.$model"
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
                id="fee-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.fee.feeDt.$invalid, invalid: $v.fee.feeDt.$invalid }"
                v-model="$v.fee.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.prod')" for="fee-prod">Prod</label>
            <select class="form-control" id="fee-prod" data-cy="prod" name="prod" v-model="fee.prod">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="fee.prod && prodOption.id === fee.prod.id ? fee.prod : prodOption"
                v-for="prodOption in prods"
                :key="prodOption.id"
              >
                {{ prodOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.cerf')" for="fee-cerf">Cerf</label>
            <select class="form-control" id="fee-cerf" data-cy="cerf" name="cerf" v-model="fee.cerf">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="fee.cerf && cerfOption.id === fee.cerf.id ? fee.cerf : cerfOption"
                v-for="cerfOption in cerfs"
                :key="cerfOption.id"
              >
                {{ cerfOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.fee.company')" for="fee-company">Company</label>
            <select class="form-control" id="fee-company" data-cy="company" name="company" v-model="fee.company">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="fee.company && companyOption.id === fee.company.id ? fee.company : companyOption"
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
            :disabled="$v.fee.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./fee-update.component.ts"></script>
