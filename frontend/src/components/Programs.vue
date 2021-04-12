<template>
<div class="programs">
    <h1>Programs</h1>
    <input class="searchbar" type="text" placeholder="Search..">
    <h3> Program searched for: <br> {{ searchProgram }}</h3>

    <h3 style="color:red" v-if="currentChannel">Program baserat på {{currentChannel}}</h3>
        <ol id="programList">
            <li v-for="(program, index) in setPrograms" :key="index">
                <div>
                    <button @click="setButtonKey(program.id, program.name)" class="progButton" :value="program.id">{{program.name}}</button>
                </div>
                {{program.description}} - {{program.id}}
                <br>
                <br>
            </li>
        </ol>
</div>    
</template>

<script>
export default {
    name: "Programs",

    data(){
        return {
            storedPrograms: [],
            currentChannel: '',
            searchPhrase:'sporten p4',
            searchProgram: [],
            buttonKey: 0
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
        }
    },

    async mounted(){
        this.$store.dispatch("fetchProgram")

        // console.log(this.$route.params.searchPhrase )
        // this.id = this.$route.params.searchPhrase
        let searchProgram = await fetch('/rest/programs/search/' + this.searchPhrase)
        this.searchProgram = await searchProgram.json()
        console.log(this.searchProgram)
    },
}
</script>

<style>
    #programList{
        display: block;
        list-style-type: none;
        background-color: rgba(0, 0, 0, 0.2);
        margin-bottom: 0;
        box-shadow: 0 -3px 1px rgba(0, 0, 0, 0.3);
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