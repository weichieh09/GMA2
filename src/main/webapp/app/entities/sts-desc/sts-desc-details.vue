<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="stsDesc">
        <h2 class="jh-entity-heading" data-cy="stsDescDetailsHeading">
          <span v-text="$t('gma2App.stsDesc.detail.title')">StsDesc</span> {{ stsDesc.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.stsDesc.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ stsDesc.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stsDesc.stsDesc')">Sts Desc</span>
          </dt>
          <dd>
            <span>{{ stsDesc.stsDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stsDesc.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ stsDesc.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stsDesc.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ stsDesc.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="stsDesc.id" :to="{ name: 'StsDescEdit', params: { stsDescId: stsDesc.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./sts-desc-details.component.ts"></script>
