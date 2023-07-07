<template>
  <header class="header">
    <router-link :to="{ path: '/' }">
      <img
        class="logo"
        alt="GraphVocab logo"
        src="/static/img/Graph_Vocab.png"
      />
    </router-link>

    <nav class="main-nav">
      <ul class="main-nav-list">
        <li class="search-box">
          <input
            class="search-txt"
            type="txt"
            name=""
            placeholder="look up dictionary"
            @keyup.enter="nav2others"
            v-model="searchText"
          />
          <a class="search-btn">
            <i class="icon iconfont icon-search search-icon"></i>
          </a>
        </li>
        <li v-if="isadmin">
          <router-link :to="{ path: '/manager' }" class="main-nav-link">
            Data Manager
          </router-link>
        </li>
        <li>
          <a class="main-nav-link" href="https://neo4j.com/">Learn neo4j</a>
        </li>
        <li>
          <a class="main-nav-link" href="https://vuejs.org/">Learn Vue</a>
        </li>
        <li>
          <router-link :to="{ path: '/login' }" class="main-nav-link nav-cta">{{
            !login ? "LOG IN" : "LOG OUT"
          }}</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>

<script>
import { useStore } from "vuex";

export default {
  name: "nava",
  props: {},
  data() {
    return {
      searchText: "",
      login: localStorage.getItem("token"),
      isadmin: useStore().getters.getData == 4,
    };
  },
  mounted() {},
  methods: {
    nav2others() {
      this.$router.push({
        path: "/search_result",
        query: {
          ok: true,
          data: this.searchText,
        },
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
*:focus {
  outline: none;

  box-shadow: 0 0 0 8px rgba(34, 230, 93, 0.5);
}

.heading-primary {
  font-size: 52px;
  line-height: 1.2;
  margin-bottom: 32px;
}

.heading-primary .highlighted {
  color: #339a46;
}

.grid--2-cols {
  grid-template-columns: repeat(2, 1fr);
}

.grid--5-cols {
  grid-template-columns: 2fr repeat(3, 1fr) 2fr;
}

.grid--5-rows {
  grid-template-rows: repeat(2, 1fr);
}

.margin-right-sm {
  margin-right: 16px !important;
}

/**************************/
/* HEADER */
/**************************/

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ecf9ee;

  height: 96px;
  padding: 0 48px;
  position: relative;
}

.logo {
  height: 150px;
}
.main-nav-list {
  list-style: none;
  display: flex;
  align-items: center;
  gap: 48px;
}

.main-nav-link:link,
.main-nav-link:visited {
  display: inline-block;
  text-decoration: none;
  color: #333;
  font-weight: 500;
  font-size: 18px;
  transition: all 0.3s;
}

.main-nav-link:hover,
.main-nav-link:active {
  color: #40c057;
}

.main-nav-link.nav-cta:link,
.main-nav-link.nav-cta:visited {
  padding: 12px 24px;
  border-radius: 9px;
  color: #fff;
  background-color: #40c057;
}

.main-nav-link.nav-cta:hover,
.main-nav-link.nav-cta:active {
  background-color: #339a46;
}

/*
      SEARCH IT   
*/

.search-box {
  padding: 6px;
  border-radius: 40px;
  background-color: #40c057;
  display: flex;
}

.search-icon {
  font-size: 20px;
}

.search-btn {
  display: inline-block;
  padding: 4px;
  background-color: #40c057;
  color: #fff;
  border-radius: 50px;
  cursor: pointer;
  transition: 0.4s;
}

.search-txt {
  border: none;
  background: none;
  outline: none;
  font-size: 16px;
  font-family: inherit;
  color: #fff;
  line-height: 1;
  width: 0;

  transition: 0.4s;
}

.search-txt::placeholder {
  color: #ebfbee;
}

.search-box:hover > .search-txt {
  width: 240px;
  padding: 0 12px;
}

.search-box:hover > .search-btn {
  background-color: white;
  color: #40c057;
}

.search-box:hover > .search-txt:focus {
  box-shadow: 0 0 8px rgba(34, 230, 93, 0.5);
}
</style>
