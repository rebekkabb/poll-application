package as.ter.rebekka.poll.dto;

import java.util.List;

public class PollDto {
    public long id;
    public String title;
    public Boolean multipleAnswers;
    public Boolean duplicationCheck;
    public List<PollOptionDto> options;
}
