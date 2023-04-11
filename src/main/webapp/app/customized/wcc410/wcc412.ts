import axios from 'axios';

export default {
  data() {
    return {
      form: {
        countryId: null,
        cerfStatus: null,
        cerfNo: '',
        prodNo: '',
        prodName: '',
        previousPage: 1,
        currentPage: 1,
        perPage: 10,
        objList: null,
        objTotal: 0,
      },
      countryList: null,
      cerfStatusList: null,
      show: true,
      cerfList: [],
    };
  },
  beforeRouteLeave(to, from, next) {
    sessionStorage.setItem('Wcc412CountryId', this.form.countryId);
    // sessionStorage.setItem('Wcc412CerfStatus', this.form.cerfStatus);
    sessionStorage.setItem('Wcc412ProdNo', this.form.prodNo);
    sessionStorage.setItem('Wcc412ProdName', this.form.prodName);
    sessionStorage.setItem('Wcc412CurrentPage', this.form.currentPage);
    next();
  },
  created() {
    this.getCountryList();
    // this.getCerfStatusList();
    this.lastTimePage();
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.getCerfList();
    },
    lastTimePage() {
      let needInit = false;
      let Wcc412CountryId = sessionStorage.getItem('Wcc412CountryId');
      // let Wcc412CerfStatus = sessionStorage.getItem('Wcc412CerfStatus');
      let Wcc412ProdNo = sessionStorage.getItem('Wcc412ProdNo');
      let Wcc412ProdName = sessionStorage.getItem('Wcc412ProdName');
      let Wcc412CurrentPage = sessionStorage.getItem('Wcc412CurrentPage');
      if (Wcc412CountryId != 'null') {
        this.form.countryId = Wcc412CountryId;
        needInit = true;
      }
      // if (Wcc412CerfStatus != 'null') {
      //   this.form.cerfStatus = Wcc412CerfStatus;
      //   needInit = true;
      // }
      if (Wcc412ProdNo) {
        this.form.prodNo = Wcc412ProdNo;
        needInit = true;
      }
      if (Wcc412ProdName) {
        this.form.prodName = Wcc412ProdName;
        needInit = true;
      }
      if (Wcc412CurrentPage) {
        this.form.currentPage = Wcc412CurrentPage;
        needInit = true;
      }
      if (needInit) {
        this.getCerfList();
      }
    },
    getCountryList() {
      axios.get('/api/wcc412/countryList').then(res => {
        this.countryList = res.data;
      });
    },
    // getCerfStatusList() {
    //   axios.get('/api/wcc412/cerfStatusList').then(res => {
    //     this.cerfStatusList = res.data;
    //   });
    // },
    getCerfList() {
      const postData = {
        countryId: this.form.countryId == null ? '' : this.form.countryId,
        prodNo: this.form.prodNo,
        prodName: this.form.prodName,
        page: this.form.currentPage - 1,
        size: this.form.perPage,
      };

      console.log(postData);

      axios.post('/api/wcc412/cerfList', postData).then(res => {
        // this.cerfList = res.data;
        // this.form.objTotal = Number(res.headers['x-total-count']);
      });
    },
    loadPage(page) {
      if (page !== this.form.previousPage) {
        this.form.previousPage = page;
        this.getCerfList();
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      sessionStorage.removeItem('Wcc412CountryId');
      // sessionStorage.removeItem('Wcc412CerfStatus');
      sessionStorage.removeItem('Wcc412ProdNo');
      sessionStorage.removeItem('Wcc412ProdName');
      sessionStorage.removeItem('Wcc412CurrentPage');
      this.form.countryId = null;
      this.form.cerfStatus = null;
      this.form.cerfNo = '';
      this.form.prodNo = '';
      this.form.prodName = '';
      this.form.currentPage = 1;
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
