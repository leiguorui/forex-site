package cn.injava.forex.web.controller;

import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.PageModel;
import cn.injava.forex.web.model.Technical;
import cn.injava.forex.web.service.NewsService;
import cn.injava.forex.web.service.SubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    /**
     * 获取所有的技术分析
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult all() {
        OperationResult response;

        try {
            Map<String, Technical> result = subService.getTechnicals();
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }
}