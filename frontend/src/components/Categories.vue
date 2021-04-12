<template>
  <div >
<h1>Categories</h1>

<h3 style="color:red">Alla kategorier totalt</h3>
 <ul style="list-style-type:none;">
        <li v-for="(Category, index) in getAllCategories" :key="index"> 
            {{Category.name}}
        </li>
    </ul>

  </div>
</template>

<script>
export default {
    name: "Categories",

    computed: {
        getAllCategories(){
            return this.$store.getters.getAllCategories
        },
    },

    mounted(){
        this.$store.dispatch("fetchAllCategories")
    },
}
</script>

<style>

</style>