<template>
    <div >
        <h1>Friends</h1>
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

    mounted(){   
        this.$store.dispatch("fetchFriends")
    },
}
</script>

<style>

</style>