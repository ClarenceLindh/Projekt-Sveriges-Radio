<template>
    <select name="channels" id="channels_drop">
        <option value="" selected disabled hidden>Channels</option>
        <option v-for="(channel, index) in getChannel" :key="index"   > 
           {{channel.name}} {{channel.id}}
        </option>
         <!--  -->
    </select> 
</template>

<script>
export default {
    name: "Channels",
data(){
    id:''
}

    computed: {
        getChannel(){
            return this.$store.getters.getChannel
        },
    },
 methods:{
       
       addIdToStore(id){
           
            this.$store.commit('addChannelID',id);
            console.log(id)
        }
 },
   async mounted(){
        this.$store.dispatch("fetchChannels"),

        
      
    },
}
</script>
