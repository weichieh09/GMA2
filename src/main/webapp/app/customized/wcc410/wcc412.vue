<template>
  <b-container fluid>
    <b-row>
      <b-col cols="12">
        <h2 id="page-heading">
          <span>證書查詢</span>
        </h2>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
          <!-- <b-row>
            <b-col cols="6">
              <b-form-group id="input-group-1" :label="$t('gmaApp.wcc101.form.country')" label-for="input-1">
                <b-form-select id="input-1" v-model="form.countryId" :options="countryList">
                  <template #first>
                    <b-form-select-option :value="null">請選擇</b-form-select-option>
                  </template>
                </b-form-select>
              </b-form-group>
            </b-col>
            <b-col cols="6">
              <b-form-group id="input-group-2" :label="$t('gmaApp.wcc101.form.cerfStatus')" label-for="input-2">
                <b-form-select id="input-2" v-model="form.cerfStatus" :options="cerfStatusList">
                  <template #first>
                    <b-form-select-option :value="null">請選擇</b-form-select-option>
                  </template>
                </b-form-select>
              </b-form-group>
            </b-col>
          </b-row> -->

          <!-- <b-row>
            <b-col cols="12">
              <b-form-group id="input-group-3" :label="$t('gmaApp.wcc101.form.cerfNo')" label-for="input-3">
                <b-form-input id="input-3" v-model="form.cerfNo" type="text"
                  :placeholder="$t('gmaApp.wcc101.form.cerfNo')"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row> -->

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
            <b-col cols="12" class="d-flex justify-content-end">
              <b-button-group>
                <b-button type="submit" variant="primary"
                  ><b-icon icon="search"></b-icon> <span v-text="$t('gmaApp.wcc101.home.submitLabel')">search</span></b-button
                >
                <b-button type="reset" variant="outline-secondary"
                  ><b-icon icon="eraser"></b-icon> <span v-text="$t('gmaApp.wcc101.home.resetLabel')">eraser</span></b-button
                >
              </b-button-group>
            </b-col>
          </b-row>
        </b-form>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <div class="alert alert-warning" v-if="false">
          <span v-text="$t('gmaApp.wcc101.home.notFound')">No data found</span>
        </div>
      </b-col>
      <b-col cols="12">
        <table class="table table-striped" aria-describedby="cerfs">
          <thead>
            <tr>
              <th scope="row">
                <span>序號</span>
              </th>
              <th scope="row">
                <span>國家</span>
              </th>
              <th scope="row">
                <span>產品型號</span>
              </th>
              <th scope="row">
                <span>產品名稱</span>
              </th>
              <th scope="row">
                <span>證書編號</span>
              </th>
              <th scope="row">
                <span>證書版本號碼</span>
              </th>
              <th scope="row">
                <span>狀態</span>
              </th>
              <th scope="row"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="cerf in cerfList" :key="cerf.id" data-cy="entityTable">
              <td>{{ cerf.cerfId }}</td>
              <td>{{ cerf.countryChName }}</td>
              <td>{{ cerf.prodNo }}</td>
              <td>{{ cerf.prodChName }}</td>
              <td>{{ cerf.cerfNo }}</td>
              <td>{{ cerf.cerfVer }}</td>
              <td>{{ cerf.cerfStatus }}</td>
              <td class="text-right">
                <!-- <b-button variant="success" size="sm"><b-icon icon="eye"></b-icon> <span>詳情Q</span></b-button> -->
                <div class="btn-group">
                  <router-link :to="{ name: 'Wcc313', params: { cerfId: cerf.cerfId } }" custom v-slot="{ navigate }">
                    <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                      <font-awesome-icon icon="eye"></font-awesome-icon>
                      <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                    </button>
                  </router-link>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <div v-show="cerfList && cerfList.length > 0">
          <div class="row justify-content-center">
            <jhi-item-count :page="form.currentPage" :total="form.objTotal" :itemsPerPage="form.perPage"></jhi-item-count>
          </div>
          <div class="row justify-content-center">
            <b-pagination
              v-model="form.currentPage"
              :total-rows="form.objTotal"
              :per-page="form.perPage"
              @input="loadPage(form.currentPage)"
              size="md"
            />
          </div>
        </div>
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./wcc412.ts"></script>
