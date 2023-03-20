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
          <!-- <b-row>
            <b-col cols="6">
              <b-form-group id="input-group-1" :label="$t('gma2App.wcc102.form1.country')" label-for="input-1">
                <b-form-select id="input-1" v-model="form.country" :options="countryList"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col cols="6">
              <b-form-group id="input-group-2" :label="$t('gma2App.wcc102.form1.cerfStatus')" label-for="input-2">
                <b-form-select id="input-2" v-model="form.cerfStatus" :options="cerfStatusList"></b-form-select>
              </b-form-group>
            </b-col>
          </b-row> -->

          <b-row>
            <b-col cols="12">
              <b-form-group id="input-group-3" :label="$t('gma2App.wcc102.form1.mnfctrId')" label-for="input-3">
                <b-form-input
                  id="input-3"
                  v-model="form.mnfctrId"
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
        <div class="alert alert-warning" v-if="false">
          <span v-text="$t('gma2App.wcc102.home.notFound')">No data found</span>
        </div>
      </b-col>
      <b-col cols="8">
        <div class="table-responsive" v-if="show && cerfs && cerfs.length > 0">
          <table class="table table-striped" aria-describedby="cerfs">
            <thead>
              <tr>
                <th scope="row" v-on:click="changeOrder('areaCd')">
                  <span v-text="$t('gma2App.wcc102.table1.areaCd')">Area Cd</span>
                  <jhi-sort-indicator></jhi-sort-indicator>
                </th>
                <th scope="row" v-on:click="changeOrder('cerfNo')">
                  <span v-text="$t('gma2App.wcc102.table1.cerfNo')">Cerf No</span>
                </th>
                <th scope="row" v-on:click="changeOrder('cerfVer')">
                  <span v-text="$t('gma2App.wcc102.table1.cerfVer')">Cerf Ver</span>
                </th>
                <th scope="row" v-on:click="changeOrder('cerfFee')">
                  <span v-text="$t('gma2App.wcc102.table1.cerfFee')">Cerf Fee</span>
                </th>
                <th scope="row" v-on:click="changeOrder('stsCd')">
                  <span v-text="$t('gma2App.wcc102.table1.stsCd')">Sts Cd</span>
                  <jhi-sort-indicator></jhi-sort-indicator>
                </th>
                <th scope="row" v-on:click="changeOrder('applId')">
                  <span v-text="$t('gma2App.wcc102.table1.applId')">Appl Id</span>
                </th>
                <th scope="row" v-on:click="changeOrder('lstMtnDt')">
                  <span v-text="$t('gma2App.wcc102.table1.lstMtnDt')">Lst Mtn Dt</span>
                </th>
                <th scope="row"></th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="cerf in cerfs" :key="cerf.id" data-cy="entityTable">
                <td>{{ cerf.areaCd }}</td>
                <td>{{ cerf.cerfNo }}</td>
                <td>{{ cerf.cerfVer }}</td>
                <td>{{ cerf.cerfFee }}</td>
                <td>{{ cerf.stsCd }}</td>
                <td>{{ cerf.applId }}</td>
                <td>{{ cerf.lstMtnDt }}</td>
                <td class="text-right">
                  <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }">
                    <b-button variant="success" size="sm"><b-icon icon="eye"></b-icon> <span>詳情Q</span></b-button>
                  </router-link>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-if="show && cerfs && cerfs.length > 0">
          <div class="row justify-content-center">
            <jhi-item-count :page="1" :total="2" :itemsPerPage="2"></jhi-item-count>
          </div>
          <div class="row justify-content-center">
            <b-pagination size="md"></b-pagination>
          </div>
        </div>
      </b-col>
      <b-col cols="4">
        <div style="height: 250px" ref="chart1"></div>
        <div style="height: 250px" ref="chart2"></div>
        <div style="height: 250px" ref="chart3"></div>
      </b-col> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <b-card class="mt-3" header="*表單結果" v-if="false">
          <pre class="m-0">{{ form }}</pre>
        </b-card>
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./index.ts"></script>
