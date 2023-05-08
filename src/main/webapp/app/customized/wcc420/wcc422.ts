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
    sessionStorage.setItem('Wcc422CompanyChName', this.form.companyChName);
    sessionStorage.setItem('Wcc422CurrentPage', this.form.currentPage);
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
      let Wcc422CompanyChName = sessionStorage.getItem('Wcc422CompanyChName');
      let Wcc422CurrentPage = sessionStorage.getItem('Wcc422CurrentPage');
      if (Wcc422CompanyChName) {
        this.form.companyChName = Wcc422CompanyChName;
        needInit = true;
      }
      if (Wcc422CurrentPage) {
        this.form.currentPage = Wcc422CurrentPage;
        needInit = true;
      }
      if (needInit) {
        this.getCerfList();
      }
    },
    getCerfList() {
      axios
        .get(
          '/api/wcc422/cerfList?sort=id,desc' +
            '&companyChName.contains=' +
            this.form.companyChName +
            '&relType.equals=FCTY' +
            '&cerfStatus.notEquals=' +
            'delete' +
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
      sessionStorage.removeItem('Wcc422CompanyChName');
      sessionStorage.removeItem('Wcc422CurrentPage');
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
