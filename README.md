#### 待处理的bug
+ 发送email时，只能发送到green_forex邮箱，发送到别的邮箱报错


mvn -Dtest=TestSubTechnical#test_se test

+ htmlunit 执行js时内存溢出:JS executor for com.gargoylesoftware.htmlunit.WebClient Java heap space, 需要把内存设置为-Xmx1024M

#### 待新增的功能
+ 人机问答系统（对外汇交易的一些常见问题）
+ 订阅的页面中，显示价格和技术指标，以供参考
+ 在首页 Latest Games 模块中,添加一列"推荐"
+ 在http://localhost/gameforest/gallery.html页面添加视频教程和外汇市场节目等
+ 在http://localhost/gameforest/forums.html页面添加论坛
+ 在http://localhost/gameforest/timeline.html页面今天将要发布的重要新闻,以及该新闻的历史数据,数据对汇价的影响等

+ 外汇市场节目更新后,立即推送
+ 新页面中播放视频
+ 某种货币在一小时内波动超过1000点,则提示

#### 待优化的功能
+ logback.xml 中， 不同的线程打印到不同的文件中
+ http请求中,不需要执行js的页面,使用restTemplate发送请求
+ OperationResult 类

#### 开发中，学习的一些教程
+ Spring MVC + Logback SLF4j example ：http://www.mkyong.com/spring-mvc/spring-mvc-logback-slf4j-example/
+ logback logback.xml常用配置详解 ：http://aub.iteye.com/blog/1101260

#### 访问链接
+   heroku: https://waihuitong.herokuapp.com/
+   阿里TAE: http://waihuitong.wx.jaeapp.com/