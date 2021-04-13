<template>
<body>
  

  <div class="home">
    
    <div id="Programs"><Programs/></div>
    
    <div id="Episodes"><Episodes/></div>


  </div>
  </body>
</template>

<script>
import Programs from "../components/Programs.vue"
import Episodes from "../components/Episodes.vue"




export default {
  name: "Home",
  
  components: {
    Programs,
    Episodes
  
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
}

#Episodes {
  background-color: rgba(60, 55, 65, .3);
  color: blanchedalmond;
  width: 49.5%;
  margin: 0;
  margin-top: 1vh;
  margin-left: 1%;
  height: 100%;
  box-shadow: 6px 6px 3px rgba(0, 0, 0, .6), inset 3px 3px 3px rgba(240, 200, 255, .05);
  justify-content: center;
  min-height: 15vh;
}

#Programs {
  background-color: rgba(60, 55, 65, .3);
  color: blanchedalmond;
  margin: 0;
  margin-top: 1vh;
  width: 49.5%;
  height: 100%;
  box-shadow: 6px 6px 3px rgba(0, 0, 0, .6), inset 3px 3px 3px rgba(240, 200, 255, .05);
  justify-content: center;
  min-height: 15vh;
}

body{
  background-color: rgba(60, 55, 65, .1);
}

</style>