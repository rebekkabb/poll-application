package as.ter.rebekka.poll.repository;

import as.ter.rebekka.poll.model.PollOptionsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollOptionsRepository extends CrudRepository<PollOptionsModel, Long> {
}
