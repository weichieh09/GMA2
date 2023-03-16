<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerf">
        <h2 class="jh-entity-heading" data-cy="cerfDetailsHeading">
          <span v-text="$t('gma2App.cerf.detail.title')">Cerf</span> {{ cerf.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerf.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ cerf.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ cerf.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ cerf.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.cerfTag')">Cerf Tag</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfTag }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.issuDt')">Issu Dt</span>
          </dt>
          <dd>
            <span>{{ cerf.issuDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.cerfExpDt')">Cerf Exp Dt</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfExpDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.remainDays')">Remain Days</span>
          </dt>
          <dd>
            <span>{{ cerf.remainDays }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.upldFile')">Upld File</span>
          </dt>
          <dd>
            <div v-if="cerf.upldFile">
              <a v-on:click="openFile(cerf.upldFileContentType, cerf.upldFile)" v-text="$t('entity.action.open')">open</a>
              {{ cerf.upldFileContentType }}, {{ byteSize(cerf.upldFile) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ cerf.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ cerf.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerf.id" :to="{ name: 'CerfEdit', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-details.component.ts"></script>
