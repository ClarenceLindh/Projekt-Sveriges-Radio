<template>
<div class="programs">
    <h1>Programs</h1>
    <input class="searchbar" type="text" placeholder="Search..">
    <h3> Program searched for: <br> {{ searchProgram }}</h3>

    <h3 style="color:red">Program baserat på channel P2</h3>
        <ol>
            <li v-for="(program, index) in setPrograms" :key="index">
                {{program.name}} - {{program.description}}
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
            searchPhrase:'sporten p4',
            searchProgram: {},
            componentKey: 0
        }
    },

    computed: {
        setPrograms(){
          console.log("Retrieving new programs")
          var programs = this.$store.getters.getProgram
          
          return programs
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

</style>