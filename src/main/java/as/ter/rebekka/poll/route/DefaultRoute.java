package as.ter.rebekka.poll.route;

import as.ter.rebekka.poll.model.PollModel;
import as.ter.rebekka.poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;

@Service
public class DefaultRoute {
    @Autowired
    private PollRepository pollRepository;

    public Map<String, Object> getDefault() {
        return Map.of("title", "Hello World!");
    }

    public Map<String, Object> getCreate() {
        var poll = new PollModel();
        poll.title = "new poll";
        poll.timeCreated = LocalTime.now();
        pollRepository.save(poll);
        return Map.of(
                "title", poll.title,
                "time", poll.timeCreated
        );
    }
}
