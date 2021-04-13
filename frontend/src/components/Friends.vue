<template>
  <div >
<h1>Friendslist</h1>

<h3 style="color:gray">Alla vänner {{getAllFriends}}</h3>
 <ol id="friendList">
        <li v-for="(Friend, index) in getAllFriends" :key="index" id="friendItem" @click="Clicked(Friend)"> 
         <Card :card="Friend" :type="'friend'"/>
        </li>
    </ol>

  
<!--
 <ul style="list-style-type:none;">
        <li v-for="(Friends, index) in getAllFriends" :key="index"> 
            {{Friends.name}}
        </li>
    </ul>
-->
  </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Friends",
    
    component: {
        Card
    },

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