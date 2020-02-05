
<template>
    <b-modal id="modal-edit" centered title="Edit poll">
        <label>
            Title:<b-input id="tekst" type="text" v-model="edit.title"/>
        </label>
        <br>
        <b-button @click="addOption" size="sm" variant="outline-success">Add option</b-button>
        <br><br>
        <div v-for="(option, index) in edit.options">
            <b-input-group>
                <template v-slot:prepend>
                    <b-input-group-text >Option {{index + 1}}</b-input-group-text>
                </template>
                <b-input type="text" v-model="edit.options[index]"/>
                <b-input-group-append>
                    <b-button @click="deleteOption(index)" size="sm" variant="outline-danger">Delete option</b-button>
                </b-input-group-append>
            </b-input-group>
            <br>
        </div>
        <br>
        <label>
            Multiple answers
            <input type="checkbox" v-model="edit.multipleAnswers"/>
        </label>
        <br>
        <label>
            Duplication check
            <input type="checkbox" v-model="edit.duplicationCheck">
        </label>
        <template v-slot:modal-footer="{ ok, cancel, hide }">
            <b-button @click="editPoll(poll.id)" variant="outline-dark" size="sm">Edit poll</b-button>
        </template>
    </b-modal>
</template>
<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import CreatePollDto from "../dto/CreatePollDto";
    import axios from "axios";

    @Component
    export default class CreatePoll extends Vue {
        edit: CreatePollDto = new CreatePollDto();

        private addOption(): void {
            this.edit.options.push("")
        }

        private deleteOption(index: number): void {
            this.$delete(this.edit.options, index);
        }

        private editPoll(id: number): void {
            axios.post("/api/poll/" + id, this.edit).then(() => {
                this.$root.$emit('refreshPollList');
            })
        }
    };

</script>