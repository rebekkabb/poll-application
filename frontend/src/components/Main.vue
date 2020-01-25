<template>
    <div class="everything">
        Name: <input v-model="name" type="text">
        <h1>Poll</h1>
        <hello :name="name" :initialEnthusiasm="initialEnthusiasm"/>
        <br><br>
        <poll-list></poll-list>
        <create-poll></create-poll>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import Hello from "./Hello.vue";
    import Poll from "./Poll.vue";
    import CreatePoll from "./CreatePoll.vue";
    import PollList from "./PollList.vue";

    @Component({
        components: {
            Hello,
            Poll,
            CreatePoll,
            PollList
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
    .everything {
       align-content: center;
    }
</style>