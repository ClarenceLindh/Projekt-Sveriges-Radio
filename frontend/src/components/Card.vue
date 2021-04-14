<template>
  <div id="card" >
    <div class="Program-card" v-if="type == 'program'">
        <span class="name">{{ card.name }}</span><br><br><br>
        <button @click.stop="favoriteItem(card.id, card.name, type)">fav</button>
        <button @click.stop="shareItem(card.id, card.name, type)">share</button>
        <span id="desc">{{ card.description }}</span><br><br>

      </div>
      
     <div class="Episode-card" v-if="type == 'episode'">
      <span class="title">{{ card.title }}</span><br><br><br>
      <button @click.stop="favoriteItem(card.id, card.title, type)">fav</button>
      <button @click.stop="shareItem(card.id, card.title, type)">share</button>
      <span id="airtime">{{ card.Airtime }} </span><br><br>
      <span id="desc">{{ card.description }} </span><br><br>
    
    </div>

    <div class="Favorite-card" v-if="type == 'favorite'">
      <span class="favoriteID">{{ card.id }}</span><br>
      <span class="programname">{{ card.programname }}</span><br>
      <span id="episodename">{{card.episodename}}</span><br><br>
      <button v-if="card.episodename != ''" @click="play(card.episode_id)">Play me</button>
      <button @click="deleteFavorite(card.id), refreshStuff()">Delete</button>
      <button v-if="card.programname != ''" 
      @Click="shareItem(card.id, card.programname, 'program')">
        share
        </button>
      <button v-if="card.episodename != ''" 
      @Click="shareItem(card.id, card.episodename, 'episode')">
        share
        </button>


    </div>
    
    <div class="Friend-card" v-if="type == 'friend'">
      <span class="username"> {{ card.username.username }} </span><br><br>
      <button @click="deleteFriend(card.id), refreshStuff()">Delete</button>
    </div>

    <div class="Social-card" v-if="type == 'social'">
      <h3 class="name">{{ card.username.username }}</h3>
      <div id="programId" v-if="card.program_id != 0">
        <h5>Program</h5>

      <button v-if="card.programname != ''" 
      @Click="favoriteItem(card.id, card.programname, 'program')">
        favorite
        </button>

      <button v-if="card.programname != ''" 
      @Click="shareItem(card.id, card.programname, 'program')">
        share
        </button>

        <span>{{ card.program_id }}</span><br>
        <span>{{ card.programname }}</span>
      </div>
      <div id="episodeId" v-if="card.episode_id != 0">
        <h5>Episode</h5>
        
      <button @click="play(card.episode_id)">Play me</button>

      <button v-if="card.episodename != ''" 
      @Click="favoriteItem(card.id, card.episodename, 'episode')">
        favorite
        </button>

      <button v-if="card.episodename != ''" 
      @Click="shareItem(card.id, card.episodename, 'episode')">
        share
        </button>

        

        <span>{{ card.episode_id }}</span><br>
        <span>{{ card.episodename }}</span>
      </div>
    </div>


  </div>
</template>

<script>
export default {
  props: ["card", "type"],

  methods: {
    play(url){
      window.open('https://sverigesradio.se/avsnitt/' + url, "_blank").focus
    },


    refreshStuff(){
            this.$store.dispatch("findMyFriends")
            this.$store.dispatch("fetchAllShares")
            this.$store.dispatch("fetchAllFavorites")
        },

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

    async deleteFavorite(id) {
      let credentials = {
        favoriteID: id
      } 
      let response = await fetch ('/rest/favorites/'+ id, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log ('DELETED')
      }

  },
   
   
   async favoriteItem(id, name, type) {
    if(type == "program"){
      let credentials = {
        program_id: id,
        programname: name,
        episode_id: 0,
        episodename:'',
        user_id: this.$store.state.loggedInUser.id
      
      } 
      let response = await fetch ('/rest/favorites', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log ('Saved as favorite')
      }
      }
    if(type == "episode"){
      let credentials = {
        program_id: 0,
        programname: '',
        episode_id: id,
        episodename:name,
        user_id: this.$store.state.loggedInUser.id
      
      } 
      let response = await fetch ('/rest/favorites', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log ('Saved as favorite')
      }
      }

    },
   async shareItem(id, name, type) {
     if(type == "program"){
      let credentials = {
        program_id: id,
        programname: name,
        episode_id: 0,
        episodename:'',
        userid: this.$store.state.loggedInUser.id
      
      } 
      console.log("Share credantials done")
      let response = await fetch ('/rest/shares', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log ('Saved as share')
      }
      }
      if(type == "episode"){
      let credentials = {
        program_id: 0,
        programname: '',
        episode_id: id,
        episodename:name,
        userid: this.$store.state.loggedInUser.id
      
      } 
      console.log("Share credantials done")
      let response = await fetch ('/rest/shares', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        console.log ('Saved as share')
      }
      }

    }
  }
};
</script>

<style scoped>
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

  .Program-card > .name{
    font-weight: bold;
     font-size: 2.5vh; 
    text-shadow: 4px 3px 2px rgba(0, 0, 0, .3);
    
  }

  .Episode-card{
    width: 99%;
    padding-right: 30px;
  }

  .Program-card{
    width: 99%;
    padding-right: 30px;
  }

  .Episode-card > .title{
    font-weight: bold;
     font-size: 2.4vh; 
    text-shadow: 4px 3px 2px rgba(0, 0, 0, .3);
  }

  .Friend-card > .title{
    font-weight: bold;
    font-size: 2.4vh;
    text-shadow: 4px 3px 2px rgba(0, 0, 0, .3);
  }

  .Favorite-card > .title{
    font-weight: bold;
    font-size: 2.4vh;
    text-shadow: 4px 3px 2px rgba(0, 0, 0, .3);
  }

  #desc{
    color: rgba(255, 255, 255, .6);
    font-size: 1.8vh;
    text-shadow: 3px 2px 2px rgba(0, 0, 0, .5);
  }

  .Episode-card:hover > #desc{
    color: rgba(255, 255, 255, .6);
  }

  .Program-card:hover > #desc{
    color: rgba(255, 255, 255, .6);
  }

  .Episode-card > #airtime{
    color: rgba(255, 255, 255, .4);
    font-size: min(2.5vw, 20px);
  }

  .Episode-card:hover > #airtime{
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
</style>