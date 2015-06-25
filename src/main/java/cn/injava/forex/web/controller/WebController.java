package cn.injava.forex.web.controller;

import cn.injava.forex.web.service.SubPriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class WebController {
    @Resource
    private SubPriceService subPriceService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "content/index";
    }

    @RequestMapping(value = "/sub_price", method = RequestMethod.GET)
    public String sub_price(ModelMap model) {
        return "content/sub_price";
    }

    @RequestMapping(value = "/sub_price", method = RequestMethod.POST)
    public String do_sub_price(String email, String product, double price) {
        subPriceService.subPrice(email, product, price);
        return "ok";
    }
}