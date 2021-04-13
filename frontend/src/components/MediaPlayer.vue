<template>
    <div class="Player">
        <audio autoplay src=""
        type="audio/mpeg"
        id="media"
        controls>
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
        background-color: rgba(30, 25, 35, 1);
        box-shadow: 0 6px 3px rgba(0, 0, 0, .6), inset 0 4px 6px rgba(240, 200, 255, .025);
        position: fixed;
        bottom: 0;
        width: 100%;
        height: 6vh;
        z-index: 99;
    }

    #media{
        margin-top: 0.75vh;
        height: 80%;
        outline: none;
        width: 98vw;
    }
</style>