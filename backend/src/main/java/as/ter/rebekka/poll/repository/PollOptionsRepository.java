package as.ter.rebekka.poll.repository;

import as.ter.rebekka.poll.model.PollOptionsModel;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollOptionsRepository extends CrudRepository<PollOptionsModel, Long> {

    @Query("SELECT * FROM poll_options WHERE poll_options.poll_id = :pollId")
    public List<PollOptionsModel> findAllByPollId(long pollId);

    @Query("SELECT option FROM poll_options WHERE poll_options.poll_id = :pollId")
    public List<String> findAllOptionValuesWithPollId(long pollId);

    @Modifying
    @Query("DELETE FROM poll_options WHERE poll_options.poll_id = :pollId")
    public void deleteAllOptionsWithPollId(long pollId);
}
