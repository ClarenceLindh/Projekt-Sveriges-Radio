<template>
<nav id="nav">
    <div id="routers">
      <router-link to="/">Startsida</router-link> |
      <router-link to="/favorites">Favoriter</router-link> |
      <router-link to="/socialview" @click="refreshUser()">Vänner</router-link> 
    </div>
    <div id="droppers">
       <ChannelDropDown/>
       <CategoryDropDown/>
    </div>
    <div id="login">
        <router-link to="/login">
        <p id="loginText">{{ loginText }}</p>
        </router-link>
        </div>
</nav>
  
</template>

<script>
import ChannelDropDown from '../components/Channel_Drop.vue'
import CategoryDropDown from '../components/category_Drop.vue'

export default {
    name: "Navbar",

  components: {
    ChannelDropDown,
    CategoryDropDown
  },

  computed:{
        loginText(){
          var testStuff
          if(this.$store.getters.getCurrentUser != null){
            testStuff = "Logga ut"
          }else{
            testStuff = "Logga in"
          }
          
          this.updateChannelName()
          return testStuff
        }
  },

  methods:{
        updateChannelName(){
          console.log(this.$store.getters.getLoginStatus)
        },
        refreshUser(){
            this.$store.dispatch("findMyFriends")
            this.$store.dispatch("fetchAllShares")
        }
  }
}
</script>

<style>
#nav{
  position: relative;
  box-sizing: border-box;
  display: block;
  padding: 0;
  width: 100%;
  height: 8vh;

  background-color: rgba(60, 55, 65, .3);
  color: #42b983;
  box-shadow: 0 6px 3px rgba(0, 0, 0, .6), inset 0 4px 6px rgba(240, 200, 255, .025);
}

#routers{
  position: absolute;
  left: 0;
  right: 0;
  top: 5px;
}

#login{
  position: absolute;
  right: 5px;
  bottom: 6.8vh;
}
#logout{
    display: flex;
    justify-content: flex-end;
    margin-top: -20px;
}

#droppers{
  position: absolute;
  left: 0;
  right: 0;
  bottom: 5px;
}

select{
    background: black;
    outline: none;
    border: solid 1px rgba(230, 230, 255, .6);
    color: blanchedalmond;
    height: 25px;
    font-size: 16px;
    font-weight: bold;
    margin: 2px;
    box-shadow: 3px 3px 4px rgba(0, 0, 0, .3);
}
</style>