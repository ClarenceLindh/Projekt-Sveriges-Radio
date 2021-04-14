<template>
<body>
  <div class="friends">

    <div id="Friends"><Friends/></div>

    <div id="Social"><Social/></div>

  </div>
</body>
</template>

<script>
import Friends from "../components/Friends.vue"
import Social from "../components/Social.vue"


export default {
  name: "socialview",
  components: {
    Friends,
    Social
  },
}
</script>

<style scoped>

.friends{
  display: flex;
}

#Social {
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

#Friends {
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