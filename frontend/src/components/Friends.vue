<template>
    <div >
        <h1>Vänner</h1>
        <div id="doppers">
            <FriendDrop/>
        </div>
        
        <ol id="friendList">
        <li v-for="(friend, index) in getNewFriends" :key="index"> 
            <Card :card="friend"  :type="'friend'"/>
        </li>
        </ol>
    </div>
</template>

<script>
import Card from "./Card"
import FriendDrop from '../components/friend_Drop.vue'
export default {
    name: "Friends",

    components:{
        FriendDrop,
        Card
    },

    computed: {
        getNewFriends(){
            return this.$store.getters.getNewFriends
        },
        userId(){
            return this.$store.getters.getLoginUserId
        }
    },

    mounted(){   
        this.$store.dispatch("findMyFriends")
    },
}
</script>

<style scoped>
#friendList{
        display: block;
        margin-left: -40px;

        list-style-type: none;

        overflow: auto;
        max-height: 67vh;
    }

    #friendList::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: rgba(60, 55, 65, .3);
    }

    #friendList::-webkit-scrollbar{
        width: 12px;
        background-color: rgba(0, 0, 0, 0);
    }

    #friendList::-webkit-scrollbar-thumb{
        border-radius: 10px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color:rgba(80, 75, 85, .5);
    }

select{
    background: black;
    outline: none;
    border: solid 1px rgba(230, 230, 255, .6);
    color: blanchedalmond;
    height: 25px;
    font-size: 16px;
    font-weight: bold;
    margin: 2px;
    width: 80%;
    box-shadow: 3px 3px 4px rgba(0, 0, 0, .3);
}

</style>