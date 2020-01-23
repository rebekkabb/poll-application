import Home from "./components/Home.vue";
import Main from "./components/Main.vue";
import Router from 'vue-router';
import Vue from 'vue';

Vue.use(Router);

const routes = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Home
        },
        {
            path: '/polls',
            component: Main
        }
    ]
});

export default routes;