<template>
    <div class=Friends>
        <h1>Friends</h1>
        <h2>{{userId}}</h2>
        
        <ol id="friendList">
        <li  v-for="(friends, index) in getNewFriends" :key="index"> 
            <Card :card="friends" :type="'friend'"/>
            
        </li>
        </ol>
     
    </div>
</template>

<script>
import Card from "./Card"
export default {
  
    
    component: {
        Card
    },

    computed: {
        getNewFriends(){
            return this.$store.getters.getNewFriends
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
#friendList{
        display: block;
        margin-left: -40px;

        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #friendList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #friendList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #friendList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }

</style>