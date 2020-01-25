<template>
    <div>
        <h2>Poll list</h2>
        <div v-for="poll in polls">
            <p>Title</p>
            <poll :poll="poll"></poll>
        </div>

        <button @click="this.getPolls">GetData</button>

    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import axios from "axios";
    import PollDto from "../dto/PollDto";
    import Poll from "./Poll.vue";

    @Component({
        components: {
            Poll
        }
    })
    export default class PollList extends Vue {
        polls: PollDto[] = [];

        private getPolls(): void {
            axios.get("/api/poll").then((res) => {
                this.polls = res.data;
                console.log(res);
            })
        }
    };
</script>