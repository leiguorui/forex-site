package cn.injava.forex.web.controller;

import cn.injava.forex.web.model.SubPrice;
import cn.injava.forex.web.service.SubPriceService;
import cn.injava.forex.web.service.SubService;
import cn.injava.forex.web.service.SubTechnicalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class WebController {
    @Resource
    private SubPriceService subPriceService;

    @Resource
    private SubTechnicalService subTechnicalService;

    @Resource
    private SubService subService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "content/index";
    }

    @RequestMapping(value = "/sub_price", method = RequestMethod.GET)
    public String sub_price(ModelMap model) {
        return "content/sub_price";
    }

    @RequestMapping(value = "/sub_price", method = RequestMethod.POST)
    @ResponseBody
    public String do_sub_price(String email, String product, double price) {
//        subPriceService.subPriceByEmailAsync(email, product, price);
        SubPrice subPrice = new SubPrice();
        subPrice.setEmail(email);
        subPrice.setPrice(price);
        subPrice.setProduct(product);
        subService.addSubPrice(subPrice);
        return "ok";
    }

    @RequestMapping(value = "/sub_technical", method = RequestMethod.GET)
    public String sub_technical(ModelMap model) {
        return "content/sub_technical";
    }

    @RequestMapping(value = "/sub_technical", method = RequestMethod.POST)
    @ResponseBody
    public String do_sub_technical(String email, String product, int period) {
        subTechnicalService.subByEmailAsync(email, product, period);
        return "ok";
    }
}