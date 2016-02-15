package cn.injava.forex.web.dao;

import cn.injava.forex.web.model.Customer;
import cn.injava.forex.web.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lei on 16-2-15.
 */
public interface NewsDao {
    public int insert(News news);
    public List<News> findByType(@Param("type") String type,
                                 @Param("start") int start,
                                 @Param("size") int size);
}
