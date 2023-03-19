/* wccCode */
// 導入 echarts
import * as Echarts from 'echarts';
/* wccCode */

export default {
  data() {
    return {
      eChart1: null,
      eChart2: null,
      eChart3: null,
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
      show: false,
      cerfs: [
        {
          id: '1',
          areaCd: '台灣',
          cerfNo: 'CI435060200161',
          cerfVer: '01',
          cerfFee: '100,000',
          stsCd: '有效',
          applId: '陳XX',
          lstMtnDt: '2023-03-11',
        },
        {
          id: '2',
          areaCd: '中國',
          cerfNo: 'CI435060208585',
          cerfVer: '01',
          cerfFee: '200,000',
          stsCd: '維護中',
          applId: '張XX',
          lstMtnDt: '2023-01-15',
        },
      ],
    };
  },
  mounted() {
    // this.eChart1Init();
    // this.eChart2Init();
    // this.eChart3Init();
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      // alert(JSON.stringify(this.form));
      this.show = !this.show;
      this.eChart1Init();
      this.eChart2Init();
      this.eChart3Init();
    },
    onReset(event) {
      event.preventDefault();
      this.form.country = null;
      this.form.cerfStatus = null;
      this.form.cerfNo = '';
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
    eChart1Init() {
      this.eChart1 = Echarts.init(this.$refs.chart1);
      let option = {
        title: {
          text: '相關費用',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        legend: {
          orient: 'vertical',
          left: 'right',
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center',
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 20,
                fontWeight: 'bold',
              },
            },
            labelLine: {
              show: false,
            },
            data: [
              { value: 64, name: '申請證書' },
              { value: 25, name: '證書變更' },
              { value: 11, name: '證書展延' },
            ],
          },
        ],
      };
      this.eChart1.setOption(option);
    },
    eChart2Init() {
      this.eChart2 = Echarts.init(this.$refs.chart2);
      let option = {
        title: {
          text: '證書狀態',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        legend: {
          orient: 'vertical',
          left: 'right',
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center',
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 20,
                fontWeight: 'bold',
              },
            },
            labelLine: {
              show: false,
            },
            data: [
              { value: 77, name: '有效' },
              { value: 16, name: '維護中' },
              { value: 7, name: '失效' },
            ],
          },
        ],
      };
      this.eChart2.setOption(option);
    },
    eChart3Init() {
      this.eChart3 = Echarts.init(this.$refs.chart3);
      let option = {
        title: {
          text: '國家證書',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        legend: {
          orient: 'vertical',
          left: 'right',
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center',
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 20,
                fontWeight: 'bold',
              },
            },
            labelLine: {
              show: false,
            },
            data: [
              { value: 78, name: '台灣' },
              { value: 17, name: '中國' },
              { value: 5, name: '美國' },
            ],
          },
        ],
      };
      this.eChart3.setOption(option);
    },
  },
};
