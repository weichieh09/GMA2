<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fee">
        <h2 class="jh-entity-heading" data-cy="feeDetailsHeading"><span v-text="$t('gma2App.fee.detail.title')">Fee</span> {{ fee.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.fee.fee')">Fee</span>
          </dt>
          <dd>
            <span>{{ fee.fee }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.fee.feeType')">Fee Type</span>
          </dt>
          <dd>
            <span>{{ fee.feeType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.fee.feeDt')">Fee Dt</span>
          </dt>
          <dd>
            <span>{{ fee.feeDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.fee.prod')">Prod</span>
          </dt>
          <dd>
            <div v-if="fee.prod">
              <router-link :to="{ name: 'ProdView', params: { prodId: fee.prod.id } }">{{ fee.prod.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.fee.cerf')">Cerf</span>
          </dt>
          <dd>
            <div v-if="fee.cerf">
              <router-link :to="{ name: 'CerfView', params: { cerfId: fee.cerf.id } }">{{ fee.cerf.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.fee.company')">Company</span>
          </dt>
          <dd>
            <div v-if="fee.company">
              <router-link :to="{ name: 'CompanyView', params: { companyId: fee.company.id } }">{{ fee.company.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="fee.id" :to="{ name: 'FeeEdit', params: { feeId: fee.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./fee-details.component.ts"></script>
