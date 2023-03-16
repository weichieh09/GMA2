<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prod2Fcty">
        <h2 class="jh-entity-heading" data-cy="prod2FctyDetailsHeading">
          <span v-text="$t('gma2App.prod2Fcty.detail.title')">Prod2Fcty</span> {{ prod2Fcty.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.prodId')">Prod Id</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.prodId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.mnfctrId')">Mnfctr Id</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.mnfctrId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.fctyId')">Fcty Id</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.fctyId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.inspectDt')">Inspect Dt</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.inspectDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.discontinueFg')">Discontinue Fg</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.discontinueFg }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.discontinueDesc')">Discontinue Desc</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.discontinueDesc }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod2Fcty.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ prod2Fcty.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="prod2Fcty.id"
          :to="{ name: 'Prod2FctyEdit', params: { prod2FctyId: prod2Fcty.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-2-fcty-details.component.ts"></script>
