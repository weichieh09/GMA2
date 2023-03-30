<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="sticker">
        <h2 class="jh-entity-heading" data-cy="stickerDetailsHeading">
          <span v-text="$t('gma2App.sticker.detail.title')">Sticker</span> {{ sticker.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('gma2App.sticker.stickerNo')">Sticker No</span>
          </dt>
          <dd>
            <span>{{ sticker.stickerNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.sticker.img')">Img</span>
          </dt>
          <dd>
            <div v-if="sticker.img">
              <a v-on:click="openFile(sticker.imgContentType, sticker.img)">
                <img v-bind:src="'data:' + sticker.imgContentType + ';base64,' + sticker.img" style="max-width: 100%" alt="sticker image" />
              </a>
              {{ sticker.imgContentType }}, {{ byteSize(sticker.img) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('gma2App.sticker.mark')">Mark</span>
          </dt>
          <dd>
            <span v-for="(mark, i) in sticker.marks" :key="mark.id"
              >{{ i > 0 ? ', ' : '' }}
              <router-link :to="{ name: 'MarkView', params: { markId: mark.id } }">{{ mark.id }}</router-link>
            </span>
          </dd>
          <dt>
            <span v-text="$t('gma2App.sticker.prod')">Prod</span>
          </dt>
          <dd>
            <div v-if="sticker.prod">
              <router-link :to="{ name: 'ProdView', params: { prodId: sticker.prod.id } }">{{ sticker.prod.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="sticker.id" :to="{ name: 'StickerEdit', params: { stickerId: sticker.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./sticker-details.component.ts"></script>
