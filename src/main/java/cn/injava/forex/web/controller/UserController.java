package cn.injava.forex.web.controller;

import cn.injava.forex.web.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    /**
     * 用户注册
     * @param n
     * @param e
     * @param p
     * @return
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public String regist(String n, String e, String p) {
        userService.userRegister(n, e, p);
        return "ok";
    }

}