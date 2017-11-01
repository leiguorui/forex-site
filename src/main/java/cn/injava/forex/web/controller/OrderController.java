package cn.injava.forex.web.controller;

import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.system.SystemService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public String config(Model model, String date,
                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {

        model.addAttribute("data", orderService.queryWithPage(pageNo));

        DateTime dateTime = new DateTime();
        if (date != null){
            dateTime = new DateTime(date);
        }
        List<Map> stat = new ArrayList<>();
        for (int n = 0; n > -5; n--){
            Map orderStat = orderService.orderStat(dateTime.plusDays(n));
            orderStat.put("date", dateTime.plusDays(n).toString("MM-dd"));
            stat.add(orderStat);
        }

        model.addAttribute("stat", stat);

        return "order/list";
    }
}
