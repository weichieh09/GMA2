<template>
  <div class="container">
    <main>
      <!-- <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" alt="" width="72" height="57" />
        <h2>Checkout form</h2>
        <p class="lead">
          Below is an example form built entirely with Bootstrap’s form controls. Each required form group has a validation state that can
          be triggered by attempting to submit the form without completing it.
        </p>
      </div> -->

      <div class="py-3">
        <h2>詳細內容</h2>
      </div>

      <div class="row g-5">
        <div class="col-md-7 col-lg-8">
          <h4 class="mb-3">證書</h4>
          <form class="needs-validation">
            <div class="row g-3">
              <div class="col-sm-6">
                <label class="form-label">證書編號</label>
                <input type="text" class="form-control" v-model="cerf.cerfNo" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書版本號碼</label>
                <input type="text" class="form-control" v-model="cerf.cerfVer" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">國家/地區代碼</label>
                <input type="text" class="form-control" v-model="cerf.areaCd" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">狀態代碼</label>
                <input type="text" class="form-control" v-model="cerf.stsCd" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書申請人ID</label>
                <input type="text" class="form-control" v-model="cerf.applId" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書標籤</label>
                <input type="text" class="form-control" v-model="cerf.cerfTag" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書發行日期</label>
                <input type="text" class="form-control" v-model="cerf.issuDt" disabled />
                <br />
              </div>

              <div class="col-sm-6">
                <label class="form-label">證書到期日期</label>
                <input type="text" class="form-control" v-model="cerf.cerfExpDt" disabled />
                <br />
              </div>

              <div class="col-12">
                <label for="email" class="form-label">證書檔案</span></label>
                <input type="file" class="form-control" />
              </div>
            </div>

            <hr class="my-4" />

            <h4 class="mb-3">廠商</h4>

            <div v-for="mnfctr in cerf2Mnfctr" :key="mnfctr.id" class="row gy-3">
              <div class="col-md-12">
                <label for="cc-name" class="form-label">統一編號</label>
                <input type="text" class="form-control" disabled />
                <br />
              </div>

              <div class="col-md-6">
                <label for="cc-name" class="form-label">廠商英文名稱</label>
                <input type="text" class="form-control" disabled />
                <br />
              </div>

              <div class="col-md-6">
                <label for="cc-number" class="form-label">廠商中文名稱</label>
                <input type="text" class="form-control" :value="mnfctr.mnfctrNmCh" disabled />
                <br />
              </div>

              <!-- <div class="col-md-3">
                <label for="cc-expiration" class="form-label">Expiration</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="" required />
                <div class="invalid-feedback">Expiration date required</div>
              </div>

              <div class="col-md-3">
                <label for="cc-cvv" class="form-label">CVV</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="" required />
                <div class="invalid-feedback">Security code required</div>
              </div> -->
            </div>
            <button class="btn btn-info" type="submit" @click="previousState"><b-icon icon="arrow-left"></b-icon> <span>返回</span></button>
          </form>
        </div>
        <div class="col-md-5 col-lg-4 order-md-last">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">產品</span>
            <span v-if="cerf2Prod && cerf2Prod.length > 0" class="badge bg-primary rounded-pill">{{ cerf2Prod.length }}</span>
          </h4>
          <ul class="list-group mb-3">
            <li v-for="prod in cerf2Prod" :key="prod.id" class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">{{ prod.prodNmCh }}</h6>
                <small class="text-muted">{{ prod.prodId }}</small>
              </div>
            </li>
          </ul>
          <br />
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">費用</span>
            <span v-if="cerf2CerfFee && cerf2CerfFee.length > 0" class="badge bg-primary rounded-pill">{{cerf2CerfFee.length}}</span>
          </h4>
          <ul class="list-group mb-3">
            <li v-for="cerfFee in cerf2CerfFee" :key="cerfFee.id" class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">{{cerfFee.feeDesc}}</h6>
                <small class="text-muted">{{cerfFee.feeDt}}</small>
              </div>
              <span class="text-muted">${{cerfFee.fee}}</span>
            </li>
            <!-- <li class="list-group-item d-flex justify-content-between">
              <span>Total (USD)</span>
              <strong>$20</strong>
            </li> -->
          </ul>
          <br />
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">檢驗標準</span>
            <span v-if="cerf2Std && cerf2Std.length > 0" class="badge bg-primary rounded-pill">{{ cerf2Std.length }}</span>
          </h4>
          <ul class="list-group mb-3">
            <li v-for="std in cerf2Std" :key="std.id" class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">{{ std.stdNo }}</h6>
                <small class="text-muted">{{ std.stdVer }}</small>
              </div>
            </li>
            <!-- <li class="list-group-item d-flex justify-content-between">
              <span>Total (USD)</span>
              <strong>$20</strong>
            </li> -->
          </ul>
        </div>
      </div>
    </main>
  </div>
</template>

<script lang="ts" src="./index.ts"></script>
