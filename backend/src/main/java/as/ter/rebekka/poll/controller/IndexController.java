package as.ter.rebekka.poll.controller;

import as.ter.rebekka.poll.route.DefaultRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @Autowired
    private DefaultRoute defaultRoute;

    @RequestMapping("/")
    public ModelAndView getDefault() {
        return new ModelAndView("index", defaultRoute.getDefault());
    }

    @RequestMapping(value = "/**/{[path:[^.]*}")
    public ModelAndView redirect() {
        // Forward to home page so that route is preserved.
        return getDefault();
    }
}
