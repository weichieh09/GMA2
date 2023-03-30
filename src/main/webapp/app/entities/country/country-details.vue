<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="country">
        <h2 class="jh-entity-heading" data-cy="countryDetailsHeading">
          <span v-text="$t('gma2App.country.detail.title')">Country</span> {{ country.id }}
        </h2>
        <br />
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.country.countryNo')">Country No</span>
          </dt>
          <dd>
            <span>{{ country.countryNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.country.enName')">En Name</span>
          </dt>
          <dd>
            <span>{{ country.enName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.country.chName')">Ch Name</span>
          </dt>
          <dd>
            <span>{{ country.chName }}</span>
          </dd>
          <!-- <dt>
            <span v-text="$t('gma2App.country.std')">Std</span>
          </dt>
          <dd>
            <span v-for="(std, i) in country.stds" :key="std.id">{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
            </span>
          </dd> -->
        </dl>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="country.id" :to="{ name: 'CountryEdit', params: { countryId: country.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./country-details.component.ts"></script>
