<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerf2MnfctrView">
        <h2 class="jh-entity-heading" data-cy="cerf2MnfctrViewDetailsHeading">
          <span v-text="$t('gma2App.cerf2MnfctrView.detail.title')">Cerf2MnfctrView</span> {{ cerf2MnfctrView.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.cerfNo')">Cerf No</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.cerfNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.cerfVer')">Cerf Ver</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.cerfVer }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.area')">Area</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.area }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.sts')">Sts</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.sts }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.issuDt')">Issu Dt</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.issuDt }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.remainDays')">Remain Days</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.remainDays }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.applId')">Appl Id</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.applId }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.mnfctrNmCh')">Mnfctr Nm Ch</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.mnfctrNmCh }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.upldFile')">Upld File</span>
          </dt>
          <dd>
            <div v-if="cerf2MnfctrView.upldFile">
              <a v-on:click="openFile(cerf2MnfctrView.upldFileContentType, cerf2MnfctrView.upldFile)" v-text="$t('entity.action.open')"
                >open</a
              >
              {{ cerf2MnfctrView.upldFileContentType }}, {{ byteSize(cerf2MnfctrView.upldFile) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.imageFile')">Image File</span>
          </dt>
          <dd>
            <div v-if="cerf2MnfctrView.imageFile">
              <a v-on:click="openFile(cerf2MnfctrView.imageFileContentType, cerf2MnfctrView.imageFile)">
                <img
                  v-bind:src="'data:' + cerf2MnfctrView.imageFileContentType + ';base64,' + cerf2MnfctrView.imageFile"
                  style="max-width: 100%"
                  alt="cerf2MnfctrView image"
                />
              </a>
              {{ cerf2MnfctrView.imageFileContentType }}, {{ byteSize(cerf2MnfctrView.imageFile) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerf2MnfctrView.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ cerf2MnfctrView.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-2-mnfctr-view-details.component.ts"></script>
