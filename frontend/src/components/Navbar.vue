<template>
<nav id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/favorites">Favorites</router-link> |
       <ChannelDropDown/>
    <div class="loginbtn" id="login">
        <router-link to="/login">Login</router-link>
    </div>
       
     
</nav>
  
</template>

<script>
import ChannelDropDown from '../components/Channel_Drop.vue';
export default {
    name: "Navbar",
    components: {
    ChannelDropDown
  },

  computed:{
      
            
  }
}

</script>

<style>
#nav{
    display: block;
    justify-content: flex-end;
    padding: 15px;

    background: rgba(60, 55, 65, .3);
    color: #42b983;
    box-shadow: 0 6px 3px rgba(0, 0, 0, .2), inset 0 4px 6px rgba(240, 200, 255, .025);
}

#login{
    display: flex;
    justify-content: flex-end;
    margin-top: -20px;
}
#logout{
    display: flex;
    justify-content: flex-end;
    margin-top: -20px;
}

select{
    background: black;
    color: blanchedalmond;
    height: 25px;
    font-size: 16px;
    font-weight: bold;
}
</style>