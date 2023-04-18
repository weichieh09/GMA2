<template>
  <b-container fluid>
    <b-row>
      <b-col cols="12">
        <h2 id="page-heading">
          <span>費用模組</span>
        </h2>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <b-form @submit="onSubmit">
          <b-row>
            <b-col cols="12">
              <b-form-group id="input-group-1" :label="$t('gmaApp.wcc412.form.country')" label-for="input-1">
                <b-form-select id="input-1" v-model="form.countryId" :options="countryList">
                  <template #first>
                    <b-form-select-option :value="null">請選擇</b-form-select-option>
                  </template>
                </b-form-select>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="6">
              <b-form-group id="input-group-2" :label="$t('gmaApp.wcc412.form.prodNo')" label-for="input-2">
                <b-form-input id="input-2" v-model="form.prodNo" type="text" :placeholder="$t('gmaApp.wcc412.form.prodNo')"></b-form-input>
              </b-form-group>
            </b-col>
            <b-col cols="6">
              <b-form-group id="input-group-3" :label="$t('gmaApp.wcc412.form.prodName')" label-for="input-3">
                <b-form-input
                  id="input-3"
                  v-model="form.prodName"
                  type="text"
                  :placeholder="$t('gmaApp.wcc412.form.prodName')"
                ></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="6">
              <b-form-group id="input-group-2" label="開始時間" label-for="input-4">
                <b-input-group class="mb-3">
                  <b-input-group-prepend>
                    <b-form-datepicker v-model="form.startDate" button-only today-button reset-button close-button />
                  </b-input-group-prepend>
                  <b-form-input type="text" class="form-control" v-model="form.startDate" />
                </b-input-group>
              </b-form-group>
            </b-col>
            <b-col cols="6">
              <b-form-group id="input-group-3" label="結束時間" label-for="input-5">
                <b-input-group class="mb-3">
                  <b-input-group-prepend>
                    <b-form-datepicker v-model="form.endDate" button-only today-button reset-button close-button />
                  </b-input-group-prepend>
                  <b-form-input type="text" class="form-control" v-model="form.endDate" />
                </b-input-group>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="12" class="d-flex justify-content-end">
              <b-button-group>
                <b-button type="submit" variant="primary"><b-icon icon="search"></b-icon> <span>search</span></b-button>
              </b-button-group>
            </b-col>
          </b-row>
        </b-form>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <div class="alert alert-warning" v-if="false">
          <span>No data found</span>
        </div>
      </b-col>
      <b-col cols="12">
        {{ feeList }}
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./wcc321.ts"></script>
