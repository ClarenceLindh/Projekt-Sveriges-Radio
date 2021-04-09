<template>
  <div class="home">
    <h1>Home</h1>
    <h4>Is logged in: {{ isLoggedIn }}</h4>
    <h5 v-if="isLoggedIn">username: {{ loggedInUser.username }}</h5>
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

  mounted (){
    console.log('mounted Home');
  },

  computed:{
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    }
  }

};
</script>
