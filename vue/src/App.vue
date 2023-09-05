<script setup>
// import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import Home from './components/Home.vue'
import Menu from './components/SearchMenu.vue'
import HomeHeader from './components/HomeHeader.vue'
</script>

<template>
  <!-- <div class="wrapper"> -->
  <!-- <HelloWorld /> -->

  <HomeHeader />
  <Menu></Menu>

  <!-- <Home /> -->
  <!-- <Footer></Footer> -->

  <!-- <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </nav> -->

  <!-- <RouterView /> -->
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}
@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }
}
</style>
