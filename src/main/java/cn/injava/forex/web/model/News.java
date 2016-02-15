package cn.injava.forex.web.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 新闻
 *
 * Created by Administrator on 2015/7/3.
 */
public class News {

    int id;
    //新闻类型
    String type;
    String title;
    String source;
    String content;
    String imageUrl;
    String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
