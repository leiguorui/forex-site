package cn.injava.forex.web.service.order;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.dao.order.TradingOrderMapper;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.TradingOrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 订单
 *
 * Created by Administrator on 2017/10/25.
 */
@Service
public class OrderService {
    @Resource
    private TradingOrderMapper orderMapper;

    /**
     * 获取财经日历
     * @param from
     * @param to
     * @return
     */
    public int insertOrUpdate(TradingOrder order){

        TradingOrderExample example = new TradingOrderExample();
        example.createCriteria().andTradingIdEqualTo(order.getTradingId())
                .andTradingPlatformEqualTo(SystemConstant.BROKER_OANDA);

        List<TradingOrder> orders = orderMapper.selectByExample(example);

        if (orders.size() > 0) {
            orderMapper.updateByExampleSelective(order, example);
        }else {
            orderMapper.insert(order);
        }

        return 1;
    }

    public int insert(TradingOrder order){
        order.setOpenTime(new Date());
        return orderMapper.insertSelective(order);
    }

    public int update(TradingOrder order){
        order.setCloseTime(new Date());
        return orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 根据第三方的交易号, 获取订单
     * @param tradeId
     * @return
     */
    public TradingOrder selectOrderByRradeId(String tradeId){
        TradingOrderExample example = new TradingOrderExample();
        example.createCriteria().andTradingIdEqualTo(tradeId)
                .andTradingPlatformEqualTo(SystemConstant.BROKER_OANDA);

        TradingOrder order = null;
        List<TradingOrder> orders = orderMapper.selectByExample(example);
        if (orders.size() > 0){
            order = orders.get(0);
        }

        return order;
    }

}
