package as.ter.rebekka.poll.controller;

import as.ter.rebekka.poll.dto.CreatePollDto;
import as.ter.rebekka.poll.dto.PollDto;
import as.ter.rebekka.poll.route.PollRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/poll")
public class PollController {
    @Autowired
    private PollRoute pollRoute;

    @GetMapping //GET requests to "/" mapped to this method
    public List<PollDto> viewAllPolls() {
        return pollRoute.viewAllPolls();
    }

    @PutMapping
    public void createPoll(@RequestBody CreatePollDto createPollDto) {
        pollRoute.createPoll(createPollDto);
    }

    @PostMapping("/:pollId")
    public void editPoll(@RequestParam("pollId") long pollId, @RequestBody CreatePollDto createPollDto) {
        throw new RuntimeException("Not implemented");
    }

    @GetMapping("/:pollId")
    public PollDto viewPoll(@RequestParam("pollId") long pollId) {
        throw new RuntimeException("Not implemented");
    }

    @DeleteMapping("/{pollId}")
    public void deletePoll(@PathVariable long pollId) {
        pollRoute.deletePoll(pollId);
    }
}
