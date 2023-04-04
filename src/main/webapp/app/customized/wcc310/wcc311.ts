import axios from 'axios';

export default {
  data() {
    return {
      test: null,
      cerf: {
        countryId: null,
        countryNoInput: null,
      },
      company: {
        apply: null,
        mnfctr: null,
        fctyList: [],
      },
      modal: {
        previousPage: 1,
        currentPage: 1,
        perPage: 6,
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
          '/api/wcc310/countryList?sort=countryNo,asc' +
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
          '/api/wcc310/companyList?sort=companyNo,asc' +
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
    previousState() {
      // this.$router.go(-1);
      alert('goBack');
    },
  },
};
