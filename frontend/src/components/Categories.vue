<template>
    <button @click="MaximizeWindow()" id="minButt">[x]</button>
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

    #minButt{
        display: flex;
        float: left;
        border: none;
        height: 2vh;
        width: 3vh;
        outline: none;
        background-color: rgba(80, 75, 85, .3);
        color: rgba(230, 230, 255, .6);
        box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
    }

  #minButt:hover{
    background-color: rgba(80, 75, 85, .8);
  }
  
  #minButt:active{
    color: rgba(230, 230, 255, .8);
    border: none;
    background-color: rgba(80, 75, 85, .1);
    box-shadow: inset -2px -2px 2px rgba(220, 180, 255, .1), inset 2px 2px 2px rgba(0, 0, 0, .2);
  }
</style>