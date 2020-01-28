<template>
    <b-modal id="modal-center" centered title="Sign in">
        <b-input-group>
            <template v-slot:prepend>
                <b-input-group-text >Username</b-input-group-text>
            </template>
            <b-input type="text" v-model="user.name"/>
        </b-input-group>
        <br>
        <b-input-group>
            <template v-slot:prepend>
                <b-input-group-text >Password</b-input-group-text>
            </template>
            <b-input type="password" v-model="user.password"/>
        </b-input-group>

        <br>
        <template v-slot:modal-footer="{ ok, cancel, hide }">
            <b-button size="sm" variant="success" @click="signIn">Sign In</b-button>
        </template>
    </b-modal>
</template>
<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import UserSignInDto from "../dto/UserSignInDto";
    import axios from "axios";

    @Component
    export default class CreatePoll extends Vue {
        user: UserSignInDto = new UserSignInDto();

    };

</script>
<style>


</style>