<template>
  <div >
<h1>Episodes</h1>


<h3 style="color:red">Alla episodes från programid {{currentProgram}}</h3>
 <ol id="episodeList">
        <li v-for="(Episode, index) in getAllEpisodes" :key="index" :card="Episode" id="episodeItem"> 
         <Card :card={{Episode}}/> 
        </li>
    </ol>

  </div>
</template>

<script>
import Card from "./Card"
export default {
    name: "Episodes",

    components:{
        Card
    },

    data(){
        return {
            currentProgram: ''
        }
    },

    computed: {
        getAllEpisodes(){
            this.updateProgramName()

            return this.$store.getters.getAllEpisodes
        },
    },

    methods:{
        updateProgramName(){
            var newProgram = this.$store.getters.getProgramName
            console.log(newProgram)
            this.currentProgram = newProgram
        },
    },

    mounted(){
        this.$store.dispatch("fetchAllEpisodes")
    },
}
</script>

<style>
    #episodeList{
        display: block;
        margin-right: 32px;
    }

    #episodeItem{
        display: flex;
        list-style-type: none;
        background-color: rgba(0, 0, 0, 0.2);
        margin-bottom: 12px;
        box-shadow: 0 -3px 1px rgba(0, 0, 0, 0.3);
    }

    .v1{
  border-left: 6px dotted rgba(0, 0, 0, .3);
  height: auto;
    }
</style>