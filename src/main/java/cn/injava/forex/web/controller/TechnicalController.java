package cn.injava.forex.web.controller;

import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.model.technical.Technical;
import cn.injava.forex.web.service.SubService;
import cn.injava.forex.web.service.TradeViewService;
import cn.injava.forex.web.service.technical.TechnicalnvestingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 技术分析
 *
 * Created by Administrator on 2016/2/16.
 */
@Controller
@RequestMapping(value = "/technical")
public class TechnicalController {
    private static final Logger logger = LoggerFactory.getLogger(TechnicalController.class);

    @Resource
    private SubService subService;

    @Resource
    private TradeViewService tradeViewService;

    @Resource
    private TechnicalnvestingService technicalnvestingService;


    /**
     * 获取所有的技术分析
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult all() {
        OperationResult response;

        try {
            Map<String, Object> result = new LinkedHashMap<>();
            result.putAll(technicalnvestingService.getTechnicals());
            result.putAll(subService.getTechnicals());

            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }

    @RequestMapping(value = "/screenShot", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult screenShot(String currency) {
        OperationResult response;

        try {
            Object result = tradeViewService.screenShot(currency);
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }
}