package cn.injava.forex.web.controller;

import cn.injava.forex.core.utils.OperationResult;
import cn.injava.forex.web.model.Customer;
import cn.injava.forex.web.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult regist(String n, String e, String p) {
        OperationResult response;

        try {
            int result = userService.userRegister(n, e, p);
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }

    /**
     * 用户登陆
     * @param e
     * @param p
     * @param request
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult signin(String e, String p,HttpServletRequest request) {
        OperationResult response;

        try {
            int result = userService.userSign(e, p, request);
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }

    /**
     * 获取登陆用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public OperationResult profile(HttpServletRequest request) {
        OperationResult response;

        try {
            Customer result = userService.loginedUser(request);
            response = OperationResult.buildSuccessResult("success", result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response = OperationResult.buildFailureResult("error");
        }

        return response;
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {

        try {
            userService.logout(request);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return new ModelAndView("redirect:/index.html");
    }

}