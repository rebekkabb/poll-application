<template>
    <div class="everything">
        Name: <input v-model="name" type="text">
        <h1>Poll</h1>
        <hello :name="name" :initialEnthusiasm="initialEnthusiasm"/>
        <h1>Hello Decorator Component</h1>
        <div v-for="poll in polls">
            <poll :poll="poll"></poll>
        </div>

        <button @click="this.getPolls">GetData</button>

        <create-poll></create-poll>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import axios from "axios";
    import Hello from "./Hello.vue"
    import Poll from "./Poll.vue"
    import CreatePoll from "./CreatePoll.vue"
    import PollDto from "../dto/PollDto";

    @Component({
        components: {
            Hello,
            Poll,
            CreatePoll
        }
    })
    export default class Main extends Vue {
        name: String = "ame";
        initialEnthusiasm: number = 3;
        polls: PollDto[] = [];

        private getPolls(): void {
            axios.get("/api/poll").then((res) => {
                this.polls = res.data;
                console.log(res);
            })
        }
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