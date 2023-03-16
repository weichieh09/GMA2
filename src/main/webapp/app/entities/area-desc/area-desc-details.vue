<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="areaDesc">
        <h2 class="jh-entity-heading" data-cy="areaDescDetailsHeading">
          <span v-text="$t('gma2App.areaDesc.detail.title')">AreaDesc</span> {{ areaDesc.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.areaDesc.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ areaDesc.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.areaDesc.areaDesc')">Area Desc</span>
          </dt>
          <dd>
            <span>{{ areaDesc.areaDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.areaDesc.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ areaDesc.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.areaDesc.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ areaDesc.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="areaDesc.id" :to="{ name: 'AreaDescEdit', params: { areaDescId: areaDesc.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./area-desc-details.component.ts"></script>
