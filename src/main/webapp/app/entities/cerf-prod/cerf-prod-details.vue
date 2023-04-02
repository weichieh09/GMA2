<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfProd">
        <h2 class="jh-entity-heading" data-cy="cerfProdDetailsHeading">
          <span v-text="$t('gma2App.cerfProd.detail.title')">CerfProd</span> {{ cerfProd.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfProd.relType')">Rel Type</span>
          </dt>
          <dd>
            <span>{{ cerfProd.relType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfProd.cerf')">Cerf</span>
          </dt>
          <dd>
            <div v-if="cerfProd.cerf">
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerfProd.cerf.id } }">{{ cerfProd.cerf.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfProd.prod')">Prod</span>
          </dt>
          <dd>
            <div v-if="cerfProd.prod">
              <router-link :to="{ name: 'ProdView', params: { prodId: cerfProd.prod.id } }">{{ cerfProd.prod.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerfProd.id" :to="{ name: 'CerfProdEdit', params: { cerfProdId: cerfProd.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-prod-details.component.ts"></script>
