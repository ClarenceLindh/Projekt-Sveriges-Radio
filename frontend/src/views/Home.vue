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
    Episodes
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
body{
  background-color: rgb(12, 10, 16);
  color: black;
}

</style>