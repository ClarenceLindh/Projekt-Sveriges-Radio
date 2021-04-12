<template>
  <div id="card">
    <div class="Program-card" v-if="type == 'program'">

        <span class="name">{{ card.name }}</span> <br>
        <span id="desc">{{ card.description }}</span> <br>

      </div>

      <div class="Category-card" v-if="type == 'category'">
    
      <span class="name">{{ card.name }}</span> <br>
      <span id="desc">{{ card.description }}</span> <br>
        
    </div>
     <div class="Episode-card" v-if="type == 'episode'">
    
      <span class="title">{{ card.title }}</span> <br>
      <span id="airtime">{{ card.Airtime }} </span><br><br>
      <span id="airtime">{{ card.description }} </span>
    
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
      display: flex;
      list-style-type: none;
      background-color: rgba(0, 0, 0, 0.2);
      margin-bottom: 12px;
      box-shadow: 0 -3px 1px rgba(0, 0, 0, 0.3);
      height: auto;
  }
</style>