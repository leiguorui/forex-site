package cn.injava.forex.web.dao;

import cn.injava.forex.web.model.Customer;

/**
 * Created by lei on 16-1-10.
 */
public interface CustomerDao {
    public int insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public Customer getByEmail(String email);
}
