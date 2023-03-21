export default {
  data() {
    return {
      name: null,
    };
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
    onSubmit() {
      alert();
    },
  },
};
