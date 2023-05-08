import axios from 'axios';

export default {
  data() {
    return {
      test: null,
      cerf: {
        cerfId: null,
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
      feeTotal: 0,
      modal: {
        previousPage: 1,
        currentPage: 1,
        perPage: 5,
        keyWord: '',
        objList: null,
        objTotal: 0,
        stdKeyWord1: '',
        stdKeyWord2: '',
        prodKeyWord1: '',
        prodKeyWord2: '',
      },
    };
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfId) vm.initCerfData(to.params.cerfId);
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
      this.modal.stdKeyWord1 = '';
      this.modal.stdKeyWord2 = '';
      this.modal.prodKeyWord1 = '';
      this.modal.prodKeyWord2 = '';
      this.modalInit(modalName);
    },
    getCountryList() {
      axios
        .get(
          '/api/wcc311/countryList?sort=id,DESC' +
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
    getCompanyList() {
      axios
        .get(
          '/api/wcc311/companyList?sort=id,DESC' +
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
          '/api/wcc311/prodList?sort=id,DESC' +
            // '&chName.contains=' +
            // this.modal.keyWord +
            '&prodNo.contains=' +
            this.modal.prodKeyWord1 +
            '&chName.contains=' +
            this.modal.prodKeyWord2 +
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
          '/api/wcc311/stdList?sort=id,DESC' +
            // '&chName.contains=' +
            // this.modal.keyWord +
            '&stdNo.contains=' +
            this.modal.stdKeyWord1 +
            '&stdVer.contains=' +
            this.modal.stdKeyWord2 +
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
          '/api/wcc311/markList?' +
            'chName.contains=' +
            this.modal.keyWord +
            // '&countryId.equals=' +
            // this.cerf.countryId +
            '&sort=id,DESC' +
            '&page=' +
            (this.modal.currentPage - 1) +
            '&size=' +
            this.modal.perPage
        )
        .then(res => {
          const tmpList = [];
          res.data.forEach(function (obj) {
            // if (obj) tmpList.push(obj.mark as never);
            if (obj) tmpList.push(obj as never);
          });
          this.modal.objList = tmpList;
          this.modal.objTotal = Number(res.headers['x-total-count']);
        });
    },
    initCerfData(cerfId) {
      axios.get('/api/wcc311/cerfData/' + cerfId).then(res => {
        this.cerf.cerfId = res.data.cerfId;
        this.cerf.countryId = res.data.country.id;
        this.cerf.countryNoInput = res.data.country.countryNo;
        this.cerf.stsCd = res.data.stsCd;
        this.cerf.cerfNo = res.data.cerfNo;
        this.cerf.cerfVer = res.data.cerfVer;
        this.cerf.issuDt = res.data.issuDt;
        this.cerf.expDt = res.data.expDt;
        this.cerf.mark = res.data.mark;
        this.cerf.pdf = res.data.pdf;
        this.cerf.pdfContentType = res.data.pdfContentType;
        this.company.apply = res.data.apply[0];
        this.company.mnfctr = res.data.mnfctr[0];
        this.company.fctyList = res.data.fctyList;
        this.prodList = res.data.prodList;
        this.stdList = res.data.stdList;
        this.feeList = res.data.feeList;
        if (this.feeList == null) this.feeList = [];
        var sum = 0;
        this.feeList.forEach(function (obj) {
          sum = Number(sum) + Number(obj.fee);
        });
        this.feeTotal = sum;
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
          if (this.company.apply != null && this.company.apply.id == obj.id) this.company.apply = null;
          else this.company.apply = obj;
          break;
        }
        case 'companyMnfctrList': {
          if (this.company.mnfctr != null && this.company.mnfctr.id == obj.id) this.company.mnfctr = null;
          else this.company.mnfctr = obj;
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
      this.feeTotal = Number(this.feeTotal) + Number(this.fee.fee);
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
    feeDelete(fee) {
      this.feeTotal = Number(this.feeTotal) - Number(fee.fee);
      let tmpArray = [];
      if (fee.tmpId) tmpArray = this.feeList.filter(o => o.tmpId !== fee.tmpId);
      else tmpArray = this.feeList.filter(o => o.id !== fee.id);
      this.feeList = tmpArray;
    },
    saveAll() {
      const saveData = {
        cerfId: this.cerf.cerfId,
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
    byteSize(base64String) {
      return this.formatAsBytes(this.size(base64String));
    },
    formatAsBytes(size) {
      return size.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ' ') + ' bytes';
    },
    size(value) {
      return (value.length / 4) * 3 - this.paddingSize(value);
    },
    paddingSize(value) {
      if (this.endsWith('==', value)) {
        return 2;
      }
      if (this.endsWith('=', value)) {
        return 1;
      }
      return 0;
    },
    endsWith(suffix, str) {
      return str.indexOf(suffix, str.length - suffix.length) !== -1;
    },
    openFile(contentType, data) {
      const byteCharacters = atob(data);
      const byteNumbers = new Array(byteCharacters.length);
      for (let i = 0; i < byteCharacters.length; i++) {
        byteNumbers[i] = byteCharacters.charCodeAt(i);
      }
      const byteArray = new Uint8Array(byteNumbers);
      const blob = new Blob([byteArray], {
        type: contentType,
      });
      const objectURL = URL.createObjectURL(blob);
      const win = window.open(objectURL);
      if (win) {
        win.onload = () => URL.revokeObjectURL(objectURL);
      }
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
      this.$router.go(-1);
    },
  },
};
