<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="prod">
        <h2 class="jh-entity-heading" data-cy="prodDetailsHeading">
          <span v-text="$t('gma2App.prod.detail.title')">Prod</span> {{ prod.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.prod.prodNo')">Prod No</span>
          </dt>
          <dd>
            <span>{{ prod.prodNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.enName')">En Name</span>
          </dt>
          <dd>
            <span>{{ prod.enName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.chName')">Ch Name</span>
          </dt>
          <dd>
            <span>{{ prod.chName }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.hsCode')">Hs Code</span>
          </dt>
          <dd>
            <span>{{ prod.hsCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.cccCode')">Ccc Code</span>
          </dt>
          <dd>
            <span>{{ prod.cccCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.country')">Country</span>
          </dt>
          <dd>
            <span v-for="(country, i) in prod.countries" :key="country.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'CountryView', params: { countryId: country.id } }">{{ country.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.std')">Std</span>
          </dt>
          <dd>
            <span v-for="(std, i) in prod.stds" :key="std.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.prod.sticker')">Sticker</span>
          </dt>
          <dd>
            <div v-if="prod.sticker">
              <router-link :to="{ name: 'StickerView', params: { stickerId: prod.sticker.id } }">{{ prod.sticker.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="prod.id" :to="{ name: 'ProdEdit', params: { prodId: prod.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./prod-details.component.ts"></script>
