<template>
<body>
  

  <div class="home">
    
    
    <div id="Categories"><Categories/></div>
    
    <div id="Programs"><Programs/></div>
    
    <div id="Episodes"><Episodes/></div>

    <div id="Friends"><Friends/></div>

  </div>
  </body>
</template>

<script>
import Programs from "../components/Programs.vue"
import Categories from "../components/Categories.vue"
import Episodes from "../components/Episodes.vue"
import Friends from "../components/Friends.vue"



export default {
  name: "Home",
  
  components: {
    Programs,
    Categories,
    Episodes,
    Friends
  
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
  background-color: rgba(32, 8, 136, .3) ;
  color: aliceblue;
  margin: 1vw;
  width: 55vw;
  margin-right: 0;
  height: 100%;
  box-shadow: 6px 6px 2px rgba(0, 0, 0, .2), inset 3px 3px 2px rgba(240, 200, 255, .1);
}

#Programs {
  background-color: rgba(32, 8, 136, .3) ;
  color: aliceblue;
  margin: 1vw;
  margin-left: 0;
  margin-right: 0;
  width: 60%;
  height: 100%;
  box-shadow: 6px 6px 2px rgba(0, 0, 0, .2), inset 3px 3px 2px rgba(240, 200, 255, .1);
}

#Categories {
  background-color: rgba(32, 8, 136, .3) ;
  color: aliceblue;
  margin: 1vw;
  margin-left: 0;
  width: 10vw;
  height: 100%;
  box-shadow: 6px 6px 2px rgba(0, 0, 0, .2), inset 3px 3px 2px rgba(240, 200, 255, .1);
}

#Friends {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}

body{
  background-color: rgba(18, 15, 25, .5);
  color: black;
}

</style>