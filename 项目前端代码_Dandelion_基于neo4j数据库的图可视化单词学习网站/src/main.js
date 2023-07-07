import { createApp, compilerOptions } from "vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

import $ from "jquery";
import jQuery from "jquery";
import axios from "axios";
import VueAxios from "vue-axios";
import nava from "./components/nav.vue";
import choiceCard from "./components/choiceCard.vue";
import infoCard from "./components/infoCard.vue";
import locale from "element-plus/lib/locale/lang/zh-cn";

import App from "./App.vue";
import router from "./router";
import store from "./store";

window.jQuery = $;

const app = createApp(App);
app.use(store).use(router);
app.use(store);
app.use(router);
app.use(ElementPlus);
app.use(VueAxios, axios);
app.use($);
app.use(jQuery);
app.use(locale);
app.component("nava", nava);
app.component("choiceCard", choiceCard);
app.component("infoCard", infoCard);

app.mount("#app");
