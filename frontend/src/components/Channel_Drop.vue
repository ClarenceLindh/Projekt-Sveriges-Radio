<template>
    <select name="channels" id="channels_drop" @change="saveChannel()">
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
       
       addIdToStore(id){
           
            this.$store.commit('addChannelID',id);
            console.log(id)
        },

      saveChannel(){
          var e = document.getElementById("channels_drop");
          var strUser = e.options[e.selectedIndex].value;
            this.$store.commit('addChannelID',strUser);
            this.$store.dispatch("fetchProgram")
      }
    },

   async mounted(){
        this.$store.dispatch("fetchChannels")
    },
}
</script>
