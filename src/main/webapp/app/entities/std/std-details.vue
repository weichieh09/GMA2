<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="std">
        <h2 class="jh-entity-heading" data-cy="stdDetailsHeading"><span v-text="$t('gma2App.std.detail.title')">Std</span> {{ std.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.std.stdNo')">Std No</span>
          </dt>
          <dd>
            <span>{{ std.stdNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.stdVer')">Std Ver</span>
          </dt>
          <dd>
            <span>{{ std.stdVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.stsCd')">Sts Cd</span>
          </dt>
          <dd>
            <span>{{ std.stsCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.stdCd')">Std Cd</span>
          </dt>
          <dd>
            <span>{{ std.stdCd }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.stdNm')">Std Nm</span>
          </dt>
          <dd>
            <span>{{ std.stdNm }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.stdExpDt')">Std Exp Dt</span>
          </dt>
          <dd>
            <span>{{ std.stdExpDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.remainDays')">Remain Days</span>
          </dt>
          <dd>
            <span>{{ std.remainDays }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ std.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.std.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ std.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="std.id" :to="{ name: 'StdEdit', params: { stdId: std.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./std-details.component.ts"></script>
