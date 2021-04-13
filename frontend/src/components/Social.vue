<template>
    <div class="Social">
        <h1>Social</h1>
        <ol id="socialList">
            <li v-for="(share, index) in getAllShares"  :key="index"> 
                         <Card :card="share"  :type="'social'"/>  
            </li>
        </ol>
    </div>
</template>

<script>
import Card from "./Card"
export default {

    components: {
        Card
    },

    computed:{
        getAllShares(){
            return this.$store.getters.getAllShares
        }
    },

    mounted(){   
        this.$store.dispatch("fetchAllShares")
    }
}
</script>

<style scoped>
    #socialList{
        display: block;
        margin-left: -40px;

        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }
</style>