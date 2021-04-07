import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../views/Home.vue";
import Channels from "../views/Channels.vue"
import Favorites from "../views/Favorites.vue";
import Login from "../views/Login.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/channels",
    name: "Channels",
    component: Channels
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
  
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
