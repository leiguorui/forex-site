package cn.injava.forex.web.dao;

import cn.injava.forex.web.model.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库操作
 *
 * Created by lei on 16-1-10.
 */
@Repository
public class JdbcCustomerDAO implements CustomerDAO {
    @Resource
    private DataSource dataSource;

    public void insert(Customer customer){

        String sql = "INSERT INTO CUSTOMER " +
                "(NAME, AGE) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getAge());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Customer findByCustomerId(int custId){

        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCustId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setAge(rs.getInt("Age"));
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public int initDatabase(){

        String sql = "CREATE TABLE custom4\n" +
                "(\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  name CHAR(50),\n" +
                "  age INT,\n" +
                "  account CHAR(50),\n" +
                "  password CHAR(50),\n" +
                "  email CHAR(50)\n" +
                ");\n";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            int rs = ps.executeUpdate();

            ps.close();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}