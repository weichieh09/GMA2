<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfView">
        <h2 class="jh-entity-heading" data-cy="cerfViewDetailsHeading">
          <span v-text="$t('gma2App.cerfView.detail.title')">CerfView</span> {{ cerfView.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfView.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerfView.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfView.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerfView.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfView.feeDt')">Fee Dt</span>
          </dt>
          <dd>
            <span>{{ cerfView.feeDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfView.feeDesc')">Fee Desc</span>
          </dt>
          <dd>
            <span>{{ cerfView.feeDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfView.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ cerfView.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfView.msg01')">Msg 01</span>
          </dt>
          <dd>
            <span>{{ cerfView.msg01 }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-view-details.component.ts"></script>
