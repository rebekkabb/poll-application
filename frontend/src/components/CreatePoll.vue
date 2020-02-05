<template>
    <div>
        <b-card header="Create Poll" class="text-center" border-variant="dark" style="max-width: 65%;">
            <label>
                Title:<b-input id="tekst" type="text" v-model="poll.title"/>
            </label>
            <br>
            <b-button @click="addOption" size="sm" variant="outline-success">Add option</b-button>
            <br><br>
            <div v-for="(option, index) in poll.options">
                <b-input-group>
                    <template v-slot:prepend>
                        <b-input-group-text >Option {{index + 1}}</b-input-group-text>
                    </template>
                    <b-input type="text" v-model="poll.options[index]"/>
                    <b-input-group-append>
                        <b-button @click="deleteOption(index)" size="sm" variant="outline-danger">Delete option</b-button>
                    </b-input-group-append>
                </b-input-group>
                <br>
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
                this.$root.$emit('refreshPollList');
                this.poll = new CreatePollDto();
            })
        }

    };
</script>

<style>
    .check {
        margin-top: 30%;
    }
</style>