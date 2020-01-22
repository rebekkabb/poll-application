<template>
    <div>
        Name: <input v-model="name" type="text">
        <h1>Hello Component</h1>
        <hello :name="name" :initialEnthusiasm="initialEnthusiasm"/>
        <h1>Hello Decorator Component</h1>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import Hello from "./Hello.vue"

    @Component({
        components: {
            Hello
        }
    })
    export default class Main extends Vue {
        name: String = "ame";
        initialEnthusiasm: number = 3;
    };
</script>
<style>
    .greeting {
        font-size: 20px;
    }
</style>