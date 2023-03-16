<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="mnfctr">
        <h2 class="jh-entity-heading" data-cy="mnfctrDetailsHeading">
          <span v-text="$t('gma2App.mnfctr.detail.title')">Mnfctr</span> {{ mnfctr.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.mnfctr.uniNo')">Uni No</span>
          </dt>
          <dd>
            <span>{{ mnfctr.uniNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.mnfctrNmEn')">Mnfctr Nm En</span>
          </dt>
          <dd>
            <span>{{ mnfctr.mnfctrNmEn }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.mnfctrNmCh')">Mnfctr Nm Ch</span>
          </dt>
          <dd>
            <span>{{ mnfctr.mnfctrNmCh }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.contact')">Contact</span>
          </dt>
          <dd>
            <span>{{ mnfctr.contact }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.eamil')">Eamil</span>
          </dt>
          <dd>
            <span>{{ mnfctr.eamil }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.addr')">Addr</span>
          </dt>
          <dd>
            <span>{{ mnfctr.addr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.tel')">Tel</span>
          </dt>
          <dd>
            <span>{{ mnfctr.tel }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ mnfctr.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctr.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ mnfctr.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="mnfctr.id" :to="{ name: 'MnfctrEdit', params: { mnfctrId: mnfctr.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./mnfctr-details.component.ts"></script>
