package as.ter.rebekka.poll.dto;

import java.util.List;

public class CreatePollDto {
    public long id;
    public String title;
    public Boolean multipleAnswers = false;
    public Boolean duplicationCheck = false;
    public List<String> options;

    @Override
    public String toString() {
        return "CreatePollDto{" +
                "title='" + title + '\'' +
                ", multipleAnswers=" + multipleAnswers +
                ", duplicationCheck=" + duplicationCheck +
                ", options='" + options + '\'' +
                '}';
    }
}