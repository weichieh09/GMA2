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
  created() {
    this.getCountryList();
    this.getCerfStatusList();
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.getCerfList();
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
        });
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.country = null;
      this.form.cerfStatus = null;
      this.form.cerfNo = '';
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
