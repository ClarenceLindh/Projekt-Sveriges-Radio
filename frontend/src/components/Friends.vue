<template>
    <div >
        <h1>Friendslist</h1>
        <h2>{{userId}}</h2>

        <h3 style="color:gray">Alla vänner {{getNewFriends}}</h3>
        <h3 style="color:gray">Alla vänner {{getFriends}}</h3>
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