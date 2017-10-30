package cn.injava.forex.web.controller;

import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.PageModel;
import cn.injava.forex.web.service.NewsService;
import cn.injava.forex.web.service.system.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 系统配置
 *
 * Created by leiguorui on 2017/10/30.
 */
@Controller
@RequestMapping(value = "/sys")
public class SystemConfController {
    private static final Logger logger = LoggerFactory.getLogger(SystemConfController.class);

    @Resource
    private SystemService systemService;

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String config(Model model) {

        model.addAttribute("data", systemService.getSysConfig());

        return "system/config";
    }
}
