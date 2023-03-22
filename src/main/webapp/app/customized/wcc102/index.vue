<template>
  <b-container fluid>
    <b-row>
      <h2 id="page-heading">
        <span v-text="$t('gma2App.wcc102.home.title')">wcc102</span>
      </h2> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <b-form>
          <b-row>
            <b-col cols="12">
              <b-form-group id="input-group-3" :label="$t('gma2App.wcc102.form1.mnfctrId')" label-for="input-3">
                <b-form-input
                  id="input-3"
                  v-model="form1.mnfctrId"
                  type="text"
                  :placeholder="$t('gma2App.wcc102.form1.mnfctrId')"
                ></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="12" class="d-flex justify-content-end">
              <b-button-group>
                <b-button @click="onSubmit" variant="primary"
                  ><b-icon icon="search"></b-icon> <span v-text="$t('gma2App.wcc102.home.submitLabel')">search</span></b-button
                >
                <b-button @click="onReset" variant="outline-secondary"
                  ><b-icon icon="eraser"></b-icon> <span v-text="$t('gma2App.wcc102.home.resetLabel')">eraser</span></b-button
                >
              </b-button-group>
            </b-col>
          </b-row>
        </b-form>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <div class="alert alert-warning" v-if="isFetch && csvList && csvList.length === 0">
          <span v-text="$t('gma2App.wcc102.home.notFound')">No data found</span>
        </div>
        <div class="alert alert-warning" v-if="isNull">
          <span v-text="$t('gma2App.wcc102.home.cantNull')">Can't Null</span>
        </div>
      </b-col>
      <b-col cols="8">
        <div v-if="csvList && csvList.length > 0">
          <span>
            <h3>製造商Q: {{ name }}</h3>
          </span>
        </div>
        <div class="table-responsive" v-if="csvList && csvList.length > 0">
          <table class="table table-striped" aria-describedby="csvList">
            <thead>
              <tr>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.areaCd')">Area Cd</span>
                </th>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.cerfNo')">Cerf No</span>
                </th>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.cerfVer')">Cerf Ver</span>
                </th>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.cerfFee')">Cerf Fee</span>
                </th>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.stsCd')">Sts Cd</span>
                </th>
                <th scope="row">
                  <span v-text="$t('gma2App.wcc102.table1.applId')">Appl Id</span>
                </th>
                <th scope="row"></th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="csv in csvList" :key="csv.id" data-cy="entityTable">
                <td>{{ csv.areaDesc }}</td>
                <td>{{ csv.cerfNo }}</td>
                <td>{{ csv.cerfVer }}</td>
                <td>{{ csv.fee }}</td>
                <td>{{ csv.stsDesc }}</td>
                <td>{{ csv.mnfctrNmCh }}</td>
                <td class="text-right">
                  <router-link :to="{ name: 'Wcc111', params: { cerfNo: csv.cerfNo, cerfVer: csv.cerfVer } }">
                    <b-button variant="success" size="sm"><b-icon icon="eye"></b-icon> <span>詳情Q</span></b-button>
                  </router-link>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-if="csvList && csvList.length > 0">
          <div class="row justify-content-center">
            <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
          </div>
          <div class="row justify-content-center">
            <b-pagination
              size="md"
              :total-rows="totalItems"
              v-model="page"
              :per-page="itemsPerPage"
              :change="loadPage(page)"
            ></b-pagination>
          </div>
        </div>
      </b-col>
      <b-col cols="4">
        <div v-if="eChartShow">
          <div style="height: 250px" ref="chart1"></div>
          <div style="height: 250px" ref="chart2"></div>
          <div style="height: 250px" ref="chart3"></div>
        </div>
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./index.ts"></script>
