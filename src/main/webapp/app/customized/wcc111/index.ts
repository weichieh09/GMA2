import axios from 'axios';

export default {
  data() {
    return {
      test: null,
      cerf: {
        cerfNo: null,
        cerfVer: null,
        areaCd: null,
        stsCd: null,
        applId: null,
        cerfTag: null,
        issuDt: null,
        cerfExpDt: null,
      },
      cerf2CerfFee: null,
      cerf2Mnfctr: null,
      cerf2Prod: null,
      cerf2Std: null,
    };
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfNo && to.params.cerfVer) {
        vm.getApiWcc111(to.params.cerfNo, to.params.cerfVer);
      }
    });
  },
  methods: {
    getApiWcc111(cerfNo, cerfVer) {
      axios
        .get('api/wcc111i/' + cerfNo + '/' + cerfVer)
        .then(res => {
          console.log(res.data);

          this.cerf.cerfNo = res.data.content.cerf.cerfNo;
          this.cerf.cerfVer = res.data.content.cerf.cerfVer;
          this.cerf.areaCd = res.data.content.cerf.areaCd;
          this.cerf.stsCd = res.data.content.cerf.stsCd;
          this.cerf.applId = res.data.content.cerf.applId;
          this.cerf.cerfTag = res.data.content.cerf.cerfTag;
          this.cerf.issuDt = res.data.content.cerf.issuDt;
          this.cerf.cerfExpDt = res.data.content.cerf.cerfExpDt;

          this.cerf2CerfFee = res.data.content.cerf2CerfFee;

          this.cerf2Mnfctr = res.data.content.cerf2Mnfctr;

          this.cerf2Prod = res.data.content.cerf2Prod;

          this.cerf2Std = res.data.content.cerf2Std;
        })
        .catch(err => {
          alert(err);
        });
    },
    previousState() {
      this.$router.go(-1);
    },
  },
};
