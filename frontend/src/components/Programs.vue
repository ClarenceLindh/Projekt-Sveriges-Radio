<template>
<div class="programs">
    <h1>Programs</h1>
    <input class="searchbar" type="text" placeholder="Search..">
    <h3> Program searched for: <br> {{ searchProgram }}</h3>
    
    <ol>
        <li v-for="(program, index) in getProgram" :key="index"> 
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
            searchPhrase:'sporten p4',
            searchProgram: {}
        }
    },

    computed: {
        getProgram(){
            return this.$store.getters.getProgram
        },
    },

    async mounted(){
        this.$store.dispatch("fetchProgram")

        console.log(this.$route.params.searchPhrase)
        this.id = this.$route.params.searchPhrase
        let searchProgram = await fetch('/rest/programs/search/' + this.searchPhrase)
        this.searchProgram = await searchProgram.json()
        console.log(this.searchProgram)
    },
}
</script>

<style>

</style>