<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfCompany">
        <h2 class="jh-entity-heading" data-cy="cerfCompanyDetailsHeading">
          <span v-text="$t('gma2App.cerfCompany.detail.title')">CerfCompany</span> {{ cerfCompany.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfCompany.relType')">Rel Type</span>
          </dt>
          <dd>
            <span>{{ cerfCompany.relType }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfCompany.cerf')">Cerf</span>
          </dt>
          <dd>
            <div v-if="cerfCompany.cerf">
              <router-link :to="{ name: 'CerfView', params: { cerfId: cerfCompany.cerf.id } }">{{ cerfCompany.cerf.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfCompany.company')">Company</span>
          </dt>
          <dd>
            <div v-if="cerfCompany.company">
              <router-link :to="{ name: 'CompanyView', params: { companyId: cerfCompany.company.id } }">{{
                cerfCompany.company.id
              }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cerfCompany.id"
          :to="{ name: 'CerfCompanyEdit', params: { cerfCompanyId: cerfCompany.id } }"
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

<script lang="ts" src="./cerf-company-details.component.ts"></script>
