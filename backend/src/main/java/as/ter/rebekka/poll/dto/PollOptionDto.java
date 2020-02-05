package as.ter.rebekka.poll.dto;

import as.ter.rebekka.poll.model.PollOptionsModel;

public class PollOptionDto {
    public long id;
    public String option;

    public PollOptionDto(PollOptionsModel pollOptionsModel) {
        this.id = pollOptionsModel.id;
        this.option = pollOptionsModel.option;
    }
    public PollOptionDto(){}
}
