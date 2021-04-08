import { createStore} from "vuex";
import axios from 'axios';

export default createStore({
  name: 'store',

  state: {
    program: [],
    category:[],
  },

  mutations: {
    setProgram(state, payload){
      state.program = payload;
    },
    setAllCategories(state, payload){
      state.category=payload;
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

    getAllCategories(state){
      return state.category
    },
  },

  modules: {

  },

});
