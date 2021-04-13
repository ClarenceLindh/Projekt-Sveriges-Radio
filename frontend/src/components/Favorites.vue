<template>
  <div >
<h1 >Favorites</h1>


<h3 style="color:red">Alla favoriter</h3>
<div id="favoriteList">
 <ol style="list-style-type:none;">
        <li v-for="(Favorite, index) in getAllFavorites" :key="index"> 
       <Card :card="Favorite"  :type="'favorite'"/>
         </li>
    </ol>
   </div>
  </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Favorites",
components: {
        Card
    },
    

    computed: {
        getAllFavorites(){
           
            return this.$store.getters.getAllFavorites
        },
        
    },

    methods:{},

    mounted(){
        this.$store.dispatch("fetchAllFavorites")
    },


    
}
</script>

<style scoped>

      
    #favoriteList{
        display: block;
        margin-left: -40px;
        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #favoriteList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #favoriteList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #favoriteList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }

.v1{
  border-left: 6px dotted rgba(0, 0, 0, .3);
  height: auto;
    }
</style>