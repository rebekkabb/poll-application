package as.ter.rebekka.poll.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Data
@Table("polls")
public class PollModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String title;
    public boolean duplicationCheck;
    public boolean multipleAnswers;
    public List<String> options;
}
