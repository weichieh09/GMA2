<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerf2ProdView">
        <h2 class="jh-entity-heading" data-cy="cerf2ProdViewDetailsHeading">
          <span v-text="$t('gma2App.cerf2ProdView.detail.title')">Cerf2ProdView</span> {{ cerf2ProdView.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerf2ProdView.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerf2ProdView.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2ProdView.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerf2ProdView.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2ProdView.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ cerf2ProdView.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2ProdView.prodNmCh')">Prod Nm Ch</span>
          </dt>
          <dd>
            <span>{{ cerf2ProdView.prodNmCh }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-prod-view-details.component.ts"></script>
