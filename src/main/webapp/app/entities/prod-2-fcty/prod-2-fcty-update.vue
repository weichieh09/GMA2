<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="gma2App.prod2Fcty.home.createOrEditLabel"
          data-cy="Prod2FctyCreateUpdateHeading"
          v-text="$t('gma2App.prod2Fcty.home.createOrEditLabel')"
        >
          Create or edit a Prod2Fcty
        </h2>
        <div>
          <div class="form-group" v-if="prod2Fcty.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="prod2Fcty.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.prodId')" for="prod-2-fcty-prodId">Prod Id</label>
            <input
              type="text"
              class="form-control"
              name="prodId"
              id="prod-2-fcty-prodId"
              data-cy="prodId"
              :class="{ valid: !$v.prod2Fcty.prodId.$invalid, invalid: $v.prod2Fcty.prodId.$invalid }"
              v-model="$v.prod2Fcty.prodId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.mnfctrId')" for="prod-2-fcty-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="prod-2-fcty-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.prod2Fcty.mnfctrId.$invalid, invalid: $v.prod2Fcty.mnfctrId.$invalid }"
              v-model="$v.prod2Fcty.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.fctyId')" for="prod-2-fcty-fctyId">Fcty Id</label>
            <input
              type="text"
              class="form-control"
              name="fctyId"
              id="prod-2-fcty-fctyId"
              data-cy="fctyId"
              :class="{ valid: !$v.prod2Fcty.fctyId.$invalid, invalid: $v.prod2Fcty.fctyId.$invalid }"
              v-model="$v.prod2Fcty.fctyId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.inspectDt')" for="prod-2-fcty-inspectDt">Inspect Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-2-fcty-inspectDt"
                  v-model="$v.prod2Fcty.inspectDt.$model"
                  name="inspectDt"
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
                id="prod-2-fcty-inspectDt"
                data-cy="inspectDt"
                type="text"
                class="form-control"
                name="inspectDt"
                :class="{ valid: !$v.prod2Fcty.inspectDt.$invalid, invalid: $v.prod2Fcty.inspectDt.$invalid }"
                v-model="$v.prod2Fcty.inspectDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.discontinueFg')" for="prod-2-fcty-discontinueFg"
              >Discontinue Fg</label
            >
            <input
              type="text"
              class="form-control"
              name="discontinueFg"
              id="prod-2-fcty-discontinueFg"
              data-cy="discontinueFg"
              :class="{ valid: !$v.prod2Fcty.discontinueFg.$invalid, invalid: $v.prod2Fcty.discontinueFg.$invalid }"
              v-model="$v.prod2Fcty.discontinueFg.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.discontinueDesc')" for="prod-2-fcty-discontinueDesc"
              >Discontinue Desc</label
            >
            <textarea
              class="form-control"
              name="discontinueDesc"
              id="prod-2-fcty-discontinueDesc"
              data-cy="discontinueDesc"
              :class="{ valid: !$v.prod2Fcty.discontinueDesc.$invalid, invalid: $v.prod2Fcty.discontinueDesc.$invalid }"
              v-model="$v.prod2Fcty.discontinueDesc.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.lstMtnUsr')" for="prod-2-fcty-lstMtnUsr">Lst Mtn Usr</label>
            <input
              type="text"
              class="form-control"
              name="lstMtnUsr"
              id="prod-2-fcty-lstMtnUsr"
              data-cy="lstMtnUsr"
              :class="{ valid: !$v.prod2Fcty.lstMtnUsr.$invalid, invalid: $v.prod2Fcty.lstMtnUsr.$invalid }"
              v-model="$v.prod2Fcty.lstMtnUsr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.prod2Fcty.lstMtnDt')" for="prod-2-fcty-lstMtnDt">Lst Mtn Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="prod-2-fcty-lstMtnDt"
                  v-model="$v.prod2Fcty.lstMtnDt.$model"
                  name="lstMtnDt"
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
                id="prod-2-fcty-lstMtnDt"
                data-cy="lstMtnDt"
                type="text"
                class="form-control"
                name="lstMtnDt"
                :class="{ valid: !$v.prod2Fcty.lstMtnDt.$invalid, invalid: $v.prod2Fcty.lstMtnDt.$invalid }"
                v-model="$v.prod2Fcty.lstMtnDt.$model"
              />
            </b-input-group>
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
            :disabled="$v.prod2Fcty.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./prod-2-fcty-update.component.ts"></script>
