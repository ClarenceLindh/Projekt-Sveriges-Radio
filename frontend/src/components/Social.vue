<template>
    <div class="Social">
        <h1>Vänners delningar</h1>
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

    #socialList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #socialList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #socialList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }
    
</style>