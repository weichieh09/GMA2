<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerf2StdView">
        <h2 class="jh-entity-heading" data-cy="cerf2StdViewDetailsHeading">
          <span v-text="$t('gma2App.cerf2StdView.detail.title')">Cerf2StdView</span> {{ cerf2StdView.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerf2StdView.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerf2StdView.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2StdView.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerf2StdView.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2StdView.stdNo')">Std No</span>
          </dt>
          <dd>
            <span>{{ cerf2StdView.stdNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2StdView.stdVer')">Std Ver</span>
          </dt>
          <dd>
            <span>{{ cerf2StdView.stdVer }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-std-view-details.component.ts"></script>
