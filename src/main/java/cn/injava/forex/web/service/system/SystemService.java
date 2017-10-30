package cn.injava.forex.web.service.system;

import cn.injava.forex.web.dao.NewsDao;
import cn.injava.forex.web.dao.system.SysConfigMapper;
import cn.injava.forex.web.model.system.SysConfig;
import cn.injava.forex.web.model.system.SysConfigExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统配置
 *
 * Created by leiguorui on 2017/10/30.
 */
@Service
public class SystemService {
    @Resource
    private SysConfigMapper configMapper;

    /**
     * 获取所有配置
     * @return
     */
    public Map<String, String> getSysConfig(){
        Map<String, String> result = new HashMap<>();

        SysConfigExample example = new SysConfigExample();
        example.createCriteria().andSysKeyIsNotNull();

        List<SysConfig> configs = configMapper.selectByExample(example);

        for (SysConfig config : configs){
            result.put(config.getSysKey(), config.getSysValue());
        }

        return result;
    }
}
