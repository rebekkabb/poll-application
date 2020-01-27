package as.ter.rebekka.poll.route;

import as.ter.rebekka.poll.dto.CreatePollDto;
import as.ter.rebekka.poll.dto.PollDto;
import as.ter.rebekka.poll.model.PollModel;
import as.ter.rebekka.poll.repository.PollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class PollRoute {
    @Autowired
    private PollRepository pollRepository;

    public List<PollDto> viewAllPolls() {
        final var polls = pollRepository.findAll();
        List<PollDto> pollDtos = new ArrayList<>();

        polls.forEach(pollModel -> {
            final var pollDto = new PollDto();
            pollDto.title = pollModel.title;
            pollDto.duplicationCheck = pollModel.duplicationCheck;
            pollDto.multipleAnswers = pollModel.multipleAnswers;
            pollDto.options = pollModel.options;
            pollDtos.add(pollDto);
        });
        return pollDtos;
    }

    public void createPoll(CreatePollDto createPollDto) {
        final var poll = new PollModel();
        poll.title = createPollDto.title;
        poll.duplicationCheck = createPollDto.duplicationCheck;
        poll.multipleAnswers = createPollDto.multipleAnswers;
        poll.options = createPollDto.options;
        pollRepository.save(poll);
    }

    public Map<String, Object> editPoll() {
        throw new RuntimeException("Not implemented");
    }

    public Map<String, Object> viewPoll(long pollId) {
        throw new RuntimeException("Not implemented");
    }

    public Map<String, Object> deletePoll(long pollId) {
        throw new RuntimeException("Not implemented");
    }
}
