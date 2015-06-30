package cn.injava.forex.web.service;

import cn.injava.forex.web.model.SubPrice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/30.
 */
@Service
public class SubService {
    List<SubPrice> subPrices = new ArrayList<>();

    public boolean addSubPrice(SubPrice subPrice) {
        return this.subPrices.add(subPrice);
    }

    public boolean removeSubPrice(SubPrice subPrice) {
        return this.subPrices.remove(subPrice);
    }

    public List<SubPrice> getSubPricesByProduct(String produce){
        List<SubPrice> subPricesByProduct = new ArrayList<>();
        for (SubPrice subPrice : subPrices){
            if (produce.equals(subPrice.getProduct())){
                subPricesByProduct.add(subPrice);
            }
        }
        return subPricesByProduct;
    }
}
