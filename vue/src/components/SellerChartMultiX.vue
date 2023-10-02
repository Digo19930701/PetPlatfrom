<script setup>
import {ref} from 'vue'
import {onMounted} from 'vue'
import * as echarts from 'echarts/core';
import {
  TooltipComponent,
  GridComponent,
  LegendComponent
} from 'echarts/components';
import { LineChart } from 'echarts/charts';
import { UniversalTransition } from 'echarts/features';
import { CanvasRenderer } from 'echarts/renderers';

echarts.use([
  TooltipComponent,
  GridComponent,
  LegendComponent,
  LineChart,
  CanvasRenderer,
  UniversalTransition
]);

const props=defineProps({
    name:{
        type:Array,
        default:['2016', '2015']
    },
    xData:{
        type:Array,
        default:[['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12'],
                 ['2015-1', '2015-2', '2015-3', '2015-4', '2015-5', '2015-6', '2015-7', '2015-8', '2015-9', '2015-10', '2015-11', '2015-12']
                ]
    },
    yData:{
        type:Array,
        default:[[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 171.6, 82.2, 48.7, 18.8, 6.0, 2.3],
                 [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 104, 55.4, 18.4, 10.3, 0.7]
                ]
    },
    yAxis:{
      type:Array,
      default:['金額(NT$)']
    },
    colors:{
        type:Array,
        default:['#CD7B00', '#888888']
    } 
})

const canvas = ref(0);


const option = {
  color: props.colors,
  tooltip: 
  {
    trigger: 'none',
    axisPointer: {
      type: 'cross'
    }
  },
  legend: {},
  grid: 
  {
    top: '15%',
    left: '3%',
    bottom: '10%',
    containLabel: true
  },
  xAxis: [
    {
      type: 'category',
      axisTick: {
        alignWithLabel: true
      },
      axisLine: {
        onZero: false,
        lineStyle: {
          color: props.colors[0]
        }
      },
      axisPointer: {
        label: {
          formatter: function (params) {
            return (
              params.value +
              (params.seriesData.length ? '：NT$ ' + params.seriesData[0].data : '')
            );
          }
        }
      },
    //   data: ['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12']
      data: props.xData[0]
    },
    {
      type: 'category',
      axisTick: {
        alignWithLabel: true
      },
      axisLine: {
        onZero: false,
        lineStyle: {
          color: props.colors[1]
        }
      },
      axisPointer: {
        label: {
          formatter: function (params) {
            return (
              params.value +
              (params.seriesData.length ? '：NT$ ' + params.seriesData[0].data : '')
            );
          }
        }
      },
      //   data: ['2015-1', '2015-2', '2015-3', '2015-4', '2015-5', '2015-6', '2015-7', '2015-8', '2015-9', '2015-10', '2015-11', '2015-12']
      data: props.xData[1]
    }
  ],
  yAxis: [
    {
        type: 'value',
        name: props.yAxis,
        nameLocation: 'end',
        nameTextStyle: {
            fontWeight: 'bold',
            fontSize: 14,
            lineHeight: 50,
        }
    }
  ],
  series: [
    {
        name: props.name[0],
        type: 'line',
        xAxisIndex: 1,
        smooth: true,
        emphasis: {
        focus: 'series'
        },
        data: props.yData[0]
    },
    {
        name: props.name[1],
        type: 'line',
        smooth: true,
        emphasis: {
        focus: 'series'
        },
        data: props.yData[1],
        lineStyle:{
            type : 'dotted'
        }
    }
  ]
};

onMounted(()=>{
    const line=echarts.init(canvas.value)
    line.setOption(option)
})
</script>

<template>
  <div  ref="canvas" style="width:100%;height:500px"></div>
</template>