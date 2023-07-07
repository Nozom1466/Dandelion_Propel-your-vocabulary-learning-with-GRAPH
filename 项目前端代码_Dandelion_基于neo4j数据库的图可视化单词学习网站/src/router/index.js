import { createRouter, createWebHistory } from "vue-router";
import Index from "@/views/index.vue";
import Login from "@/views/login.vue";
import Main from "@/views/main.vue";
import Mapper from "@/views/mapper.vue";
import SearchResult from "@/views/searchResult.vue";
import register from "@/views/register.vue";
import manager from "@/views/manager.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "Index",
      component: Index,
    },
    {
      path: "/login",
      name: "Login",
      component: Login,
    },
    {
      path: "/main",
      name: "Main",
      component: Main,
    },
    {
      path: "/mapper",
      name: "Mapper",
      component: Mapper,
    },
    {
      path: "/search_result",
      name: "searchResult",
      component: SearchResult,
    },
    {
      path: "/register",
      name: "register",
      component: register,
    },
    {
      path: "/manager",
      name: "manager",
      component: manager,
    },
  ],
});

export default router;
