<template>
    <div class="Friends">
        <h1>Friends</h1>
        <h2>{{userId}}</h2>
        <div id="friendList">
        <ol style="list-style-type:none;">
        <li v-for="(friend, index) in getNewFriends" :key="index"> 
            {{friend.username.username}}
            <span class="relationId">{{ friend.id }}</span>
            <button @click="deleteFriend(friend.id)">Delete</button>
            
            
        </li>
        </ol>
        </div>
    </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Friends",
    props: ["card"],
    
    component: {
        Card
    },
    methods: {
    async deleteFriend(id){
      let credentials = {
        relationId: id
      } 
      let response = await fetch ('/rest/friends/'+ id, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        alert ('DELETED')
      }

    }
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
        this.$store.dispatch("findMyFriends")
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