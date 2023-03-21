import axios from 'axios';

export default {
  data() {
    return {
      name: null,
    };
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cerfNo && to.params.cerfVer) {
        vm.getApiWcc111(to.params.cerfNo, to.params.cerfVer);
      }
    });
  },
  beforeRouteLeave(to, from, next) {
    // sessionStorage.setItem('mnfctrId', this.form.mnfctrId);
    next();
  },
  mounted() {
    // let mnfctrId = sessionStorage.getItem('mnfctrId');
    // if (mnfctrId) {
    //   this.form.mnfctrId = mnfctrId;
    //   this.onSubmit();
    // }
  },
  methods: {
    getApiWcc111(cerfNo, cerfVer) {
      axios
        .get('api/wcc111i/' + cerfNo + '/' + cerfVer)
        .then(res => {
          console.log(res.data);
        })
        .catch(err => {
          alert(err);
        });
    },
  },
};
