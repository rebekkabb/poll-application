package as.ter.rebekka.poll.controller;

import as.ter.rebekka.poll.route.PollRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/as/ter/rebekka/poll")
public class PollController {
    @Autowired
    private PollRoute pollRoute;

    @GetMapping("/") //GET requests to "/" mapped to this method
    public ModelAndView viewAllPolls() {
        return new ModelAndView("polls", pollRoute.viewAllPolls());
    }

    @PutMapping("/as/ter/rebekka/poll")
    public ModelAndView createPoll() {
        return new ModelAndView("poll_create", pollRoute.createPoll());
    }

    @PostMapping("/as/ter/rebekka/poll")
    public ModelAndView editPoll() {
        return new ModelAndView("poll_edit", pollRoute.editPoll());
    }

    //@RequestParam makes the query string param "pollName" into param pollName for editPoll method
    @GetMapping("/:pollName")
    public ModelAndView editPoll(@RequestParam("pollName") String pollName) {
        return new ModelAndView("poll_view", pollRoute.viewPoll(pollName));
    }
}
