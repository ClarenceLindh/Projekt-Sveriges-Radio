<template>
  <div id="loginForms">
    <form @submit.prevent="login">
      <input id="input" v-model="username" type="text" placeholder="username" required>
      <input id="input" v-model="password" type="password" placeholder="password" required>
      <button @click="login">Logga in</button>
      <button type="button" @click="register">Registrera</button>
    </form>
    <div id="logout">
      <button @click="logout">Logga ut</button>
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

  computed: {
    
  },

  methods: {  

    logout(){
      fetch ('/logout', {mode: 'no-cors'})
      location.reload()
    },

     async login (){
      const credentials = 'username=' + encodeURIComponent(this.username) 
      + '&password=' + encodeURIComponent (this.password)
      
      let response =  await fetch ("/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        mode: 'no-cors',
        body: credentials,
      });

      console.log(response)
      
      setTimeout(() => location.reload(), 1)
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
        alert ('Användare registrerad')
      }
    }

  },

  components: {
    
  },

};
</script>

<style scoped>
  
  button{
    height: 3vh;
    width: 5.5vh;
    border: none;
    outline: none;
    background-color: rgba(80, 75, 85, .3);
    color: rgba(230, 230, 255, .6);
    box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
    margin: 3px;
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
  
  
  #loginForms{
    padding: 2vh;
    position: relative;
    display: table;
    margin: 20px auto;
    height: 25vh;
    width: 30%;
    background-color: rgba(60, 55, 65, .3);
    box-shadow: 4px 4px 2px rgba(0, 0, 0, .3), inset 2px 2px 2px rgba(240, 200, 255, .1);
  }

  #input{
    background: black;
    outline: none;
    border: solid 1px rgba(230, 230, 255, .6);
    color: blanchedalmond;
    height: 25px;
    font-size: 16px;
    font-weight: bold;
    margin: 2px;
    box-shadow: 3px 3px 4px rgba(0, 0, 0, .3);
    max-width: 75%;
  }

  #logout{
    display: flex;
    height: 23px;
    width: 100px;
    position: absolute;
    bottom: 15px;
    right: 5px;
    padding: 1vh;
  }

  #logout > button{
    height: 29px;
    width: 100px;
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