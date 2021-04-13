<template>
  <form >
    <input v-model="username" type="text" placeholder="username" required>
    <input v-model="password" type="password" placeholder="password" required>
    <button @click="login">Login</button>
    <button @click="register">Register</button>
    <button @click="logout">Logout</button>
    
<!-- 
    <button v-if="loggedInUser!=null" @click="logout">Logout</button>
    <button v-else @click="login">Login</button>
-->
  </form>
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

  computed: {
    
  },

  methods: {  

    logout(){
      this.$store.commit('setLoggedInUser', null),
      alert ('Logged out')
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
        body: credentials,
      });

      try {
        let user =  fetch('/auth/whoami')
        this.$store.commit('setLoggedInUser', user)
        console.log(user);
      } catch {
        alert ('Wrong username/password')        
      }
      if(response.url.includes('error')){
        console.log('Wrong username/password')        
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
      if(response.url.includes('error')){
        console.log('Something went wrong. Try again')
      } else {
        alert ('Registered user')
      }
    }

  },

  components: {
    
  },

};
</script>
