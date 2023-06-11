import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: '首页',
    component: () => import('../views/layout'),
    redirect:'/shouye',
    children:[
      {
        path: '/shouye',
        name: '首页',
        component: () => import('../views/shouye/index')
      },
      {
        path: '/user',
        name: '用户管理',
        component: () => import('../views/user/index')
      },
      {
        path: '/order',
        name: '订单管理',
        component: () => import('../views/order/index')
      },
      {
        path: '/product',
        name: '房源管理',
        component: () => import('../views/product/index')
      },
      {
        path: '/shoucang',
        name: '收藏管理',
        component: () => import('../views/shoucang/index')
      },

      
      {
        path: '/modifyPassword',
        name: '修改密码',
        component: () => import('../views/modifyPassword/index')
      }
    ]
  },

  {
    path: '/login',
    name: 'login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/login')
  }


]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
