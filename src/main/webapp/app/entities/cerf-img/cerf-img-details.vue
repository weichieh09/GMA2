<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cerfImg">
        <h2 class="jh-entity-heading" data-cy="cerfImgDetailsHeading">
          <span v-text="$t('gma2App.cerfImg.detail.title')">CerfImg</span> {{ cerfImg.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.cerfImg.cerfTag')">Cerf Tag</span>
          </dt>
          <dd>
            <span>{{ cerfImg.cerfTag }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfImg.imageFile')">Image File</span>
          </dt>
          <dd>
            <div v-if="cerfImg.imageFile">
              <a v-on:click="openFile(cerfImg.imageFileContentType, cerfImg.imageFile)">
                <img
                  v-bind:src="'data:' + cerfImg.imageFileContentType + ';base64,' + cerfImg.imageFile"
                  style="max-width: 100%"
                  alt="cerfImg image"
                />
              </a>
              {{ cerfImg.imageFileContentType }}, {{ byteSize(cerfImg.imageFile) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfImg.lstMtnUsr')">Lst Mtn Usr</span>
          </dt>
          <dd>
            <span>{{ cerfImg.lstMtnUsr }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.cerfImg.lstMtnDt')">Lst Mtn Dt</span>
          </dt>
          <dd>
            <span>{{ cerfImg.lstMtnDt }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="cerfImg.id" :to="{ name: 'CerfImgEdit', params: { cerfImgId: cerfImg.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cerf-img-details.component.ts"></script>
