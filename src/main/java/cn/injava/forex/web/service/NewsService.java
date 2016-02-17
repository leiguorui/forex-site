package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.dao.NewsDao;
import cn.injava.forex.web.model.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

/**
 * 新闻
 *
 * Created by Administrator on 2016/2/15.
 */
@Service
public class NewsService {
    @Resource
    private NewsDao newsDao;

    @Value("#{sysConfigProperties['forex.calendar.url']}")
    private String calendarUrl;

    /**
     * 添加新闻
     * @param news
     * @return
     */
    public int addNews(News news){
        return newsDao.insert(news);
    }

    /**
     * 分页获取新闻
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageModel<News> getNewsByPage(String type, int pageNo, int pageSize){
        PageModel pageModel=new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setPageSize(pageSize);

        List<News> newses = newsDao.findByType(type, (pageNo - 1) * pageSize, pageSize);
        pageModel.setList(newses);

        return pageModel;
    }

    /**
     * 获取财经日历
     * @param from
     * @param to
     * @return
     */
    public String getCalendar(String from, String to){

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(calendarUrl, String.class);

        result = StringEscapeUtils.unescapeJson(result);

        return result;
    }

}
