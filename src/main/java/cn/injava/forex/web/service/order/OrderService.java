package cn.injava.forex.web.service.order;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.page.Page;
import cn.injava.forex.web.dao.order.TradingOrderMapper;
import cn.injava.forex.web.dao.order.TradingOrderMapperExt;
import cn.injava.forex.web.dao.order.TradingPriceMapper;
import cn.injava.forex.web.dao.technical.TradingSignalMapper;
import cn.injava.forex.web.model.order.*;
import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.model.technical.TradingSignalExample;
import org.apache.commons.collections.map.HashedMap;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 订单
 *
 * Created by Administrator on 2017/10/25.
 */
@Service
public class OrderService {
    @Resource
    private TradingOrderMapper orderMapper;
    @Resource
    private TradingOrderMapperExt orderMapperExt;
    @Resource
    private TradingSignalMapper tradingSignalMapper;
    @Resource
    private TradingPriceMapper tradingPriceMapper;

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
        orderMapperExt.insertSelectiveReturnId(order);
        return order.getId();
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

    public Page<OrderVo> queryWithPage(int pageNo){
        Page<OrderVo> page = new Page<>(pageNo, SystemConstant.PAGE_SIZE);

        TradingOrderExample example = new TradingOrderExample();
        example.createCriteria().andOpenTimeGreaterThanOrEqualTo(new DateTime().withTime(0, 0, 0, 0).toDate());
        example.setOrderByClause("id desc");

        orderMapperExt.selectByExampleAndPage(page, example);

        //设置获利价格
        for (OrderVo orderVo : page.getResult()){
            TradingSignalExample signalExample = new TradingSignalExample();
            signalExample.createCriteria().andOrderIdEqualTo(orderVo.getId());
            TradingSignal signal = tradingSignalMapper.selectByExample(signalExample).get(0);
            orderVo.setSignalSrc(signal.getPlatform());
            orderVo.setSignalUser(signal.getUserName());
        }

        return page;
    }

    /**
     * 获取订单的获利价格走势
     * @param orderId
     * @return
     */
    public List<TradingPrice> getProfitPrice(Integer orderId){
        TradingPriceExample priceExample = new TradingPriceExample();
        priceExample.createCriteria().andOrderIdEqualTo(orderId);
        return tradingPriceMapper.selectByExample(priceExample);
    }

    public Page<OrderVo> queryWithPagePrice(int pageNo){
        Page<OrderVo> page = new Page<>(pageNo, SystemConstant.PAGE_SIZE);

        TradingOrderExample example = new TradingOrderExample();
        example.createCriteria().andOpenTimeGreaterThanOrEqualTo(new DateTime().withTime(0, 0, 0, 0).toDate());
        example.setOrderByClause("id desc");

        orderMapperExt.selectByExampleAndPage(page, example);

        //设置获利价格
        for (OrderVo orderVo : page.getResult()){
            TradingPriceExample priceExample = new TradingPriceExample();
            priceExample.createCriteria().andOrderIdEqualTo(Integer.parseInt(orderVo.getTradingId()));
            orderVo.setTradingPrices(tradingPriceMapper.selectByExample(priceExample));

            TradingSignalExample signalExample = new TradingSignalExample();
            signalExample.createCriteria().andOrderIdEqualTo(orderVo.getId());
            TradingSignal signal = tradingSignalMapper.selectByExample(signalExample).get(0);
            orderVo.setSignalSrc(signal.getPlatform());
            orderVo.setSignalUser(signal.getUserName());
        }

        return page;
    }

    /**
     * 交易统计信息
     * @param dateTime
     * @return
     */
    public Map<String, Object> orderStat(DateTime dateTime){

        TradingOrderExample example = new TradingOrderExample();
        example.createCriteria()
                .andOpenTimeBetween(dateTime.millisOfDay().withMinimumValue().toDate(), dateTime.millisOfDay().withMaximumValue().toDate());
        List<TradingOrder> orders = orderMapper.selectByExample(example);

        TradingSignalExample signalExample = new TradingSignalExample();
        signalExample.createCriteria()
                .andCreateTimeBetween(dateTime.millisOfDay().withMinimumValue().toDate(), dateTime.millisOfDay().withMaximumValue().toDate());
        List<TradingSignal> signals = tradingSignalMapper.selectByExample(signalExample);


        //盈利订单数
        int profitOrders = 0;
        //亏损订单数
        int loseOrders = 0;
        //总订单数
        int ordersCount = 0;
        //持仓数量
        int holdCount = 0;
        //获利或亏损点数
        float profitAmount = 0;
        for (TradingOrder order : orders){
            ordersCount++;
            if (order.getProfitPips() == null){
                holdCount++;
            }else if (order.getProfitPips() > 0){
                profitOrders++;
            }else if (order.getProfitPips() < 0){
                loseOrders++;
            }

            if (order.getProfitPips() != null){
                profitAmount = profitAmount + order.getProfitPips();
            }

        }

        int signalCount = 0;
        int usefulSignal = 0;
        for (TradingSignal signal : signals){
            signalCount++;
            if (signal.getProfitPrice() != null){
                usefulSignal++;
            }
        }

        Map<String, Object> result = new TreeMap();
        result.put("profitOrders", profitOrders);
        result.put("loseOrders", loseOrders);
        result.put("ordersCount", ordersCount);
        result.put("signalCount", signalCount);
        result.put("usefulSignal", usefulSignal);
        result.put("holdCount", holdCount);
        result.put("profitAmount", profitAmount);

        return result;
    }

    public int addOrderPrice(TradingPrice price){

        price.setCreateTime(new Date());

        return tradingPriceMapper.insertSelective(price);
    }
}
