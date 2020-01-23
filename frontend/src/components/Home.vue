<template>
    <div class="jumboboy">
        <div class="bootstrap">
            <b-jumbotron header="Poll application" lead="Make ur own polls!">
                <b-button variant="primary" href="#">
                    <router-link to="/polls">Go to Polls</router-link>
                </b-button>
            </b-jumbotron>
        </div>
    </div>
</template>
<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";

    @Component
    export default class Home extends Vue {
        name: String = 'bootstrap';
    };
</script>


<style>
    .jumboboy {
        width: 50%;
        margin-top: 15%;
        margin-left: 25%;
    }
</style>