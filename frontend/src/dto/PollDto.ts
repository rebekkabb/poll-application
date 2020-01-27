export default interface PollDto {
    id: number;
    title: String;
    multipleAnswers: boolean;
    duplicationCheck: boolean;
    options: String[];
}