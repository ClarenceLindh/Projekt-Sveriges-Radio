<template>
<body>
  

  <div class="home">
    <h4>Is logged in: {{ isLoggedIn }}</h4>
    <h5 v-if="isLoggedIn">username: {{ loggedInUser.username }}</h5>
    
    <div id="Categories"><Categories/></div>
    
    <div id="Programs"><Programs/></div>
    
    <div id="Episodes"><Episodes/></div>

  </div>
  </body>
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
    Episodes,
  
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


<style scoped>

.home{
  display: flex;
  justify-content: space-between;
  
}
#Episodes {
  background-color: rgb(16, 4, 68) ;
  color: aliceblue;
  margin: 2vw;
  width: 30vw;
}
#Programs {
  background-color: rgb(16, 4, 68) ;
  color: aliceblue;
  margin: 2vw;

}
#Categories {
  background-color: rgb(16, 4, 68) ;
  color: aliceblue;
  margin: 2vw;
  width: 10vw;
}

#Friends {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}


body{
  background-color: rgb(12, 10, 16);
  color: black;
}

</style>