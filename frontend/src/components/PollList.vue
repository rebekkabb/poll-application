<template>
    <b-card header="Polls created" class="text-center" border-variant="dark" style="max-width: 50%;">
        <b-list-group>
            <div v-for="poll in polls">
                <b-list-group-item style="height: 3em;">
                <poll :poll="poll"></poll>
                </b-list-group-item>
            </div>
            <button @click="this.getPolls">GetData</button>
        </b-list-group>

    </b-card>
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