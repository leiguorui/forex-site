package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SubTypeConstant;
import cn.injava.forex.web.model.Product;
import cn.injava.forex.web.model.SubModel;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 订阅报价、技术指标，单例service
 *
 * Created by Administrator on 2015/6/30.
 */
@Service
public class SubService {
    List<SubModel> subModels = new ArrayList<>();
    Map<String, Product> productMap = new HashMap<>();

    /**
     * 添加订阅者
     * @param subModel
     * @return
     */
    public boolean addSubPrice(SubModel subModel) {
        return this.subModels.add(subModel);
    }

    /**
     * 移除订阅者
     * @param subModel
     * @return
     */
    public boolean removeSubPrice(SubModel subModel) {
        return this.subModels.remove(subModel);
    }

    /**
     * 获取订阅报价的人
     * @param produce
     * @return
     */
    public List<SubModel> getSubPricesByProduct(String produce){
        List<SubModel> subPricesByProduct = new ArrayList<>();
        for (SubModel sub : subModels){
            if (SubTypeConstant.sub_price.equals(sub.getSubType()) &&
                    produce.equals(sub.getProduct())){
                subPricesByProduct.add(sub);
            }
        }
        return subPricesByProduct;
    }

    /**
     * 获取订阅技术指标的人
     * @param produce
     * @param period
     * @return
     */
    public List<SubModel> getSubTechnicalByProductAndPeriod(String produce, int period){
        List<SubModel> subs = new ArrayList<>();
        for (SubModel sub : subModels){
            if (SubTypeConstant.sub_technical.equals(sub.getSubType()) &&
                    period == sub.getPeriod()){
                subs.add(sub);
            }
        }
        return subs;
    }

    /**
     * 添加货币对
     * @param product
     */
    public void setProduct(Product product) {
        this.productMap.put(product.getProductName(), product);
    }

    /**
     * 返回所有的货币对
     * @return
     */
    public Map<String, Product> getProducts() {
        return this.productMap;
    }
}
