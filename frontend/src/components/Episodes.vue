<template>
  <div >
<h1 id="columnTitle">Episodes</h1>


<h3 id="columnSubTitle">Alla episodes från valt program {{currentProgram}}</h3>
 <ol id="episodeList">
        <li v-for="(Episode, index) in getAllEpisodes" :key="index" id="episodeItem" @click="Clicked(Episode)"> 
         <Card :card="Episode" :type="'episode'"/>
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

        Clicked(episode){
            window.open(episode.url, '_blank').focus()
        }
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
        list-style-type: none;
    }

    .v1{
  border-left: 6px dotted rgba(0, 0, 0, .3);
  height: auto;
    }
</style>