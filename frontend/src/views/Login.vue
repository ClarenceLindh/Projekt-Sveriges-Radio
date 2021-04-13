<template>
  <div id="loginForms">
    <form @submit.prevent="login">
      <input v-model="username" type="text" placeholder="username" required>
      <input v-model="password" type="password" placeholder="password" required>
      <button @click="login">Login</button>
      <button type="button" @click="register">Register</button>
    </form>
    <div id="logout">
      <button @click="logout">Logout</button>
    </div>
  </div>
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
      location.reload()
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
        this.$store.commit('setLoggedInUser', user)
        console.log(user);
        location.reload()
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
        console.log('Wrong username/password')
      }
    }

  },

  components: {
    
  },

};
</script>

<style scoped>
  #loginForms{
    position: relative;
    display: table;
    margin: 20px auto;
    height: 25vh;
    width: 30%;
    background-color: rgba(60, 55, 65, .3);
    box-shadow: 4px 4px 2px rgba(0, 0, 0, .3), inset 2px 2px 2px rgba(240, 200, 255, .1);
  }

  #logout{
    display: flex;
    height: 23px;
    width: 60px;
    position: absolute;
    bottom: 15px;
    right: 5px;
  }

  #logout > button{
    height: 29px;
    width: 60px;
  }

  button{
    height: 6vh;
    width: 40%;
    margin: 5px;
  }

  input{
    margin: 5px;
    height: 3vh;
  }
</style>