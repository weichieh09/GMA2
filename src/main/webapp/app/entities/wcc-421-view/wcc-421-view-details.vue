<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="wcc421View">
        <h2 class="jh-entity-heading" data-cy="wcc421ViewDetailsHeading">
          <span v-text="$t('gma2App.wcc421View.detail.title')">Wcc421View</span> {{ wcc421View.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.wcc421View.cerfId')">Cerf Id</span>
          </dt>
          <dd>
            <span>{{ wcc421View.cerfId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.countryChName')">Country Ch Name</span>
          </dt>
          <dd>
            <span>{{ wcc421View.countryChName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ wcc421View.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ wcc421View.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.cerfStatus')">Cerf Status</span>
          </dt>
          <dd>
            <span>{{ wcc421View.cerfStatus }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.companyChName')">Company Ch Name</span>
          </dt>
          <dd>
            <span>{{ wcc421View.companyChName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.wcc421View.relType')">Rel Type</span>
          </dt>
          <dd>
            <span>{{ wcc421View.relType }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./wcc-421-view-details.component.ts"></script>
