import { createStore} from "vuex";
import axios from 'axios';

export default createStore({
  name: 'store',

  state: {
    program: [],
    channel: [],
    
  },

  mutations: {
    setProgram(state, payload){
      state.program = payload;
    },
    setChannel(state, payload){
      state.channel = payload;
    },

    
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
    
  },

  getters: {
    getProgram(state){
      return state.program
    },
    getChannel(state){
      return state.channel
    },

  },

  modules: {

  },

});
