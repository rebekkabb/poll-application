<template>
    <div>
        <h1>Create Poll</h1>
        <label>
            Title
            <input type="text" v-model="poll.title"/>
        </label>
        <label>
            Multiple answers
            <input type="checkbox" v-model="poll.multipleAnswers"/>
        </label>
        <label>
            Duplication check
            <input type="checkbox" v-model="poll.duplicationCheck">
        </label>
        <div v-for="(option, index) in poll.options">
            <label>
                Option {{index + 1}}
                <input type="text" v-model="poll.options[index]">
            </label>
        </div>
        <button @click="addOption">Add option</button>
        <button @click="sendPoll">Send poll</button>
        {{this.poll}}
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


        private sendPoll(): void {
            axios.put("/api/poll", this.poll).then((res) => {
                console.log(res);
            })
        }
    };
</script>