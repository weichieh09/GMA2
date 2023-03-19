<template>
  <div>
    <b-dropdown-item to="/cerf">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerf')">Cerf</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-fee">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfFee')">Cerf Fee</span>
    </b-dropdown-item>
    <b-dropdown-item to="/mnfctr">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mnfctr')">Mnfctr</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prod')">Prod</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-2-cerf">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prod2Cerf')">Prod 2 Cerf</span>
    </b-dropdown-item>
    <b-dropdown-item to="/std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.std')">Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/area-desc">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.areaDesc')">Area Desc</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-img">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfImg')">Cerf Img</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cref-2-std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cref2Std')">Cref 2 Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/fee-desc">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.feeDesc')">Fee Desc</span>
    </b-dropdown-item>
    <b-dropdown-item to="/mnfctr-fee">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mnfctrFee')">Mnfctr Fee</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-2-fcty">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prod2Fcty')">Prod 2 Fcty</span>
    </b-dropdown-item>
    <b-dropdown-item to="/prod-2-std">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prod2Std')">Prod 2 Std</span>
    </b-dropdown-item>
    <b-dropdown-item to="/std-fee">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.stdFee')">Std Fee</span>
    </b-dropdown-item>
    <b-dropdown-item to="/sts-desc">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.stsDesc')">Sts Desc</span>
    </b-dropdown-item>
    <b-dropdown-item to="/cerf-search-view">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.cerfSearchView')">Cerf Search View</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
