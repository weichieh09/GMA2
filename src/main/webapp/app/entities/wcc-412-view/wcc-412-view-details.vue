<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="wcc412View">
        <h2 class="jh-entity-heading" data-cy="wcc412ViewDetailsHeading">
          <span v-text="$t('gma2App.wcc412View.detail.title')">Wcc412View</span> {{ wcc412View.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.wcc412View.cerfId')">Cerf Id</span>
          </dt>
          <dd>
            <span>{{ wcc412View.cerfId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.countryChName')">Country Ch Name</span>
          </dt>
          <dd>
            <span>{{ wcc412View.countryChName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ wcc412View.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ wcc412View.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.cerfStatus')">Cerf Status</span>
          </dt>
          <dd>
            <span>{{ wcc412View.cerfStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.countryId')">Country Id</span>
          </dt>
          <dd>
            <span>{{ wcc412View.countryId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.prodNo')">Prod No</span>
          </dt>
          <dd>
            <span>{{ wcc412View.prodNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc412View.prodChName')">Prod Ch Name</span>
          </dt>
          <dd>
            <span>{{ wcc412View.prodChName }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./wcc-412-view-details.component.ts"></script>
