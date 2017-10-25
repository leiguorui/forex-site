package cn.injava.forex.web.dao.technical;

import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.model.technical.TradingSignalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradingSignalMapper {
    int countByExample(TradingSignalExample example);

    int deleteByExample(TradingSignalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradingSignal record);

    int insertSelective(TradingSignal record);

    List<TradingSignal> selectByExample(TradingSignalExample example);

    TradingSignal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradingSignal record, @Param("example") TradingSignalExample example);

    int updateByExample(@Param("record") TradingSignal record, @Param("example") TradingSignalExample example);

    int updateByPrimaryKeySelective(TradingSignal record);

    int updateByPrimaryKey(TradingSignal record);
}