import axios from 'axios';

export default {
  data() {
    return {
      form: {
        countryId: null,
        cerfStatus: null,
        cerfNo: '',
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
    sessionStorage.setItem('Wcc312CountryId', this.form.countryId);
    sessionStorage.setItem('Wcc312CerfStatus', this.form.cerfStatus);
    sessionStorage.setItem('Wcc312CerfNo', this.form.cerfNo);
    sessionStorage.setItem('Wcc312CurrentPage', this.form.currentPage);
    next();
  },
  created() {
    this.getCountryList();
    this.getCerfStatusList();
    this.lastTimePage();
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.getCerfList();
    },
    lastTimePage() {
      let needInit = false;
      let Wcc312CountryId = sessionStorage.getItem('Wcc312CountryId');
      let Wcc312CerfStatus = sessionStorage.getItem('Wcc312CerfStatus');
      let Wcc312CerfNo = sessionStorage.getItem('Wcc312CerfNo');
      let Wcc312CurrentPage = sessionStorage.getItem('Wcc312CurrentPage');
      if (Wcc312CountryId != 'null') {
        this.form.countryId = Wcc312CountryId;
        needInit = true;
      }
      if (Wcc312CerfStatus != 'null') {
        this.form.cerfStatus = Wcc312CerfStatus;
        needInit = true;
      }
      if (Wcc312CerfNo) {
        this.form.cerfNo = Wcc312CerfNo;
        needInit = true;
      }
      if (Wcc312CurrentPage) {
        this.form.currentPage = Wcc312CurrentPage;
        needInit = true;
      }
      if ((needInit = true)) {
        this.getCerfList();
      }
    },
    getCountryList() {
      axios.get('/api/wcc312/countryList').then(res => {
        this.countryList = res.data;
      });
    },
    getCerfStatusList() {
      axios.get('/api/wcc312/cerfStatusList').then(res => {
        this.cerfStatusList = res.data;
      });
    },
    getCerfList() {
      axios
        .get(
          '/api/wcc312/cerfList?sort=id,desc' +
            '&countryId.equals=' +
            (this.form.countryId == null ? '' : this.form.countryId) +
            '&status.contains=' +
            (this.form.cerfStatus == null ? '' : this.form.cerfStatus) +
            '&cerfNo.contains=' +
            this.form.cerfNo +
            '&page=' +
            (this.form.currentPage - 1) +
            '&size=' +
            this.form.perPage
        )
        .then(res => {
          this.cerfList = res.data;
          this.form.objTotal = Number(res.headers['x-total-count']);
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
      sessionStorage.removeItem('Wcc312CountryId');
      sessionStorage.removeItem('Wcc312CerfStatus');
      sessionStorage.removeItem('Wcc312CerfNo');
      sessionStorage.removeItem('Wcc312CurrentPage');
      this.form.countryId = null;
      this.form.cerfStatus = null;
      this.form.cerfNo = '';
      this.form.currentPage = 1;
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
