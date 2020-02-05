package as.ter.rebekka.poll.route;

import as.ter.rebekka.poll.dto.CreatePollDto;
import as.ter.rebekka.poll.dto.PollDto;
import as.ter.rebekka.poll.model.PollModel;
import as.ter.rebekka.poll.model.PollOptionsModel;
import as.ter.rebekka.poll.repository.PollOptionsRepository;
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

    @Autowired
    private PollOptionsRepository pollOptionsRepository;

    public List<PollDto> viewAllPolls() {
        final var polls = pollRepository.findAll();
        //final var poll_options = pollOptionsRepository.findAll();
        List<PollDto> pollDtos = new ArrayList<>();

        polls.forEach(pollModel -> {
            final var pollDto = new PollDto();
            pollDto.id = pollModel.id;
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

        System.out.println(poll.id);

        pollRepository.save(poll);

        System.out.println(poll.id);

        if(createPollDto.options.size() > 0){
            createPollDto.options.forEach(option -> {
                final var poll_option = new PollOptionsModel();
                poll_option.poll_id = poll.id;
                poll_option.option = option;
                pollOptionsRepository.save(poll_option);
            });
        }
    }

    public void editPoll(long pollId, CreatePollDto createPollDto) {
        var poll = pollRepository.findById(pollId);
        PollModel pollModel = new PollModel();
        if(poll.isPresent()){
            pollModel = poll.get();
            pollModel.title = createPollDto.title;
            pollModel.multipleAnswers = createPollDto.multipleAnswers;
            pollModel.duplicationCheck = createPollDto.duplicationCheck;
            pollModel.options = createPollDto.options;
        }else {
            System.out.println("Poll not found!");
        }
        pollRepository.save(pollModel);
    }

    public PollDto viewPoll(long pollId) {
        var poll = pollRepository.findById(pollId);
        final var pollDto = new PollDto();
        if(poll.isPresent()){
            PollModel pollModel = poll.get();
            pollDto.id = pollModel.id;
            pollDto.title = pollModel.title;
            pollDto.duplicationCheck = pollModel.duplicationCheck;
            pollDto.multipleAnswers = pollModel.multipleAnswers;
            pollDto.options = pollModel.options;
        }else {
            System.out.println("Poll not found!");
        }
        return pollDto;
    }

    public void deletePoll(long pollId) {
        pollRepository.deleteById(pollId);
    }
}
