<template>
  <div >
<h1>Favorites</h1>


<h3 style="color:red">Alla favoriter</h3>

 <ul style="list-style-type:none;">
        <li v-for="(Favorite, index) in getAllFavorites" :key="index"> 
       {{Favorite.program_id}} - {{Favorite.programname}} - {{Favorite.episode_id}} - {{Favorite.episodename}} - 
        <button>Delete</button>
        </li>
    </ul>
  </div>
</template>

<script>
export default {
    name: "Favorites",

    computed: {
        getAllFavorites(){
            return this.$store.getters.getAllFavorites
        },
        
    },

    mounted(){
        this.$store.dispatch("fetchAllFavorites")
    },


    
}
</script>

<style>

</style>