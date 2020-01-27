package as.ter.rebekka.poll.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Table("poll_options")
public class PollOptionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String option;
    public long votes;
}
