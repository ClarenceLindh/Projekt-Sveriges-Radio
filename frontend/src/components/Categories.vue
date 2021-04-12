<template>
    <button @click="MaximizeWindow()">[x]</button>
  <div v-if="isMaximized">
    <h1>Categories</h1>
 <ul style="list-style-type:none;">
        <li v-for="(Category, index) in getAllCategories" :key="index" id="categoryList" @click="Clicked(Category)">
            <Card :card="Category" :type="'category'"/>
        </li>
    </ul>

  </div>
  <div v-if="!isMaximized">
      <br>
      C<br>
      a<br>
      t<br>
      e<br>
      g<br>
      o<br>
      r<br>
      i<br>
      e<br>
      s<br><br>
  </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Categories",

    components:{
        Card
    },

    data() {
        return{
            isMaximized: true
        }
    },

    computed: {
        getAllCategories(){
            return this.$store.getters.getAllCategories
        },
    },

    methods: {
        Clicked(category){
            this.$store.commit('setCategoryId',category.id)
            this.$store.dispatch("fetchProgramByCategory")
        },

        MaximizeWindow(){
            this.isMaximized = !this.isMaximized
                var e = document.getElementById("Categories");
            if(!this.isMaximized){
                e.style.width = "auto";
            }else{
                e.style.width = "10vw";
            }
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