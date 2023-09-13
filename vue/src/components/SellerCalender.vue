<!-- npm install qalendar -->

<script>
import { Qalendar } from "qalendar";

export default {
  components: {
    Qalendar,
  },

  data() {
    return {
      events: [
        {
          // title: "寵物溝通",
          // with: "Albert Einstein",
          time: { start: "2023-09-11 04:00", end: "2023-09-11 05:00" },
          colorScheme: "whisperer",
          isEditable: false,
          id: "de471c78cb5c",
          description:
            "Think of me as Yoda. Only instead of being little and green, I wear suites and I'm awesome.",
        },
        {
          // title: "Advanced algebra",
          // with: "Pheobe Buffay",
          time: { start: "2023-09-11 20:30", end: "2023-09-11 21:00" },
          colorScheme: "nannyTraining",
          // isEditable: true,
          id: "6d3c0980a5cf",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores assumenda corporis doloremque et expedita molestias necessitatibus quam quas temporibus veritatis. Deserunt excepturi illum nobis perferendis praesentium repudiandae saepe sapiente voluptatem!",
        },
        {
          // title: "Break",
          // with: "Marshall Eriksen",
          time: { start: "2023-09-02 22:10", end: "2023-09-02 22:55" },
          colorScheme: "beauty",
          // isEditable: true,
          
          id: "9f1b209982f1",
          // location: "Zoom",
        },
        // ... and more
      ],

      config: {
        locale: "zh-CN",
        defaultMode: "month",
        style: {
          colorSchemes: {
            beauty: {
              color: "#666666",
              backgroundColor: "#FFBFD6",
            },
            nannyTraining: {
              color: "#666666",
              backgroundColor: "#BFF3FF",
            },
            whisperer: {
              color: "#666666",
              backgroundColor: "#BFF3B3",
            },
            graphy: {
              color: "#666666",
              backgroundColor: "#E3BFFF",
            },
            
          },
        },
      },
    };
  },
};
</script>

<template>
  <Qalendar
    :selected-date="new Date(2023, 8, 18)"
    :events="events"
    :config="config"
  />
</template>

<style src="../assets/seller.css"></style>
<style>@import "qalendar/dist/style.css";</style>
<style lang="scss">
  .calendar-header[data-v-2292c0f3] {
    background-color: var(--qalendar-theme-color);
    border-radius: var(--qalendar-border-radius) var(--qalendar-border-radius) 0px 0px;
    color: #666666;
  }
  .qalendar-is-small .calendar-month__event[data-v-4766dfc7] {
      width: 0.5rem;
      height: 0.5rem;
      border: 1px solid var(--system-gray);;
  }
  .agenda__header-date{
    color: var(--system-gray);
  }
  .agenda__event[data-v-698b431e] {
    padding: 5px;
  }
  .agenda__wrapper[data-v-b60cbce5] {
    padding: 10px 5px;
  }
  .calendar-root-wrapper .calendar-root{
    background-color: white;
  }
  .calendar-root, .date-picker-root {
    --system-yellow: #F8D479;
    --system-gray: #666666;
    --qalendar-border-gray-thin: 1px solid rgb(224 224 224);
    --qalendar-theme-color: var(--system-yellow);
}
</style>

<!-- https://tomosterlund.github.io/qalendar/guide.html -->
<!-- https://y3jnxov469.codesandbox.io/ -->