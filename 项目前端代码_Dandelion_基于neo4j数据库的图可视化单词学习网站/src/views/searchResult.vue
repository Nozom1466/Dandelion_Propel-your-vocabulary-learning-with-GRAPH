<template>
  <head>
    <link
      rel="stylesheet"
      href="http://at.alicdn.com/t/c/font_4098090_nx9t38xfkzc.css"
    />
    <link
      rel="stylesheet"
      href="http://at.alicdn.com/t/c/font_4114555_tl0gx85xamn.css"
    />
  </head>
  <main>
    <nava />
    <section class="section-carosel">
      <div class="cards-selection">
        <div class="mj-meal-choices-main">
          <ul class="mj-all-meals grid--3-cols">
            <infoCard
              v-for="(item, index) in this.wordData"
              :key="index"
              :word="item.word"
              :description="item.description"
              :cate="item.cate"
            />
          </ul>
        </div>
      </div>
    </section>
  </main>
</template>

<script lang="js">
import {reactive, toHandlers, toRefs} from "vue";

export default {
  name: "searchResult",
  data() {
    return {
      ok : this.$route.query.ok,
      wordData : [],
    }
  },
  computed: {
    findWordData() {
      return this.$route.query.data
    }
  },
  watch: {
    "$route.query.data": function() {
      this.loader();
    }
  },
  mounted() {
    this.loader();
  },
  methods: {
    loader() {
      this.wordData = []
      let word2Search = String(this.$route.query.data)

      fetch('http://139.196.197.42:8085/neo4j?keyword=' + word2Search, {
        method: 'GET'
      }).then(response => response.json())
      .then(data => {
        let nodes = data.data.nodes
        for (let i  =0; i < nodes.length; i++) {
          let wd = {}
          wd["word"] = nodes[i].label;
          wd["description"] = nodes[i].info;
          wd["cate"] = nodes[i].categories + '.';
          this.wordData.push(wd)
        }
      })
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
}

body {
  font-family: sans-serif;
  line-height: 1;
  font-weight: 400;
  color: #555;
}

*:focus {
  outline: none;
  /* outline: 4px dotted #40c057; */
  /* outline-offset: 8px; */
  box-shadow: 0 0 0 8px rgba(34, 230, 93, 0.5);
}

.grid--2-cols {
  grid-template-columns: repeat(2, 1fr);
}
.grid--3-cols {
  grid-template-columns: repeat(3, 1fr);
}

.grid--2-rows {
  grid-template-rows: repeat(2, 1fr);
}

.grid--2-rows-fatterbottom {
  grid-template-rows: 40fr 90fr;
}

.margin-right-sm {
  margin-right: 16px !important;
}

.margin-bottom-sm {
  margin-bottom: 16px !important;
}

.margin-bottom-md {
  margin-bottom: 48px !important;
}

.heading-primary {
  font-size: 52px;
  line-height: 105;
  margin-bottom: 32px;
}

.heading-secondary {
  font-size: 44px;
  line-height: 1.2;
  margin-bottom: 96px;
}

.heading-tertiary {
  font-size: 30px;
  line-height: 1.2;
  margin-bottom: 32px;
}

.subheading {
  display: block;
  font-size: 16px;
  font-weight: 500;
  color: #40c057;
  text-transform: uppercase;
  margin-bottom: 16px;
  letter-spacing: 0.75px;
}

.subsubheading {
  display: block;
  font-size: 14px;
  font-weight: 500;
  color: #40c057;
  /* text-transform: uppercase; */
  margin-bottom: 16px;
  letter-spacing: 0.75px;
}

.text-left {
  text-align: left !important;
}

.btn,
.btn:link,
.btn:visited {
  display: inline-block;

  text-decoration: none;
  font-size: 20px;
  font-weight: 600;
  padding: 16px 32px;
  border-radius: 9px;

  /* Only necessary for .btn */
  border: none;
  cursor: pointer;
  font-family: inherit;

  transition: all 0.3s;
}

.btn--full:link,
.btn--full:visited {
  background-color: #40c057;
  color: #fff;
}

.btn--full:hover,
.btn--full:active {
  background-color: #3aad4e;
}

.btn--outline:link,
.btn--outline:visited {
  background-color: #fff;
  color: #555;
}

.btn--outline:hover,
.btn--outline:active {
  background-color: #fdf2e9;

  box-shadow: inset 0 0 0 3px #fff;
}

.btn--form {
  background-color: #2d863d;
  color: #ecf9ee;
  align-self: end;
  padding: 12px;
}

.btn--form:hover {
  background-color: #fff;
  color: #555;
}

.container {
  /* 1140px */
  max-width: 1200px;
  padding: 0 32px;
  margin: 0 auto;
}

.grid {
  display: grid;
  column-gap: 64px;
  row-gap: 96px;
}

.section-carosel {
  padding-top: 96px;
  background-color: #ebfbee;
}

ul.mj-all-meals {
  /* margin: 0 0 1px; */
  padding: 0;
  list-style: none outside;
  clear: both;
  display: grid;
  column-gap: 50px;
  row-gap: 30px;
  /* padding: 4.8px 0 9.6px 0; */
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
  border: 2px solid #40c057;
  border-radius: 30px;
  list-style: none outside;
  /* border-color: rgb(55, 60, 62); */
  z-index: 10;
  position: relative;
}

a {
  text-decoration-color: initial;
  text-decoration: none;
}

.mj-meal-slider-img {
  box-shadow: none;
  /* width: 100%; */
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 0 1px;
  z-index: 0;
  /* object-fit: cover; */
  border-top-left-radius: 28px;
  border-top-right-radius: 28px;

  aspect-ratio: auto 600 / 400;

  overflow: clip;

  /* overflow: hidden; */
  overflow-clip-margin: content-box;
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
  box-shadow: 0 2.4px 4.8px rgba(0, 0, 0, 0.075);
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
  letter-spacing: 4px;
  text-align: left;
  text-transform: uppercase;
}

.mj-button-links {
  display: inline-block;
  height: 5.2px;
  width: 16px;
  padding: 1px 2.3px;
  /* margin-top: 0.9px; */
  color: #ebfbee;
  transition: all 0.3s ease-in-out;
  background-image: initial;
  background-color: #40c057;
  font-family: Roboto Medium;
  font-weight: 500;
  font-size: 1px;
  line-height: 2.4px;
  letter-spacing: 0.2px;
  text-align: center;
  text-transform: uppercase;
  text-decoration-color: initial;
  text-decoration: none;
  border: 2px solid #40c057;
  border-bottom: none;
  border-right: none;
  border-radius: 28px;
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
  margin: 48px auto;
  width: 95%;
  overflow-x: hidden;
  position: relative;
  cursor: grab;
  background-color: #ebfbee;
  padding-bottom: 48px;
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
  /* padding: 4.8px 0 9.6px 0; */
  padding-bottom: 96px;
}

.cards-selection {
  max-width: 1300px;
  margin: 0 auto;
  /* padding: 4.8px 0 9.6px 0; */
  align-items: center;
  text-align: center;
  /* padding-bottom: 9.6px; */
}

.mj-meal-choices-main {
  margin: 0 auto;
  max-width: 1200px;
}
</style>
