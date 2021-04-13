<template>
  <div >
<h1>Friends</h1>


<h3 style="color:red">Alla vänner</h3>

 <ul style="list-style-type:none;">
        <li v-for="(Friend, index) in getAllFriends" :key="index"> 
        {{Friend.userid}} - {{Friend.friendsid}}
        </li>
    </ul>
  </div>
</template>

<script>
export default {
    name: "Friends",

    computed: {
        getAllFriends(){
            return this.$store.getters.getAllFriends
        },
        
    },

    mounted(){
        this.$store.dispatch("fetchAllFriends")
    },

    
}
</script>

<style>

</style>