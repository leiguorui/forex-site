package cn.injava.forex.web.dao.order;

import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.TradingOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradingOrderMapper {
    int countByExample(TradingOrderExample example);

    int deleteByExample(TradingOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradingOrder record);

    int insertSelective(TradingOrder record);

    List<TradingOrder> selectByExample(TradingOrderExample example);

    TradingOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradingOrder record, @Param("example") TradingOrderExample example);

    int updateByExample(@Param("record") TradingOrder record, @Param("example") TradingOrderExample example);

    int updateByPrimaryKeySelective(TradingOrder record);

    int updateByPrimaryKey(TradingOrder record);
}