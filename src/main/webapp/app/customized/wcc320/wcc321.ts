import axios from 'axios';

export default {
  data() {
    return {
      form: {
        countryId: null,
        prodNo: null,
        prodChName: null,
        startDate: null,
        endDate: null,
      },
      countryList: null,
      feeList: null,
    };
  },
  beforeRouteLeave(to, from, next) {
    next();
  },
  created() {
    this.getCountryList();
  },
  methods: {
    getCountryList() {
      axios.get('/api/wcc412/countryList').then(res => {
        this.countryList = res.data;
      });
    },
    onSubmit(event) {
      event.preventDefault();
      this.postFeeList();
    },
    postFeeList() {
      axios.post('/api/wcc321/feeList', this.form).then(res => {
        console.log(res.data);
        this.feeList = res.data;
      });
    },
  },
};
