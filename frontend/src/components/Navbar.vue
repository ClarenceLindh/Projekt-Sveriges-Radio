<template>
<nav id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/channels">Channels</router-link> |
    <router-link to="/favorites">Favorites</router-link> |
    <select name="channels" id="channels">
        <option value="" selected disabled hidden>Channels</option>
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
        <option value="4">Four</option>
        <option value="5">Five</option>    
    </select> 
    <div id="login">
        <router-link to="/login">Login</router-link>
    </div>
</nav>
  
</template>

<script>
export default {
    name: "Navbar"
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