import axios from 'axios';

export default {
  data() {
    return {
      test: null,
      cerf: {
        countryId: null,
        countryInput: null,
      },
      modal: {
        previousPage: 1,
        currentPage: 1,
        perPage: 6,
        keyWord: '',
        countryList: null,
        countryTotal: 0,
      },
    };
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      // if (to.params.cerfNo) {
      //   vm.getApiWcc111(to.params.cerfNo, to.params.cerfVer);
      // }
      vm.modalInit();
    });
  },
  methods: {
    modalInit() {
      this.getCountryList();
    },
    modalQueryInit() {
      this.modal.previousPage = 1;
      this.modal.currentPage = 1;
      this.modal.keyWord = '';
      this.modalInit();
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
          this.modal.countryList = res.data;
          this.modal.countryTotal = Number(res.headers['x-total-count']);
        });
    },
    modalLoad(page) {
      if (page !== this.modal.previousPage) {
        this.modal.previousPage = page;
        this.modalInit();
      }
    },
    modalSearch() {
      this.modalInit();
    },
    modalChoice(country) {
      this.cerf.countryId = country.id;
      this.cerf.countryInput = country.countryNo;
      this.modalQueryInit();
      this.$bvModal.hide('modal-countryList');
    },
    previousState() {
      // this.$router.go(-1);
      alert('goBack');
    },
  },
};
