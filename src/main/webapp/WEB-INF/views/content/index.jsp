<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>GameForest - Online Magazine Template</title>

<!-- ======= META TAGS ======= -->	
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
<!-- ======= STYLE SHEET ======= -->	
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/colors/blue.css" id="colors"/>

<!-- ======= STYLE SWITCHER ======= -->	
<link rel="stylesheet" href="css/styleswitcher.css">
</head>

<body>
	<!-- sub navigation -->
	<div id="sub-navigation">
		<c:import url="/common/page/sub_navigation.html" charEncoding="UTF-8">
		</c:import>
	</div>
	<!-- ./sub navigation -->
	
	<!-- top navigation -->
	<!-- ./top navigation -->
	
	<!-- header -->
	<header>
		<c:import url="/common/page/header.html" charEncoding="UTF-8">
		</c:import>
	</header>
	<!-- ./headerer -->
	
	<!-- slideshow -->
	<!-- ./slideshow -->


	<!-- wrapper -->
	<div class="container">
		<div id="wrapper" class="clearfix">
						<div class="col-md-8 no-padding">
							<div class="padding">
							<ul class="section-title no-margin-top clearfix">
									<li><h3>汇市新闻</h3></li>
							</ul>
							<div class="clearfix">
								<ul class="section-categories">
									<li><a href="#" class="active">全部</a></li>
									<li><a href="#">美元</a></li>
									<li><a href="#">欧元</a></li>
									<li><a href="#">日元</a></li>
									<li><a href="#">英镑</a></li>
									<li><a href="#">澳元</a></li>
									<li><a href="#">纽元</a></li>
									<li><a href="#">人民币</a></li>
								</ul>
							</div>

							
							<!-- section 新闻 -->
							<section class="clearfix" style="display: none">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h4></h4>
									<p></p>
                                    <div class="details">
                                        <i class="fa fa-calendar-o"> </i>
                                        <i class="glyphicon glyphicon-link"></i>来自 <a href="#"> </a>
                                    </div>
                                </div>
							</section>

							<button type="button" class="btn-flat btn btn-primary btn-lg btn-block btn-load" data-loading-text="正在加载...">加载更多...</button>
						</div>
						</div>
						
						
						<!-- sidebar section -->
						<div class="col-md-4 no-padding right-sidebar">
							<div id="sidebar" class="sidebar-alignment">
								<a href="#signin" data-toggle="modal" class="btn btn-success btn-block btn-flat"> <i class="fa fa-sign-in"></i> 免费订阅 新闻/技术分析</a>
								<!-- latest games -->
								<div class="sidebar-section">
									<div class="title"><i class="glyphicon glyphicon-stats"></i> 技术分析</div>
									<div class="categories">
										<ul>
											<li><a href="#EURUSD" data-toggle="tab" type="button" class="btn disabled">EURUSD</a></li>
											<li><a href="#AUDUSD" data-toggle="tab" type="button" class="btn">AUDUSD</a></li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="tab-content">
										<ul id="EURUSD" class="tab-pane fade in active content">
											<!-- row #1 -->
                                            <li class="clearfix hidden">

                                                <div class="details">
                                                    <div class="rate pull-left">
                                                        <span class="label label-success">牛市</span>
                                                    </div>

                                                    <div class="pull-left">
                                                        <h5><a href="sub_technical.html">EUR/USD</a> 5 分钟</h5>
                                                        <div><span class="category">移动平均指数: 购买 (5) 出售 (7)</span></div>
                                                        <div><span class="category">其他技术指标: 购买 (6) 出售 (1)</span></div>
                                                    </div>

                                                </div>
                                            </li>
										</ul>

										<ul id="AUDUSD" class="tab-pane fade content">
                                            <!-- row #1 -->
                                            <li class="clearfix hidden">

                                                <div class="details">
                                                    <div class="rate pull-left">
                                                        <span class="label label-success">牛市</span>
                                                    </div>

                                                    <div class="pull-left">
                                                        <h5><a href="sub_technical.html">AUD/USD</a> 5 分钟</h5>
                                                        <div><span class="category">移动平均指数: 购买 (5) 出售 (7)</span></div>
                                                        <div><span class="category">其他技术指标: 购买 (6) 出售 (1)</span></div>
                                                    </div>

                                                </div>
                                            </li>
										</ul>

									</div>
								</div>
								<!-- ./latest games -->
								
								<!-- latest news -->
								<div class="sidebar-section">
								<div class="title"><i class="fa fa-comments"></i> 大家都在说</div>
								<ul class="content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="col-md-2 thumbnail pull-left">
												<img src="holder.js/100%x48" alt="" />
										</div>
										<div class="details col-md-10">
											<div class="pull-left">
												<h5><a href="#">Caesar in Gaul Expansion</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="col-md-2 thumbnail pull-left">
											<img src="holder.js/100%x48" alt="" />
										</div>
										<div class="details col-md-10">
											<div class="pull-left">
												<h5><a href="#">Skullgirls Encore Re-Release</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="col-md-2 thumbnail pull-left">
											<img src="holder.js/100%x48" alt="" />
										</div>
										<div class="details col-md-10">
											<div class="pull-left">
												<h5><a href="#">Capture Mode Coming to GTA Online</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="col-md-2 thumbnail pull-left">
											<img src="holder.js/100%x48" alt="" />
										</div>
										<div class="details col-md-10">
											<div class="pull-left">
												<h5><a href="#">Titanfall PC Accessories</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #5 -->
									<li class="clearfix">
										<div class="col-md-2 thumbnail pull-left">
											<img src="holder.js/100%x48" alt="" />
										</div>
										<div class="details col-md-10">
											<div class="pull-left">
												<h5><a href="#">Uncharted in Space and Our Holiday</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
								</ul>
								</div>
								<!-- ./latest news -->

							</div>
						</div>
					<!-- ./sidebar section -->
			</div>
	</div>
	<!-- ./wrapper -->
	
	<!-- footer -->
	<footer>
		<c:import url="/common/page/footer.html" charEncoding="UTF-8">
		</c:import>
	</footer>	
	<!-- ./footer -->

	<!-- modal -->
	<c:import url="/common/page/modal.html" charEncoding="UTF-8">
	</c:import>
	<!-- ./modal -->
	
	<!-- Javascript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.bxslider.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/holder.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/service/user.js"></script>
	<script src="js/service/news.js"></script>
	<script src="js/service/technical.js"></script>
</body>
</html>