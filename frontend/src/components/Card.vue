<template>
  <div id="card">
    <div class="Program-card" v-if="type == 'program'">
        <span class="name">{{ card.name }}</span>
        <button>fav</button>
        <button>share</button>
        <br>
        <span id="desc">{{ card.description }}</span> <br>

      </div>

      <div class="Category-card" v-if="type == 'category'">
    
      <span class="name">{{ card.name }}</span><br>
      <span id="desc">{{ card.description }}</span> <br>
        
    </div>
     <div class="Episode-card" v-if="type == 'episode'">
    
      <span class="title">{{ card.title }}</span>
      <button>fav</button>
      <button>share</button>
      <br>
      <span id="airtime">{{ card.Airtime }} </span><br><br>
      <span>{{ card.description }} </span>
    
    </div>
  </div>
</template>

<script>
export default {
  props: ["card", "type"],
  methods: {
  }
};
</script>

<style scoped>
  #card{
      display: table;
      list-style-type: none;
      background-color: rgba(0, 0, 0, 0.2);
      margin-bottom: 18px;
      box-shadow: 4px 4px 2px rgba(0, 0, 0, .3), inset 2px 2px 2px rgba(240, 200, 255, .1);
      min-height: 4vh;
      max-height: 25vh;
      text-align: center;
      vertical-align: middle;
      width: 100%;
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
    color: rgba(255, 255, 255, .6);
  }

  .Category-card{
    font-size: 100%;
  }

  button{
    border: none;
    background-color: rgba(64, 46, 120, .8);
    box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
  }

  span{
    vertical-align: middle;
  }
</style>