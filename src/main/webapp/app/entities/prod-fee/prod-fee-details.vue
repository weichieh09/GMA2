<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prodFee">
        <h2 class="jh-entity-heading" data-cy="prodFeeDetailsHeading">
          <span v-text="$t('gma2App.prodFee.detail.title')">ProdFee</span> {{ prodFee.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prodFee.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ prodFee.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prodFee.feeType')">Fee Type</span>
          </dt>
          <dd>
            <span>{{ prodFee.feeType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prodFee.prod')">Prod</span>
          </dt>
          <dd>
            <div v-if="prodFee.prod">
              <router-link :to="{ name: 'ProdView', params: { prodId: prodFee.prod.id } }">{{ prodFee.prod.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="prodFee.id" :to="{ name: 'ProdFeeEdit', params: { prodFeeId: prodFee.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-fee-details.component.ts"></script>
