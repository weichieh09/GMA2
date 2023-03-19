export default {
  data() {
    return {
      form: {
        country: null,
        cerfStatus: null,
        cerfNo: '',
      },
      countryList: [
        { text: '全選', value: null },
        { text: '中國', value: 'CN' },
        { text: '台灣', value: 'TW' },
      ],
      cerfStatusList: [
        { text: '全選', value: null },
        { text: '有效', value: 'isWork' },
        { text: '失效', value: 'notWork' },
        { text: '維護中', value: 'fixing' },
      ],
      show: true,
      cerfs: [
        {
          id: '1',
          cerfNo: 'CI435060200161',
          areaCd: 'TW',
          issuFt: '2016-06-13T16:00:00Z',
          cerfExpDt: '2019-06-12T16:00:00Z',
          effFg: 'N',
          applId: '22099738',
        },
        {
          id: '2',
          cerfNo: 'CI435060208585',
          areaCd: 'TW',
          issuFt: '2020-04-12T16:00:00Z',
          cerfExpDt: '2023-04-12T16:00:00Z',
          effFg: 'Y',
          applId: '22099738',
        },
        {
          id: '3',
          cerfNo: 'Q123',
          areaCd: 'CN',
          issuFt: '2020-01-01T16:00:00Z',
          cerfExpDt: '2023-01-01T16:00:00Z',
          effFg: 'Y',
          applId: 'A123',
        },
      ],
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
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
