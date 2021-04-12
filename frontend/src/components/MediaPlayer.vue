<template>
    <div class="Player">
        <audio autoplay src=""
        type="audio/mpeg"
        controls
        id="media">
        I'm sorry. You're browser doesn't support HTML5 <code>audio</code>.
        </audio>
    </div>
</template>

<script>
export default {
    data(){
        return{
            audioFile: ''
        }
    },

        methods:{
            updateAudioFile(){
                this.audioFile = this.$store.getters.getCurrentAudioFile
                console.log(this.audioFile)
            }
        }
    }
</script>

<style>
    .Player{
        background-color: rgba(60, 55, 65, .2);
        box-shadow: 0 6px 3px rgba(0, 0, 0, .6), inset 0 4px 6px rgba(240, 200, 255, .025);
        position: relative;
        bottom: 0;
        width: 100%;
        height: 3.5rem;
        margin-top: .5rem;
    }

    #media{
        margin-top: 5px;
        height: 80%;
        outline: none;
    }
</style>