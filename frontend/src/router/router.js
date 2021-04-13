import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../views/Home.vue";

import Favorites from "../views/Favorites.vue";
import Friends from "../views/Friends.vue"
import Login from "../views/Login.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
 
  {
    path: "/favorites",
    name: "Favorites",
    component: Favorites
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/friends",
    name: "Friends",
    component: Friends
  },
  
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
