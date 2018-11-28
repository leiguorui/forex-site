package cn.injava.forex.core.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 实例ImgUtil
 *
 * @author 雷国瑞
 * @version 1.0
 * @since 2018-09-21 16:25:14
 */
public class ImgUtil {

    public static Map uploadImg(String pathImg){
        Map uploadResult = new HashMap();

        try {

            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dzrhyep59",
                    "api_key", "446726652126984",
                    "api_secret", "rS4tFQNdLCTu6jEYtw7C0QLnUv8"));

            uploadResult = cloudinary.uploader().upload(pathImg, ObjectUtils.emptyMap());
        } catch (Exception e) {
            //do nothing
        }

        return uploadResult;
    }
}
