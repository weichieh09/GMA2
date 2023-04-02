<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfMark">
        <h2 class="jh-entity-heading" data-cy="cerfMarkDetailsHeading">
          <span v-text="$t('gma2App.cerfMark.detail.title')">CerfMark</span> {{ cerfMark.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfMark.relType')">Rel Type</span>
          </dt>
          <dd>
            <span>{{ cerfMark.relType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfMark.cerf')">Cerf</span>
          </dt>
          <dd>
            <div v-if="cerfMark.cerf">
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerfMark.cerf.id } }">{{ cerfMark.cerf.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfMark.mark')">Mark</span>
          </dt>
          <dd>
            <div v-if="cerfMark.mark">
              <router-link :to="{ name: 'MarkView', params: { markId: cerfMark.mark.id } }">{{ cerfMark.mark.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerfMark.id" :to="{ name: 'CerfMarkEdit', params: { cerfMarkId: cerfMark.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-mark-details.component.ts"></script>
