<template>
    <div class="Friends">
        <h1>Friends</h1>
        <h2>{{userId}}</h2>
        <div id="friendList">
        <ol style="list-style-type:none;">
        <li v-for="(friend, index) in getNewFriends" :key="index"> 
            {{friend.username.username}}
            <span class="relationId">{{ friend.id }}</span>
            <button @click="deleteFriend(friend.id), refreshUser()">Delete</button>
            
            
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
    
    components: {
        Card
    },
    methods: {
    async deleteFriend(id){
      let credentials = {
        relationId: id,
      } 
      let response = await fetch ('/rest/friends/'+ id, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log(id + ' deleted')
        
      }

    },
    refreshUser(){
            this.$store.dispatch("findMyFriends")
            this.$store.dispatch("findMyFriends")
            this.$store.dispatch("fetchAllShares")
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
        
    },
}
</script>

<style scoped>

#favoriteList{
        display: block;
        margin-left: -40px;
        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #favoriteList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #favoriteList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #favoriteList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }
/*
#card{
    color: rgba(255, 250, 235, .7);
    display: flex;
    list-style-type: none;
    background-color: rgba(60, 55, 65, .3);
    margin: 0 auto;
    padding: 2vh;
    margin-bottom: 18px;
    box-shadow: 4px 4px 2px rgba(0, 0, 0, .3), inset 2px 2px 2px rgba(240, 200, 255, .1);
    min-height: 4vh;
    max-width: 100%;
    justify-content: center;
    align-self: center;
  }

  #card:hover{
    color: rgba(255, 250, 235, .9);
    background-color: rgba(60, 55, 65, .7);
    box-shadow: 4px 4px 4px rgba(0, 0, 0, .3), inset 3px 3px 4px rgba(240, 200, 255, .15);
  }

  #card:active{
    color: rgba(230, 230, 255, .6);
    background-color: rgba(0, 0, 0, .1);
    box-shadow: inset -3px -3px 4px rgba(240, 200, 255, .1), inset 3px 3px 2px rgba(0, 0, 0, .2);
  }



  #desc{
    color: rgba(255, 255, 255, .6);
    font-size: 1.8vh;
    text-shadow: 3px 2px 2px rgba(0, 0, 0, .5);
  }

  .Friend-card:hover > #desc{
    color: rgba(255, 255, 255, .6);
  }

  .Friend-card > #airtime{
    color: rgba(255, 255, 255, .4);
    font-size: min(2.5vw, 20px);
  }

  .Friend-card:hover > #airtime{
    color: rgba(255, 255, 255, .6);
  }

  button{
    display: block;
    position: relative;
    top: -2vh;
    left: 1px;
    border: none;
    outline: none;
    background-color: rgba(80, 75, 85, .3);
    color: rgba(230, 230, 255, .6);
    box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
    margin: 3px;
    margin-left: 1vw;
    width: 46.5vw;
    height: min(5vh, 25vw);
    text-shadow: -1px -1px 2px rgba(0, 0, 0, .3), 1px 1px 2px rgba(126, 126, 126, .5);
  }

  button:hover{
    background-color: rgba(80, 75, 85, .8);
  }
  
  button:active{
    color: rgba(230, 230, 255, .8);
    border: none;
    background-color: rgba(80, 75, 85, .1);
    box-shadow: inset -2px -2px 2px rgba(220, 180, 255, .1), inset 2px 2px 2px rgba(0, 0, 0, .2);
  }

  span{
    vertical-align: middle;
    font-size: 100%;
  }

  .isSelected{
    background-color: red;
  }
  */

</style>