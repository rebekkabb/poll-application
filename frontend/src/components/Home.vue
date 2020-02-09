<template>
    <div>
        <div class="colr">
            <div class="bootstrap" id="jumboboy">
                <b-jumbotron header="Poll application" lead="Make ur own polls!" border-variant="dark">
                    <b-button variant="outline-primary" to="/polls">Go to Polls</b-button>
                </b-jumbotron>
            </div>
            <div class="separator">
                <img src=../public/img/white-curve.png>
            </div>
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
    #jumboboy {
        width: 50%;
        margin-top: 15%;
        margin-left: 25%;
        text-align: center;

    }

    .separator {
        position: absolute;
        width: 100%;
        height: 100%;
        background: linear-gradient(black, pink);
    }

    html {
        height: 100%;
    }
</style>