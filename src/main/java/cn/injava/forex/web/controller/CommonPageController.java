package cn.injava.forex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2015/6/25.
 */
@Controller
@RequestMapping(value = "/common/page")
public class CommonPageController {

    @RequestMapping(value = "/sub_navigation", method = RequestMethod.GET)
    public String sub_navigation(ModelMap model) {
        return "common/sub_navigation";
    }

    @RequestMapping(value = "/top_navigation", method = RequestMethod.GET)
    public String top_navigation(ModelMap model) {
        return "common/top_navigation";
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String header(ModelMap model) {
        return "common/header";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(ModelMap model) {
        return "common/footer";
    }
}