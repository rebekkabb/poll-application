package as.ter.rebekka.poll.dto;

import java.util.List;

public class CreatePollDto {
    public String title;
    public Boolean multipleAnswers;
    public Boolean duplicationCheck;
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