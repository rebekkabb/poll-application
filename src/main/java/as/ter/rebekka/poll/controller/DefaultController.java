package as.ter.rebekka.poll.controller;

import as.ter.rebekka.poll.route.PollRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DefaultController {
    @Autowired
    private PollRoute pollRoute;

    @GetMapping("/")
    public ModelAndView viewAllPolls() {
        return new ModelAndView("polls", pollRoute.viewAllPolls());
    }

    @PutMapping("/poll")
    public ModelAndView createPoll() {
        return new ModelAndView("poll_create", pollRoute.createPoll());
    }

    @PostMapping("/poll")
    public ModelAndView editPoll() {
        return new ModelAndView("poll_edit", pollRoute.editPoll());
    }

    @GetMapping("/:pollName")
    public ModelAndView editPoll(@RequestParam("pollName") String pollName) {
        return new ModelAndView("poll_view", pollRoute.viewPoll(pollName));
    }
}
