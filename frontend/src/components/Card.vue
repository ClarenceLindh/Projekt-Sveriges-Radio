<template>


   <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->

  <div class="Program-card">

 
    
      <span class="name">{{ card.name }}</span> <br>
      <span id="desc">{{ card.description }}</span> <br>
     
       

      
     </div>
      <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->

    <!-- <div class="Channel-card">

   
      <span class="title">{{ card.name }}</span> <br>
    
      </div>
     -->
   <!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->
   
     <div class="Episode-card">

    
         <span class="title">{{ card.title }}</span> <br>
      <span id="airtime">{{ card.Airtime }} </span>
      
      
    
    </div>
 
</template>

<script>
export default {
  props: ["card"],
  methods: {
  }
};
</script>