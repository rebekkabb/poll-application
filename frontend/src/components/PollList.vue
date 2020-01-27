<template>
    <b-card header="Polls created" class="text-center" border-variant="dark" style="max-width: 65%;">
        <b-list-group>
            <div v-for="poll in polls">
                <b-list-group-item>
                    <!-- <poll :poll="poll"></poll> --->
                    <h5>Title: {{poll.title}}</h5>
                        <br>
                        Options: {{poll.options}}
                        <br>
                        Multiple answers allowed: {{poll.multipleAnswers}}
                        <br>
                        Duplication check: {{poll.duplicationCheck}}
                    </b-list-group-item>
                </div>
                <br>
                <b-button @click="this.getPolls" variant="outline-dark">GetData</b-button>
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