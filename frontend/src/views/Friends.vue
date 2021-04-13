<template>
  <div class="friends">
    
    
    <div id="Friends"><Friends/></div>
  </div>
</template>

<script>
import Friends from "../components/Friends.vue"
export default {
  name: "friends",
  components: {
    Friends
  },
}
</script>

<style>
#friends {
  background-color: rgba(8, 2, 68, 0.568) ;
  color: aliceblue;
  margin: 2vw;

}
</style>