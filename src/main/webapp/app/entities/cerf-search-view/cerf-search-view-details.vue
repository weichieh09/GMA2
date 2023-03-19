<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfSearchView">
        <h2 class="jh-entity-heading" data-cy="cerfSearchViewDetailsHeading">
          <span v-text="$t('gma2App.cerfSearchView.detail.title')">CerfSearchView</span> {{ cerfSearchView.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.feeCd')">Fee Cd</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.feeCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.feeDesc')">Fee Desc</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.feeDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.areaDesc')">Area Desc</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.areaDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.stsDesc')">Sts Desc</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.stsDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.mnfctrNmCh')">Mnfctr Nm Ch</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.mnfctrNmCh }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfSearchView.fctyId')">Fcty Id</span>
          </dt>
          <dd>
            <span>{{ cerfSearchView.fctyId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-search-view-details.component.ts"></script>
