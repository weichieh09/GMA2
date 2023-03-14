<template>
  <b-container fluid>
    <b-row>
      <h2 id="page-heading">
        <span>Wcc201</span>
      </h2> </b-row
    ><br />
    <b-row>
      <b-col cols="6">
        <select class="form-control">
          <option v-bind:value="0">國家</option>
          <!-- <option v-bind:value="itemOption.id" v-for="itemOption in items" :key="itemOption.id">
              {{ itemOption.name }}
            </option> -->
        </select>
      </b-col>
      <b-col cols="6">
        <select class="form-control">
          <option v-bind:value="0">證書狀態</option>
          <!-- <option v-bind:value="itemOption.id" v-for="itemOption in items" :key="itemOption.id">
              {{ itemOption.name }}
            </option> -->
        </select>
      </b-col> </b-row
    ><br />
    <b-row>
      <b-col cols="12">
        <input type="text" class="form-control" v-bind:placeholder="$t('gmaApp.wcc201.form.cerfNo')" />
      </b-col> </b-row
    ><br />
    <b-row>
      <b-col cols="12" class="d-flex justify-content-end">
        <button class="btn btn-info mr-2">
          <font-awesome-icon icon="search"></font-awesome-icon>
          <span>搜尋</span>
        </button>
      </b-col> </b-row
    ><br />
  </b-container>
</template>

<script lang="ts" src="./index.ts"></script>
