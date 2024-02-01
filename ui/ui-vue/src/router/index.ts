import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: "/vue/login"
  },
  {
    path:"/vue",
    children:[
      {path:"login",component: () => import(/* webpackChunkName: "login-page" */"@/views/LoginPage.vue")},
      {path:"dashboard",redirect:"/vue/home/dashboard"},
      {
        path:"home",
        component: () => import(/* webpackChunkName: "dashboard-view" */"@/views/HomeView.vue"),
        children:[
          {path:"invoices",component: () => import(/* webpackChunkName: "invoice-view" */"@/views/InvoiceView.vue")},
          {path:"dashboard",component: () => import(/* webpackChunkName: "dashboard-view" */"@/views/DashboardView.vue")},
        ]}
    ]
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
