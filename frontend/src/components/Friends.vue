<template>
  <div >
<h1>Friendslist</h1>
<h2>{{userId}}</h2>

<li>{{getFriends}}</li>

<h3 style="color:gray">Alla vänner {{getFriends}}</h3>
 <ol id="friendList">
        <li v-for="(Friend, index) in getFriends" :key="index" 
        id="friendItem" @click="Clicked(Friend)"> 
         <Card :card="Friend" :type="'friend'"/>
        </li>
    </ol>

  
<!--
 <ul style="list-style-type:none;">
        <li v-for="(Friend, index) in getAllFriends" :key="index"> 
        {{Friend.userid}} - {{Friend.friendsid}}
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
        getFriends(){
            return this.$store.getters.getFriends
        },
        userId(){
            return this.$store.getters.getLoginUserId
        }
    },

    mounted(){   
        this.$store.dispatch("fetchFriends")
    },

    
}
</script>

<style>

</style>