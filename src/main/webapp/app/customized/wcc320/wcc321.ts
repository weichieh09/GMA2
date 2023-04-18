import axios from 'axios';
// 導入 echarts
import * as Echarts from 'echarts';

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
      app: {},
      labelOption: null,
      eChart1: null,
      isEchartShow: false,
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
      this.reSearch();
      this.isEchartShow = true;
      this.postFeeList();
    },
    reSearch() {
      this.isEchartShow = false;
      this.app = {};
      this.labelOption = null;
      this.eChart1 = null;
    },
    postFeeList() {
      axios.post('/api/wcc321/feeList', this.form).then(res => {
        console.log(res.data);
        this.feeList = res.data;
        this.$nextTick(() => {
          // this.eChart1Data = res.data.content.echart1;
          this.eChart1Init();
        });
      });
    },
    eChart1Init() {
      this.eChart1 = Echarts.init(this.$refs.chart1);
      const posList = [
        'left',
        'right',
        'top',
        'bottom',
        'inside',
        'insideTop',
        'insideLeft',
        'insideRight',
        'insideBottom',
        'insideTopLeft',
        'insideTopRight',
        'insideBottomLeft',
        'insideBottomRight',
      ];
      this.app.configParameters = {
        rotate: {
          min: -90,
          max: 90,
        },
        align: {
          options: {
            left: 'left',
            center: 'center',
            right: 'right',
          },
        },
        verticalAlign: {
          options: {
            top: 'top',
            middle: 'middle',
            bottom: 'bottom',
          },
        },
        position: {
          options: posList.reduce(function (map, pos) {
            map[pos] = pos;
            return map;
          }, {}),
        },
        distance: {
          min: 0,
          max: 100,
        },
      };
      this.app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
          const labelOption = {
            rotate: this.app.config.rotate,
            align: this.app.config.align,
            verticalAlign: this.app.config.verticalAlign,
            position: this.app.config.position,
            distance: this.app.config.distance,
          };
          this.eChart1.setOption({
            series: [
              {
                label: labelOption,
              },
              {
                label: labelOption,
              },
              {
                label: labelOption,
              },
              {
                label: labelOption,
              },
            ],
          });
        },
      };
      this.labelOption = {
        show: false,
        position: this.app.config.position,
        distance: this.app.config.distance,
        align: this.app.config.align,
        verticalAlign: this.app.config.verticalAlign,
        rotate: this.app.config.rotate,
        formatter: '{c}  {name|{a}}',
        fontSize: 16,
        rich: {
          name: {},
        },
      };
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow',
          },
        },
        legend: {
          data: ['證書總費用', '標準總費用', '工廠總費用'],
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: false, readOnly: false, title: '原始資料' },
            magicType: { show: true, type: ['line', 'bar', 'stack'], title: { line: '折線圖', bar: '柱狀圖', stack: '堆疊圖' } },
            restore: { show: true, title: '還原' },
            saveAsImage: { show: true, title: '下載圖片' },
          },
        },
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            data: this.feeList['timeLine'],
          },
        ],
        yAxis: [
          {
            type: 'value',
          },
        ],
        series: [
          {
            name: '證書總費用',
            type: 'bar',
            barGap: 0,
            label: this.labelOption,
            emphasis: {
              focus: 'series',
            },
            data: this.feeList.feeObjectList[0],
          },
          {
            name: '標準總費用',
            type: 'bar',
            label: this.labelOption,
            emphasis: {
              focus: 'series',
            },
            data: this.feeList.feeObjectList[1],
          },
          {
            name: '工廠總費用',
            type: 'bar',
            label: this.labelOption,
            emphasis: {
              focus: 'series',
            },
            data: this.feeList.feeObjectList[2],
          },
        ],
      };
      this.eChart1.setOption(option);
    },
  },
};
