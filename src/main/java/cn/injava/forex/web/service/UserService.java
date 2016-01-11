package cn.injava.forex.web.service;

import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
