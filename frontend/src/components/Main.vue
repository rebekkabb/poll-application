<template>
    <div class="everything">
        <b-row>
            <b-col>
                <create-poll></create-poll>
            </b-col>
            <b-col>
                <poll-list></poll-list>
            </b-col>
        </b-row>
    </div>
</template>

<script lang="ts">
    import {Component, Vue} from "vue-property-decorator";
    import Hello from "./Hello.vue";
    import Poll from "./Poll.vue";
    import CreatePoll from "./CreatePoll.vue";
    import PollList from "./PollList.vue";

    @Component({
        components: {
            Hello,
            Poll,
            CreatePoll,
            PollList
        }
    })
    export default class Main extends Vue {
    };
</script>


<style>
    .everything {
        margin-left: 22%;
        margin-right: 10%;
        margin-top: 5%;
    }
</style>