<template>
  <div class="home">
    <h1>Home</h1>
    <Programs/>
    <Categories/>
    <Episodes/>
  </div>
</template>

<script>
import Programs from "../components/Programs.vue"
import Categories from "../components/Categories.vue"
import Episodes from "../components/Episodes.vue"

export default {
  name: "Home",
  components: {
    Programs,
    Categories,
    Episodes
  },
};
</script>
