export default class CreatePollDto {
    title: String = "";
    multipleAnswers: boolean = false;
    duplicationCheck: boolean = false;
    options: String[] = [];
}