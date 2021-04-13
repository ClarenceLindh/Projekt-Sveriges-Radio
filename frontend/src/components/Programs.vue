<template>
<div class="programs">
    <h1>Programs</h1>
    <input type="text" placeholder="Search.." v-model="searchPhrase" id="searchBar">
    <button @click="searchForProgram(searchPhrase)">sök</button>
        <ol id="programList">
            <li v-for="(program, index) in setPrograms"  :key="index" @click="setButtonKey(program.id, program.name)"> 
                         <Card :card="program" :type="'program'"/> 
            </li>
        </ol>
</div>    
</template>

<script>
import Card from "./Card"
export default {
    name: "Programs",

    components: {
        Card
    },
    

    data(){
        return {
            storedPrograms: [],
            currentChannel: '',
            searchProgram: [],
            buttonKey: 0,
            searchPhrase:'',
        }
    },

    computed: {
        setPrograms(){
          var programs = this.$store.getters.getProgram
          
          this.updateChannelName()
          return programs
        }
    },

    methods:{
        updateChannelName(){
            this.currentChannel = this.$store.getters.getChannelName
        },
        setButtonKey(id, name){
            this.$store.commit('addProgramID',id);
            this.$store.commit('setProgramName',name);
            this.$store.dispatch("fetchAllEpisodes")
        },
        searchForProgram(phrase){
            if(phrase.length > 3){
                this.$store.commit('setProgramSearchPhrase',phrase);
                this.$store.dispatch("fetchProgramBySearchPhrase")
            }else{
                alert("Din sökfras måste vara mer än 3 bokstäver långt")
            }

            var f = document.getElementById("category_drop");
            f.selectedIndex = 0;

            f = document.getElementById("channels_drop");
            f.selectedIndex = 0;
        }
    }
}
</script>

<style scoped>
    #programList{
        display: block;
        margin-left: -40px;

        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #programList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #programList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #programList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }

  button{
    height: 3vh;
    width: 5.5vh;
    border: none;
    outline: none;
    background-color: rgba(80, 75, 85, .3);
    color: rgba(230, 230, 255, .6);
    box-shadow: 2px 2px 1px rgba(0, 0, 0, .2), inset 2px 2px 2px rgba(255, 255, 255, .05);
    margin: 3px;
    text-shadow: -1px -1px 2px rgba(0, 0, 0, .3), 1px 1px 2px rgba(126, 126, 126, .5);
  }

  button:hover{
    background-color: rgba(80, 75, 85, .8);
  }
  
  button:active{
    color: rgba(230, 230, 255, .8);
    border: none;
    background-color: rgba(80, 75, 85, .1);
    box-shadow: inset -2px -2px 2px rgba(220, 180, 255, .1), inset 2px 2px 2px rgba(0, 0, 0, .2);
  }

  #searchBar{
    background: black;
    outline: none;
    border: solid 1px rgba(230, 230, 255, .6);
    color: blanchedalmond;
    height: 25px;
    font-size: 16px;
    font-weight: bold;
    margin: 2px;
    box-shadow: 3px 3px 4px rgba(0, 0, 0, .3);
    max-width: 75%;
  }
</style>