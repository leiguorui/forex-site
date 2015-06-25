<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>GameForest - Online Magazine Template</title>

<!-- ======= META TAGS ======= -->	
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
<!-- ======= STYLE SHEET ======= -->	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/colors/blue.css" id="colors"/>

<!-- ======= STYLE SWITCHER ======= -->	
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleswitcher.css">
</head>

<body>
	<!-- sub navigation -->
	<div id="sub-navigation">
		<c:import url="${pageContext.request.contextPath}/common/page/sub_navigation.html" charEncoding="UTF-8">
		</c:import>
	</div>
	<!-- ./sub navigation -->
	
	<!-- top navigation -->
	<div id="top-navigation">
		<c:import url="${pageContext.request.contextPath}/common/page/top_navigation.html" charEncoding="UTF-8">
		</c:import>
	</div>
	<!-- ./top navigation -->
	
	<!-- header -->
	<header>
		<c:import url="${pageContext.request.contextPath}/common/page/header.html" charEncoding="UTF-8">
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
									<li><h3>Latest Video</h3></li>
									<li class="pull-right"><a href="#" class="btn btn-default"><i class="fa fa-film"></i></a></li>
							</ul>
							<section class="clearfix">
								<div class="col-md-12 no-padding">
									<iframe width="100%" height="315" src="//www.youtube.com/embed/JxOM3-cNDA4" frameborder="0" allowfullscreen></iframe>
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
								<div class="title"><i class="fa fa-gamepad"></i> Latest Games</div>
								<div class="categories">
									<ul>
										<li><a href="#all" data-toggle="tab">All</a></li>
										<li><a href="#pc" data-toggle="tab">PC</a></li>
										<li><a href="#ps4" data-toggle="tab">PS4</a></li>
										<li><a href="#xboxone" data-toggle="tab">Xbox One</a></li>
									</ul>
								<div class="clearfix"></div>
								</div>
								<div class="tab-content">
								<ul id="all" class="tab-pane fade in active content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="number pull-left">1</div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Battlefield 4</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">60%</span>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="number pull-left">2</div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Tomb Raider</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">23%</span>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="number pull-left">3</div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Crysis 3</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">71%</span>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="number pull-left">4</div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Far Cry 3</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">45%</span>
											</div>
										</div>
									</li>
									
									<!-- row #5 -->
									<li class="clearfix">
										<div class="number pull-left">5</div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">GRID 2</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">25%</span>
											</div>
										</div>
									</li>
								</ul>
								
								<ul id="pc" class="tab-pane fade content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">GRID 2</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">60%</span>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Thief</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">40%</span>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Call of Duty: Ghost</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">70%</span>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Remember Me</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">10%</span>
											</div>
										</div>
									</li>
									
									<!-- row #5 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Assassins's Creed: Black...</a></h5>
												<span class="category">PC</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">80%</span>
											</div>
										</div>
									</li>
								</ul>
								
								<ul id="ps4" class="tab-pane fade content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">The Last of Us</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">80%</span>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Need for Speed: Rivals</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">50%</span>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Plants vs. Zombies 2</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">55%</span>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Gran Turismo 6</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">15%</span>
											</div>
										</div>
									</li>
									
									<!-- row #5 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Kill Zone</a></h5>
												<span class="category">PS4</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">25%</span>
											</div>
										</div>
									</li>
								</ul>
								
								<ul id="xboxone" class="tab-pane fade content">
									<!-- row #1 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Mortal Kombat</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">40%</span>
											</div>
										</div>
									</li>
									
									<!-- row #2 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Grand Theft Auto V</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">90%</span>
											</div>
										</div>
									</li>
									
									<!-- row #3 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">FIFA 14</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-danger">10%</span>
											</div>
										</div>
									</li>
									
									<!-- row #4 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Metro: Last Light</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-warning">20%</span>
											</div>
										</div>
									</li>
									
									<!-- row #5 -->
									<li class="clearfix">
										<div class="thumb pull-left"><img src="holder.js/36x48" alt="" /></div>
										<div class="details">
											<div class="pull-left">
												<h5><a href="#">Need for Speed</a></h5>
												<span class="category">XBOX ONE</span>
												<div class="sidebar-info line-height">May 22, 2013 - <a href="#">14 Comments</a></div>
											</div>
											<div class="rate pull-right">
												<span class="label label-success">60%</span>
											</div>
										</div>
									</li>
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
										<iframe src="//www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2Fenvato&amp;width=298&amp;height=258&amp;show_faces=true&amp;colorscheme=light&amp;stream=false&amp;show_border=false&amp;header=false&amp;appId=508045159210483" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:298px; height:258px;" allowTransparency="true"></iframe>
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
		<c:import url="${pageContext.request.contextPath}/common/page/footer.html" charEncoding="UTF-8">
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