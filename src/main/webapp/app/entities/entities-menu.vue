<template>
  <div>
    <b-dropdown-item to="/prod">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prod')">Prod</span>
    </b-dropdown-item>
    <b-dropdown-item to="/country">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.country')">Country</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerf')">Cerf</span>
    </b-dropdown-item>
    <b-dropdown-item to="/std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.std')">Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/mark">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mark')">Mark</span>
    </b-dropdown-item>
    <b-dropdown-item to="/company">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.company')">Company</span>
    </b-dropdown-item>
    <b-dropdown-item to="/fee-prod-cerf-company">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.feeProdCerfCompany')">Fee Prod Cerf Company</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-company">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfCompany')">Cerf Company</span>
    </b-dropdown-item>
    <b-dropdown-item to="/sticker">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.sticker')">Sticker</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-country">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prodCountry')">Prod Country</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prodStd')">Prod Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-prod">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfProd')">Cerf Prod</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfStd')">Cerf Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/country-std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.countryStd')">Country Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-mark">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfMark')">Cerf Mark</span>
    </b-dropdown-item>
    <b-dropdown-item to="/sticker-mark">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.stickerMark')">Sticker Mark</span>
    </b-dropdown-item>
    <b-dropdown-item to="/country-cert">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.countryCert')">Country Cert</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-sticker">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prodSticker')">Prod Sticker</span>
    </b-dropdown-item>
    <b-dropdown-item to="/country-mark">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.countryMark')">Country Mark</span>
    </b-dropdown-item>
    <b-dropdown-item to="/wcc-412-view">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.wcc412View')">Wcc 412 View</span>
    </b-dropdown-item>
    <b-dropdown-item to="/wcc-421-view">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.wcc421View')">Wcc 421 View</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
