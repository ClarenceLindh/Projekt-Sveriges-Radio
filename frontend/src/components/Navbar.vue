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
        <router-link to="/login" id="login">Login</router-link>
</nav>
  
</template>

<script>
export default {
    name: "Navbar"
}

</script>

<style>



</style>