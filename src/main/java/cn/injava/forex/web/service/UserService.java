package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户service
 *
 * Created by Administrator on 2015/6/30.
 */
@Service
public class UserService {
    @Resource
    private CustomerDao customerDAO;

    /**
     * 用户注册
     * @return
     */
    public int userRegister(String userName, String email, String pasw){
        Customer customer = new Customer();
        customer.setPassword(pasw);
        customer.setEmail(email);
        customer.setName(userName);

        return customerDAO.insert(customer);
    }

    /**
     * 用户登陆
     * @param email
     * @param pasw
     * @return
     */
    public int userSign(String email, String pasw, HttpServletRequest request){
        int result = 0;
        Customer customer = customerDAO.getByEmail(email);

        if (customer == null){
            result = 1;
        }else if (!customer.getPassword().equals(pasw)){
            result = 2;
        }else {
            request.getSession().setAttribute(SystemConstant.S_USER, customer);
        }

        return result;
    }

    /**
     * 获取以登陆的用户
     * @param request
     * @return
     */
    public Customer loginedUser(HttpServletRequest request) {

        Customer user = (Customer)request.getSession().getAttribute(SystemConstant.S_USER);

        return user;
    }

    /**
     * 用户退出登陆
     * @param request
     */
    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute(SystemConstant.S_USER);
    }

}
