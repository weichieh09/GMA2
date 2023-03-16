<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="stdFee">
        <h2 class="jh-entity-heading" data-cy="stdFeeDetailsHeading">
          <span v-text="$t('gma2App.stdFee.detail.title')">StdFee</span> {{ stdFee.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.stdFee.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ stdFee.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ stdFee.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.stdNo')">Std No</span>
          </dt>
          <dd>
            <span>{{ stdFee.stdNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.stdVer')">Std Ver</span>
          </dt>
          <dd>
            <span>{{ stdFee.stdVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ stdFee.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.feeCd')">Fee Cd</span>
          </dt>
          <dd>
            <span>{{ stdFee.feeCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.feeDt')">Fee Dt</span>
          </dt>
          <dd>
            <span>{{ stdFee.feeDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ stdFee.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.curr')">Curr</span>
          </dt>
          <dd>
            <span>{{ stdFee.curr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ stdFee.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.stdFee.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ stdFee.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="stdFee.id" :to="{ name: 'StdFeeEdit', params: { stdFeeId: stdFee.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./std-fee-details.component.ts"></script>
