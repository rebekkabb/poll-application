<template>
    <div>
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
                        <br><br>
                        <b-button @click="deletePoll(poll.id)" variant="outline-danger" size="sm">Delete poll</b-button>
                    </b-list-group-item>
                </div>
                <br>
                <b-button @click="this.getPolls" variant="outline-dark">Get data</b-button>
            </b-list-group>
        </b-card>
        <b-button @click="viewPoll(11)" variant="outline-dark">View poll</b-button>
        {{polly}}
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
            },
        })

        export default class PollList extends Vue {
            polls: PollDto[] = [];
            polly: PollDto[] = [];

            constructor() {
                super();
                this.$root.$on('refreshPollList', this.getPolls)
            }

            created(){
                this.getPolls();
            }

            private getPolls(): void {
                axios.get("/api/poll").then((res) => {
                    this.polls = res.data;
                })
            }

            private deletePoll(id: number): void {
                axios.delete("/api/poll/" + id).then(() => {
                    this.getPolls()
                })
            }

            private viewPoll(id: number): void {
                axios.get("/api/poll/" + id).then((res) => {
                    this.polly = res.data;
                })
            }
        };
    </script>