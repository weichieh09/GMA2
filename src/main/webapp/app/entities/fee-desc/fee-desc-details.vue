<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="feeDesc">
        <h2 class="jh-entity-heading" data-cy="feeDescDetailsHeading">
          <span v-text="$t('gma2App.feeDesc.detail.title')">FeeDesc</span> {{ feeDesc.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.feeDesc.feeCd')">Fee Cd</span>
          </dt>
          <dd>
            <span>{{ feeDesc.feeCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.feeDesc.feeDesc')">Fee Desc</span>
          </dt>
          <dd>
            <span>{{ feeDesc.feeDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.feeDesc.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ feeDesc.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.feeDesc.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ feeDesc.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="feeDesc.id" :to="{ name: 'FeeDescEdit', params: { feeDescId: feeDesc.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./fee-desc-details.component.ts"></script>
