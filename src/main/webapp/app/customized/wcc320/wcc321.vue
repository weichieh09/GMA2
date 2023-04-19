<template>
  <b-container fluid>
    <b-row>
      <b-col cols="12">
        <h2 id="page-heading">
          <span>費用模組</span>
        </h2>
      </b-col> </b-row
    ><br />

    <b-row v-if="!isEchartShow">
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
              <b-form-group id="input-group-3" :label="$t('gmaApp.wcc412.form.prodChName')" label-for="input-3">
                <b-form-input
                  id="input-3"
                  v-model="form.prodChName"
                  type="text"
                  :placeholder="$t('gmaApp.wcc412.form.prodChName')"
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
                <b-button type="submit" variant="primary"><b-icon icon="search"></b-icon> <span>搜尋</span></b-button>
              </b-button-group>
            </b-col>
          </b-row>
        </b-form>
      </b-col>
    </b-row>

    <b-row v-if="!isEchartShow">
      <b-col cols="12">
        <br />
        <div class="alert alert-warning">
          <span>No data found</span>
        </div>
      </b-col>
    </b-row>

    <b-row v-if="isEchartShow">
      <b-col cols="12" class="d-flex justify-content-end">
        <b-button-group>
          <b-button variant="primary" @click="reSearch"><b-icon icon="arrow-clockwise"></b-icon> <span>重新搜尋</span></b-button>
        </b-button-group>
      </b-col>
      <b-col cols="6">
        <b-form-group :label="$t('gmaApp.wcc412.form.prodNo')">
          <b-form-input disabled type="text" :value="this.feeList.prod.prodNo"></b-form-input>
        </b-form-group>
      </b-col>
      <b-col cols="6">
        <b-form-group :label="$t('gmaApp.wcc412.form.prodChName')">
          <b-form-input disabled type="text" :value="this.feeList.prod.chName"></b-form-input>
        </b-form-group>
      </b-col>
      <b-col cols="12">
        <hr />
      </b-col>
      <b-col cols="12">
        <div style="height: 500px" ref="chart1"></div>
      </b-col>
      <b-col cols="12">
        <hr />
      </b-col>
      <b-col cols="12">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th scope="col">日期</th>
              <th scope="col">類型</th>
              <th scope="col">金額</th>
              <th scope="col">證書</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="fee in this.feeList.feeDetailList" :key="fee.id">
              <td>{{ fee.feeDt }}</td>
              <td><p v-text="$t('gmaApp.wcc311.feeType.' + fee.feeType)" /></td>
              <td>$ {{ fee.fee }}</td>
              <td>{{ fee.cerf.cerfNo }} - {{ fee.cerf.cerfVer }}</td>
            </tr>
          </tbody>
        </table>
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./wcc321.ts"></script>
