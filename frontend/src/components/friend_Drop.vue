<template>
    <select name="channels" id="friend_drop" @change="addFriend()">
        <option value="" selected disabled hidden>Users</option>
        <option  v-for="(user, index) in getUsers" :key="index"  :value="user.id" > 
                {{user.username}}
        </option>
    </select> 
</template>

<script>
export default {
    name: "FriendDrop",

    computed: {
        getUsers(){
            return this.$store.getters.getAllUsers
        },
    },

 methods:{
     async addFriend() {
            var thisUser = await this.$store.getters.getLoginUserId
            var e = document.getElementById("friend_drop");
            var strUser = parseInt(e.options[e.selectedIndex].value);

            let credentials = {
            "user_id": thisUser,
            "friends_id": strUser
            } 

            console.log(credentials)
            
            let response = await fetch ('/rest/friends', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json'},
                body: JSON.stringify(credentials)
            })
            if(response.url.includes('error')){
                console.log('Something went wrong. Try again')
            } else {
                alert ('New friend added')
            }
        },
    },

   async mounted(){
        this.$store.dispatch("fetchAllUsers")
    },
}
</script>
