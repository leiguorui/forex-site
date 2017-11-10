package cn.injava.forex.web.controller;

import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.system.SystemService;
import cn.injava.forex.web.service.technical.TechnicalnvestingService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.MalformedURLException;
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
    @Resource
    private TechnicalnvestingService technicalnvestingService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String config(Model model, String date,
                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) throws MalformedURLException {

        //设置订单
        model.addAttribute("data", orderService.queryWithPage(pageNo));

        //设置统计
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

        //设置技术分析
        Map<String, String> technicals = technicalnvestingService.getTechnicals();
        model.addAttribute("technicals", technicals);

        return "order/list";
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult priceJson(Model model, String date,
                                      @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) throws MalformedURLException {

        Object data = orderService.queryWithPagePrice(pageNo).getResult();

        return OperationResult.buildSuccessResult("success", data);
    }
}
