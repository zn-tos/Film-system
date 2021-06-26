import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: {}, // 登录成功后的用户信息
  },
  mutations: {
    // 用户注销
    loginOut(state) {
      state.userInfo = {}
      sessionStorage.removeItem("userInfo");
    },
    // 用户登录
    setUserInfo(state, data) {
      state.userInfo = data
      // 将登录的用户信息存储一份到 sessionStorage，防止刷新页面 vuex 中的用户信息清除，sessionStorage 不能存储对象，转为字符串存储
      sessionStorage.userInfo = JSON.stringify(data)
    },
  },
  actions: {
    // 用户注销
    loginOut(ctx) {
      ctx.commit('loginOut')
    },
    // 用户登录
    setUserInfo(ctx, data) {
      ctx.commit('setUserInfo', data)
    },
  },
  modules: {}
})
