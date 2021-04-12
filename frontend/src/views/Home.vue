<template>
<body>
  

  <div class="home">
    
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
  background-color: rgba(60, 55, 65, .3);
  color: blanchedalmond;
  margin: 1vw;
  width: 55vw;
  margin-right: 0;
  height: 100%;
  box-shadow: 6px 6px 3px rgba(0, 0, 0, .6), inset 3px 3px 3px rgba(240, 200, 255, .05);
}

#Programs {
  background-color: rgba(60, 55, 65, .3);
  color: blanchedalmond;
  margin: 1vw;
  margin-left: 0;
  margin-right: 0;
  width: 60%;
  height: 100%;
  box-shadow: 6px 6px 3px rgba(0, 0, 0, .6), inset 3px 3px 3px rgba(240, 200, 255, .05);
}

#Categories {
  background-color: rgba(60, 55, 65, .3);
  color: blanchedalmond;
  margin: 1vw;
  margin-left: 0;
  width: 10vw;
  height: 100%;
  box-shadow: 6px 6px 3px rgba(0, 0, 0, .6), inset 3px 3px 3px rgba(240, 200, 255, .05);
}

body{
  background-color: rgba(60, 55, 65, .1);
}

</style>