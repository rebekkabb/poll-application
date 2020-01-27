import Vue from "vue";
import Home from "./App.vue"

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import routes from './routes'

Vue.use(BootstrapVue);

const v = new Vue({
    router: routes,
    render: h => h(Home)
}).$mount('#app');
