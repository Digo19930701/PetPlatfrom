<script setup>
  // Echarts 5.4.3 : npm install echarts --save
  import { ref, onMounted } from 'vue'
  import * as echarts from 'echarts/core'
  import {
    TooltipComponent,
    GridComponent,
    LegendComponent
  } from 'echarts/components';
  import { BarChart } from 'echarts/charts';
  import { CanvasRenderer } from 'echarts/renderers';

  echarts.use([
    TooltipComponent,
    GridComponent,
    LegendComponent,
    BarChart,
    CanvasRenderer
  ]);

    // 改寫成prop
  const props=defineProps({
    name:{
      type:Array,
      default:['顧客1','顧客2']
    },
    xData:{
      type:Array ,
      default:['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yData:{
      type:Array ,
      default:[[10, 20, 30, 40, 50, 60, 70],[10, 20, 30, 40, 50, 60, 70]]
    },  
    axisName:{
      type:Array,
      default:['時間','數量(筆)'] //[xAxisName, yAxisName]
    },
    colors:{
      type:Array,
      default:['#e2aa00','#ffd184']
    }
  })

  const canvas = ref(null);
  const option = {
    tooltip: {
      trigger: 'axis',
    },
    legend:
    {
      textStyle: {
        fontSize: 14
      }
    },
    grid:
    {
      left: '3%',
      right: '10%',
      bottom: '5%',
      containLabel: true
    },
    xAxis: [
      {
        type: 'category',
        data: props.xData,
        name: props.axisName[0],
        nameLocation: 'middle',
        nameTextStyle: {
          fontWeight: 'bold',
          fontSize: 14,
          lineHeight: 40,
        }
      }
    ],
    yAxis: [
      {
        type: 'value',
        name: props.axisName[1],
        nameLocation: 'end',
        nameTextStyle: {
          fontWeight: 'bold',
          fontSize: 14,
          lineHeight: 32,
        }
      }
    ],
    series: [
          {
            name: props.name[0],
            type: 'bar',
            stack: 'customer',
            emphasis: {
              focus: 'series'
            },
            data: props.yData[0],
            color: props.colors[0],
          },
          {
            name: props.name[1],
            type: 'bar',
            stack: 'customer',
            emphasis: {
              focus: 'series'
            },
            data: props.yData[1],
            color: props.colors[1],
          }
    ]
    
  };


  onMounted(()=>{
    //在onMounted中取得DOM
    const bar=echarts.init(canvas.value)
    //取得DOM後加入設定參數開始繪製
    bar.setOption(option)
})
</script>

<template>
  <div  ref="canvas" style="width:100%;height:500px"></div>
</template>