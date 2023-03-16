<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prod2Cerf">
        <h2 class="jh-entity-heading" data-cy="prod2CerfDetailsHeading">
          <span v-text="$t('gma2App.prod2Cerf.detail.title')">Prod2Cerf</span> {{ prod2Cerf.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.cerfTag')">Cerf Tag</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.cerfTag }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Cerf.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ prod2Cerf.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="prod2Cerf.id"
          :to="{ name: 'Prod2CerfEdit', params: { prod2CerfId: prod2Cerf.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-2-cerf-details.component.ts"></script>
