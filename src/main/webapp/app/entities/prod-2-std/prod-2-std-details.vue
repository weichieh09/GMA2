<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prod2Std">
        <h2 class="jh-entity-heading" data-cy="prod2StdDetailsHeading">
          <span v-text="$t('gma2App.prod2Std.detail.title')">Prod2Std</span> {{ prod2Std.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prod2Std.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ prod2Std.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ prod2Std.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.stdNo')">Std No</span>
          </dt>
          <dd>
            <span>{{ prod2Std.stdNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.stdVer')">Std Ver</span>
          </dt>
          <dd>
            <span>{{ prod2Std.stdVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ prod2Std.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ prod2Std.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Std.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ prod2Std.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="prod2Std.id" :to="{ name: 'Prod2StdEdit', params: { prod2StdId: prod2Std.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-2-std-details.component.ts"></script>
