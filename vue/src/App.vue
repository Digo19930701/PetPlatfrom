<template>
  <div class="index">
    <router-view></router-view>
  </div>
</template>

<style scoped>
/* header {
  line-height: 1.5;
  max-height: 100vh;
}
@media (min-width: 1024px) {
  header {
    display: flex;
    flex-direction: column;
    place-items:  center;
    padding-right: calc(var(--section-gap) / 2);
  }
} */

.index {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  background-color: #f8f4da;
}
</style>
