<template>
  <div class="container">
    <main>
      <div class="py-3">
        <h2>建立或編輯</h2>
      </div>

      <div class="row">
        <div class="col-md-12">
          <form class="needs-validation">
            <h4 class="mb-3">證書</h4>
            <div class="row g-3">
              <div class="col-sm-6">
                <label class="form-label">國家代碼</label>
                <div class="input-group">
                  <input type="text" class="form-control" v-model="cerf.countryInput" disabled />
                  <b-button variant="outline-secondary" v-b-modal.modal-countryList>編輯</b-button>
                  <b-modal id="modal-countryList" hide-footer title="國家代碼">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                      <b-button-group>
                        <b-button type="submit" variant="primary" @click="modalSearch"><b-icon icon="search" />搜尋</b-button>
                        <b-button type="reset" variant="outline-secondary" to="/country">管理</b-button>
                      </b-button-group>
                    </div>
                    <br />
                    <b-list-group v-for="country in modal.countryList" :key="country.id">
                      <b-list-group-item button @click="modalChoice(country)">
                        {{ country.enName }}, {{ country.chName }}
                      </b-list-group-item>
                    </b-list-group>
                    <br />
                    <div v-show="modal.countryList && modal.countryList.length > 0">
                      <div class="row justify-content-center">
                        <b-pagination
                          v-model="modal.currentPage"
                          :total-rows="modal.countryTotal"
                          :per-page="modal.perPage"
                          :change="modalLoad(modal.currentPage)"
                          size="md"
                        />
                      </div>
                    </div>
                  </b-modal>
                </div>
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">狀態代碼</label>
                <input type="text" class="form-control" v-model="cerf.stsCd" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書編號</label>
                <input type="text" class="form-control" v-model="cerf.cerfNo" />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書版本號碼</label>
                <input type="text" class="form-control" v-model="cerf.cerfVer" />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書發行日期</label>
                <!-- <input type="text" class="form-control" v-model="cerf.issuDt" /> -->
                <b-input-group class="mb-3">
                  <b-input-group-prepend>
                    <b-form-datepicker v-model="cerf.issuDt" button-only today-button reset-button close-button />
                  </b-input-group-prepend>
                  <b-form-input type="text" class="form-control" v-model="cerf.issuDt" />
                </b-input-group>
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書到期日期</label>
                <!-- <input type="text" class="form-control" v-model="cerf.cerfExpDt" /> -->
                <b-input-group class="mb-3">
                  <b-input-group-prepend>
                    <b-form-datepicker v-model="cerf.cerfExpDt" button-only today-button reset-button close-button />
                  </b-input-group-prepend>
                  <b-form-input type="text" class="form-control" v-model="cerf.cerfExpDt" />
                </b-input-group>
                <br />
              </div>

              <div class="col-12">
                <label for="email" class="form-label">證書檔案</label>
                <input type="file" class="form-control" />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              廠商
              <button class="btn btn-outline-secondary" @click="previousState">編輯</button>
            </h4>
            <div class="row gy-3">
              <div class="col-md-12">
                <label class="form-label">申請商</label>
                <input type="text" class="form-control" disabled />
                <br />
              </div>

              <div class="col-md-12">
                <label class="form-label">製造商</label>
                <input type="text" class="form-control" disabled />
                <br />
              </div>

              <div class="col-md-12">
                <label class="form-label">生產廠</label>
                <input type="text" class="form-control" disabled />
                <br />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              產品
              <button class="btn btn-outline-secondary" @click="previousState">
                <span>編輯</span>
              </button>
            </h4>
            <div class="row gy-3">
              <div class="col-md-12">
                <input type="text" class="form-control" />
                <br />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              檢驗標準
              <button class="btn btn-outline-secondary" @click="previousState">編輯</button>
            </h4>
            <div class="row gy-3">
              <div class="col-md-12">
                <label class="form-label">檢驗標準</label>
                <input type="text" class="form-control" />
                <br />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              費用
              <button class="btn btn-outline-secondary" @click="previousState">編輯</button>
            </h4>
            <div class="row gy-3">
              <div class="col-md-12">
                <label class="form-label">費用</label>
                <input type="text" class="form-control" />
                <br />
              </div>
            </div>
          </form>
        </div>
        <button class="btn btn-info" @click="previousState"><b-icon icon="arrow-left"></b-icon> <span>返回</span></button>
      </div>
    </main>
  </div>
</template>

<script lang="ts" src="./wcc311.ts"></script>
