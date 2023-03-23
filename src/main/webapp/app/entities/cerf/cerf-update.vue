<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="gma2App.cerf.home.createOrEditLabel" data-cy="CerfCreateUpdateHeading" v-text="$t('gma2App.cerf.home.createOrEditLabel')">
          Create or edit a Cerf
        </h2>
        <div>
          <div class="form-group" v-if="cerf.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cerf.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfNo')" for="cerf-cerfNo">Cerf No</label>
            <input
              type="text"
              class="form-control"
              name="cerfNo"
              id="cerf-cerfNo"
              data-cy="cerfNo"
              :class="{ valid: !$v.cerf.cerfNo.$invalid, invalid: $v.cerf.cerfNo.$invalid }"
              v-model="$v.cerf.cerfNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.cerfVer')" for="cerf-cerfVer">Cerf Ver</label>
            <input
              type="text"
              class="form-control"
              name="cerfVer"
              id="cerf-cerfVer"
              data-cy="cerfVer"
              :class="{ valid: !$v.cerf.cerfVer.$invalid, invalid: $v.cerf.cerfVer.$invalid }"
              v-model="$v.cerf.cerfVer.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.status')" for="cerf-status">Status</label>
            <input
              type="text"
              class="form-control"
              name="status"
              id="cerf-status"
              data-cy="status"
              :class="{ valid: !$v.cerf.status.$invalid, invalid: $v.cerf.status.$invalid }"
              v-model="$v.cerf.status.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.pdf')" for="cerf-pdf">Pdf</label>
            <div>
              <div v-if="cerf.pdf" class="form-text text-danger clearfix">
                <a class="pull-left" v-on:click="openFile(cerf.pdfContentType, cerf.pdf)" v-text="$t('entity.action.open')">open</a><br />
                <span class="pull-left">{{ cerf.pdfContentType }}, {{ byteSize(cerf.pdf) }}</span>
                <button
                  type="button"
                  v-on:click="
                    cerf.pdf = null;
                    cerf.pdfContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_pdf"
                id="file_pdf"
                data-cy="pdf"
                v-on:change="setFileData($event, cerf, 'pdf', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="pdf"
              id="cerf-pdf"
              data-cy="pdf"
              :class="{ valid: !$v.cerf.pdf.$invalid, invalid: $v.cerf.pdf.$invalid }"
              v-model="$v.cerf.pdf.$model"
            />
            <input type="hidden" class="form-control" name="pdfContentType" id="cerf-pdfContentType" v-model="cerf.pdfContentType" />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.applId')" for="cerf-applId">Appl Id</label>
            <input
              type="text"
              class="form-control"
              name="applId"
              id="cerf-applId"
              data-cy="applId"
              :class="{ valid: !$v.cerf.applId.$invalid, invalid: $v.cerf.applId.$invalid }"
              v-model="$v.cerf.applId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.fctyId')" for="cerf-fctyId">Fcty Id</label>
            <input
              type="text"
              class="form-control"
              name="fctyId"
              id="cerf-fctyId"
              data-cy="fctyId"
              :class="{ valid: !$v.cerf.fctyId.$invalid, invalid: $v.cerf.fctyId.$invalid }"
              v-model="$v.cerf.fctyId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.mnfctrId')" for="cerf-mnfctrId">Mnfctr Id</label>
            <input
              type="text"
              class="form-control"
              name="mnfctrId"
              id="cerf-mnfctrId"
              data-cy="mnfctrId"
              :class="{ valid: !$v.cerf.mnfctrId.$invalid, invalid: $v.cerf.mnfctrId.$invalid }"
              v-model="$v.cerf.mnfctrId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.issuDt')" for="cerf-issuDt">Issu Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-issuDt"
                  v-model="$v.cerf.issuDt.$model"
                  name="issuDt"
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
                id="cerf-issuDt"
                data-cy="issuDt"
                type="text"
                class="form-control"
                name="issuDt"
                :class="{ valid: !$v.cerf.issuDt.$invalid, invalid: $v.cerf.issuDt.$invalid }"
                v-model="$v.cerf.issuDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.expDt')" for="cerf-expDt">Exp Dt</label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cerf-expDt"
                  v-model="$v.cerf.expDt.$model"
                  name="expDt"
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
                id="cerf-expDt"
                data-cy="expDt"
                type="text"
                class="form-control"
                name="expDt"
                :class="{ valid: !$v.cerf.expDt.$invalid, invalid: $v.cerf.expDt.$invalid }"
                v-model="$v.cerf.expDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label v-text="$t('gma2App.cerf.prod')" for="cerf-prod">Prod</label>
            <select
              class="form-control"
              id="cerf-prods"
              data-cy="prod"
              multiple
              name="prod"
              v-if="cerf.prods !== undefined"
              v-model="cerf.prods"
            >
              <option v-bind:value="getSelected(cerf.prods, prodOption)" v-for="prodOption in prods" :key="prodOption.id">
                {{ prodOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label v-text="$t('gma2App.cerf.std')" for="cerf-std">Std</label>
            <select
              class="form-control"
              id="cerf-stds"
              data-cy="std"
              multiple
              name="std"
              v-if="cerf.stds !== undefined"
              v-model="cerf.stds"
            >
              <option v-bind:value="getSelected(cerf.stds, stdOption)" v-for="stdOption in stds" :key="stdOption.id">
                {{ stdOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('gma2App.cerf.country')" for="cerf-country">Country</label>
            <select class="form-control" id="cerf-country" data-cy="country" name="country" v-model="cerf.country">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="cerf.country && countryOption.id === cerf.country.id ? cerf.country : countryOption"
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
            :disabled="$v.cerf.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cerf-update.component.ts"></script>
