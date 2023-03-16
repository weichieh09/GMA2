<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cref2Std">
        <h2 class="jh-entity-heading" data-cy="cref2StdDetailsHeading">
          <span v-text="$t('gma2App.cref2Std.detail.title')">Cref2Std</span> {{ cref2Std.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cref2Std.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cref2Std.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cref2Std.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.areaCd')">Area Cd</span>
          </dt>
          <dd>
            <span>{{ cref2Std.areaCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ cref2Std.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.cerfTag')">Cerf Tag</span>
          </dt>
          <dd>
            <span>{{ cref2Std.cerfTag }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.stdNo')">Std No</span>
          </dt>
          <dd>
            <span>{{ cref2Std.stdNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.stdVer')">Std Ver</span>
          </dt>
          <dd>
            <span>{{ cref2Std.stdVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ cref2Std.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ cref2Std.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cref2Std.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ cref2Std.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cref2Std.id" :to="{ name: 'Cref2StdEdit', params: { cref2StdId: cref2Std.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cref-2-std-details.component.ts"></script>
