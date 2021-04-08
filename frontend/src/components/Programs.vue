<template>
<div class="programs">
    <h1>Programs</h1>
    
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

    computed: {
        getProgram(){
            return this.$store.getters.getProgram
        },
    },

    mounted(){
        this.$store.dispatch("fetchProgram")
    },
}
</script>

<style>

</style>