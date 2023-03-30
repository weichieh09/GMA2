<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerf">
        <h2 class="jh-entity-heading" data-cy="cerfDetailsHeading">
          <span v-text="$t('gma2App.cerf.detail.title')">Cerf</span> {{ cerf.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerf.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerf.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.status')">Status</span>
          </dt>
          <dd>
            <span>{{ cerf.status }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.pdf')">Pdf</span>
          </dt>
          <dd>
            <div v-if="cerf.pdf">
              <a v-on:click="openFile(cerf.pdfContentType, cerf.pdf)" v-text="$t('entity.action.open')">open</a>
              {{ cerf.pdfContentType }}, {{ byteSize(cerf.pdf) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.issuDt')">Issu Dt</span>
          </dt>
          <dd>
            <span>{{ cerf.issuDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.expDt')">Exp Dt</span>
          </dt>
          <dd>
            <span>{{ cerf.expDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.prod')">Prod</span>
          </dt>
          <dd>
            <span v-for="(prod, i) in cerf.prods" :key="prod.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'ProdView', params: { prodId: prod.id } }">{{ prod.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.std')">Std</span>
          </dt>
          <dd>
            <span v-for="(std, i) in cerf.stds" :key="std.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'StdView', params: { stdId: std.id } }">{{ std.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.mark')">Mark</span>
          </dt>
          <dd>
            <span v-for="(mark, i) in cerf.marks" :key="mark.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'MarkView', params: { markId: mark.id } }">{{ mark.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf.country')">Country</span>
          </dt>
          <dd>
            <div v-if="cerf.country">
              <router-link :to="{ name: 'CountryView', params: { countryId: cerf.country.id } }">{{ cerf.country.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerf.id" :to="{ name: 'CerfEdit', params: { cerfId: cerf.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-details.component.ts"></script>
