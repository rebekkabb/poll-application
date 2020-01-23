import Vue from "vue";
import Main from "./components/Main.vue";
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

/**
 const v = new Vue({
    router,
    render: h => h(Main)
}).$mount('#app');
 */

/**
 const v = new Vue({
     el: '#app',
      data: {
        currentRoute: window.location.pathname
      },
      computed: {
        ViewComponent () {
          return routes[this.currentRoute]
        }
      },
      render: h => h(Main)
}).$mount('#app');
 */