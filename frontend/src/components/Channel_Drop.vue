<template>
    <select name="channels" id="channels_drop">
        <option value="" selected disabled hidden>Channels</option>
        <option v-for="(channel, index) in getChannel" :key="index"> 
            {{channel.name}}
        </option>
    </select> 
</template>

<script>
export default {
    name: "Channels",

    computed: {
        getChannel(){
            return this.$store.getters.getChannel
        },
    },

    mounted(){
        this.$store.dispatch("fetchChannels")
    },
}
</script>
