
import Vue from 'vue'
import VueRouter from 'vue-router'


import Movies from '@/components/Movies'
import Actors from '@/components/Actors'
import Company from '@/components/Company'
//import Findfamily from '@/components/Findfamily'
//import Findname from '@/components/Findname'
import Findactors from '@/components/Findactors'
import Findcompany from '@/components/Findcompany'
import Context from '@/components/Context'
import moviedetial from '@/components/moviedetial'
import campanydetail from '@/components/campanydetail'
import actordetail from '@/components/actordetail'
//import Findname2 from '@/components/Findname2'
import store from '@/store/index.js'
import Login from '@/components/Login'
import managermovie from '@/components/managermovie'
import managecate from '@/components/managecate'
import managecampany from '@/components/managecampany'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '电影资讯',
    component: Context,
    redirect: '/Movies',
    children: [
      {
        path: '/Movies',
        name: '热门电影总览',
        component: Movies,
        children: [

        ]
      },
      {
        path: '/moviedetail',
        name: '影片详情',
        component: moviedetial
      }/*,
      {
        path: '/Findname2',
        name: '影片详情2',
        component: Findname2
      }*/
    ]
  },
  {
    path: '/',
    name: '职员资讯',
    component: Context,
    redirect: '/Actors',
    children: [
      {
        path: '/Actors',
        name: '人员总览',
        component: Actors,
        children: []
      },
      {
        path: '/actordetail',
        name: '职员详情',
        component: actordetail
      },
      {
        path: '/Findactors',
        name: '人员检索',
        component: Findactors
      },
    ]
  },
  {
    path: '/',
    name: '电影公司资讯',
    component: Context,
    redirect: '/Company',
    children: [
      {
        path: '/Company',
        name: '电影公司总览',
        component: Company,
        children: []
      },
      {
        path: '/campanydetail',
        name: '出品公司详情',
        component: campanydetail

      },
      {
        path: '/FindCompany',
        name: '电影公司检索',
        component: Findcompany
      },
    ]
  },
  {
    path: '/',
    name: '管理员',
    component: Context,
    redirect: '/Login',
    children: [
      {
        path: '/Login',
        name: '管理登录',
        component: Login,
        children: [

        ]
      },
      {
        path: '/managermovie',
        name: '电影管理',
        component: managermovie
      },
      {
        path: '/managecate',
        name: '类别管理',
        component: managecate
      },
      {
        path: '/managecampany',
        name: '公司管理',
        component: managecampany
      },
    ]
  },
]

const router = new VueRouter({
 // mode: 'history',
 mode:'hash',
  base: process.env.BASE_URL,
  routes

})


const whiteList = ['/Movies', '/campanydetail', '/moviedetail', '/actordetail', '/Findactors', '/FindCompany', '/Login', '/Actors', '/Company'] // 不需要重定向的页
router.beforeEach((to, from, next) => {
  // to 即将要进入路由的对象
  // from 要离开的路由对象
  // 调用 next() 方法，进入下一个路由
  let token = ''
  let manager = ''
  try {
    let userInfo = JSON.parse(sessionStorage.userInfo) // 将 sessionStorage 字符串解析为对象
    // 防止刷新页面 vuex 中的用户信息清除，将 sessionStorage 中的用户信息再存储到 vuex 中
    store.dispatch('setUserInfo', userInfo)
    token = userInfo.token
    manager = userInfo.manager
    console.log(token);
    console.log(manager);    
  } catch (error) {
    token = ''
  }
  if (token) {
    if(manager){
      next();
      
    }
  } else {
    // 没有 token
    if (whiteList.indexOf(to.path) !== -1) {
      // 在不需要重定向的页面直接登录
      next()
    } else if (to.path === '/managermovie'||to.path === '/managecate'||to.path==='/managecampany') {
      next('/Login');
    }
    else {
      // 其他没有访问权限的页面被重定向到登录页
      next('/login?redirect=${to.path}')
    }
  }
})

export default router