package cn.injava.forex.web.dao.order;

import cn.injava.forex.core.utils.page.Page;
import cn.injava.forex.web.model.order.OrderVo;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.TradingOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradingOrderMapperExt {
    int insertSelectiveReturnId(TradingOrder record);

    List<OrderVo> selectByExampleAndPage(Page<OrderVo> page, TradingOrderExample example);

}