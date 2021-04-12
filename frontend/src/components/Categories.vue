<template>
  <div >
<h1>Categories</h1>

<h3 style="color:red">Alla kategorier totalt</h3>
 <ul style="list-style-type:none;">
        <li v-for="(Category, index) in getAllCategories" :key="index" id="categoryList" @click="Clicked(Category)">
            <Card :card="Category" :type="'category'"/>
        </li>
    </ul>

  </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Categories",

    components:{
        Card
    },

    computed: {
        getAllCategories(){
            return this.$store.getters.getAllCategories
        },
    },

    methods: {
        Clicked(category){
            alert("Du klickade på " + category.name)
        }
    },

    mounted(){
        this.$store.dispatch("fetchAllCategories")
    },
}
</script>

<style>
    #categoryList{
        display: block;
        margin-right: 32px;
        list-style-type: none;
    }
</style>