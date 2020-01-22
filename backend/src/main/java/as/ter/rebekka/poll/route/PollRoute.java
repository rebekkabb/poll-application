package as.ter.rebekka.poll.route;

import as.ter.rebekka.poll.dto.PollDto;
import as.ter.rebekka.poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PollRoute {
    @Autowired
    private PollRepository pollRepository;

    public List<PollDto> viewAllPolls() {
        final var poll1 = new PollDto();
        poll1.title = "test";
        poll1.url = "blah";
        return List.of(poll1);
    }

    public Map<String, Object> createPoll() {
        throw new RuntimeException("Not implemented");
    }

    public Map<String, Object> viewPoll(String pollName) {
        throw new RuntimeException("Not implemented");
    }

    public Map<String, Object> editPoll() {
        throw new RuntimeException("Not implemented");
    }
}
