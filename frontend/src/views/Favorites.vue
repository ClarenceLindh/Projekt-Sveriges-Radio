<template>
  <div class="favorites">
    
    
    <div id="Favorites"><Favorites/></div>
  </div>
</template>

<script>
import Favorites from "../components/Favorites.vue"
export default {
  name: "favorites",
  components: {
    Favorites
  },
}
</script>

<style>
#Favorites {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}
</style>