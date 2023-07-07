<template>
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <link
        rel="stylesheet"
        href="http://at.alicdn.com/t/c/font_4098090_nx9t38xfkzc.css"
      />
    </head>
    <body>
      <nava />
      <main>
        <section class="section-hero">
          <div class="hero">
            <div class="hero-img-box grid--5-cols grid--5-rows">
              <div class="hero--img-innerbox hero--img-innerbox1">
                <img
                  class="hero-img hero--img-1"
                  src="/static/img/hero1.png"
                  alt="Healthy Food 1"
                />
              </div>
              <p class="hero-date hero--date-week">THU.</p>
              <p class="hero-date hero--date-year">MAR 2nd</p>
              <div class="hero--img-innerbox hero--img-innerbox2">
                <img
                  class="hero-img hero--img-2"
                  src="/static/img/hero2.png"
                  alt="Healthy Food 2"
                />
              </div>
            </div>

            <div class="hero-text-box">
              <h1 class="heading-primary">
                Explore vocabualry in <span class="highlighted">GRAPH</span>,
                designed for your English Learning
              </h1>
              <p class="hero-description">
                Learn vocabulary via visual graph interface. Relate synonyms,
                cognates, and phrases with directed graph.
              </p>
              <router-link
                :to="{ path: '/main' }"
                class="btn btn--full margin-right-sm"
                >Start Learning</router-link
              >

              <a href="https://github.com/Nozom1466" class="btn btn--outline"
                >Go to GitHub</a
              >
            </div>
          </div>
        </section>
      </main>
      <footer></footer>
    </body>
  </html>
</template>

<script lang="js">

export default {
  name: "Index",
  created() {
    const style = document.createElement('style');
    style.innerText = 'body { overflow: hidden; }';
    style.className = 'overflow-hidden-style'
    document.head.appendChild(style);
  },
  beforeUnmount() {
    const style = document.head.querySelector('.overflow-hidden-style');
    document.head.removeChild(style);
  },
  mounted() {
    //装填日期
    let myweek = document.querySelector(".hero--date-week");
    let mydate = document.querySelector(".hero--date-year");
    let todaydate = new Date();
    let mydatearray = todaydate.toDateString().split(" ");
    let dates = todaydate.getDate();
    myweek.innerText = mydatearray[0].toUpperCase() + ".";
    mydate.innerText =
      mydatearray[1] +
      "\n" +
      dates +
      (dates % 10 == 1
        ? "st"
        : dates % 10 == 2
        ? "nd"
        : dates % 10 == 3
        ? "rd"
        : "st");

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
  font-size: 10px;
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

      HERO SECTION

*/

.section-hero {
  background-color: #ebfbee;
  padding: 48px 0 96px 0;

  height: 90vh;
}

.hero {
  max-width: 1300px;
  margin: 0 auto;
  padding: 0 32px;
  display: grid;
  grid-template-columns: 60fr 40fr;
  gap: 14px;
  align-items: center;

  text-align: center;

  height: 70vh;
}

.hero-description {
  font-size: 20px;
  line-height: 1.6;
  margin-bottom: 48px;
}

.hero-img {
  width: 100%;
  border-radius: 9px;

  /* display: none; */
}

.hero--img-innerbox {
  position: relative;
}

.hero--img-innerbox::before,
.hero--img-innerbox::after {
  content: "";
  display: block;
  position: absolute;
  width: 7px;
  height: 7px;
  z-index: -1;
  background-color: #8cd99a;

  border-radius: 9px;
}

.hero--img-innerbox::before {
  right: 0;
  top: 0;
  transform: translate(16%, -16%);
}

.hero--img-innerbox::after {
  left: 0;
  bottom: 0;
  transform: translate(-16%, 16%);
}

.hero-img-box {
  display: grid;
  row-gap: 16px;
  z-index: 0;
}

.hero--img-innerbox1 {
  grid-row: 1 / 2;
  grid-column: 1 / 4;
}

.hero--img-innerbox2 {
  grid-row: 2 / 3;
  grid-column: 3 / -1;
}

.hero--date-week {
  grid-row: 1 / 2;
  grid-column: 4 / -1;
}

.hero--date-week {
  grid-row: 1 / 2;
  grid-column: 4 / -1;
}

.hero--date-year {
  grid-row: 2 / 3;
  grid-column: 1 / 3;
}

.hero-date {
  font-size: 86px;
  font-weight: 600;
  color: #c6eccd;
  margin-bottom: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
}

/*text-box -> button*/

.btn,
.btn:link,
.btn:visited {
  display: inline-block;

  text-decoration: none;
  font-size: 20px;
  font-weight: 600;
  padding: 16px 32px;
  border-radius: 9px;

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
  background-color: #ecf9ee;

  /* border: 3px solid #fff; */

  box-shadow: inset 0 0 0 3px #fff;
}
</style>
