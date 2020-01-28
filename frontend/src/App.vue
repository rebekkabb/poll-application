<template>
    <div>
        <b-nav tabs align="center">
            <b-nav-item to="/">Home</b-nav-item>
            <b-nav-item to="/polls">Polls</b-nav-item>
            <b-nav-item to="/stats">Statistics</b-nav-item>
            <b-nav-item v-b-modal.modal-center>Log in</b-nav-item>
        </b-nav>
        <SignIn></SignIn>
        <router-view></router-view>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import Home from './components/Home.vue';
    import SignIn from './components/SignIn.vue';

    @Component({
        components: {
            Home,
            SignIn
        }
    })
    export default class App extends Vue {
    }
</script>

<style>


</style>