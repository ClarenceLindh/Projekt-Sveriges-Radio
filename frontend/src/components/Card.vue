<template>
  <div id="card">
    <div class="Program-card" v-if="type == 'program'">
      <span class="name">{{ card.name }}</span><br>
      <button @click.stop="favoriteItem(card.id)">fav</button>
      <button @click.stop="shareItem(card.id)">share</button>
      <br>
      <span id="desc">{{ card.description }}</span> <br>
    </div>

    <div class="Category-card" v-if="type == 'category'">
      <span class="name">{{ card.name }}</span><br>
      <span id="desc">{{ card.description }}</span> <br>
    </div>
     
    <div class="Episode-card" v-if="type == 'episode'">
      <span class="title">{{ card.title }}</span><br>
      <button @click.stop="favoriteItem(card.id)">fav</button>
      <button @click.stop="shareItem(card.id)">share</button>
      <br>
      <span id="airtime">{{ card.Airtime }} </span><br><br>
      <span>{{ card.description }} </span>'
    </div>

    <div class="Friend-card" v-if="type == 'friend'">
      <span class="name">{{ card.name }}</span><br>
      <span id="desc">{{ card.description }}</span> <br>
    </div>


  </div>
</template>

<script>
export default {
  props: ["card", "type"],
  methods: {
    favoriteItem(id){
      console.log("Clicked to favorite " + id)
    },
    shareItem(id){
      console.log("Clicked to share " + id)
    }
  }
};
</script>

<style scoped>
  #card{
    color: rgba(230, 230, 255, .8);
    display: table;
    list-style-type: none;
    background-color: rgba(200, 150, 255, 0.05);
    margin-bottom: 18px;
    box-shadow: 4px 4px 2px rgba(0, 0, 0, .3), inset 2px 2px 2px rgba(240, 200, 255, .1);
    min-height: 4vh;
    max-height: 25vh;
    text-align: center;
    vertical-align: middle;
    width: 100%;
  }

  #card:hover{
    color: rgba(230, 230, 255, 1);
    background-color: rgba(200, 150, 255, 0.1);
    box-shadow: 4px 4px 4px rgba(0, 0, 0, .3), inset 3px 3px 4px rgba(240, 200, 255, .15);
  }

  #card:active{
    color: rgba(230, 230, 255, .6);
    background-color: rgba(0, 0, 0, 0.1);
    box-shadow: inset -3px -3px 4px rgba(220, 180, 255, .1), inset 4px 4px 4px rgba(0, 0, 0, .2);
  }

  .Program-card > .name{
    font-size: 22px;
    font-weight: bold;
  }

  .Episode-card > .title{
    font-size: 20px;
    font-weight: bold;
  }

  .Episode-card > #airtime{
    font-size: 14px;
    color: rgba(255, 255, 255, .4);
  }

  .Episode-card:hover > #airtime{
    color: rgba(255, 255, 255, .6);
  }

  .Category-card{
    font-size: 100%;
  }

  button{
    border: none;
    background-color: rgba(64, 46, 120, .8);
    box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
    margin: 1px;
    margin-top: 0;
    margin-bottom: 0;
    height: 25px;
    width: 8%;
    outline: none;
  }

  button:hover{
    background-color: rgba(84, 66, 140, .8);
  }
  
  button:active{
    border: none;
    background-color: rgba(44, 26, 100, .8);
    box-shadow: inset -2px -2px 2px rgba(220, 180, 255, .1), inset 2px 2px 2px rgba(0, 0, 0, .2);
  }

  span{
    vertical-align: middle;
  }
</style>