package cn.injava.forex.core.common;

import cn.injava.forex.web.service.system.SystemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leiguorui on 2017/10/30.
 */
@Configuration
public class Config {
    @Resource
    private SystemService systemService;

    @Bean
    public Map<String, String> getSystemConfig() {
        return systemService.getSysConfig();
    }


}
