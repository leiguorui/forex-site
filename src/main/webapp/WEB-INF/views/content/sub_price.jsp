<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
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

	<!-- wrapper -->
	<div class="container">
		<div id="wrapper">
					<div class="clearfix"> 
						<div class="col-md-8 no-padding">
							<div class="padding">
							<ul class="section-title no-margin-top clearfix">
									<li><h3>Get in Touch</h3></li>
							</ul>
							<!-- section #1 -->
							<section class="clearfix">
								<p>
									Donec elementum dolor eu mi elementum vulputate. Vivamus condimentum mauris laoreet eros lacinia tempus molestie elit ullamcorper. Fusce non mi nec nulla varius dictum. Cras condimentum, dolor eget consectetur feugiat, libero odio rhoncus neque, vitae porta erat eros sit amet sapien..
								</p>
								<%--<div class="thumbnail">--%>
									<%--<iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?q=Scotland+Yard,+Broadway,+London,+Britain&hl=hu&ie=UTF8&sll=51.505217,0.099392&sspn=0.037023,0.104628&oq=Britain+scotlan&hq=Scotland+Yard,+Broadway,&hnear=London,+Egyes%C3%BClt+Kir%C3%A1lys%C3%A1g&t=m&z=14&amp;output=embed"></iframe>--%>
								<%--</div>--%>
								<!-- contact form -->
								<form method="post" class="contact-form" action="/sub_price.html" id="subpriceId">
								<div class="row">
									<div class="col-md-5">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"></i></span>
											<input class="form-control" type="text" name="product" placeholder="product" value="EURUSD"/>
										</div>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
											<input class="form-control" type="text" name="email" placeholder="Email Address" value="green_forex@163.com"/>
										</div>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-list-alt"></i></span>
											<input class="form-control" type="text" name="price" placeholder="price" value="1."/>
										</div>
									</div>
								</div>
								<div class="details"><button class="btn btn-primary pull-right btn-flat">Send</button></div>
								</form>
							</section>
						</div>
						</div>
						
						<!-- sidebar section -->
						<div class="col-md-4 no-padding right-sidebar">
							<div id="sidebar" class="sidebar-alignment">
								<!-- contact info -->
								<div class="sidebar-section">
								<div class="title"><i class="awe-pushpin"></i> Information</div>
								<ul class="content">
									<!-- row #1 -->
									<li>
										<div class="details">
											<div class="pull-left">
												<h5>Location: 2230 Dartmouth St., Boston</h5>
											</div>
										</div>
										<div class="clearfix"></div>
									</li>

									<!-- row #2 -->
									<li>
										<div class="details">
											<div class="pull-left">
												<h5>Phone: (617) 000-0000</h5>
											</div>
										</div>
										<div class="clearfix"></div>
									</li>
									
									<!-- row #3 -->
									<li>
										<div class="details">
											<div class="pull-left">
												<h5>Fax: +00 777 00</h5>
											</div>
										</div>
										<div class="clearfix"></div>
									</li>
									
									<!-- row #4 -->
									<li>
										<div class="details">
											<div class="pull-left">
												<h5>Email: <a href="mailto:info@mydomain.com">info@mydomain.com</a></h5>
											</div>
										</div>
										<div class="clearfix"></div>
									</li>
									
									<!-- row #5 -->
									<li>
										<div class="details">
											<div class="pull-left">
												<h5>Nam venenatis convallis dolor vitae egestas. Nam ut mi non dolor mattis feugiat vel a nisi. Vivamus faucibus molestie neque, eget convallis quam aliquam sed</h5>
											</div>
										</div>
										<div class="clearfix"></div>
									</li>
								</ul>
								</div>
								<!-- ./contact info -->

							</div>
						</div>
					<!-- ./sidebar section -->
					</div>
				</div>
		<div class="clearfix"></div>
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
	<script src="js/custom.js"></script>

	<script type="text/javascript">
		$(document).ready(function () {
			$("#subpriceId").submit(function(e) {
				//prevent Default functionality
				e.preventDefault();
				var requestData =   { "product": this.product.value,"email":this.email.value,"price":this.price.value};
				//do your own request an handle the results
				$.post("/sub_price.html", requestData,
					function(data){
						alert(data);
					});
			});
		});
	</script>
</body>
</html>