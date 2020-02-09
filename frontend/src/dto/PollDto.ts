import PollOptionDto from "./PollOptionDto";

export default class PollDto {
    id?: number;
    title: String = "";
    multipleAnswers: boolean = false;
    duplicationCheck: boolean = false;
    options: PollOptionDto[] = [];

    constructor() {

    }
}