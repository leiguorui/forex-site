package cn.injava.forex.web.controller;

import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.system.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 订单
 *
 * Created by leiguorui on 2017/10/30.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String config(Model model,
                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {

        model.addAttribute("data", orderService.queryWithPage(pageNo));

        return "order/list";
    }
}
