<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<div class="container">
			<ul id="user-interface">
				<li>
					<a href="#signin" data-toggle="modal">Login</a>
				</li>
				<li>
					<a href="#register" data-toggle="modal">Create Account</a>
				</li>
			</ul>
			<div id="top-social">
				<span>Receive daily updates:</span>
				<ul>
					<li><a href="#" class="tip facebook" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#" class="tip twitter" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#" class="tip youtube" data-toggle="tooltip" data-placement="bottom" title="Youtube"><i class="fa fa-youtube"></i></a></li>
				</ul>
			</div>
			<div class="to-top display-none"><a href="#"><i class="fa fa-chevron-up"></i></a></div>
		</div>
	</div>
	<!-- ./sub navigation -->
	
	<!-- top navigation -->
	<div id="top-navigation">
		<div class="container">
			<ul>
				<li><a href="#" class="active"><i class="fa fa-home"></i></a></li>
				<li><a href="#">PC</a></li>
				<li><a href="#">Xbox 360</a></li>
				<li><a href="#">Xbox One</a></li>
				<li><a href="#">PS3</a></li>
				<li><a href="#">PS4</a></li>
				<li><a href="#">Wii U</a></li>
				<li><a href="#">PC</a></li>
				<li><a href="#">Vita</a></li>
				<li><a href="#">3DS</a></li>
				<li><a href="#">iPhone</a></li>
				<li><a href="#">Android</a></li>
				<li><a href="#">Microsoft</a></li>
				<li><a href="#">TV</a></li>
				<li><a href="#">Comics</a></li>
				<li><a href="#">Reviews</a></li>
				<li><a href="#">Videos</a></li>
				<li><a href="#">Boards</a></li>
			</ul>
		</div>
	</div>
	<!-- ./top navigation -->
	
	<!-- header -->
	<header>
		<div class="container">
			<div class="logo pull-left"><a href="index.html"><img src="images/logo.png" alt="logo" /></a></div>
			<div class="advertisement pull-right"><div class="inline"><a href="#"><img src="images/header_advertisement.png" alt="advertisement" /></a></div></div>
		</div>
		<!-- navigation -->
		<div id="navigation">
			<div class="container">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="news.html">News</a></li>
					<li class="dropdown">
					<a href="#">Pages <i class="fa fa-chevron-down"></i></a>
					<!-- dropdown menu -->
						<ul class="dropdown-menu">
							<li><a href="404.html">404</a></li>
							<li><a href="post.html">Post</a></li>
							<li><a href="timeline.html">Timeline</a></li>
							<li><a href="sidebar_left.html">Sidebar Left</a></li>
							<li><a href="sidebar_right.html">Sidebar Right</a></li>
						</ul>
					</li>
					<li class="dropdown">
					<a href="#">Features <i class="fa fa-chevron-down"></i></a>
						<!-- dropdown menu -->
						<ul class="dropdown-menu">
							<li><a href="grids.html">Grids</a></li>
							<li><a href="typography.html">Typography</a></li>
							<li><a href="tables.html">Tables, Tabs, Toggles</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="alerts.html">Alerts</a></li>
							<li><a href="thumbnails.html">Thumbnails</a></li>
							<li><a href="icons.html">Icons</a></li>
						</ul>
					</li>
					<li><a href="forums.html">Forums</a></li>
					<li><a href="gallery.html">Gallery</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
				<!-- search -->
				<div id="search" class="pull-right">
					<form method="post" class="form-inline">
							<input type="text" class="form-control" placeholder="Search..." />
							<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
					</form>
				</div>
		</div>
		<!-- ./main navigation -->
		</div>
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
			<!-- footer widget -->
			<div class="footer-widget">
				<div class="container">
					<div class="row no-margin">
						<!-- latest news -->
						<div class="col-md-3">
							<h4>Latest News</h4>
							<ul>
								<li>
									<img src="holder.js/45x35" alt="" />
									<a href="#">Vestibulum et condimentum</a>
									<span class="clearfix">March 18, 2013</span>
								</li>
								
								<li>
									<img src="holder.js/45x35" alt="" />
									<a href="#">Suspendisse vel urna elit</a>
									<span class="clearfix">March 13, 2013</span>
								</li>
								
								<li>
									<img src="holder.js/45x35" alt="" />
									<a href="#">Phasellus rutrum ligula</a>
									<span class="clearfix">March 10, 2013</span>
								</li>
								
							</ul>
						</div>
						
						<!-- recent comments -->
						<div class="col-md-3">
							<h4>Recent Comments</h4>
							<ul>
								<li class="clearfix">
									<img src="holder.js/45x35" alt="" />
									<a href="#">Sodales libero quis tellus lacinia viverra. Sed vitae risus.</a>
								</li>
								
								<li class="clearfix">
									<img src="holder.js/45x35" alt="" />
									<a href="#">Pellentesque facilisis eros sit amet massa rutrum feugiat.</a>
								</li>
								
								<li class="clearfix">
									<img src="holder.js/45x35" alt="" />
									<a href="#">condimentum lacus Morbi vulputate metus eurisus.</a>
								</li>
							</ul>
						</div>
						
						<!-- latest tweets -->
						<div class="col-md-3">
						<h4>Latest Tweets</h4>
							<script src="js/twitter.js"></script>
							<div id="twitter_list"></div>
						</div>
						
						<!-- recent comments -->
						<div class="col-md-3">
							<h4>About GameForest</h4>
							<ul>
								<li>
									<div class="text">
										GameForest is a perfect theme for gaming, news and entertainment websites. Built on latest Twitter Bootstrap. Template is available in 4 colors.
										<br /><br />
										<a href="http://themeforest.net/item/gameforest-online-magazine-html-template/5007730" class="btn btn-warning btn-flat btn-block">Purchase <i class="fa fa-shopping-cart"></i></a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- ./footer widget -->
		
			<!-- footer tags -->
			<div class="footer-social">
				<div class="container">
						<ul>	
							<li>Social Media:</li>
							<li><a href="#" class="tip" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook-square facebook-text"></i> facebook.com/gameforest</a></li>
							<li><a href="#" class="tip" data-toggle="tooltip" data-placement="top" title="YouTube"><i class="fa fa-youtube-square youtube-text"></i> youtube.com/gameforest</a></li>
							<li><a href="#" class="tip" data-toggle="tooltip" data-placement="top" title="Rss"><i class="fa fa-rss-square rss-text"></i> themeforest.net</a></li>
						</ul>
				</div>
			</div>
			<!-- ./footer tags -->
			<!-- footer bottom -->
			<div class="footer-bottom">
				<div class="container">
						<ul>
							<li>&copy; 2013 GAMEFOREST. All rights reserved.</li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Ad Choice</a></li>
							<li><a href="#">Terms of Use</a></li>
							<li><a href="#">Advertise</a></li>
						</ul>
				</div>
			</div>
			<!-- ./footer bottom -->
	</footer>	
	<!-- ./footer -->
	
	<!-- sign-in modal -->
	<!-- Modal -->
	<div id="signin" class="modal" tabindex="-1" role="dialog" aria-labelledby="signin-title" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="signin-title"><i class="fa fa-sign-in"></i> Sign In</h4>
		  </div>
		  <div class="modal-body">
			<form action="#" method="post" class="separated clearfix">
			<div class="modal-section modal-padding col-md-6">
				<h5>Login to account</h5>
				<div class="control-group">
					<label class="control-label" for="email">Email</label>
					<div class="controls">
						<input type="text" class="form-control" id="email" placeholder="Email" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<input type="password" class="form-control" id="password" placeholder="Password" required>
					</div>
				</div>
				<div class="control-group">
					<button type="button" class="btn btn-success">Sign In</button>
				</div>
			</div>
			<div class="col-md-6 social-login">
				<h5>Social Login</h5>
				<ul>
					<li>
						<a href="" class="btn facebook form-control no-border-radius"><i class="fa fa-facebook"></i> sign in with Facebook</a>
					</li>
					<li>
						<a href="" class="btn twitter form-control no-border-radius"><i class="fa fa-twitter"></i> sign in with Twitter</a>
					</li>
					<li>
						<a href="" class="btn google-plus form-control no-border-radius"><i class="fa fa-google-plus"></i> sign in with Google</a>
					</li>
				</ul>
			</div>
			</form>
		  </div>
		  <div class="modal-footer">
			Don鈥檛 have an account? <a href="#" class="btn btn-xs btn-primary">Register</a>
		  </div>
		</div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal --> 
	<!-- ./sign-in modal -->
	
	<!-- register modal -->
	<!-- Modal -->
	<div id="register" class="modal" tabindex="-1" role="dialog" aria-labelledby="register-title" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="register-title"><i class="fa fa-user"></i> Create Account</h4>
		  </div>
		  <div class="modal-body">
			<form action="#" method="post" class="clearfix">
				<h5>New Account</h5>
				<div class="alert alert-simple"><i class="fa fa-info"></i> All fields are required</div>
				<div class="row">
				<div class="control-group col-md-6">
					<label class="control-label" for="username">Username</label>
					<div class="controls">
						<input type="text" class="form-control" id="username" placeholder="Username" required>
					</div>
				</div>
				<div class="control-group col-md-6">
					<label class="control-label" for="email">Email</label>
					<div class="controls">
						<input type="text" class="form-control" id="email" placeholder="Email" required>
					</div>
				</div>
				<div class="control-group col-md-6">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<input type="password" class="form-control" id="password" placeholder="Password" required>
					</div>
				</div>
				<div class="control-group col-md-6">
					<label class="control-label" for="repeat-password">Repeat Password</label>
					<div class="controls">
						<input type="password" class="form-control" id="repeat-password" placeholder="Password" required>
					</div>
				</div>
				<div class="control-group col-md-12">
					<label class="control-label" for="repeat-password">Repeat Password</label>
					<div class="controls">
						<input type="password" class="form-control" id="repeat-password" placeholder="Password" required>
					</div>
				</div>
				<div class="control-group col-md-12">
					<div class="checkbox check-default no-padding no-margin">
						<input type="checkbox" id="checkbox" checked="checked"> 
						<label for="checkbox">Accept terms and service.</label>
					</div>
				</div>
				</div>
			</form>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-primary">Create Account</button>
		  </div>
		</div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal --> 
	<!-- ./register modal -->
	
	<!-- style switcher -->
	<div id="styleswitcher">
	<h2><a href="#"><i class="fa fa-cogs"></i></a></h2>
	<div>
	<h3>Style Configuration</h3>
	<h4>Color Style</h4>
	<div class="well">
		<ul class="colors" id="color1">
			<li><a href="#" class="green" title="Green"></a></li>
			<li><a href="#" class="blue" title="Blue"></a></li>
			<li><a href="#" class="red" title="Red"></a></li>
			<li><a href="#" class="pink" title="Pink"></a></li>
		</ul>
	</div>	
	</div>
	</div>
	<!-- ./style switcher -->
	
	<!-- Javascript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/styleswitcher.js"></script>
	<script src="js/jquery.bxslider.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/holder.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>