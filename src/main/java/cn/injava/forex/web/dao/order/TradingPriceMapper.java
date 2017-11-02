package cn.injava.forex.web.dao.order;

import cn.injava.forex.web.model.order.TradingPrice;
import cn.injava.forex.web.model.order.TradingPriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradingPriceMapper {
    int countByExample(TradingPriceExample example);

    int deleteByExample(TradingPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradingPrice record);

    int insertSelective(TradingPrice record);

    List<TradingPrice> selectByExample(TradingPriceExample example);

    TradingPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradingPrice record, @Param("example") TradingPriceExample example);

    int updateByExample(@Param("record") TradingPrice record, @Param("example") TradingPriceExample example);

    int updateByPrimaryKeySelective(TradingPrice record);

    int updateByPrimaryKey(TradingPrice record);
}