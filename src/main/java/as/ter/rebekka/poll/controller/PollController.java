package as.ter.rebekka.poll.controller;

import as.ter.rebekka.poll.route.DefaultRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/poll")
public class PollController {
    @Autowired
    private DefaultRoute defaultRoute;

    @GetMapping("/")
    public ModelAndView getDefault() {
        return new ModelAndView("index", defaultRoute.getDefault());
    }

    @GetMapping("/create")
    public ModelAndView getCreate() {
        return new ModelAndView("create", defaultRoute.getCreate());
    }
}
