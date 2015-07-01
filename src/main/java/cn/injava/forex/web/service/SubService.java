package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SubTypeConstant;
import cn.injava.forex.web.model.SubModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/30.
 */
@Service
public class SubService {
    List<SubModel> subModels = new ArrayList<>();

    public boolean addSubPrice(SubModel subModel) {
        return this.subModels.add(subModel);
    }

    public boolean removeSubPrice(SubModel subModel) {
        return this.subModels.remove(subModel);
    }

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
}
