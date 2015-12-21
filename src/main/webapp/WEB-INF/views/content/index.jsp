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
	<div id="top-navigation">
		<c:import url="/common/page/top_navigation.html" charEncoding="UTF-8">
		</c:import>
	</div>
	<!-- ./top navigation -->
	
	<!-- header -->
	<header>
		<c:import url="/common/page/header.html" charEncoding="UTF-8">
		</c:import>
	</header>
	<!-- ./headerer -->
	
	<!-- slideshow -->
	<div class="container">
		<div class="bxslider-wrapper clearfix">
		<div class="bxslider">
			<div class="img">
				<img src="holder.js/100%x260" alt="" class="animated bounce" />
				<a href="#">
					<div class="title">
						<h2 class="animated fadeInLeft">Global news</h2>
						<div class="clearfix"></div>
						<h1 class="animated fadeInRight">Phasellus cursus justo at diam bibendum</h1>
						<div class="clearfix"></div>
						<p class="animated fadeInLeft">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas egestas, orci id ullamcorper tempor, justo libero condimentum orci.</p>
					</div>
				</a>
			</div>
			<div class="img">
				<img src="holder.js/100%x260" alt="" />
				<a href="#">
					<div class="title">
						<h2>Xbox One</h2>
						<div class="clearfix"></div>
						<h1>Sed mauris elit, blandit vitae volutpat ne</h1> 
						<div class="clearfix"></div>
						<p>Susspendisse eu dui in gravida condimentum....</p>
					</div>
				</a>
			</div>
			<div class="img">
				<img src="holder.js/100%x260" alt="" />
				<a href="#">
				<div class="title">
					<h2>PS4</h2>
					<div class="clearfix"></div>
					<h1>Vestibulum ante ipsum primis in faucibus</h1>
					<div class="clearfix"></div>
					<p>Quisque vestibulum pretium quam, nec scelerisque....</p>
				</div>
				</a>
			</div>
			<div class="img">
				<img src="holder.js/100%x260" alt="" />
				<a href="#">
				<div class="title">
					<h2>PS4</h2>
					<div class="clearfix"></div>
					<h1>Vestibulum ante ipsum primis in faucibus</h1>
					<div class="clearfix"></div>
					<p>Quisque vestibulum pretium quam, nec scelerisque....</p>
				</div>
				</a>
			</div>
		</div>
		<div id="bx-tabs">
				<div class="bx-nav pull-left col-md-3 no-padding"><a data-slide-index="0" href="#"><div class="bx-section"><h3>Phasellus cursus justo at diam</h3></div></a></div>
				<div class="bx-nav pull-left col-md-3 no-padding"><a data-slide-index="1" href="#"><div class="bx-section"><h3>Sed mauris elit, blandit vitae ne</h3></div></a></div>
				<div class="bx-nav pull-left col-md-3 no-padding"><a data-slide-index="2" href="#"><div class="bx-section"><h3>Vestibulum ante ipsum primis in</h3></div></a></div>
				<div class="bx-nav pull-left col-md-3 no-padding"><a data-slide-index="3" href="#"><div class="bx-section"><h3>Vestibulum ante ipsum primis in</h3></div></a></div>
		</div>
		<div class="clearfix"></div>
		<div id="progressbar"></div>
		</div>
	</div>
	<!-- ./slideshow -->


	<!-- wrapper -->
	<div class="container">
		<div id="wrapper" class="clearfix">
						<div class="col-md-8 no-padding">
							<div class="padding">
							<ul class="section-title no-margin-top clearfix">
									<li><h3>Latest News</h3></li>
							</ul>
							<div class="clearfix">
								<ul class="section-categories">
									<li><a href="#" class="active">All</a></li>
									<li><a href="#">PC</a></li>
									<li><a href="#">PS3</a></li>
									<li><a href="#">PS4</a></li>
									<li><a href="#">Xbox 360</a></li>
									<li><a href="#">Xbox One</a></li>
									<li><a href="#">WII U</a></li>
									<li><a href="#">PS VITA</a></li>
									<li><a href="#">Mobile</a></li>
									<li><a href="#">Vita</a></li>
									<li><a href="#">3DS</a></li>
									<li><a href="#">iPhone</a></li>
									<li><a href="#">Microsoft</a></li>
								</ul>
							</div>
							
							<!-- section  -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="post.html">Caesar in Gaul Expansion for Rome II</a></h3>
									<p>
										Donec elementum dolor eu mi elementum vulputate. Vivamus condimentum mauris laoreet eros lacinia tempus molestie elit ullamcorper. Fusce non mi nec nulla varius dictum. Cras condimentum, dolor eget consectetur fe..
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
				
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="#">Skullgirls Encore Re-Release Announced</a></h3>
									<p>
										Cras fringilla fringilla aliquam. Suspendisse eu dui in dui gravida condimentum. Vestibulum et condimentum lacus. Morbi vulputate metus eu risus euismod in mollis mauris feugiat. Vestibulum fermentum convallis...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
							
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="#">Capture Mode Coming to GTA Online</a></h3>
									<p>
										Maecenas facilisis, ipsum eget ornare semper, arcu nisi porttitor elit, pellentesque bibendum quam lectus sed massa. Nunc accumsan arcu nec velit aliquam rhoncus. Phasellus rutrum ligula vel eros faucibus porta...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
							
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="#">Titanfall PC Accessories Debuted</a></h3>
									<p>
										Vestibulum ligula metus, aliquet vel fringilla vitae, vestibulum in magna. Ut dignissim suscipit odio at placerat. Nullam hendrerit nunc id felis tempus ut euismod risus scelerisque. Class aptent taciti sociosqu ad litora...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
							
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="#">Supernatural Delivers an Emotional Episode</a></h3>
									<p>
										Maecenas facilisis, ipsum eget ornare semper, arcu nisi porttitor elit, pellentesque bibendum quam lectus sed massa. Nunc accumsan arcu nec velit aliquam rhoncus. Phasellus rutrum ligula vel eros faucibus porta...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
							
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
								<div class="col-md-10">
									<h3><a href="#">Peter Molyneux with Fable 3</a></h3>
									<p>
										Vestibulum ligula metus, aliquet vel fringilla vitae, vestibulum in magna. Ut dignissim suscipit odio at placerat. Nullam hendrerit nunc id felis tempus ut euismod risus scelerisque. Class aptent taciti sociosqu ad litora...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
								</div>
							</section>
							
							<ul class="section-title clearfix">
									<li><h3> 本周重要的财经日历</h3></li>
									<li class="pull-right"><a href="#" class="btn btn-default"><i class="fa fa-film"></i> 查看所有财经日历</a></li>
							</ul>
							<section class="clearfix">
								<div class="col-md-12 no-padding">
									<%--<iframe src="http://ec.cn.forexprostools.com?columns=exc_flags,exc_currency,exc_importance,exc_actual,exc_forecast,exc_previous&importance=3&countries=37,6,110,14,48,46,32,17,10,36,35,72,22,41,25,12,43,5,4,26,11,39,42&calType=week&timeZone=28&lang=6" width="636" height="467" frameborder="0" allowtransparency="true" marginwidth="0" marginheight="0"></iframe>--%>
								</div>
							</section>
							
							<ul class="section-title clearfix">
								<li><h3>Features</h3></li>
								<li class="pull-right"><a href="#" class="btn btn-default"><i class="fa fa-th"></i></a></li>
							</ul>
							<!-- section #1 -->
							<div class="row">
							<div class="col-md-6">
								<section class="clearfix pull-left no-margin">
									<h3><a href="#">Call of Duty: Ghosts</a></h3>
									<div class="thumbnail"><img src="holder.js/100%x100" alt="" /></div>
									<p>
										Donec elementum dolor eu mi elementum vulputate. Vivamus condimentum mauris laoreet eros lacinia tempus molestie elit ullamcorper. Fusce non mi nec nulla varius dictum. Cras condimentum, dolor eget consectetur feugiat, libero odio rhoncus neque, vitae porta erat eros sit amet sapien..
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i> 2</div>
								</section>
							</div>
							
							<!-- section #2 -->
							<div class="col-md-6">
								<section class="clearfix pull-left no-margin">
									<h3><a href="#">Battlefield 4 Multiplayer</a></h3>
									<div class="thumbnail"><img src="holder.js/100%x100" alt="" /></div>
									<p>
										Cras fringilla fringilla aliquam. Suspendisse eu dui in dui gravida condimentum. Vestibulum et condimentum lacus. Morbi vulputate metus eu risus euismod in mollis mauris feugiat. Vestibulum fermentum convallis purus, at vulputate arcu vestibulum quis. Nulla placerat orci ut arcu...
									</p>
									<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i> 2</div>
								</section>
							</div>
							</div>
							<div class="clearfix"></div>
							
							<ul class="section-title clearfix">
								<li><h3>Reviews</h3></li>
								<li class="pull-right"><a href="#" class="btn btn-default"><i class="fa fa-share"></i></a></li>
							</ul>
							<!-- section -->
							<section class="clearfix">
								<div class="pull-left col-md-2 no-padding"><img src="holder.js/100%x100" alt="" /></div>
									<div class="col-md-10">
										<h3><a href="#">Titanfall PC Accessories Debuted</a></h3>
										<p>
											Vestibulum ligula metus, aliquet vel fringilla vitae, vestibulum in magna. Ut dignissim suscipit odio at placerat. Nullam hendrerit nunc id felis tempus ut euismod risus scelerisque. Class aptent taciti sociosqu ad litora...
										</p>
										<div class="details"><i class="fa fa-calendar-o"></i> Jan 18, 2014 - 10:00 <span class="fa fa-caret-right"></span> <i class="fa fa-comments"></i><a href="#">2</a></div>
									</div>
								</section>
							<button type="button" class="btn-flat btn btn-primary btn-lg btn-block btn-load" data-loading-text="Loading...">Load More...</button>
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
								<div class="title"><i class="fa fa-file-text-o"></i> Latest News</div>
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
	
	<!-- Javascript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.bxslider.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/holder.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>