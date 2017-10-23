package cn.injava.forex.core.schedul;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.service.NewsService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 爬取新闻
 */
@Component
public class NewsTask implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(NewsTask.class);

    @Value("#{sysConfigProperties['forex.news.host']}")
    private String newsHost;

    //执行时间间隔(秒)
    @Value("#{sysConfigProperties['forex.news.period']}")
    private int period;

    @Resource
    private HtmlUnit htmlUnit;

    @Resource
    private NewsService newsService;



    @Override
    public void run() {

        while(true){
            readNews();

            try {
                Thread.sleep(period*1000);
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

        logger.debug("thread completed ！");
    }

    /**
     * 获取新闻
     */
    public void readNews() {
        final WebClient webClient = htmlUnit.getFastWebClient();
        try {

            logger.debug("开始一次新闻的请求");

            final HtmlPage page = webClient.getPage(newsHost);
            List<DomElement> newses = (List)page.getByXPath("//article[@class='articleItem']");

            for (DomElement element : newses){
                String[] newsInfo = element.asText().split("\n");
                String[] dateSource = newsInfo[1].split(" - ");

                String img = element.getElementsByTagName("img").get(0).getAttribute("src");
                String title = newsInfo[0];
                String date = dateSource[1];
                String source = dateSource[0].replace("提供者 ", "");
                String content = newsInfo[2];
                String type = "";

                if (title.contains("JPY") || title.contains("日元") || title.contains("日圆")){
                    type += "日元 ";
                }
                if (title.contains("USD") || title.contains("美元")){
                    type += "美元 ";
                }
                if (title.contains("EUR") || title.contains("欧元")){
                    type += "欧元 ";
                }
                if (title.contains("GBP") || title.contains("英镑")){
                    type += "英镑 ";
                }
                if (title.contains("CNH") || title.contains("人民币")){
                    type += "人民币 ";
                }
                if (title.contains("NZD") || title.contains("纽元")){
                    type += "纽元 ";
                }
                if (title.contains("AUD") || title.contains("澳元")){
                    type += "澳元 ";
                }
                if (title.contains("原油")){
                    type += "原油 ";
                }
                if (title.contains("黄金")){
                    type += "黄金 ";
                }

                News news = new News();
                news.setContent(content);
                news.setImageUrl(img);
                news.setSource(source);
                news.setTitle(title);
                news.setTime(date);
                news.setType(type);

                newsService.addNews(news);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

    }
}
