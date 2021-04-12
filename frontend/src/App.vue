<template>
  <h1 id="title">Sveriges Radios Vänskapskrets</h1>
    <p v-if="isLoggedIn" id="UserName"> {{ loggedInUser.username }}</p>
    <p v-if="!loggedInUser">Is logged in: {{ isLoggedIn }} </p> 
  <Navbar/>
  <media-player />
  <router-view />
</template>

<script>
import Navbar from './components/Navbar.vue'
import MediaPlayer from './components/MediaPlayer.vue'

export default {
  name: "App",
  components: {
    Navbar,
    MediaPlayer
  },

  async mounted () {
    let user = await fetch ('/auth/whoami')
    try {
      user = await user.json()
      this.$store.commit('setLoggedInUser', user)
      console.log(user);
    } catch {
      console.log('Not logged in')
    }
    
  },

  computed:{
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    }
  }
  
}
</script>

<style>
body{
    margin: 0;
    background-color: #121212;
}

p{
  margin-top: -28px;
  margin-right: 5px;
  display: flex;
  float: right;
}

#UserName{
  font-size: 25px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #a4b4c4d5;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: rgba(255, 235, 205, 1);
}

#nav a.router-link-exact-active {
    color: #42b983;
}

#columnTitle{
  color: rgba(255, 245, 225, 1);
}

#columnSubTitle{
  color: #a4b4c4d5;
}
</style>
