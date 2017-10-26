package cn.injava.forex.web.dao.technical;

import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.model.technical.TradingSignalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradingSignalMapperExt {

    int insertSelectiveReturnId(TradingSignal record);

}