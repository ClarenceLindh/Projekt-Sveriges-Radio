<template>
    <div >
        <h1>Friendslist</h1>
        <h2>{{userId}}</h2>

        <div v-for="(friend, index) in getNewFriends" :key="index"> 
            {{friend.username}}
        </div>
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
        getNewFriends(){
            return this.$store.getters.getNewFriends
        },
        getFriends(){
            return this.$store.getters.getFriends
        },
        userId(){
            return this.$store.getters.getLoginUserId
        }
    },
}
</script>

<style>

</style>