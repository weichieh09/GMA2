<template>
  <b-container fluid>
    <b-row>
      <h2 id="page-heading">
        <span v-text="$t('gma2App.wcc101.home.title')">wcc101</span>
      </h2> </b-row
    ><br />

    <b-row>
      <b-col cols="12">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
          <b-row>
            <b-col cols="6">
              <b-form-group id="input-group-1" :label="$t('gma2App.wcc101.form.country')" label-for="input-1">
                <b-form-select id="input-1" v-model="form.country" :options="countryList"></b-form-select>
              </b-form-group>
            </b-col>
            <b-col cols="6">
              <b-form-group id="input-group-2" :label="$t('gma2App.wcc101.form.cerfStatus')" label-for="input-2">
                <b-form-select id="input-2" v-model="form.cerfStatus" :options="cerfStatusList"></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="12">
              <b-form-group id="input-group-3" :label="$t('gma2App.wcc101.form.cerfNo')" label-for="input-3">
                <b-form-input id="input-3" v-model="form.cerfNo" type="text" :placeholder="$t('gma2App.wcc101.form.cerfNo')"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>

          <b-row>
            <b-col cols="12" class="d-flex justify-content-end">
              <b-button-group>
                <b-button type="submit" variant="primary"
                  ><b-icon icon="search"></b-icon> <span v-text="$t('gma2App.wcc101.home.submitLabel')">search</span></b-button
                >
                <b-button type="reset" variant="outline-secondary"
                  ><b-icon icon="eraser"></b-icon> <span v-text="$t('gma2App.wcc101.home.resetLabel')">eraser</span></b-button
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
          <span v-text="$t('gma2App.wcc101.home.notFound')">No data found</span>
        </div>
      </b-col>
      <b-col cols="12">
        <table class="table table-striped" aria-describedby="cerfs">
          <thead>
            <tr>
              <th scope="row" v-on:click="changeOrder('id')">
                <span v-text="$t('global.field.id')">ID</span>
              </th>
              <th scope="row" v-on:click="changeOrder('cerfNo')">
                <span v-text="$t('gma2App.cerf.cerfNo')">Cerf No</span>
              </th>
              <th scope="row" v-on:click="changeOrder('areaCd')">
                <span v-text="$t('gma2App.cerf.areaCd')">Area Cd</span>
              </th>
              <th scope="row" v-on:click="changeOrder('issuFt')">
                <span v-text="$t('gma2App.cerf.issuFt')">Issu Ft</span>
              </th>
              <th scope="row" v-on:click="changeOrder('cerfExpDt')">
                <span v-text="$t('gma2App.cerf.cerfExpDt')">Cerf Exp Dt</span>
              </th>
              <th scope="row" v-on:click="changeOrder('effFg')">
                <span v-text="$t('gma2App.cerf.effFg')">Eff Fg</span>
              </th>
              <th scope="row" v-on:click="changeOrder('applId')">
                <span v-text="$t('gma2App.cerf.applId')">Appl Id</span>
              </th>
              <th scope="row"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="cerf in cerfs" :key="cerf.id" data-cy="entityTable">
              <td>
                <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }">{{ cerf.id }}</router-link>
              </td>
              <td>{{ cerf.cerfNo }}</td>
              <td>{{ cerf.areaCd }}</td>
              <td>{{ cerf.issuFt ? $d(Date.parse(cerf.issuFt), 'short') : '' }}</td>
              <td>{{ cerf.cerfExpDt ? $d(Date.parse(cerf.cerfExpDt), 'short') : '' }}</td>
              <td>{{ cerf.effFg }}</td>
              <td>{{ cerf.applId }}</td>
              <td class="text-right">
                <b-button variant="success" size="sm"><b-icon icon="eye"></b-icon> <span>詳情Q</span></b-button>
                <!-- <div class="btn-group">
                <router-link :to="{ name: 'CerfView', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CerfEdit', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cerf)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div> -->
              </td>
            </tr>
          </tbody>
        </table>
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
