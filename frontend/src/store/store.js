import { createStore} from "vuex";
import axios from 'axios';






export default createStore({
  name: 'store',

  state: {
    program: [],
    programId: 0,
    programName: '',
    category:[],
    categoryId: 0,
    categoryName: '',
    loggedInUser: null,
    isLoggedIn: "Login",
    channel:[],
    episodes:[],
    friends:[],
    favorites:[],
    channelId: 0,
    channelName: '',
    programSearchPhrase: '',
    currentAudioFileURL: 'http://sverigesradio.se/topsy/ljudfil/srapi/4119397.mp3'
  },

  mutations: {
    addChannelID(state,payload){
      state.channelId = payload;
    },
    
    addProgramID(state, payload) {
      state.programId = payload;
    },
  
    setProgram(state, payload){
      state.program = payload;
    },

    setProgramName(state, payload){
      state.programName = payload;
    },

    setProgramSearchPhrase(state, payload) {
      state.programSearchPhrase = payload;
    },

    setAllCategories(state, payload){
      state.category = payload;
    },
    setCategoryId(state, payload) {
      state.categoryId = payload;
    },
    setCategoryName(state, payload) {
      state.categoryName = payload;
    },
    setAllEpisodes(state, payload){
      state.episodes = payload;
    },
    
    setLoggedInUser(state, user) {
      state.loggedInUser = user
    },

    setFriends(state,payload){
      state.Friends = payload;
    },

    setFavorites(state,payload){
      state.favorites = payload;
    },
    
    setChannelName(state,payload) {
      state.channelName = payload
    },

    setChannel(state,payload){
      state.channel = payload;
    },
    
    setNewAudioFile(state, payload) {
      state.currentAudioFileURL = payload;
    },

    setUser(state, payload) {
      state.loggedInUser = payload;
    }
  },

  //http://localhost:3000/rest/programs/channel/163 

  actions: {
    async fetchProgram(){
      await axios.get("http://localhost:3000/rest/programs/channel/" + this.state.channelId)
      .then(response => {
        this.commit("setProgram", response.data)
        console.log(response.data)
      })
    },

    async fetchUser(){
      await axios.get("http://localhost:3000/auth/whoami")
      .then(response => {
        this.commit("setUser", response.data)
        if(response != null)
          console.log(response.data)
      })
    },

    async fetchProgramByCategory(){
      await axios.get("http://localhost:3000/rest/programsByCategoryId/" + this.state.categoryId)
      .then(response => {
        this.commit("setProgram", response.data)
        console.log(response.data)
      })
    },

    async fetchChannels(){
      await axios.get("http://localhost:3000/rest/channels")
      .then(response => {
        this.commit("setChannel", response.data)
        console.log(response.data)
      })
    },
    
    async fetchAllCategories(){
      await axios.get("http://localhost:3000/rest/categories")
      .then(response => {
        this.commit("setAllCategories", response.data)
        console.log(response.data)
      })
    },

    async fetchAllFavorites(){
      await axios.get("http://localhost:3000/rest/favorites/"+ this.state.loggedInUser)
      .then(response => {
        this.commit("setFavorites", response.data)
        console.log(response.data)
      })
    },


    async fetchAllEpisodes(){
      await axios.get("http://localhost:3000/rest/episodes/" + this.state.programId)
      .then(response => {
        this.commit("setAllEpisodes", response.data)
        console.log(response.data)
      })
    },

    async fetchAllFriends(){
      await axios.get("http://localhost:3000/rest/friends/" + this.state.loggedInUser)
      .then(response => {
        this.commit("setAllFriends", response.data)
        console.log(response.data)
      })
    },
    async fetchLoggedInUser(){
      await axios.get("http://localhost:3000/auth/whoami" + this.state.loggedInUser)
      .then(response => {
        this.commit("setLoggedInUser", response.data)
        console.log(response.data)
      })
    },
    async fetchProgramBySearchPhrase(){
      await axios.get("http://localhost:3000/rest/programs/search/" + this.state.programSearchPhrase)
      .then(response => {
        this.commit("setProgram", response.data)
        console.log(response.data)
      })
    }

  },

  getters: {
    getProgram(state){
      return state.program
    },

    getProgramName(state){
      return state.programName
    },

    getSearchPhrase(state) {
      return state.programSearchPhrase
    },
    
    getChannel(state){
      return state.channel
    },

    getAllCategories(state){
      return state.category
    },
    
    getAllEpisodes(state){
      console.log(state.episodes)
    return state.episodes
    },
    
    getChannelId(state) {
      return state.channelId
    },

    getChannelName(state) {
      return state.channelName
    },
    
    getCategoryId(state) {
      return state.categoryId
    },

    getProgramId(state) {
      return state.programId
    },
    getAllFriends(state){
      return state.friends
    },

    getAllFavorites(state){
      return state.favorites
    },

    getCurrentAudioFile(state) {
      return state.currentAudioFileURL
    },

    getCurrentUser(state) {
      return state.loggedInUser
    },

    getLoginStatus(state) {
      console.log(state.isLoggedIn)
      return state.isLoggedIn
    }
},

  modules: {

  },

});
