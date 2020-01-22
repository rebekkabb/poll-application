import Vue from "vue";
import Main from "./components/Main.vue";

let v = new Vue({
    render: h => h(Main)
}).$mount('#app');