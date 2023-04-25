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
                  <input type="text" class="form-control" v-model="cerf.countryNoInput" disabled />
                  <b-button variant="outline-secondary" v-b-modal.modal-countryList @click="modalInit('countryList')">編輯</b-button>
                  <!-- countryList 彈跳視窗 -->
                  <b-modal id="modal-countryList" hide-footer title="選擇國家">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                      <b-button-group>
                        <b-button type="submit" variant="primary" @click="modalSearch('countryList')"
                          ><b-icon icon="search" />搜尋</b-button
                        >
                        <b-button type="reset" variant="outline-secondary" to="/country">管理</b-button>
                      </b-button-group>
                    </div>
                    <br />
                    <b-list-group v-for="country in modal.objList" :key="country.id">
                      <b-list-group-item button @click="modalChoice('countryList', 'oneChoice', country)">
                        {{ country.chName }}, {{ country.enName }}
                      </b-list-group-item>
                    </b-list-group>
                    <br />
                    <div v-show="modal.objList && modal.objList.length > 0">
                      <div class="row justify-content-center">
                        <b-pagination
                          v-model="modal.currentPage"
                          :total-rows="modal.objTotal"
                          :per-page="modal.perPage"
                          @input="modalLoad('countryList', modal.currentPage)"
                          size="md"
                        />
                      </div>
                    </div>
                  </b-modal>
                  <!-- countryList 彈跳視窗 -->
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
                <b-input-group class="mb-3">
                  <b-input-group-prepend>
                    <b-form-datepicker v-model="cerf.expDt" button-only today-button reset-button close-button />
                  </b-input-group-prepend>
                  <b-form-input type="text" class="form-control" v-model="cerf.expDt" />
                </b-input-group>
                <br />
              </div>

              <div class="col-md-12">
                <label class="form-label">
                  證書圖示
                  <b-button variant="outline-secondary" v-b-modal.modal-markList @click="modalInit('markList')">編輯</b-button>
                </label>
                <!-- countryList 彈跳視窗 -->
                <b-modal id="modal-markList" hide-footer title="選擇標籤">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                    <b-button-group>
                      <b-button type="submit" variant="primary" @click="modalSearch('markList')"><b-icon icon="search" />搜尋</b-button>
                      <b-button type="reset" variant="outline-secondary" to="/mark">管理</b-button>
                    </b-button-group>
                  </div>
                  <br />
                  <b-list-group v-for="mark in modal.objList" :key="mark.id">
                    <b-list-group-item button @click="modalChoice('markList', 'oneChoice', mark)">
                      <div class="row">
                        <div class="col-6">
                          {{ mark.chName }}<br />
                          <small>{{ mark.markNo }}</small>
                        </div>
                        <div class="col-6">
                          <img
                            v-bind:src="'data:' + mark.imgContentType + ';base64,' + mark.img"
                            style="max-height: 80px"
                            alt="mark image"
                          />
                        </div>
                      </div>
                    </b-list-group-item>
                  </b-list-group>
                  <br />
                  <div v-show="modal.objList && modal.objList.length > 0">
                    <div class="row justify-content-center">
                      <b-pagination
                        v-model="modal.currentPage"
                        :total-rows="modal.objTotal"
                        :per-page="modal.perPage"
                        @input="modalLoad('markList', modal.currentPage)"
                        size="md"
                      />
                    </div>
                  </div>
                </b-modal>
                <!-- countryList 彈跳視窗 -->
              </div>
              <div class="col-md-12">
                <b-list-group v-if="cerf.mark">
                  <b-list-group-item>
                    <div class="row">
                      <div class="col-6">
                        {{ cerf.mark.chName }}<br />
                        <small>{{ cerf.mark.markNo }}</small>
                      </div>
                      <div class="col-6">
                        <img
                          v-bind:src="'data:' + cerf.mark.imgContentType + ';base64,' + cerf.mark.img"
                          style="max-height: 80px"
                          alt="mark image"
                        />
                      </div>
                    </div>
                  </b-list-group-item>
                </b-list-group>
                <br />
              </div>

              <div class="col-md-12">
                <label for="email" class="form-label">證書檔案</label>
                <input type="file" class="form-control" v-on:change="setPdfData($event, false)" />
                <div v-if="cerf.pdf" class="form-text text-danger clearfix">
                  <span class="pull-left">檔案格式: {{ cerf.pdfContentType }}, 檔案大小: {{ byteSize(cerf.pdf) }}</span>
                  <button type="button" v-on:click="openFile(cerf.pdfContentType, cerf.pdf)" class="btn btn-primary btn-xs pull-right">
                    <font-awesome-icon icon="eye" />開啟檔案
                  </button>
                  <button
                    type="button"
                    v-on:click="
                      cerf.pdf = null;
                      cerf.pdfContentType = null;
                    "
                    class="btn btn-danger btn-xs pull-right"
                  >
                    <font-awesome-icon icon="times" />移除檔案
                  </button>
                </div>
                <br />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">廠商</h4>
            <div class="row gy-3">
              <div class="col-md-12">
                <label class="form-label">
                  申請商
                  <b-button variant="outline-secondary" v-b-modal.modal-companyApplyList @click="modalInit('companyApplyList')"
                    >編輯</b-button
                  >
                </label>
                <!-- countryList 彈跳視窗 -->
                <b-modal id="modal-companyApplyList" hide-footer title="選擇公司">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                    <b-button-group>
                      <b-button type="submit" variant="primary" @click="modalSearch('companyApplyList')"
                        ><b-icon icon="search" />搜尋</b-button
                      >
                      <b-button type="reset" variant="outline-secondary" to="/company">管理</b-button>
                    </b-button-group>
                  </div>
                  <br />
                  <b-list-group v-for="company in modal.objList" :key="company.id">
                    <b-list-group-item button @click="modalChoice('companyApplyList', 'oneChoice', company)">
                      {{ company.chName }}<br />
                      {{ company.enName }}<br />
                      <small>{{ company.peopleName }}</small>
                    </b-list-group-item>
                  </b-list-group>
                  <br />
                  <div v-show="modal.objList && modal.objList.length > 0">
                    <div class="row justify-content-center">
                      <b-pagination
                        v-model="modal.currentPage"
                        :total-rows="modal.objTotal"
                        :per-page="modal.perPage"
                        @input="modalLoad('companyApplyList', modal.currentPage)"
                        size="md"
                      />
                    </div>
                  </div>
                </b-modal>
                <!-- countryList 彈跳視窗 -->
              </div>
              <div class="col-md-12">
                <b-list-group v-if="company.apply">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        {{ company.apply.chName }}<br />
                        {{ company.apply.enName }}<br />
                        <small>{{ company.apply.peopleName }}</small>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <router-link :to="{ name: 'CompanyView', params: { companyId: company.apply.id } }" custom v-slot="{ navigate }">
                          <button type="button" @click="navigate" class="btn btn-primary btn-xs pull-right">
                            <font-awesome-icon icon="eye" />檢視
                          </button>
                        </router-link>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
                <br />
              </div>

              <div class="col-md-12">
                <label class="form-label">
                  製造商
                  <b-button variant="outline-secondary" v-b-modal.modal-companyMnfctrList @click="modalInit('companyMnfctrList')"
                    >編輯</b-button
                  >
                </label>
                <!-- countryList 彈跳視窗 -->
                <b-modal id="modal-companyMnfctrList" hide-footer title="選擇公司">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                    <b-button-group>
                      <b-button type="submit" variant="primary" @click="modalSearch('companyMnfctrList')"
                        ><b-icon icon="search" />搜尋</b-button
                      >
                      <b-button type="reset" variant="outline-secondary" to="/company">管理</b-button>
                    </b-button-group>
                  </div>
                  <br />
                  <b-list-group v-for="company in modal.objList" :key="company.id">
                    <b-list-group-item button @click="modalChoice('companyMnfctrList', 'oneChoice', company)">
                      {{ company.chName }}<br />
                      {{ company.enName }}<br />
                      <small>{{ company.peopleName }}</small>
                    </b-list-group-item>
                  </b-list-group>
                  <br />
                  <div v-show="modal.objList && modal.objList.length > 0">
                    <div class="row justify-content-center">
                      <b-pagination
                        v-model="modal.currentPage"
                        :total-rows="modal.objTotal"
                        :per-page="modal.perPage"
                        @input="modalLoad('companyMnfctrList', modal.currentPage)"
                        size="md"
                      />
                    </div>
                  </div>
                </b-modal>
                <!-- countryList 彈跳視窗 -->
              </div>
              <div class="col-md-12">
                <b-list-group v-if="company.mnfctr">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        {{ company.mnfctr.chName }}<br />
                        {{ company.mnfctr.enName }}<br />
                        <small>{{ company.mnfctr.peopleName }}</small>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <router-link :to="{ name: 'CompanyView', params: { companyId: company.mnfctr.id } }" custom v-slot="{ navigate }">
                          <button type="button" @click="navigate" class="btn btn-primary btn-xs pull-right">
                            <font-awesome-icon icon="eye" />檢視
                          </button>
                        </router-link>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
                <br />
              </div>

              <div class="col-md-12">
                <label class="form-label"
                  >生產廠
                  <b-button variant="outline-secondary" v-b-modal.modal-companyFctyList @click="modalInit('companyFctyList')"
                    >編輯</b-button
                  >
                </label>
                <!-- countryList 彈跳視窗 -->
                <b-modal id="modal-companyFctyList" hide-footer title="選擇公司">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                    <b-button-group>
                      <b-button type="submit" variant="primary" @click="modalSearch('companyFctyList')"
                        ><b-icon icon="search" />搜尋</b-button
                      >
                      <b-button type="reset" variant="outline-secondary" to="/company">管理</b-button>
                    </b-button-group>
                  </div>
                  <small style="color: red">tips: 此項目可多重選擇。</small>
                  <br />
                  <b-list-group v-for="company in modal.objList" :key="company.id">
                    <b-list-group-item button @click="modalChoice('companyFctyList', 'manyChoice', company)">
                      {{ company.chName }}<br />
                      {{ company.enName }}<br />
                      <small>{{ company.peopleName }}</small>
                    </b-list-group-item>
                  </b-list-group>
                  <br />
                  <div v-show="modal.objList && modal.objList.length > 0">
                    <div class="row justify-content-center">
                      <b-pagination
                        v-model="modal.currentPage"
                        :total-rows="modal.objTotal"
                        :per-page="modal.perPage"
                        @input="modalLoad('companyFctyList', modal.currentPage)"
                        size="md"
                      />
                    </div>
                  </div>
                </b-modal>
                <!-- countryList 彈跳視窗 -->
              </div>
              <div class="col-md-12">
                <b-list-group v-for="(fcty, index) in company.fctyList" :key="fcty.id">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        {{ fcty.chName }}<br />
                        {{ fcty.enName }}<br />
                        <small>{{ fcty.peopleName }}</small>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <router-link :to="{ name: 'CompanyView', params: { companyId: fcty.id } }" custom v-slot="{ navigate }">
                          <button type="button" @click="navigate" class="btn btn-primary btn-xs pull-right">
                            <font-awesome-icon icon="eye" />檢視
                          </button>
                        </router-link>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              產品
              <b-button variant="outline-secondary" v-b-modal.modal-prodList @click="modalInit('prodList')">編輯</b-button>
            </h4>
            <div class="row gy-3">
              <!-- countryList 彈跳視窗 -->
              <b-modal id="modal-prodList" hide-footer title="選擇產品">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                  <b-button-group>
                    <b-button type="submit" variant="primary" @click="modalSearch('prodList')"><b-icon icon="search" />搜尋</b-button>
                    <b-button type="reset" variant="outline-secondary" to="/prod">管理</b-button>
                  </b-button-group>
                </div>
                <small style="color: red">tips: 此項目可多重選擇。</small>
                <br />
                <b-list-group v-for="prod in modal.objList" :key="prod.id">
                  <b-list-group-item button @click="modalChoice('prodList', 'manyChoice', prod)">
                    {{ prod.chName }}<br />
                    {{ prod.enName }}<br />
                    <small>{{ prod.prodNo }}</small>
                  </b-list-group-item>
                </b-list-group>
                <br />
                <div v-show="modal.objList && modal.objList.length > 0">
                  <div class="row justify-content-center">
                    <b-pagination
                      v-model="modal.currentPage"
                      :total-rows="modal.objTotal"
                      :per-page="modal.perPage"
                      @input="modalLoad('prodList', modal.currentPage)"
                      size="md"
                    />
                  </div>
                </div>
              </b-modal>
              <!-- countryList 彈跳視窗 -->
              <div class="col-md-12">
                <b-list-group v-for="(prod, index) in prodList" :key="prod.id">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        {{ prod.chName }}<br />
                        {{ prod.enName }}<br />
                        <small>{{ prod.prodNo }}</small>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <router-link :to="{ name: 'ProdView', params: { prodId: prod.id } }" custom v-slot="{ navigate }">
                          <button type="button" @click="navigate" class="btn btn-primary btn-xs pull-right">
                            <font-awesome-icon icon="eye" />檢視
                          </button>
                        </router-link>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              檢驗標準
              <b-button variant="outline-secondary" v-b-modal.modal-stdList @click="modalInit('stdList')">編輯</b-button>
            </h4>
            <div class="row gy-3">
              <!-- countryList 彈跳視窗 -->
              <b-modal id="modal-stdList" hide-footer title="選擇標準">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="關鍵字" v-model="modal.keyWord" />
                  <b-button-group>
                    <b-button type="submit" variant="primary" @click="modalSearch('stdList')"><b-icon icon="search" />搜尋</b-button>
                    <b-button type="reset" variant="outline-secondary" to="/std">管理</b-button>
                  </b-button-group>
                </div>
                <small style="color: red">tips: 此項目可多重選擇。</small>
                <br />
                <b-list-group v-for="std in modal.objList" :key="std.id">
                  <b-list-group-item button @click="modalChoice('stdList', 'manyChoice', std)">
                    {{ std.chName }}<br />
                    <small>{{ std.stdNo }}</small>
                  </b-list-group-item>
                </b-list-group>
                <br />
                <div v-show="modal.objList && modal.objList.length > 0">
                  <div class="row justify-content-center">
                    <b-pagination
                      v-model="modal.currentPage"
                      :total-rows="modal.objTotal"
                      :per-page="modal.perPage"
                      @input="modalLoad('stdList', modal.currentPage)"
                      size="md"
                    />
                  </div>
                </div>
              </b-modal>
              <!-- countryList 彈跳視窗 -->
              <div class="col-md-12">
                <b-list-group v-for="(std, index) in stdList" :key="std.id">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        {{ std.chName }}<br />
                        <small>{{ std.stdNo }}</small>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <router-link :to="{ name: 'StdView', params: { stdId: std.id } }" custom v-slot="{ navigate }">
                          <button type="button" @click="navigate" class="btn btn-primary btn-xs pull-right">
                            <font-awesome-icon icon="eye" />檢視
                          </button>
                        </router-link>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">
              費用
              <b-button variant="outline-secondary" v-b-modal.modal-feeList @click="modalInit('feeTypeList')">編輯</b-button>
            </h4>
            <div class="row gy-3">
              <!-- countryList 彈跳視窗 -->
              <b-modal id="modal-feeList" hide-footer title="編輯費用">
                <div class="row">
                  <div class="col-md-12">
                    <label class="form-label">費用日期</label>
                    <b-input-group class="mb-3">
                      <b-input-group-prepend>
                        <b-form-datepicker v-model="fee.feeDt" button-only today-button reset-button close-button />
                      </b-input-group-prepend>
                      <b-form-input type="text" class="form-control" v-model="fee.feeDt" />
                    </b-input-group>
                    <br />
                  </div>

                  <div class="col-md-12">
                    <label class="form-label">費用金額</label>
                    <input type="text" class="form-control" v-model="fee.fee" />
                    <br />
                  </div>

                  <div class="col-md-12">
                    <label class="form-label">費用類別</label>
                    <b-form-select v-model="fee.feeType" :options="feeTypeList"></b-form-select>
                    <br /><br />
                  </div>
                  <div class="col-md-12">
                    <small style="color: red">tips: 此項目可增加多筆。</small>
                  </div>
                  <div class="col-md-12 d-flex justify-content-end">
                    <b-button-group>
                      <b-button type="submit" variant="primary" @click="feeAdd()">
                        <b-icon icon="plus" />
                        加入
                      </b-button>
                      <!-- <b-button type="reset" variant="outline-secondary" to="/">管理</b-button> -->
                    </b-button-group>
                  </div>
                </div>
              </b-modal>
              <!-- countryList 彈跳視窗 -->
              <div class="col-md-12">
                <b-list-group v-for="(f, index) in feeList" :key="f.id">
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        <b-row>
                          <b-col cols="8">
                            <h6 v-text="$t('gmaApp.wcc311.feeType.' + f.feeType)" />
                            <small>{{ f.feeDt }}</small>
                          </b-col>
                          <b-col cols="4">
                            <span>${{ f.fee }}</span>
                          </b-col>
                        </b-row>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse">
                        <button type="button" @click="feeDelete(f)" class="btn btn-danger btn-xs pull-right">
                          <font-awesome-icon icon="times" />移除
                        </button>
                      </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
                <b-list-group>
                  <b-list-group-item>
                    <b-row>
                      <b-col cols="8">
                        <b-row>
                          <b-col cols="8">
                            <h6>total</h6>
                          </b-col>
                          <b-col cols="4">
                            <span>${{ feeTotal }}</span>
                          </b-col>
                        </b-row>
                      </b-col>
                      <b-col cols="4" class="d-inline-flex p-2 flex-row-reverse"> </b-col>
                    </b-row>
                  </b-list-group-item>
                </b-list-group>
              </div>
            </div>

            <hr class="my-4" />
          </form>
        </div>
        <!-- <button class="btn btn-info" @click="previousState"><b-icon icon="arrow-left"></b-icon> <span>返回</span></button> -->
        <div class="col-md-12 d-flex justify-content-end">
          <b-button-group>
            <button class="btn btn-info" @click="previousState">
              <b-icon icon="arrow-left" />
              <span>返回</span>
            </button>
            <b-button type="submit" variant="primary" @click="saveAll()">
              <font-awesome-icon icon="save" />
              <span>儲存</span>
            </b-button>
          </b-button-group>
        </div>
      </div>
    </main>
  </div>
</template>

<script lang="ts" src="./wcc311.ts"></script>
