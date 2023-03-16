<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prod">
        <h2 class="jh-entity-heading" data-cy="prodDetailsHeading">
          <span v-text="$t('gma2App.prod.detail.title')">Prod</span> {{ prod.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prod.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ prod.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ prod.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.prodNmCh')">Prod Nm Ch</span>
          </dt>
          <dd>
            <span>{{ prod.prodNmCh }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.prodNmEn')">Prod Nm En</span>
          </dt>
          <dd>
            <span>{{ prod.prodNmEn }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.hsCd')">Hs Cd</span>
          </dt>
          <dd>
            <span>{{ prod.hsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.cccCd')">Ccc Cd</span>
          </dt>
          <dd>
            <span>{{ prod.cccCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ prod.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ prod.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="prod.id" :to="{ name: 'ProdEdit', params: { prodId: prod.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-details.component.ts"></script>
