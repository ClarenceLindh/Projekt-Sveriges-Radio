<template>
<div class="programs">
    <h1>Programs</h1>
    <input class="searchbar" type="text" placeholder="Search.." v-model="searchPhrase">
    <button @click="searchForProgram(searchPhrase)">sök</button>
   
        <ol id="programList">
            <li v-for="(program, index) in setPrograms"  :key="index" @click="setButtonKey(program.id, program.name)"> 
                         <Card :card="program"  :type="'program'"/>  
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
            searchPhrase:'',
            buttonKey: 0,
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
        },
        AddToProgramList(id, name){
            this.$store.commit('addProgramID',id);
            this.$store.commit('setProgramName',name);
            
        }
    }
}
</script>

<style>
    #programList{
        display: block;
        margin-right: 32px;
        list-style-type: none;
    }

    .progButton{
        background-color: rgba(0, 0, 0, 0.2);
        color: whitesmoke;
        border: none;
        box-shadow: -2px -2px 2px rgba(255, 255, 255, 0.1), 2px 2px 2px rgba(0, 0, 0, 0.3);
        height: 4vh;
        width: 15vw;
        margin-top: 8px;
        margin-bottom: 8px;
    }
</style>