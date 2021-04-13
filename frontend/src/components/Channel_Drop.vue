<template>
    <select name="channels" id="channels_drop" @change="saveChannel(true)">
        <option value="" selected disabled hidden>Channels</option>
        <option  v-for="(channel, index) in getChannel" :key="index"  :value="channel.id" > 
                {{channel.name}}
        </option>
    </select> 
</template>

<script>
export default {
    name: "Channels",

    data(){
    },

    computed: {
        getChannel(){
            return this.$store.getters.getChannel
        },
    },
 methods:{
       
     
      saveChannel(boolean){
          var e = document.getElementById("channels_drop");
          var strUser = e.options[e.selectedIndex].value;
          this.$store.commit('setBoolean',boolean);
            this.$store.commit('addChannelID',strUser);
            this.$store.dispatch("fetchEpisodesByChannel"),
            this.$store.dispatch("fetchProgram"),
            this.$store.commit('setChannelName', e.options[e.selectedIndex].text)
      }
    },

   async mounted(){
        this.$store.dispatch("fetchChannels")
    },
}
</script>
