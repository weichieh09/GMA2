<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.prodFee.home.createOrEditLabel"
          data-cy="ProdFeeCreateUpdateHeading"
          v-text="$t('gma2App.prodFee.home.createOrEditLabel')"
        >
          Create or edit a ProdFee
        </h2>
        <div>
          <div class="form-group" v-if="prodFee.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prodFee.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodFee.fee')" for="prod-fee-fee">Fee</label>
            <input
              type="number"
              class="form-control"
              name="fee"
              id="prod-fee-fee"
              data-cy="fee"
              :class="{ valid: !$v.prodFee.fee.$invalid, invalid: $v.prodFee.fee.$invalid }"
              v-model.number="$v.prodFee.fee.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodFee.feeType')" for="prod-fee-feeType">Fee Type</label>
            <input
              type="text"
              class="form-control"
              name="feeType"
              id="prod-fee-feeType"
              data-cy="feeType"
              :class="{ valid: !$v.prodFee.feeType.$invalid, invalid: $v.prodFee.feeType.$invalid }"
              v-model="$v.prodFee.feeType.$model"
            />
            <div v-if="$v.prodFee.feeType.$anyDirty && $v.prodFee.feeType.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.prodFee.feeType.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 10 })"
              >
                This field cannot be longer than 10 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodFee.feeDt')" for="prod-fee-feeDt">Fee Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-fee-feeDt"
                  v-model="$v.prodFee.feeDt.$model"
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
                id="prod-fee-feeDt"
                data-cy="feeDt"
                type="text"
                class="form-control"
                name="feeDt"
                :class="{ valid: !$v.prodFee.feeDt.$invalid, invalid: $v.prodFee.feeDt.$invalid }"
                v-model="$v.prodFee.feeDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prodFee.prod')" for="prod-fee-prod">Prod</label>
            <select class="form-control" id="prod-fee-prod" data-cy="prod" name="prod" v-model="prodFee.prod">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="prodFee.prod && prodOption.id === prodFee.prod.id ? prodFee.prod : prodOption"
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
            :disabled="$v.prodFee.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-fee-update.component.ts"></script>
