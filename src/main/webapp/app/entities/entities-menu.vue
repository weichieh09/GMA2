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
    <b-dropdown-item to="/prod-fee">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.prodFee')">Prod Fee</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
