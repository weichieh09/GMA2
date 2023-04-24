import axios from 'axios';

export default {
  data() {
    return {
      form: {
        companyChName: '',
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
    sessionStorage.setItem('Wcc421CompanyChName', this.form.companyChName);
    sessionStorage.setItem('Wcc421CurrentPage', this.form.currentPage);
    next();
  },
  created() {
    this.lastTimePage();
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.getCerfList();
    },
    lastTimePage() {
      let needInit = false;
      let Wcc421CompanyChName = sessionStorage.getItem('Wcc421CompanyChName');
      let Wcc421CurrentPage = sessionStorage.getItem('Wcc421CurrentPage');
      if (Wcc421CompanyChName) {
        this.form.companyChName = Wcc421CompanyChName;
        needInit = true;
      }
      if (Wcc421CurrentPage) {
        this.form.currentPage = Wcc421CurrentPage;
        needInit = true;
      }
      if (needInit) {
        this.getCerfList();
      }
    },
    getCerfList() {
      axios
        .get(
          '/api/wcc421/cerfList?sort=id,desc' +
            '&companyChName.contains=' +
            this.form.companyChName +
            '&relType.equals=APPLY' +
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
      sessionStorage.removeItem('Wcc421CompanyChName');
      sessionStorage.removeItem('Wcc421CurrentPage');
      this.form.companyChName = '';
      this.form.currentPage = 1;
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
