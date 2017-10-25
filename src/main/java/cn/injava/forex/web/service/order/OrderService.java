package cn.injava.forex.web.service.order;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.dao.NewsDao;
import cn.injava.forex.web.dao.order.OrderMapper;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.PageModel;
import cn.injava.forex.web.model.order.Order;
import cn.injava.forex.web.model.order.OrderExample;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private OrderMapper orderMapper;

    /**
     * 获取财经日历
     * @param from
     * @param to
     * @return
     */
    public int insertOrUpdate(Order order){

        OrderExample example = new OrderExample();
        example.createCriteria().andTradingIdEqualTo(order.getTradingId())
                .andTradingPlatformEqualTo(SystemConstant.BROKER_OANDA);

        List<Order> orders = orderMapper.selectByExample(example);

        if (orders.size() > 0) {
            orderMapper.updateByExampleSelective(order, example);
        }else {
            orderMapper.insert(order);
        }

        return 1;
    }

    public int insert(Order order){
        order.setOpenTime(new Date());
        return orderMapper.insertSelective(order);
    }

    public int update(Order order){
        order.setCloseTime(new Date());
        return orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 根据第三方的交易号, 获取订单
     * @param tradeId
     * @return
     */
    public Order selectOrderByRradeId(String tradeId){
        OrderExample example = new OrderExample();
        example.createCriteria().andTradingIdEqualTo(tradeId)
                .andTradingPlatformEqualTo(SystemConstant.BROKER_OANDA);

        Order order = null;
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders.size() > 0){
            order = orders.get(0);
        }

        return order;
    }

}
