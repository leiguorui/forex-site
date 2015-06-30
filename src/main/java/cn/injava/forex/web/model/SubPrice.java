package cn.injava.forex.web.model;

/**
 * 订阅价格的参数
 *
 * Created by Administrator on 2015/6/30.
 */
public class SubPrice {
    private String email;
    private String product;
    private double price;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
