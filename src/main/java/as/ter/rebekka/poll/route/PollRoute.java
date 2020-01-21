package as.ter.rebekka.poll.route;

import as.ter.rebekka.poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PollRoute {
    @Autowired
    private PollRepository pollRepository;

    public Map<String, Object> viewAllPolls() {
        throw new RuntimeException("Not implemented");
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
