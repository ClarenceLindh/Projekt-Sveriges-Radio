<template>
  <h1 id="title">Sveries Radio API</h1>
    <p v-if="isLoggedIn" id="UserName"> {{ loggedInUser.username }}</p>
    <p v-if="!loggedInUser">Is logged in: {{ isLoggedIn }} </p> 
  <Navbar/>
  <router-view />
</template>

<script>
import Navbar from './components/Navbar.vue'

export default {
  name: "App",
  components: {
    Navbar
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
    background-color: rgba(14, 10, 18, .9);
    
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
  color: blanchedalmond;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
