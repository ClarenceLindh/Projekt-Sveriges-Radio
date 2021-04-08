import { createStore} from "vuex";
import axios from 'axios';

export default createStore({
  name: 'store',

  state: {
    program: [],
    
  },

  mutations: {
    setProgram(state, payload){
      state.program = payload;
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
    
  },

  getters: {
    getProgram(state){
      return state.program
    },

  },

  modules: {

  },

});
