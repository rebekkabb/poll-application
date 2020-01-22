export default class CreatePollDto {
    title?: String;
    multipleAnswers?: boolean;
    duplicationCheck?: boolean;
    options: String[] = [];
}