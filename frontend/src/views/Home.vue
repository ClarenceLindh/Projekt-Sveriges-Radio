<template>
  <div class="home">
    <h1>Home</h1>
    <Programs/>
    <Categories/>
  </div>
</template>

<script>
import Programs from "../components/Programs.vue"
import Categories from "../components/Categories.vue"

export default {
  name: "Home",
  components: {
    Programs,
    Categories
  },
};
</script>
