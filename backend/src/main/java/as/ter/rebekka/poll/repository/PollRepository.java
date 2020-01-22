package as.ter.rebekka.poll.repository;

import as.ter.rebekka.poll.model.PollModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<PollModel, Long> {
}
