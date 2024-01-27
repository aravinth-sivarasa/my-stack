import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: "/vue/login"
  },
  {
    path:"/vue",
    children:[
      {path:"login",component: () => import(/* webpackChunkName: "login-page" */"@/views/LoginPage.vue")}
    ]
  },
  {
    path:"/page-one",
    children:[
      {path:"", component: () => import(/* webpackChunkName: "page-one" */"@/components/PageOne.vue")},
      {path:"page-two", component: () => import(/* webpackChunkName: "page-two" */"@/components/PageTwo.vue")}
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: "/:catchAll(.*)",
    component: () => import(/* webpackChunkName: "page-not-found" */ '../views/PageNotFound.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
