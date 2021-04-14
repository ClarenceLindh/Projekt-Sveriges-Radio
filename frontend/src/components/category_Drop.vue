<template>
    <select name="categories" id="category_drop" @change="saveCategory()">
        <option value="" selected disabled hidden>Kategorier</option>
        <option  v-for="(category, index) in getCategories" :key="index"  :value="category.id" > 
                {{category.name}}
        </option>
    </select> 
</template>

<script>
export default {
    name: "Categories",

    data(){
    },

    computed: {
        getCategories(){
            return this.$store.getters.getAllCategories
        },
    },
    
 methods:{
      saveCategory(){
            var e = document.getElementById("category_drop");
            var strUser = e.options[e.selectedIndex].value;
            this.$store.commit('setCategoryId',strUser);
            this.$store.dispatch("fetchProgramByCategory")
            this.$store.commit('setCategoryName', e.options[e.selectedIndex].text)

            var f = document.getElementById("channels_drop");
            f.selectedIndex = 0;
      }
    },

   async mounted(){
        this.$store.dispatch("fetchAllCategories")
    },
}
</script>
