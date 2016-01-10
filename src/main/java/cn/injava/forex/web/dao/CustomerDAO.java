package cn.injava.forex.web.dao;

import cn.injava.forex.web.model.Customer;

/**
 * Created by lei on 16-1-10.
 */
public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public int initDatabase();
}
