<template>
  <div id="card">
    <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->

    <!-- <div class="Program-card">

  
      
        <span class="name">{{ card.name }}</span> <br>
        <span id="desc">{{ card.description }}</span> <br>
      
            -->

        
      <!-- </div> -->
        <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->

      <div class="Channel-card" :v-if="card.name && !card.description">
    
        <span class="title">{{ card.name }}</span> <br>
      
      </div>
    
      <div class="Episode-card" v-if="card.title">

          <span class="title">{{ card.title }}</span> <br>
        <span id="airtime">{{ card.Airtime }} </span>
        
      </div>
    </div>
 
</template>

<script>
export default {
  props: ["card"],
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
      height: 5vh;
      text-align: center;
  }
</style>