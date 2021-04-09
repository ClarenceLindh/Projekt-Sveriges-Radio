<template>
  <form @submit.prevent="login">
    <input v-model="username" type="text" placeholder="username" required>
    <input v-model="password" type="password" placeholder="password" required>
    <button @click="login">Login</button>
    <button type="button" @click="register">Register</button>
  </form>
  <button @click="logout">Logout</button>
</template>

<script>

export default {
  name: "Login",

  data(){
    return {
      username: '',
      password:''
    }
  },

  mounted(){
    console.log('mounted Login');
  },
  methods: {

    logout(){
      fetch ('/logout', {mode: 'no-cors'})
    },

     login (){
      const credentials = 'username=' + encodeURIComponent(this.username) 
      + '&password=' + encodeURIComponent (this.password)
      
      let response =  fetch ("/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        mode: 'no-cors',
        body: credentials
      });

      let user =  fetch('/auth/whoami')

      try {
        user =  user.json()
        this.$store.commit('setLoggedInUser', user)
        console.log(user);
      } catch {
        alert ('Wrong username/password')
      }
    },

    async register() {
      let credentials = {
        username: this.username,
        password: this.password
      }
      let response = await fetch ('/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(credentials)
      })
    }

  },

  components: {
    
  },

};
</script>
