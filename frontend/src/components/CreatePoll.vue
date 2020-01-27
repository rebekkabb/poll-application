<template>
    <div>
        <b-card header="Create Poll" class="text-center" border-variant="dark" style="max-width: 50%;">
            <label>
                Title:<b-input type="text" v-model="poll.title"/>
            </label>
            <br>
            <b-button @click="addOption" size="sm" variant="outline-dark">Add option</b-button>
            <br><br>
            <div v-for="(option, index) in poll.options">
                <label>
                    Option {{index + 1}}
                    <b-input type="text" v-model="poll.options[index]"/>
                    <b-button @click="deleteOption(index)" size="sm" variant="outline-danger">Delete option</b-button>
                </label>
            </div>

            <br><br>
            <label>
                Multiple answers
                <input type="checkbox" v-model="poll.multipleAnswers"/>
            </label>
            <br>
            <label>
                Duplication check
                <input type="checkbox" v-model="poll.duplicationCheck">
            </label>
            <br><br>
            <b-button @click="sendPoll" size="sm" variant="outline-dark">Send poll</b-button>
        </b-card>
        <div class="check">
            Check if the fields are workin:
            <br>
            {{this.poll}}
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import CreatePollDto from "../dto/CreatePollDto";
    import axios from "axios";

    @Component
    export default class CreatePoll extends Vue {
        poll: CreatePollDto = new CreatePollDto();

        private addOption(): void {
            this.poll.options.push("")
        }

        private deleteOption(index: number): void {
            this.$delete(this.poll.options, index);
        }

        private sendPoll(): void {
            axios.put("/api/poll", this.poll).then((res) => {
                console.log(res);
            })
        }
    };
</script>

<style>
    .check {
        margin-top: 30%;
    }
</style>