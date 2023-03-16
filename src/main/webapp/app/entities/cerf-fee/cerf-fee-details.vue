<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfFee">
        <h2 class="jh-entity-heading" data-cy="cerfFeeDetailsHeading">
          <span v-text="$t('gma2App.cerfFee.detail.title')">CerfFee</span> {{ cerfFee.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfFee.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerfFee.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerfFee.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.cerfTag')">Cerf Tag</span>
          </dt>
          <dd>
            <span>{{ cerfFee.cerfTag }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ cerfFee.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ cerfFee.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ cerfFee.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.feeCd')">Fee Cd</span>
          </dt>
          <dd>
            <span>{{ cerfFee.feeCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.feeDt')">Fee Dt</span>
          </dt>
          <dd>
            <span>{{ cerfFee.feeDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ cerfFee.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.curr')">Curr</span>
          </dt>
          <dd>
            <span>{{ cerfFee.curr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ cerfFee.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfFee.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ cerfFee.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerfFee.id" :to="{ name: 'CerfFeeEdit', params: { cerfFeeId: cerfFee.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-fee-details.component.ts"></script>
