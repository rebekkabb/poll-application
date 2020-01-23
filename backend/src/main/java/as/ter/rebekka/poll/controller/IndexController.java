package as.ter.rebekka.poll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @RequestMapping("/")
    public ModelAndView getDefault() {
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/**/{[path:[^.]*}")
    public ModelAndView redirect() {
        // Forward to home page so that route is preserved.
        return getDefault();
    }
}
