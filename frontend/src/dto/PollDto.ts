export default interface PollDto {
    title: String;
    multipleAnswers: boolean;
    duplicationCheck: boolean;
    options: String[];
}