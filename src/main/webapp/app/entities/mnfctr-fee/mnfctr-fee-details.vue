<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="mnfctrFee">
        <h2 class="jh-entity-heading" data-cy="mnfctrFeeDetailsHeading">
          <span v-text="$t('gma2App.mnfctrFee.detail.title')">MnfctrFee</span> {{ mnfctrFee.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.fctyId')">Fcty Id</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.fctyId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.feeCd')">Fee Cd</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.feeCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.feeDt')">Fee Dt</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.feeDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.curr')">Curr</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.curr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.mnfctrFee.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ mnfctrFee.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="mnfctrFee.id"
          :to="{ name: 'MnfctrFeeEdit', params: { mnfctrFeeId: mnfctrFee.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./mnfctr-fee-details.component.ts"></script>
