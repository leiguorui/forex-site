package cn.injava.forex.web.controller;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.PageModel;
import cn.injava.forex.web.model.SubModel;
import cn.injava.forex.web.model.YouKuVideo;
import cn.injava.forex.web.service.NewsService;
import cn.injava.forex.web.service.SubService;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Resource
    private NewsService newsService;

    /**
     * 获取新闻
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/type", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult news(String type, int pageNo, int pageSize) {
        OperationResult response;

        try {
            PageModel<News> result = newsService.getNewsByPage(type, pageNo, pageSize);
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }
}