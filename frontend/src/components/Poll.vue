<template>
    <div>
        <span>{{poll.title}}</span>
        <span>{{poll.url}}</span>
    </div>
</template>

<script lang="ts">
    import {Prop, Component, Vue} from "vue-property-decorator";
    import PollDto from "../dto/PollDto";

    @Component
    export default class Poll extends Vue {
        @Prop()
        poll?: PollDto;
    };
</script>