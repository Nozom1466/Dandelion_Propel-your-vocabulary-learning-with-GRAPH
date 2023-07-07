import { createStore } from "vuex";

export default createStore({
  state() {
    return {
      permission: sessionStorage.getItem('permission') || null,
    };
  },
  getters: {
    getData(state) {
      return state.permission;
    },
  },
  mutations: {
    setData(state, payload) {
      // 更新数据的 mutation
      state.permission = payload;

      // 将 permission 值存储到 sessionStorage
      sessionStorage.setItem('permission', payload);
    },
  },
  actions: {},
  modules: {},
});
