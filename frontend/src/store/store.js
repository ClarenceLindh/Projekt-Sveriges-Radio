import { createStore} from "vuex";
import axios from 'axios';






export default createStore({
  name: 'store',

  state: {
    program: [],
    category:[],
    loggedInUser: null
  },

  mutations: {
    setProgram(state, payload){
      state.program = payload;
    },
    setAllCategories(state, payload){
      state.category=payload;
    },
    setChannel(state, payload){
      state.channel=payload;
    },
    setLoggedInUser(state, user) {
      state.loggedInUser = user
    }

    
  },

  actions: {
    async fetchProgram(){
      await axios.get("http://localhost:3000/rest/programs")
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

  },

  getters: {
    getProgram(state){
      return state.program
    },
    getChannel(state){
      return state.channel
    },

    getAllCategories(state){
      return state.category
    },
  },

  modules: {

  },

});
