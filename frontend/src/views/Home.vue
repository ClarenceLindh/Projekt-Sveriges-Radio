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
    Friends,
  },
};
</script>


<style scoped>

.home{
  display: flex;
  justify-content: space-between;
  
}
#Episodes {
  background-color: rgb(9, 18, 71) ;
  color: aliceblue;
  margin: 2vw;

}
#Programs {
  background-color: rgb(16, 4, 68) ;
  color: aliceblue;
  margin: 2vw;

}
#Categories {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}

#Friends {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}


body{
  background-color: black;
  color: black;
}

</style>