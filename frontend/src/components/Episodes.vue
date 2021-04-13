<template>
  <div >
<h1 id="columnTitle">Episodes</h1>


<h3 id="columnSubTitle">Alla episodes från valt program {{currentProgram}}</h3>





<div id="episodeList">
    <ol id="channel"  v-show="isNinja">
            <li  v-for="(Episode, index) in getChannelEpisode" :key="index" id="episodeItem"> 
            <Card :card="Episode" :type="'episode'"/>
            </li>
        </ol>
        
        
        <ol id="program" v-show="!isNinja">
            <li  v-on:click="isNinja = !isNinja" v-for="(Episode, index) in getAllEpisodes" :key="index" id="episodeItem" @click="Clicked(Episode)"> 
            <Card :card="Episode" :type="'episode'"/>
            </li>
        </ol>
    </div>
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
        },getChannelEpisode(){
            this.updateProgramName()

            return this.$store.getters.getAllEpisodesByChannel
        },

        isNinja(){
            return this.$store.getters.getBoolean
        }
    },

    methods:{

      
        updateProgramName(){
            var newProgram = this.$store.getters.getProgramName
            console.log(newProgram)
            this.currentProgram = newProgram
        },

        Clicked(episode){
            if(episode.hasOnDemand){
                var e = document.getElementById("media")
                e.setAttribute('src', episode.url)
                console.log(episode.url)
            }else{
                window.open(episode.url, "_blank").focus
            }
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
        margin-left: -40px;
        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #episodeList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #episodeList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #episodeList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }

    #channel{
        list-style-type: none;
    }

    #program{
        list-style-type: none;
    }

    .v1{
  border-left: 6px dotted rgba(0, 0, 0, .3);
  height: auto;
    }
</style>