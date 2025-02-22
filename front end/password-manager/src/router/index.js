import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginPage from '../views/LoginPage.vue'
import HomePage from '../views/HomePage.vue'


Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      name: 'login',
      path: "/",
      component: LoginPage 
    },
  
    {
      name: 'home',
      path: "/home",
      component: HomePage,
      meta: {requiresAuth: true}
    }
  
  ]
})

router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem("token") !== null;

  if (to.name !== 'login' && !isAuthenticated) {
    next("/");
  } else {
    next();
  }
});


export default router
