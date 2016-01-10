package test.service;

import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.dao.CustomerDAO;
import cn.injava.forex.web.model.Customer;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Green Lei on 2015/7/20 10:11.
 */
public class TestDao extends TestSupport {
    @Resource
    private CustomerDAO customerDAO;

    @Test
    public void test_initdatabase() {
        start();
        int rs = customerDAO.initDatabase();
        System.out.println(rs);
        end();
    }

    @Test
    public void test_dao() {
        start();
        Customer customer = new Customer();
        customer.setAge(28);
        customer.setName("你好");

        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
        end();
    }

}
