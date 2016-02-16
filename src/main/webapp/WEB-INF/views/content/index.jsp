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
								<a href="#signin" data-toggle="modal" class="btn btn-success btn-block btn-flat">Sign in <i class="fa fa-sign-in"></i> GameForest</a>
								<!-- latest games -->
								<div class="sidebar-section">
									<div class="title"><i class="fa fa-gamepad"></i> Technical</div>
									<div class="categories">
										<ul>
											<li><a href="#EURUSD" data-toggle="tab">EURUSD</a></li>
											<li><a href="#AUDUSD" data-toggle="tab">AUDUSD</a></li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="tab-content">
										<ul id="EURUSD" class="tab-pane fade in active content">
											<!-- row #1 -->
											<c:forEach items="${technicals}" var="entry" varStatus="loop">
												<c:if test="${fn:containsIgnoreCase(entry.value.produtcName, 'eur-usd')}">
												<li class="clearfix">
													<div class="number pull-left">${entry.value.period}</div>
													<div class="details">
														<div class="pull-left">
															<h5><a href="#">${entry.value.produtcName}</a></h5>
															<span class="category">建议买入</span>
															<div class="sidebar-info line-height">${entry.value.maBuy} / ${entry.value.maSell}</div>
														</div>
														<div class="rate pull-right">
															<span class="label label-success">牛</span>
														</div>
													</div>
												</li>
												</c:if>
											</c:forEach>
										</ul>

										<ul id="AUDUSD" class="tab-pane fade content">
											<!-- row #1 -->
											<c:forEach items="${technicals}" var="entry" varStatus="loop">
												<c:if test="${fn:containsIgnoreCase(entry.value.produtcName, 'aud-usd')}">
													<li class="clearfix">
														<div class="number pull-left">${entry.value.period}</div>
														<div class="details">
															<div class="pull-left">
																<h5><a href="#">${entry.value.produtcName}</a></h5>
																<span class="category">建议买入</span>
																<div class="sidebar-info line-height">${entry.value.maBuy} / ${entry.value.maSell}</div>
															</div>
															<div class="rate pull-right">
																<span class="label label-success">牛</span>
															</div>
														</div>
													</li>
												</c:if>
											</c:forEach>
										</ul>

									</div>
								</div>
								<!-- ./latest games -->
								
								<!-- advertisement -->
								<div class="sidebar-section advertisement">
									<a href="#"><img src="holder.js/300x250" alt="" /></a>
								</div>
								<!-- ./advertisement -->
								
								<!-- latest news -->
								<div class="sidebar-section">
								<div class="title"><i class="fa fa-file-text-o"></i> 汇市新闻</div>
								<ul class="content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="details col-md-12 no-padding">
											<div class="icon-nav pull-left">
												<i class="fa fa-rss"></i>
											</div>
											<div class="pull-left">
												<h5><a href="#">Caesar in Gaul Expansion</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="details col-md-12 no-padding">
											<div class="icon-nav pull-left">
												<i class="fa fa-rss"></i>
											</div>
											<div class="pull-left">
												<h5><a href="#">Skullgirls Encore Re-Release</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="details col-md-12 no-padding">
											<div class="icon-nav pull-left">
												<i class="fa fa-rss"></i>
											</div>
											<div class="pull-left">
												<h5><a href="#">Capture Mode Coming to GTA Online</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="details col-md-12 no-padding">
											<div class="icon-nav pull-left">
												<i class="fa fa-rss"></i>
											</div>
											<div class="pull-left">
												<h5><a href="#">Titanfall PC Accessories</a></h5>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
										</div>
									</li>
								</ul>
								</div>
								<!-- ./latest news -->
								
								<!-- latest news -->
								<div class="sidebar-section">
								<div class="title"><i class="fa fa-comments"></i> Latest Comments</div>
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
								
								<!-- facebook -->
								<div class="sidebar-section">
								<div class="title"><i class="fa fa-thumbs-up"></i> Facebook</div>
									<div class="facebook-like-box">
										<iframe></iframe>
									</div>
								</div>
								<!-- ./facebook -->
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
</body>
</html>