import axios from 'axios';

export default {
  data() {
    return {
      test: null,
      cerf: {
        countryId: null,
        countryNoInput: null,
        stsCd: null,
        cerfNo: null,
        cerfVer: null,
        issuDt: null,
        expDt: null,
        pdfContentType: null,
        pdf: null,
        mark: null,
      },
      company: {
        apply: null,
        mnfctr: null,
        fctyList: [],
      },
      prodList: [],
      stdList: [],
      feeList: [],
      fee: {
        tmpId: 0,
        feeType: null,
        fee: null,
        feeDt: null,
      },
      feeTypeList: null,
      modal: {
        previousPage: 1,
        currentPage: 1,
        perPage: 5,
        keyWord: '',
        objList: null,
        objTotal: 0,
      },
    };
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      // if (to.params.cerfNo) {
      //   vm.getApiWcc111(to.params.cerfNo, to.params.cerfVer);
      // }
      // vm.modalInit();
    });
  },
  methods: {
    modalInit(modalName) {
      switch (modalName) {
        case 'countryList': {
          this.getCountryList();
          break;
        }
        case 'companyApplyList':
        case 'companyMnfctrList':
        case 'companyFctyList': {
          this.getCompanyList();
          break;
        }
        case 'prodList': {
          this.getProdList();
          break;
        }
        case 'stdList': {
          this.getStdList();
          break;
        }
        case 'feeTypeList': {
          this.getFeeTypeList();
          break;
        }
        case 'markList': {
          this.getMarkList();
          break;
        }
        default: {
          console.log('錯誤');
          break;
        }
      }
    },
    modalQueryInit(modalName) {
      this.modal.previousPage = 1;
      this.modal.currentPage = 1;
      this.modal.keyWord = '';
      this.modalInit(modalName);
    },
    getCountryList() {
      axios
        .get(
          '/api/wcc311/countryList?sort=countryNo,asc' +
            '&enName.contains=' +
            this.modal.keyWord +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          this.modal.objList = res.data;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    getCompanyList() {
      axios
        .get(
          '/api/wcc311/companyList?sort=companyNo,asc' +
            '&chName.contains=' +
            this.modal.keyWord +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          this.modal.objList = res.data;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    getProdList() {
      axios
        .get(
          '/api/wcc311/prodList?sort=prodNo,asc' +
            '&chName.contains=' +
            this.modal.keyWord +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          this.modal.objList = res.data;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    getStdList() {
      axios
        .get(
          '/api/wcc311/stdList?sort=stdNo,asc' +
            '&chName.contains=' +
            this.modal.keyWord +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          this.modal.objList = res.data;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    getFeeTypeList() {
      axios.get('/api/wcc311/feeTypeList').then(res => {
        this.feeTypeList = res.data;
      });
    },
    getMarkList() {
      axios
        .get(
          '/api/wcc311/markList?countryId.equals=' +
            this.cerf.countryId +
            '&markChName.contains=' +
            this.modal.keyWord +
            '&sort=id,asc' +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          const tmpList = [];
          res.data.forEach(function (obj) {
            if (obj) tmpList.push(obj.mark as never);
          });
          this.modal.objList = tmpList;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    modalLoad(modalName, page) {
      if (page !== this.modal.previousPage) {
        this.modal.previousPage = page;
        this.modalInit(modalName);
      }
    },
    modalSearch(modalName) {
      this.modalInit(modalName);
    },
    modalChoice(modalName, choiceType, obj) {
      switch (modalName) {
        case 'countryList': {
          this.cerf.countryId = obj.id;
          this.cerf.countryNoInput = obj.countryNo;
          break;
        }
        case 'companyApplyList': {
          this.company.apply = obj;
          break;
        }
        case 'companyMnfctrList': {
          this.company.mnfctr = obj;
          break;
        }
        case 'companyFctyList': {
          let tmpArray = this.company.fctyList.filter(o => o.id !== obj.id);
          if (tmpArray.length == this.company.fctyList.length) this.company.fctyList.push(obj);
          else this.company.fctyList = tmpArray;
          break;
        }
        case 'prodList': {
          let tmpArray = this.prodList.filter(o => o.id !== obj.id);
          if (tmpArray.length == this.prodList.length) this.prodList.push(obj);
          else this.prodList = tmpArray;
          break;
        }
        case 'stdList': {
          let tmpArray = this.stdList.filter(o => o.id !== obj.id);
          if (tmpArray.length == this.stdList.length) this.stdList.push(obj);
          else this.stdList = tmpArray;
          break;
        }
        case 'markList': {
          this.cerf.mark = obj;
          break;
        }
        default: {
          console.log('錯誤');
          break;
        }
      }
      this.modalQueryInit(modalName);
      if (choiceType == 'oneChoice') {
        this.$bvModal.hide('modal-' + modalName);
      }
    },
    feeAdd() {
      this.fee.tmpId = Number(this.fee.tmpId) + 1;
      const obj = {
        tmpId: this.fee.tmpId,
        feeType: this.fee.feeType,
        fee: this.fee.fee,
        feeDt: this.fee.feeDt,
      };
      this.feeList.push(obj);
      this.fee.feeType = null;
      this.fee.fee = null;
      this.fee.feeDt = null;
    },
    saveAll() {
      const saveData = {
        countryId: this.cerf.countryId,
        stsCd: this.cerf.stsCd,
        cerfNo: this.cerf.cerfNo,
        cerfVer: this.cerf.cerfVer,
        issuDt: this.cerf.issuDt,
        expDt: this.cerf.expDt,
        pdf: this.cerf.pdf,
        pdfContentType: this.cerf.pdfContentType,
        apply: this.company.apply,
        mnfctr: this.company.mnfctr,
        fctyList: this.company.fctyList,
        prodList: this.prodList,
        stdList: this.stdList,
        feeList: this.feeList,
        mark: this.cerf.mark,
      };

      axios
        .post('/api/wcc311/saveAll', saveData)
        .then(res => {
          this.showMsgBox(res.data);
        })
        .catch(err => {
          // reject(err);
          // this.showMsgBox(err);
          alert(err);
        });
    },
    setPdfData(event, isImage) {
      if (event && event.target.files && event.target.files[0]) {
        const file = event.target.files[0];
        if (isImage && !/^image\//.test(file.type)) {
          return;
        }
        this.toBase64(file, base64Data => {
          this.cerf.pdf = base64Data;
          this.cerf.pdfContentType = file.type;
        });
      }
    },
    toBase64(file, cb) {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);
      fileReader.onload = (e: any) => {
        const base64Data = e.target.result.substring(e.target.result.indexOf('base64,') + 'base64,'.length);
        cb(base64Data);
      };
    },
    showMsgBox(res) {
      this.boxTwo = '';
      this.$bvModal
        .msgBoxOk(res.msg, {
          title: '儲存結果',
        })
        .then(value => {
          if (res.code == 0) this.$router.go(-1);
        });
    },
    previousState() {
      // this.$router.go(-1);
      alert('goBack');
    },
  },
};
