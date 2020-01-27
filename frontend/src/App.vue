<template>
    <div>
        <b-nav tabs align="center">
            <b-nav-item to="/">Home</b-nav-item>
            <b-nav-item to="/polls">Polls</b-nav-item>
        </b-nav>
        <router-view></router-view>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import Home from './components/Home.vue'

    @Component({
        components: {
            Home
        }
    })
    export default class App extends Vue {

    }
</script>

<style>


</style>