<template>
  <!DOCTYPE html>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
      <link
        rel="stylesheet"
        type="text/css"
        href="static/lib/interactive-graph-0.1.0/interactive-graph.min.css"
      />
      <link
        rel="stylesheet"
        type="text/css"
        href="static/lib/jquery-3.2.1/jquery-ui.css"
      />
      <link
        type="text/css"
        href="static/lib/font-awesome-4.7.0/css/font-awesome.min.css"
        rel="stylesheet"
      />
      <!-- <link href="../assets/css/test.css" /> -->
      <title>Mapping</title>
    </head>
    <body>
      <div class="shift-mode">
        <label class="search-label" for="searchID">EXPLORE FROM HERE:</label>
        <input
          id="searchID"
          type="txt"
          name=""
          placeholder="Enter Where To Start"
          @keyup.enter="startExpMode"
          v-model="startExplore"
        />
      </div>
      <div class="map-container">
        <div class="sidebar">
          <ul class="meal-list">
            <li
              class="mj-meal aos-init meal-active meal-st"
              data-aos="zoom-in-up"
              ref="item"
              @click="change(`meal-st`)"
            >
              <div class="mj-meal-slider-wrapper">
                <img
                  class="mj-meal-slider-img"
                  src="static/img/Zermatt.png"
                  alt="Ketogenic Diet Plan"
                  decoding="async"
                  loading="lazy"
                  sizes="(max-width: 600px) 1vw, 60px"
                />
                <div class="mj-meal-slider-content">
                  <h2>Word List Overview</h2>
                  <p>DO YOUR BEST!!!</p>
                </div>
              </div>
            </li>
            <li
              v-for="n in units"
              :key="n"
              :class="[
                'mj-meal',
                'aos-init',
                'meal-' + String(n + 1),
                // n == 0 ? 'meal-active' : '',
              ]"
              data-aos="zoom-in-up"
              @click="change(`meal-${n + 1}`)"
              ref="item"
            >
              <div class="mj-meal-slider-wrapper">
                <img
                  class="mj-meal-slider-img"
                  src="static/img/Zermatt.png"
                  decoding="async"
                  loading="lazy"
                  sizes="(max-width: 600px) 100vw, 600px"
                />

                <div class="mj-meal-slider-content">
                  <h2>Word List {{ n }}</h2>
                  <p>DO YOUR BEST!!!</p>
                </div>
              </div>
            </li>

          </ul>
        </div>
        <div id="allmap">
          <div id="graphArea"></div>
        </div>
      </div>
    </body>

  </html>

  <!-- <script type="text/javascript"></script> -->
</template>

<script lang="js">
import {reactive, toRefs, vShow} from "vue";
import "../assets/lib/jquery-3.2.1/jquery-3.2.1.min.js";
import "../assets/lib/jquery-3.2.1/jquery-ui.js";
import "../assets/lib/interactive-graph-0.1.0/interactive-graph.min.js"


export default {
  name: "Mapper",
  data() {
    return {
      tot_word_num : 3000,
      per_page: 300,
      word_list:  ["qqq.json","test.json","qqq.json"],
      appli:  null,
      startExplore: "",
      units: 10,
      graphMode: 0
    }
  },
  beforeCreate() {
    const Vtoken = localStorage.getItem('token');
    if (Vtoken) {
        fetch("http://139.196.197.42:8085/interceptor", {
              'headers': {
                  'token': Vtoken
              }
        }).then(response => response.json())
              .then(data => {
                  if (data.code == 0)
                    this.$router.push({path: "/login"})
              }).catch(error => console.log(error));
    }
    else {
      this.$router.push({path: "/login"})
    }
  },
  mounted() {
    this.units = this.tot_word_num / this.per_page
    igraph.i18n.setLanguage("chs");
    var app = new igraph.GraphNavigator(
      document.getElementById("graphArea"),
      {
        canvasBackground: "#ecf9ee",
        nodes: {
          color: "#40c057"
        },
        edges: {
          color: "#fff",
          width: 1
        },
       groups: {
           useSeqColors: false,
           custom: {
               person: {color:'blue'},
               location: {color:'red'},
               event: {color:'green'}
           }
       }
    }
    );

    this.appli=app

    let tot = this.tot_word_num

    app.loadGson("http://139.196.197.42:8085/neo4j?page=1&size=" + String(tot));
    this.hideUseless()

  },
  methods:{
    hideUseless: function() {
      let toolBarPanel = document.querySelector(".toolbarPanel")
      let searchPannel = document.querySelector(".searchPanel")
      let searchPanel_img = document.querySelector(".igraph-searchbox-image")
      let theme_chage = document.querySelectorAll(".ui-tool");
      let navButtons = document.querySelectorAll(".vis-button")
      let searchWordDownSelect = document.querySelector(".label-select")
      let searchPanel = document.querySelector(".searchPanel")

      for (let i = 1; i < theme_chage.length; i++) {
        theme_chage[i].style.display = "none";
      }

      for (let i = 0; i < navButtons.length; i++) {
        navButtons[i].style.fontSize = "15px";
      }

      toolBarPanel.style.borderRadius = "10px";
      toolBarPanel.style.padding = "10px 20px";

      toolBarPanel.style.left = "80%";
      toolBarPanel.style.width = "360px"

      searchWordDownSelect.style.display="none"

      searchPanel.style.height="40px"



      let canva = document.getElementById("graphArea")
      canva.style.height = "100vh"

      searchPannel.style.borderRadius = "10px";
      searchPannel.style.padding = "10px 20px"

      searchPanel_img.style.display = "none";

      let infoPanel=document.querySelector(".infoPanel")
      if(infoPanel!=null){

        infoPanel.style.borderRadius="10px"
      }
    },
    change: function(e){
      // console.log(this.$refs)
      let list_items=document.querySelectorAll(".mj-meal");
      console.log(list_items)
      for (let i =0;i< list_items.length;i++) {
        console.log(list_items[i])
        if(list_items[i].classList.contains("meal-active")){
          list_items[i].classList.remove("meal-active")
          break;
        }
      }
      let selected=document.querySelector('.'+e)
      selected.classList.add('meal-active')
      // e.classList.add("meal-active")
      let index=Number(String(e).slice(String(e).length-1))
      let path = `http://139.196.197.42:8085/neo4j?page=${index + 1}&size=${this.per_page}`
      if (e == 'meal-st') {
        path = `http://139.196.197.42:8085/neo4j?page=1&size=${this.tot_word_num}`
      }
      if (this.graphMode == 1) {
        var app = new igraph.GraphNavigator(
        document.getElementById("graphArea"),
            {
              canvasBackground: "#ecf9ee",
              nodes: {
                color: "#40c057"
              },
              edges: {
                color: "#fff",
                width: 1
              },
            groups: {
                useSeqColors: false,
                custom: {
                    person: {color:'blue'},
                    location: {color:'red'},
                    event: {color:'green'}
                }
            }
          }
        );
        this.appli = app;
        this.hideUseless()
      }

      this.appli.loadGson(path);

    },
    startExpMode() {
      this.graphMode = 1;
      var app = new igraph.GraphExplorer(document.getElementById('graphArea'),{
        canvasBackground: "#ecf9ee",
        nodes: {
          color: "#40c057"
        },
        edges: {
          color: "#fff",
          width: 1
        },
        groups: {
            useSeqColors: false,
            custom: {
                person: {color:'blue'},
                location: {color:'red'},
                event: {color:'green'}
            }
        }
      });

      let starto = this.startExplore
      app.loadGson(`http://139.196.197.42:8085/neo4j?page=1&size=${this.tot_word_num}`, {}, function () {
        app.pickup([{
            label: starto
        }]);
      });
      this.appli = app
      this.hideUseless()
    }
  }
}
</script>

<style scoped lang="css">


* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

html {
  font-size: 62.5%;
  position: relative;
}

body {
  font-family: sans-serif;
  line-height: 1;
  font-weight: 400;
  color: #555;
  height: 100%;
  transition: all 0.3s;
  position: relative;
}

*:focus {
  outline: none;
  /* outline: 4px dotted #40c057; */
  /* outline-offset: 8px; */
  box-shadow: 0 0 0 0.8rem rgba(34, 230, 93, 0.5);
}

.shift-mode {
  position: absolute;
  left: 50%;
  bottom: 20px;
  padding: 10px 20px;
  background-color: #40c057;
  color: #fff;
  /* font-size: large; */
  border-radius: 20px;
  cursor: pointer;
  z-index: 10;
}

.search-label {
  margin-right: 10px;
  font-weight: 700;
  /* letter-spacing: 1.5px; */
}

#searchID {
  padding: 10px 20px;
  font-weight: 700;
  border-radius: 10px;
  border: none;
}

/* ------------map----------------------------------------- */

.anchorBL a,
.anchorBL img {
  display: none;
}

.anchorBL span {
  display: none !important;
}

html,
#allmap {
  /* width: 100%; */
  height: 100vh;
  overflow: hidden;
  margin: 0;
  font-family: "微软雅黑";
}

#graphArea {
  height: 100%;
}

.sidebar {
  background-color: #ecf9ee;
  overflow: scroll;
}

.sidebar::-webkit-scrollbar {
  background-color: #c6eccd;
  width: 1rem;
}

.sidebar::-webkit-scrollbar-track {
  /* box-shadow: inset 0 0 0px #c6eccd; */
  border-radius: 10px;
  background-color: #ecf9ee;
}

.sidebar::-webkit-scrollbar-thumb {
  border-radius: 10px;
  box-shadow: inset 0 0 0px rgba(240, 240, 240, 0.5);
  background-color: #c6eccd;
}

.meal-list {
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.map-container {
  width: 100%;
  height: 100%;
  display: grid;
  grid-template-columns: 2fr 8fr;
}

.section-carosel {
  background-color: #ebfbee;
}

ul.mj-all-meals {
  /* margin: 0 0 1rem; */
  padding: 0;
  list-style: none outside;
  clear: both;
  display: grid;
  column-gap: 5rem;
  row-gap: 3rem;
  /* padding: 4.8rem 0 9.6rem 0; */
}

li.mj-meal {

  position: relative;

  list-style: none outside;
  list-style-image: initial;
}

li.mj-meal:nth-child(3n) {
  margin-right: 0;
}

li.mj-meal:nth-child(3n + 1) {
  clear: both;
  margin-left: 0;
}

.mj-meal-slider-wrapper {
  /* width: 100%; */
  /* max-width: 380px; */
  border: 2px solid #40c057;
  border-radius: 30px;
  list-style: none outside;
  /* border-color: rgb(55, 60, 62); */
  z-index: 10;
  background-color: #ebfbee;
  cursor: pointer;
}

a {
  text-decoration-color: initial;
  text-decoration: none;
}

.mj-meal-slider-img {
  box-shadow: none;
  /* width: 100%; */
  max-width: 100%;
  /* height: 3rem; */
  display: block;
  margin: 0 0 1rem;
  z-index: 0;
  /* object-fit: cover; */
  border-top-left-radius: 28px;
  border-top-right-radius: 28px;

  aspect-ratio: auto 600 / 400;

  overflow: clip;

  /* overflow: hidden; */
  overflow-clip-margin: content-box;
  /* display: none */
  height: 0;
  /* transition: all 0.3s; */
  transition: all 0.3s ease-in-out;
}

.mj-meal.meal-active .mj-meal-slider-wrapper .mj-meal-slider-img {
  /* display: block; */
  height: auto;
  /* transition: all 0.3s; */
  transition: all 0.3s ease-in-out;
}

.mj-meal-slider-content {
  /* background-color: #ebfbee; */
  border-top-color: initial;
  border-top: none;
  border-bottom-right-radius: 30px;
  border-bottom-left-radius: 30px;
  /* margin: -6px auto 10px; */
  margin: 0 auto;
  padding: 0 24px 24px;
  /* height: 200px; */
  display: flex;
  flex-direction: column;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
}

.mj-meal-slider-content h2 {
  margin-top: 15px;
  margin-bottom: 20px;
  color: rgb(196, 191, 184);
  font-family: Luxia Display;
  font-size: 18px;
  font-weight: 400;
  line-height: 1.4;
  letter-spacing: 0;
  transition: all 0.1s ease-in-out;
}

.mj-meal-slider-content h2:hover {
  color: rgb(181, 167, 131);
}

.mj-meal-slider-content p {
  color: rgb(163, 156, 144);
  margin: 0;
  font-family: Roboto Light;
  font-size: 10px;
  font-weight: 400;
  line-height: 1.6;
  letter-spacing: 0.3px;
  text-align: left;
  text-transform: uppercase;
}

.mj-button-links {
  display: inline-block;
  height: 5.2rem;
  width: 16rem;
  padding: 1rem 2.3rem;
  /* margin-top: 0.9rem; */
  color: #ebfbee;
  transition: all 0.3s ease-in-out;
  background-image: initial;
  background-color: #40c057;
  font-family: Roboto Medium;
  font-weight: 500;
  font-size: 1rem;
  line-height: 2.4rem;
  letter-spacing: 0.2rem;
  text-align: center;
  text-transform: uppercase;
  text-decoration-color: initial;
  text-decoration: none;
  border: 2px solid #40c057;
  border-bottom: none;
  border-right: none;
  border-radius: 30px;
  border-bottom-left-radius: 0;
  border-top-right-radius: 0;
  /* border-radius: 9px; */
  position: absolute;
  bottom: 0;
  right: 0;
  overflow: hidden;
}

.mj-button-links:hover {
  background-color: #40c057;
  color: rgb(232, 230, 227);
}

.mj-meal-choices-main {
  margin: 0 auto;

}

.mj-meal-benefits-carousel-main {
  margin: 4.8rem auto;
  width: 95%;
  overflow-x: hidden;
  position: relative;
  cursor: grab;
  background-color: #ebfbee;
  padding-bottom: 4.8rem;
}

.mj-meal-benefits-carousel-main:active {
  cursor: grabbing;
}

.mj-carousel-slider > span {
  font-size: 85px;
}

[class*=" icon-"],
[class^="icon-"] {
  font-family: icomoon !important;
  /* speak: never; */
  font-style: normal;
  font-weight: 400;
  font-variant: normal;
  text-transform: none;
  line-height: 1;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.mj-carousel-slider {
  position: absolute;

  background-color: #3aad4e;
  /* height: 180px; */
  width: 30%;
  border: 1px solid;
  border-radius: 23px;
  border-color: #3aad4e;

  /* margin: 0 5%; */
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  aspect-ratio: auto 200 / 100;
}

.mj-carousel-slider > h6 {
  color: #c6eccd;
  font-family: Roboto Regular;
  font-size: 14px;
  letter-spacing: 0;
  line-height: 24px;
  text-align: center;
  margin-top: 6px;
}

.mj-carousel-box {
  overflow: hidden;
  touch-action: pan-y;
}

.section-carosel {
  background-color: #ebfbee;
  /* padding: 4.8rem 0 9.6rem 0; */
  padding-bottom: 9.6rem;
}

.cards-selection {
  max-width: 130rem;
  margin: 0 auto;
  /* padding: 4.8rem 0 9.6rem 0; */
  align-items: center;
  text-align: center;
  /* padding-bottom: 9.6rem; */
}

.mj-meal-choices-main {
  margin: 0 auto;
  max-width: 120rem;
}

/* ------------------------floating----------------------- */
.details {
  position: absolute;
  /* width: 3rem; */
  top: 2rem;
  right: 2rem;
  width: 40rem;
}

.meal-detail .mj-meal-slider-wrapper .mj-meal-slider-img {
  height: auto;
}

.myChart {
  width: 10rem;
  height: 10rem;
}

.table {
  display: flex;
  width: 100%;
  gap: 2rem;
}

.nutrition {
  display: flex;
  width: 100%;
  justify-content: space-between;
  letter-spacing: 0.3px;
  /* flex-direction: column; */
}

.nutrition .nutrition-name {
  text-transform: capitalize;
}


.close-details {
  position: absolute;
  top: 2rem;
  right: 1rem;
  width: 5rem;
  height: 5rem;
  color: #3aad4e;
  cursor: pointer;
  transition: all 0.3s;
  /* background-color: #fff; */
  border-radius: 100%;
  padding: 0.5rem;
  transition: all 0.3s;
}

.close-details .opener {
  display: none;

  transition: all 0.3s;
}

.close-details .closer {
  display: block;
  /* transition: display 0.3s; */
}
</style>
