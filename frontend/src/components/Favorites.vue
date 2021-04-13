<template>
  <div >
<h1>Favorites</h1>
<p>Current user id: {{ currentUser }}</p>
<h3 style="color:red">Alla favoriter</h3>

 <ul style="list-style-type:none;">
        <li v-for="(Favorites, index) in getAllFavorites" :key="index"> 
            {{Favorites.name}}
        </li>
    </ul>

  </div>
</template>

<script>
export default {
    name: "Favorites",

    data(){
        return{
            currentUser: ''
        }
    },

    computed: {
        getAllFavorites(){
            this.updateCurrentUser()
            return this.$store.getters.getAllFavorites
        },
    },

    methods:{
        updateCurrentUser(){
            this.currentUser = this.$store.state.loggedInUser
        }
    },

    mounted(){
        this.$store.dispatch("fetchAllFavorites")
    },
}
</script>

<style>

</style>