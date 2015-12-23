<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

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

	<!-- wrapper -->
	<div class="container">
		<div id="wrapper" class="clearfix">
			<div class="col-md-12 no-padding">
				<div class="padding-fullpage clearfix">
					<!-- section -->
					<div class="row">
						<div class="col-md-12">
							<ul class="section-title no-margin-top clearfix">
								<li><h3><i class="fa fa-picture-o"></i> - Gallery</h3></li>
								<li class="pull-right">
									<div class="btn-group pull-right">
										<a href="#all" class="btn btn-primary" data-toggle="tab">2015年12月</a>
										<a href="#pc" class="btn btn-primary" data-toggle="tab">2015年11月</a>
										<a href="#nextgen" class="btn btn-primary" data-toggle="tab">2015年10月</a>
									</div>
								</li>
							</ul>
							<div class="gallery tab-content">
								<div id="all" class="tab-pane fade in active content">

									<c:forEach items="${videos}" var="entry" varStatus="loop">

										<!-- section -->
										<section class="col-md-6">
											<div class="img thumbnail">
												<a href="" rel="prettyPhoto">
													<img src="${entry.bigThumbnail}" alt="" />
													<span><i class="fa fa-film"></i></span>
												</a>
											</div>
											<h4>${entry.title}</h4>
											<p>观看次数: ${entry.view_count} 视频时长: ${entry.duration}</p>
										</section>
									</c:forEach>

								</div>
							</div>
							<button type="button" class="btn btn-primary btn-lg btn-flat btn-block btn-load" data-loading-text="Loading...">Load More...</button>
						</div>
					</div>
				</div>
			</div>
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
	<script src="js/custom.js"></script>

	<script type="text/javascript">
		$(document).ready(function () {
			$("#subpriceId").submit(function(e) {
				//prevent Default functionality
				e.preventDefault();
				var requestData =   { "product": this.product.value,"email":this.email.value,"price":this.price.value};
				//do your own request an handle the results
				$.post("sub_price.html", requestData,
					function(data){
						alert(data);
					});
			});
		});
	</script>
</body>
</html>