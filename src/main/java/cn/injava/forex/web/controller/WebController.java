package cn.injava.forex.web.controller;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.SubModel;
import cn.injava.forex.web.model.YouKuVideo;
import cn.injava.forex.web.service.SubService;
import cn.injava.forex.web.service.TradeViewService;
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
public class WebController {
    @Resource
    private SubService subService;

    @Resource
    private HtmlUnit htmlUnit;

    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private static final Logger logger =
            LoggerFactory.getLogger(WebController.class);


    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "content/index";
    }

    /**
     * 订阅报价
     * @param model
     * @return
     */
    @RequestMapping(value = "/sub_price", method = RequestMethod.GET)
    public String sub_price(ModelMap model) {
        model.addAttribute("products", subService.getProducts());
        return "content/sub_price";
    }

    @RequestMapping(value = "/sub_price", method = RequestMethod.POST)
    @ResponseBody
    public String do_sub_price(String email, String product, BigDecimal price) {
//        subPriceService.subPriceByEmailAsync(email, product, price);
        SubModel subModel = new SubModel();
        subModel.setEmail(email);
        subModel.setPrice(price);
        subModel.setProduct(product);
        subModel.setSubType(SystemConstant.sub_price);
        subService.addSubPrice(subModel);
        return "ok";
    }

    /**
     * 订阅技术分析
     * @param model
     * @return
     */
    @RequestMapping(value = "/sub_technical", method = RequestMethod.GET)
    public String sub_technical(ModelMap model) {
        model.addAttribute("technicals", subService.getTechnicals());
        return "content/sub_technical";
    }

    /**
     * 订阅一个时段的技术分析
     * @param email
     * @param product
     * @param period
     * @return
     */
    @RequestMapping(value = "/sub_technical", method = RequestMethod.POST)
    @ResponseBody
    public String do_sub_technical(String email, String product, int period) {
        SubModel subModel = new SubModel();
        subModel.setEmail(email);
        subModel.setPeriod(period);
        subModel.setProduct(product);
        subModel.setSubType(SystemConstant.sub_technical);
        subService.addSubPrice(subModel);
        return "ok";
    }

    /**
     * 订阅多个时段的技术分析
     * @param email
     * @param product
     * @param periods
     * @return
     */
    @RequestMapping(value = "/sub_technical_periods", method = RequestMethod.POST)
    @ResponseBody
    public String do_sub_technical_periods(String email, String product, int[] periods) {
        SubModel subModel = new SubModel();
        subModel.setEmail(email);
        subModel.setPeriods(periods);
        subModel.setProduct(product);
        subModel.setSubType(SystemConstant.sub_technical);
        subService.addSubPrice(subModel);
        return "ok";
    }

    /**
     * 视频页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    public String videos(ModelMap model) {
        //TODO 这里应该转换成spring rest client
        final WebClient webClient = htmlUnit.getFastWebClient();
        try {
            final Page page = webClient.getPage("https://openapi.youku.com/v2/videos/by_user.json?client_id=7b4d1fbbc2359ab2&user_id=52643541&count=4");
            String response = page.getWebResponse().getContentAsString();

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();

            Type listType = new TypeToken<ArrayList<YouKuVideo>>() {}.getType();
            List<YouKuVideo> videos = gson.fromJson(jobject.getAsJsonArray("videos"), listType);

            model.addAttribute("videos", videos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "videos/videos";
    }

    /**
     * 财经日历
     * @param model
     * @return
     */
    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar(ModelMap model) {
        return "calendar/calendar";
    }
}