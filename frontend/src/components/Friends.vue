<template>
  <div >
<h1>Friendslist</h1>

 <ul style="list-style-type:none;">
        <li v-for="(Friends, index) in getAllFriends" :key="index"> 
            {{Friends.name}}
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