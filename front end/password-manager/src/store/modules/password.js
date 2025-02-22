const state = {
    isLoggedIn: false
};
  
const mutations = {
    login: state =>{
        state.isLoggedIn = true
    },
    logout: state =>{
        state.isLoggedIn = false
    },

};
    
const actions = {
    authenticateLogin({commit}, password){
        //insert api call here and get the token
        if (password === "xd"){
            localStorage.setItem('token', "XD")
            commit('login')
            
        }
    }
};
  
const getters = {
    
};
  
export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
};