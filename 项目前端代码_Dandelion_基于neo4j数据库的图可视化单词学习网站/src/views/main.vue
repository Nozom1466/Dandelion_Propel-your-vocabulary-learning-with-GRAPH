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
  <body>
    <nava />
    <main>
      <section class="section-carosel">
        <div class="cards-selection">
          <div class="mj-meal-choices-main">
            <ul class="mj-all-meals grid--3-cols">
              <li class="mj-meal aos-init" data-aos="zoom-in-up">
                <div class="mj-meal-slider-wrapper">
                  <router-link :to="{ path: '/mapper' }"
                    ><img
                      class="mj-meal-slider-img"
                      src="static/img/CET4.png"
                      alt="Low Carb Meal Plan"
                      decoding="async"
                      loading="lazy"
                      sizes="(max-width: 600px) 100vw, 600px"
                  /></router-link>
                  <div class="mj-meal-slider-content">
                    <router-link :to="{ path: '/mapper' }"
                      ><h2>RED bible FOR CET 4</h2>
                      <p>MinHong Yu</p>
                    </router-link>
                  </div>
                </div>
              </li>
              <li class="mj-meal aos-init" data-aos="zoom-in-up">
                <div class="mj-meal-slider-wrapper">
                  <router-link :to="{ path: '/mapper' }">
                    <img
                      class="mj-meal-slider-img"
                      src="static/img/CET6.png"
                      alt="Ketogenic Diet Plan"
                      decoding="async"
                      loading="lazy"
                      sizes="(max-width: 600px) 100vw, 600px"
                    />
                  </router-link>
                  <div class="mj-meal-slider-content">
                    <router-link :to="{ path: '/mapper' }">
                      <h2>CET6</h2>
                      <p>YU MIN HONG</p>
                    </router-link>
                  </div>
                </div>
              </li>
              <li class="mj-meal aos-init" data-aos="zoom-in-up">
                <div class="mj-meal-slider-wrapper">
                  <router-link :to="{ path: '/mapper' }">
                    <img
                      class="mj-meal-slider-img"
                      src="static/img/gre.png"
                      alt="Ketogenic Diet Plan"
                      decoding="async"
                      loading="lazy"
                      sizes="(max-width: 600px) 100vw, 600px"
                    />
                  </router-link>
                  <div class="mj-meal-slider-content">
                    <router-link :to="{ path: '/mapper' }">
                      <h2>GRE</h2>
                      <p>KILL YOU 3000</p>
                    </router-link>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </section>

      <section class="section-basicInfo">
        <div class="basicInfo grid--2-cols .grid--2-rows">
          <div class="basicInfo-gauge">
            <div class="gaugeHeader">
              <p class="subheading">progress of your books</p>
              <div class="filling"></div>
            </div>
            <div class="gauges gauge-1 margin-bottom-sm">
              <div class="ga-percent">60%</div>
              <div class="mave-1 mave"></div>
              <div class="ga-bookname">TOFEL</div>
            </div>
            <div class="gauges gauge-1 margin-bottom-sm">
              <div class="ga-percent">80%</div>
              <div class="mave-2 mave"></div>
              <div class="ga-bookname">ELTS</div>
            </div>
            <div class="gauges gauge-1 margin-bottom-sm">
              <div class="ga-percent">90%</div>
              <div class="mave-3 mave"></div>
              <div class="ga-bookname">GRE</div>
            </div>
          </div>
          <div class="health-tips">
            <div class="health-tips-Header">
              <p class="subheading">RECAP:WARM UP!</p>
              <div class="filling"></div>
            </div>
            <div class="health-tips-container">
              <input
                type="radio"
                name="slider"
                class="d-none"
                id="s1"
                checked
              />
              <input type="radio" name="slider" class="d-none" id="s2" />
              <input type="radio" name="slider" class="d-none" id="s3" />
              <input type="radio" name="slider" class="d-none" id="s4" />
              <input type="radio" name="slider" class="d-none" id="s5" />

              <div class="cards">
                <label for="s1" id="slide1">
                  <div class="card">
                    <div class="image">
                      <img src="static/img/steak.jpg" alt="health-tips-img1" />
                      <div class="dots">
                        <div></div>
                        <div></div>
                        <div></div>
                      </div>
                    </div>
                    <div class="infos">
                      <span class="name">Steak</span>
                      <span class="lopx"
                        >A steak is a thick cut of meat generally sliced across
                        the muscle fibers, sometimes including a bone. It is
                        normally grilled or fried.
                      </span>
                    </div>
                  </div>
                </label>

                <label for="s2" id="slide2">
                  <div class="card">
                    <div class="image">
                      <img
                        src="static/img/sneakers.jpg"
                        alt="health-tips-img2"
                      />
                      <div class="dots">
                        <div class="dot1"></div>
                        <div class="dot2"></div>
                        <div class="dot3"></div>
                      </div>
                    </div>
                    <div class="infos">
                      <span class="name">Sneakers</span>
                      <span class="lopx"
                        >Sneakers are shoes primarily designed for sports or
                        other forms of physical exercise, but which are also
                        widely used for everyday casual wear.</span
                      >
                    </div>
                  </div>
                </label>

                <label for="s3" id="slide3">
                  <div class="card">
                    <div class="image">
                      <img src="static/img/stock.jpg" alt="health-tips-img3" />
                      <div class="dots">
                        <div class="dot1"></div>
                        <div class="dot2"></div>
                        <div class="dot3"></div>
                      </div>
                    </div>
                    <div class="infos">
                      <span class="name">Stock</span>
                      <span class="lopx"
                        >Stock (also capital stock, or sometimes
                        interchangeably, shares) consist of all the shares[a] by
                        which ownership of a corporation or company is
                        divided.</span
                      >
                    </div>
                  </div>
                </label>

                <label for="s4" id="slide4">
                  <div class="card">
                    <div class="image">
                      <img src="static/img/skate.jpg" alt="health-tips-img4" />
                      <div class="dots">
                        <div class="dot1"></div>
                        <div class="dot2"></div>
                        <div class="dot3"></div>
                      </div>
                    </div>
                    <div class="infos">
                      <span class="name">Skate</span>
                      <span class="lopx"
                        >Ice skates are metal blades attached underfoot and used
                        to propel the bearer across a sheet of ice while ice
                        skating.</span
                      >
                    </div>
                  </div>
                </label>

                <label for="s5" id="slide5">
                  <div class="card">
                    <div class="image">
                      <img src="static/img/stack.png" alt="health-tips-img5" />
                      <div class="dots">
                        <div class="dot1"></div>
                        <div class="dot2"></div>
                        <div class="dot3"></div>
                      </div>
                    </div>
                    <div class="infos">
                      <span class="name">Stack</span>
                      <span class="lopx"
                        >In computer science, a stack is an abstract data type
                        that serves as a collection of elements, with two
                        principal operations, namely push and pop.
                      </span>
                    </div>
                  </div>
                </label>
              </div>
            </div>
          </div>
          <div class="meal_generator">
            <choiceCard />
          </div>
        </div>
      </section>
    </main>
    <footer class="footer">
      <div class="container grid grid--footer">
        <div class="logo-col">
          <a href="#" class="footer-logo">
            <img
              class="logo"
              alt="Omnifood logo"
              src="static/img/Graph_Vocab.png"
            />
          </a>
        </div>
        <div class="contact-us">
          <p class="footer-heading">Contact us</p>
        </div>
        <div class="address-col">
          <address class="contacts">
            <p class="address">mts1466842541@163.com</p>
            <p>
              <a class="footer-link" href="tel:415-201-6370">415-201-6370</a
              ><br />
              <a class="footer-link" href="mts1466842541@163.com">1466842541</a>
            </p>
          </address>
        </div>

        <div class="address-col">
          <address class="contacts">
            <p class="address">wyh0501@tongji.edu.cn</p>
            <p>
              <a class="footer-link" href="tel:415-201-6370">415-201-1520</a
              ><br />
              <a class="footer-link" href="#">maiji</a>
            </p>
          </address>
        </div>
      </div>
    </footer>
  </body>
</template>

<script lang="js">
import {reactive, toRefs} from "vue";

export default {
  name: "Main",
  data() {
    return {
      login: localStorage.getItem("token")
    }
  },
  mounted() {
    if (!this.checkLogin()) {
      console.log(!this.checkLogin())
      let mave_list = document.querySelectorAll(".mave")
      // console.log(mave_list)
      for (let i = 0;i < mave_list.length; i++) {
        mave_list[i].style.backgroundColor ="#ecf9ee"
      }
    }
    else {
      console.log(!this.checkLogin())
      let mave_list = document.querySelectorAll(".mave")
      // console.log(mave_list)
      for (let i = 0;i < mave_list.length; i++) {
        mave_list[i].style.backgroundColor ="#40c057"
      }
    }
  },
  methods: {
    checkLogin: function() {
      return this.login
    }
  }

}
</script>

<style scoped>
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

.contact-us {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
}

.address-col {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
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

  /* margin-bottom: 9.6px; */
}

/**************************/
/* HEADER */
/**************************/

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ecf9ee;

  padding: 0 48px;
  position: relative;
}

.logo {
  height: 250px;
}

/**************************/
/* HEADER */
/**************************/

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ecf9ee;

  /* Because we want header to be sticky later */
  height: 96px;
  padding: 0 48px;
  position: relative;
}

/**************************/
/* NAVIGATION */
/**************************/

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

/*

      CAROSEL SECTION

*/
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
  /* width: 30.75%; */
  /* float: left; */
  /* margin: 0 3.8% 3px 0; */
  /* padding: 2.5px; */
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
  border-top-right-radius: 28px;

  aspect-ratio: auto 600 / 400;

  overflow: clip;

  /* overflow: hidden; */
  overflow-clip-margin: content-box;
}

.mj-meal-slider-content {
  border-top-color: initial;
  border-top: none;
  border-bottom-right-radius: 30px;
  border-bottom-left-radius: 30px;
  margin: 0 auto;
  padding: 0 24px 24px;
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

/*

      HERO SECTION

*/

.section-basicInfo {
  background-color: #ebfbee;
  padding: 48px 0 96px 0;

  height: 110vh;
}

.basicInfo {
  max-width: 1300px;
  margin: 0 auto;
  padding: 0 32px;
  display: grid;
  grid-template-columns: 60fr 40fr;
  grid-template-rows: 20fr 32fr;
  gap: 64px;
  align-items: center;

  text-align: center;

  /* height: 70vh; */
}

.basicInfo-gauge {
  background-color: #e5f8e8;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  /* grid-template-rows: 20fr 40fr; */
  row-gap: 24px;
  padding: 24px;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  border-radius: 10px;

  align-items: center;
  justify-items: center;
}

.gaugeHeader {
  grid-row: 1 / 2;
  grid-column: 1 / 4;
  text-align: left;
  width: 100%;
}

.gauges {
  width: 180px;
  height: 180px;
  border-radius: 50%;
  /* background-color: #333; */
  border: 2px solid #40c057;
  /* padding: 10px; */
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.ga-percent {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 35px;
  color: #ebfbee;
  z-index: 100;
  /* mix-blend-mode: difference; */
}
.ga-bookname {
  position: absolute;
  bottom: -25%;
  left: 50%;
  display: block;
  font-size: 16px;
  font-weight: 500;
  color: #40c057;
  text-transform: uppercase;
  margin-bottom: 16px;
  letter-spacing: 0.75px;
  transform: translateX(-50%);
}

/* 
    gauge mave effect
*/
.mave {
  position: relative;
  border-radius: 50%;
  background-color: #79d389;
  width: 160px;
  height: 160px;
  overflow: hidden;
  border: 1px solid #ecf9ee;
}

.mave::before {
  content: " ";
  position: absolute;
  top: 0;
  left: 50%;
  width: 240px;
  height: 240px;

  background-color: rgb(229, 248, 232, 1);
  border-radius: 42%;
  /* background-color: #555; */
}

.mave::after {
  content: " ";
  position: absolute;
  top: 0;
  left: 50%;
  width: 26px;
  height: 26px;

  background-color: rgb(229, 248, 232, 0.2);
  border-radius: 42%;
  /* background-color: #555; */
}

.mave-1::before {
  transform: translate(-50%, -70%);
  animation: mave-1 5s linear infinite;
}

.mave-1::after {
  transform: translate(-50%, -70%);
  animation: mave-1 4s linear infinite;
}

.mave-2::before {
  transform: translate(-50%, -80%);
  animation: mave-2 6s linear infinite;
}

.mave-2::after {
  transform: translate(-50%, -80%);
  animation: mave-2 5s linear infinite;
}
.mave-3::before {
  transform: translate(-50%, -90%);
  animation: mave-3 7s linear infinite;
}

.mave-3::after {
  transform: translate(-50%, -90%);
  animation: mave-3 6s linear infinite;
}

.mave-4::before {
  transform: translate(-50%, -60%);
  animation: mave-4 8s linear infinite;
}
.mave-4::after {
  transform: translate(-50%, -60%);
  animation: mave-4 7s linear infinite;
}


@keyframes mave-1 {
  100% {
    transform: translate(-50%, -70%) rotate(360deg);
  }
}

@keyframes mave-2 {
  100% {
    transform: translate(-50%, -80%) rotate(360deg);
  }
}
@keyframes mave-3 {
  100% {
    transform: translate(-50%, -90%) rotate(360deg);
  }
}
@keyframes mave-4 {
  100% {
    transform: translate(-50%, -60%) rotate(360deg);
  }
}

/*
    health tips
*/

.health-tips {
  grid-column: 1 / 2;
  padding: 24px;
  /* align-self: top; */
}

a {
  text-decoration: none;
}

input {
  display: none;
}

.health-tips {
  display: grid;
  align-self: start;
}

.health-tips-Header {
  width: 100%;
  text-align: left;
}

.health-tips-container {

  display: flex;
  transform-style: preserve-3d;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.cards {
  position: relative;
  height: 200px;
  width: 400px;
  margin-bottom: 20px;
  /* DEPTH ---------------------------*/
  perspective: 800px;
  transform-style: preserve-3d;
}

.cards label {
  position: absolute;
  width: 80%;
  height: 100%;
  left: 0;
  right: 0;
  margin: auto;
  cursor: pointer;
  transition: transform 0.55s ease;
}

.cards .card {
  position: relative;
  /* height: 100%; */
  /* width: 50%; */
  background-color: #ebfbee;
  border: 2px solid #40c057;
  border-radius: 10px;
  padding: 30px 35px;
}

.card .image {
  display: flex;
  justify-content: space-between;
}

.card .image img {
  border-radius: 9px;
  box-shadow: 0 0 0.4px rgba(0, 0, 0, 50%);
  margin-top: 5px;
  width: 86%;
  height: 220px;
  object-fit: cover;
}

.card .image .dots {
  text-align: center;
}

.dots div {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  margin-bottom: 10px;
}

.dots div:nth-child(1) {
  background-color: var(--current-color1);
}

.dots div:nth-child(2) {
  background-color: #5b85f9;
}

.dots div:nth-child(3) {
  background-color: #000;
}

.card .infos {
  display: block;
  text-align: start;
  padding-top: 10px;
}

.infos span {
  display: block;
}

.infos .name {
  font-size: 30px;
  color: var(--current-color1);
  letter-spacing: 0.75px;
  margin-bottom: 20px;
  /* padding-left: 25%; */
  transition: all 0.6s ease;
}

.infos .lopx {
  font-size: 15.5px;
  color: #8cd99a;
  /* letter-spacing: 3px; */
  line-height: 1.3;
}

.card .btn-contact {
  width: 100%;
  height: 60px;
  /* margin: 35px auto; */
  border-radius: 5px;
  background-color: var(--current-color1);
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  font-size: 25px;
  letter-spacing: 10px;
  font-weight: 700;
  transition: all 0.7s ease;
}

.card .socials {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: 20px;
}

.socials i {
  font-size: 25px;
  transition: all 0.7s ease;
  color: var(--current-color2);
}

#s1:checked ~ .cards #slide4,
#s2:checked ~ .cards #slide5,
#s3:checked ~ .cards #slide1,
#s4:checked ~ .cards #slide2,
#s5:checked ~ .cards #slide3 {
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  transform: translate3d(-70%, 0, -220px);
  --current-color1: #40c057;
  --current-color2: #404457;
}

#s1:checked ~ .cards #slide5,
#s2:checked ~ .cards #slide1,
#s3:checked ~ .cards #slide2,
#s4:checked ~ .cards #slide3,
#s5:checked ~ .cards #slide4 {
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  transform: translate3d(-35%, 0, -120px);
  --current-color1: #40c057;
  --current-color2: #404457;
}

#s1:checked ~ .cards #slide1,
#s2:checked ~ .cards #slide2,
#s3:checked ~ .cards #slide3,
#s4:checked ~ .cards #slide4,
#s5:checked ~ .cards #slide5 {
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.1);
  transform: translate3d(0, 0, 0);
  --current-color1: #40c057;
  --current-color2: #eceaed;
}

#s1:checked ~ .cards #slide2,
#s2:checked ~ .cards #slide3,
#s3:checked ~ .cards #slide4,
#s4:checked ~ .cards #slide5,
#s5:checked ~ .cards #slide1 {
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  transform: translate3d(35%, 0, -120px);
  --current-color1: #40c057;
  --current-color2: #404457;
}

#s1:checked ~ .cards #slide3,
#s2:checked ~ .cards #slide4,
#s3:checked ~ .cards #slide5,
#s4:checked ~ .cards #slide1,
#s5:checked ~ .cards #slide2 {
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  transform: translate3d(70%, 0, -220px);
  --current-color1: #40c057;
  --current-color2: #404457;
}

/*
    meal-generator
*/

.meal_generator {
  grid-row: 1 / 3;
  grid-column: 2 / -1;
  padding: 24px;
  border-radius: 9px;
  /* box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075); */
  /* background-color: #e5f8e8; */
  /* background-color: #2f9e44; */
  /* background-color: #fff; */
  height: 100%;

  /*for card filpping*/
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  position: relative;
}
.generator {
  height: 100%;
  position: absolute;
  transition: all 0.3s;
}

.generator-header {
  width: 100%;
}

.eating-types {
  display: grid;
  list-style: none;
  gap: 24px;
  justify-content: center;
  align-items: center;
}

.eating-type {
  width: 100%;
  display: flex;
  border-radius: 11px;
  /* background-color: #5b85f9; */

  flex-direction: column;
  align-items: center;
  justify-content: center;
  row-gap: 16px;
  justify-content: space-between;
  justify-self: center;
}

.eating-type.type-selected {
  background-color: #c6eccd;
}

.eating-type a {
  text-decoration: none;
  padding-top: 12px;

  /* display: block; */
  /* width: 100%; */
}

.eating-type p {
  font-size: 1px;
  line-height: 1;
  margin-bottom: 32px;
  /* align-self: center; */
  font-size: 16px;
  justify-self: center;
  color: #2d863d;
}

.eatingtype-icon {
  /* height: 48px;
  width: 48px; */
  font-size: 48px;
  color: #40c057;
  text-align: center;
  margin-bottom: 10px;
}

/*
    query generator box
*/

label {
  display: block;
}

.queryform-purpose,
.queryform-calories,
.queryform-mealtimes {
  display: flex;
  justify-content: space-between;
}

.query-box {
  position: relative;
  width: 100%;
}

.form-label {
  text-align: left;
}

.query-box {
  /* width: 100%; */
  /* padding: 1.2px; */
  /* font-size: 1.8px; */
  font-family: inherit;
  color: inherit;
  border: none;
  background-color: #e5f8e8;
  border-radius: 9px;
  box-shadow: 0 10px 20px rgb(0 0 0 / 10%);
}

.form-control {
  display: block;
  width: 100%;
  padding: 12px;
  font-size: 16px;
  line-height: 1.5;
  color: #495057;
  background-color: #f0faf1;
  border: none;
  border-radius: 9px;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

#cal-input-label {
  position: absolute;
  left: auto;
  right: 30px;
  top: 50%;
  transform: translateY(-50%);
  color: #40c057;
  font-size: 16px;
  text-transform: uppercase;
  font-weight: 600;
}

.btn-group {
  width: 100%;
  display: flex;
  justify-content: space-between;
  box-shadow: 0 10px 20px rgb(0 0 0 / 10%);
  border: 1px solid #40c057;
  padding: 6px;
}

.btn-group:first-child {
  border-top-left-radius: 9px;
  border-bottom-left-radius: 9px;
  /* border-left: 2px solid #40c057; */
}

.btn-group:last-child {
  border-top-right-radius: 9px;
  border-bottom-right-radius: 9px;
  /* border-left: 2px solid #40c057; */
}

.btn-selector-primary {
  color: #40c057;
  font-size: 16px;
  padding: 12px 24px;
}


.mealplan-generated {
  width: 100%;
  display: none;
  transition: all 0.3s;
}

.mealplan-generated-list {
  padding-right: 48px;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.mealplan-generated-item {
  border-radius: 9px;
  overflow: hidden;
  height: 30%;
  position: relative;
}

.mealtype::after {
  content: "";
  display: block;
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.075);
  z-index: 1;
  transition: all 0.3s;
}

.mealplan-generated-item:hover .mealtype::after {
  background-color: rgba(0, 0, 0, 0);
}

.mealplan-generated-item a {
  display: block;
  height: 100%;
}

.meal-generated-img {
  width: 100%;
}


.mealplan-generated {
  position: absolute;
  height: 100%;
}

.meal-plan-img-generated {
  width: 100%;
}

.mealplan-generated-item {
  position: relative;
}

.mealplan1-text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 40px;
  color: #fff;
  transition: all 0.3s;
  /* background-color: #000; */
}

.mealplan-generated-item:hover .mealplan1-text {
  transform-origin: center center;
  transform: scale(1.5);
  /* transform: scale3d(1.5); */
}

/*
    FOOTER
*/

.footer {
  padding: 128px 0;
  border-top: 1px solid #eee;
}

.grid--footer {
  grid-template-columns: repeat(4, 1fr);
}

.logo-col {
  display: flex;
  flex-direction: column;
}

.footer-logo {
  display: block;
  margin-bottom: 32px;
}

.social-links {
  list-style: none;
  display: flex;
  gap: 24px;
}

.social-icon {
  height: 24px;
  width: 24px;
}

.copyright {
  font-size: 14px;
  line-height: 1.6;
  color: #767676;
  margin-top: auto;
}

.footer-heading {
  font-size: 40px;
  font-weight: 700;
  margin-bottom: 40px;
}

.contacts {
  font-style: normal;
  font-size: 16px;
  line-height: 1.6;
}

.address {
  margin-bottom: 24px;
}

.footer-nav {
  list-style: none;
  display: flex;
  flex-direction: column;
  gap: 24px;
}

.footer-link:link,
.footer-link:visited {
  text-decoration: none;
  font-size: 16px;
  color: #767676;
  transition: all 0.3s;
}

.footer-link:hover,
.footer-link:active {
  color: #555;
}
</style>
