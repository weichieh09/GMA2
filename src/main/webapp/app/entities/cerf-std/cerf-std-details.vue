<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfStd">
        <h2 class="jh-entity-heading" data-cy="cerfStdDetailsHeading">
          <span v-text="$t('gma2App.cerfStd.detail.title')">CerfStd</span> {{ cerfStd.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfStd.relType')">Rel Type</span>
          </dt>
          <dd>
            <span>{{ cerfStd.relType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfStd.cerf')">Cerf</span>
          </dt>
          <dd>
            <div v-if="cerfStd.cerf">
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerfStd.cerf.id } }">{{ cerfStd.cerf.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfStd.std')">Std</span>
          </dt>
          <dd>
            <div v-if="cerfStd.std">
              <router-link :to="{ name: 'StdView', params: { stdId: cerfStd.std.id } }">{{ cerfStd.std.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerfStd.id" :to="{ name: 'CerfStdEdit', params: { cerfStdId: cerfStd.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-std-details.component.ts"></script>
