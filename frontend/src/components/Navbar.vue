<template>
<nav id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/favorites">Favorites</router-link> |
       <ChannelDropDown/>
    <div id="login">
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
}

</script>

<style>
#nav{
    display: block;
    justify-content: flex-end;
    padding: 15px;

    background: black;
    color: #42b983;
}

#login{
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