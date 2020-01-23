<template>
    <div>
        <p>
            <router-link to="/">Home</router-link>
            <router-link to="/polls">Polls</router-link>
        </p>
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