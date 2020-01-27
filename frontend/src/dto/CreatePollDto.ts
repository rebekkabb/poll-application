export default class CreatePollDto {
    id?: number;
    title?: String;
    multipleAnswers?: boolean;
    duplicationCheck?: boolean;
    options: String[] = [];
}