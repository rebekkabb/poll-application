
<template>
    <b-modal id="modal-edit" centered title="Edit poll">
        <label>
            Title:<b-input id="tekst" type="text" v-model="editedPoll.title"/>
        </label>
        <br>
        <b-button @click="addOption" size="sm" variant="outline-success">Add option</b-button>
        <br><br>
        <div v-for="(option, index) in editedPoll.options">
            <b-input-group>
                <template v-slot:prepend>
                    <b-input-group-text >Option {{index + 1}}</b-input-group-text>
                </template>
                <b-input type="text" v-model="editedPoll.options[index].option"/>
                <b-input-group-append>
                    <b-button @click="deleteOption(index)" size="sm" variant="outline-danger">Delete option</b-button>
                </b-input-group-append>
            </b-input-group>
            <br>
        </div>
        <br>
        <label>
            Multiple answers
            <input type="checkbox" v-model="editedPoll.multipleAnswers"/>
        </label>
        <br>
        <label>
            Duplication check
            <input type="checkbox" v-model="editedPoll.duplicationCheck">
        </label>
        <template v-slot:modal-footer="{ ok, cancel, hide }">
            <b-button @click="editPoll" variant="outline-dark" size="sm">Edit poll</b-button>
        </template>
    </b-modal>
</template>
<script lang="ts">
    import {Component, Prop, Vue} from "vue-property-decorator";
    import PollDto from "../dto/PollDto";
    import PollOptionDto from "../dto/PollOptionDto";
    import axios from "axios";

    @Component
    export default class EditPoll extends Vue {
        editedPoll: PollDto = new PollDto();

        @Prop()
        editId: number | null = null;

        private addOption(): void {
            this.editedPoll.options.push(new PollOptionDto())
        }

        private deleteOption(index: number): void {
            this.$delete(this.editedPoll.options, index);
        }

        private editPoll(): void {
            axios.post("/api/poll/" + this.editedPoll.id, this.editedPoll).then(() => {
                this.$root.$emit('refreshPollList');
                this.$bvModal.hide("modal-edit");
            })
        }

        public showEditPoll(poll: PollDto) {
            this.editedPoll = JSON.parse(JSON.stringify(poll));
            this.$bvModal.show("modal-edit");
        }
    }

</script>