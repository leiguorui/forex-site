package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.dao.NewsDao;
import cn.injava.forex.web.model.*;
import org.springframework.stereotype.Service;

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

}
