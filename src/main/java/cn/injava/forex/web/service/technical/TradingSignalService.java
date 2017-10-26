package cn.injava.forex.web.service.technical;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.dao.order.TradingOrderMapper;
import cn.injava.forex.web.dao.technical.TradingSignalMapper;
import cn.injava.forex.web.dao.technical.TradingSignalMapperExt;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.TradingOrderExample;
import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.model.technical.TradingSignalExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by leiguorui on 2017/10/25.
 */
@Service
public class TradingSignalService {
    @Resource
    private TradingSignalMapper signalMapper;
    @Resource
    private TradingSignalMapperExt signalMapperExt;

    /**
     * 新增信号, 如果存在相同, 则插入失败
     * @param signal
     * @return
     */
    public boolean insert(TradingSignal signal){

        TradingSignalExample example = new TradingSignalExample();
        example.createCriteria().andPlatformEqualTo(signal.getPlatform())
                .andUserNameEqualTo(signal.getUserName())
                .andCurrencyEqualTo(signal.getCurrency())
                .andPriceEqualTo(signal.getPrice());

        boolean result = false;
        if (signalMapper.selectByExample(example).size() < 1){
            signal.setCreateTime(new Date());

            signalMapperExt.insertSelectiveReturnId(signal);

            result = true;
        }

        return result;
    }

    public int update(TradingSignal signal){
        return signalMapper.updateByPrimaryKeySelective(signal);
    }

}
