<!-- npm install qalendar -->

<script>
import { Qalendar } from 'qalendar'

// const props=defineProps({
//   events: {
//     type: Object,
//     default:{
//       id:{
//         type: String,
//         default: "orderId"
//       },
//       title:{
//         type: String,
//         default: "保母/訓練"
//       },
//       time:{
//         type: String,
//         default: '{ start: "2023-09-21 20:30", end: "2023-09-21 21:00" }'
//       },
//       colorScheme: {
//         type: String,
//         default: "nannyTraining"
//       },
//     }
//   }
// })

export default {
  components: {
    Qalendar
  },

  data() {
    return {
      events: [
        {
          id: 'props.events.id',
          title: '保母/訓練',
          // with: "Pheobe Buffay",
          time: { start: '2023-09-21 20:30', end: '2023-09-21 21:00' },
          colorScheme: 'nannyTraining'
          // description:
          //   "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores assumenda corporis doloremque et expedita molestias necessitatibus quam quas temporibus veritatis. Deserunt excepturi illum nobis perferendis praesentium repudiandae saepe sapiente voluptatem!",
          // location: "Zoom",
        },
        {
          id: '9f1b209982f1',
          title: '寵物美容',
          time: { start: '2023-09-21 08:30', end: '2023-09-21 09:00' },
          colorScheme: 'beauty'
        },
        {
          id: '9f1b209982f1',
          title: '寵物攝影',
          time: { start: '2023-09-21 20:30', end: '2023-09-21 21:00' },
          colorScheme: 'graphy'
        },
        {
          id: '9f1b209982f1',
          title: '剪指甲',
          time: { start: '2023-10-17 13:00', end: '2023-10-17 14:00' },
          colorScheme: 'beauty'
        },
        {
          id: '9f1b209982f1',
          title: '剪毛',
          time: { start: '2023-10-18 15:00', end: '2023-10-18 16:00' },
          colorScheme: 'beauty'
        },
        {
          id: '9f1b209982f1',
          title: '洗澡&SPA',
          time: { start: '2023-10-19 10:00', end: '2023-10-19 11:00' },
          colorScheme: 'beauty'
        }

        // {
        //   id: "9f1b209982f1",
        //   title: "寵物美容",
        //   time: { start: "2023-10-01 20:30", end: "2023-10-01 21:00" },
        //   colorScheme: "beauty",
        // },
        // {
        //   id: "9f1b209982f1",
        //   title: "寵物美容",
        //   time: { start: "2023-10-01 20:30", end: "2023-10-01 21:00" },
        //   colorScheme: "beauty",
        // },
        // {
        //   id: "9f1b209982f1",
        //   title: "寵物美容",
        //   time: { start: "2023-10-01 20:30", end: "2023-10-01 21:00" },
        //   colorScheme: "beauty",
        // },
        // {
        //   title: "寵物攝影",
        //   time: { start: "2023-10-23 19:30", end: "2023-10-23 21:00" },
        //   colorScheme: "graphy",
        //   id: "9f1b209982f1",
        // },
      ],

      config: {
        locale: 'en-US', //中文版"zh-CN"翻譯不佳故用英文
        defaultMode: 'week',
        showCurrentTime: true,
        dayBoundaries: {
          start: 6,
          end: 23
        },
        style: {
          colorSchemes: {
            beauty: {
              color: '#666666',
              backgroundColor: '#FFBFD6'
            },
            nannyTraining: {
              color: '#666666',
              backgroundColor: '#BFF3FF'
            },
            whisperer: {
              color: '#666666',
              backgroundColor: '#BFF3B3'
            },
            graphy: {
              color: '#666666',
              backgroundColor: '#E3BFFF'
            }
          }
        }
      }
    }
  }
}
</script>

<template>
  <Qalendar :events="events" :config="config" />
</template>

<style src="../assets/seller.css"></style>
<style>
@import 'qalendar/dist/style.css';
</style>
<style lang="scss">
.calendar-header[data-v-2292c0f3] {
  background-color: var(--qalendar-theme-color);
  border-radius: var(--qalendar-border-radius) var(--qalendar-border-radius) 0px 0px;
  color: #666666;
}
.qalendar-is-small .calendar-month__event[data-v-4766dfc7] {
  width: 0.5rem;
  height: 0.5rem;
  border: 1px solid var(--system-gray);
}
.agenda__header-date {
  color: var(--system-gray);
}
.agenda__event[data-v-698b431e] {
  padding: 5px;
}
.agenda__wrapper[data-v-b60cbce5] {
  padding: 10px 5px;
}

.calendar-root-wrapper .calendar-root {
  background-color: white;
  height: 100%;
}
.calendar-root,
.date-picker-root {
  --system-yellow: #f8d479;
  --system-gray: #666666;
  --qalendar-border-gray-thin: 1px solid rgb(224 224 224);
  --qalendar-theme-color: var(--system-yellow);
}
</style>

<!-- https://tomosterlund.github.io/qalendar/guide.html -->
<!-- https://y3jnxov469.codesandbox.io/ -->
