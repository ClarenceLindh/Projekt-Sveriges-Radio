<template>
  <div >
<h1>Episodes</h1>


<h3 style="color:red">Alla episodes från programid 4821</h3>
 <ol >
        <li v-for="(Episode, index) in getAllEpisodes" :key="index"> 
            {{Episode.title}} |  Sändningstid: {{Episode.Airtime}}
        </li>
    </ol>

  </div>
</template>

<script>
export default {
    name: "Episodes",

    computed: {
        getAllEpisodes(){
            return this.$store.getters.getAllEpisodes
        },
    },

    mounted(){
        this.$store.dispatch("fetchAllEpisodes")
    },
}
</script>

<style>

</style>