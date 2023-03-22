/* wccCode */
// 導入 echarts
import * as Echarts from 'echarts';
/* wccCode */

import axios from 'axios';
import buildPaginationQueryOpts from '@/shared/sort/sorts';

export default {
  data() {
    return {
      eChart1: null,
      eChart1Data: null,
      eChart2: null,
      eChart2Data: null,
      eChart3: null,
      eChart3Data: null,
      eChartShow: false,
      page: 1,
      itemsPerPage: 10,
      queryCount: null,
      totalItems: 0,
      previousPage: 1,
      propOrder: 'id',
      reverse: false,
      isFetch: false,
      isNull: false,
      form1: {
        mnfctrId: '',
      },
      name: null,
      csvList: null,
    };
  },
  beforeRouteLeave(to, from, next) {
    sessionStorage.setItem('mnfctrId', this.form1.mnfctrId);
    next();
  },
  mounted() {
    let mnfctrId = sessionStorage.getItem('mnfctrId');
    if (mnfctrId) {
      this.form1.mnfctrId = mnfctrId;
      this.onSubmit();
    }
  },
  methods: {
    onSubmit() {
      this.isFetch = true;
      if (this.form1.mnfctrId != '') {
        this.isNull = false;
        this.postApiWcc101();
        this.getApiWcc102();
      } else {
        this.isNull = true;
      }
    },
    onReset() {
      sessionStorage.removeItem('mnfctrId');
      this.form1.mnfctrId = '';
      this.isFetch = true;
      this.eChartShow = false;
      this.csvList = null;
    },
    postApiWcc101() {
      axios
        .post('api/wcc101i', this.form1)
        .then(res => {
          if (res.data.code == 0 && res.data.content.echart1.length > 0) {
            this.eChartShow = true;
            this.$nextTick(() => {
              this.eChart1Data = res.data.content.echart1;
              this.eChart1Init();
              this.eChart2Data = res.data.content.echart2;
              this.eChart2Init();
              this.eChart3Data = res.data.content.echart3;
              this.eChart3Init();
            });
          } else {
            this.eChartShow = false;
          }
        })
        .catch(err => {
          alert(err);
        });
    },
    getApiWcc102() {
      const paginationQuery = {
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
      };
      axios
        .get('api/wcc102i?' + 'mnfctrId.equals=' + this.form1.mnfctrId + `&${buildPaginationQueryOpts(paginationQuery)}`)
        .then(res => {
          this.csvList = res.data.content.csvList;
          this.name = res.data.content.name;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
        })
        .catch(err => {
          alert(err);
        });
    },
    sort() {
      const result = [this.propOrder + ',' + (this.reverse ? 'desc' : 'asc')];
      if (this.propOrder !== 'id') {
        result.push('id');
      }
      return result;
    },
    loadPage(page) {
      if (page !== this.previousPage) {
        this.previousPage = page;
        this.getApiWcc102();
      }
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
            data: this.eChart1Data,
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
            data: this.eChart2Data,
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
            data: this.eChart3Data,
          },
        ],
      };
      this.eChart3.setOption(option);
    },
  },
};
