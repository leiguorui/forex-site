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
		<c:import url="/common/page/sub_navigation.html" charEncoding="UTF-8">
		</c:import>
	</div>
	<!-- ./sub navigation -->

	<!-- header -->
	<header>
		<c:import url="/common/page/header.html" charEncoding="UTF-8">
		</c:import>
	</header>
	<!-- ./headerer -->

	<!-- wrapper -->
	<div class="container">
		<div id="wrapper">
					<div class="clearfix">
						<div class="col-md-8 no-padding">
							<div class="padding">

                            <ol class="breadcrumb">
                                <li><a href="index.html">首页</a></li>
                                <li class="active">技术分析</li>
                            </ol>

							<!-- section #1 -->
							<section class="clearfix">

								<div class="col-md-12">
									<h3>货币对的技术分析</h3>
									<p>目前免费提供以下货币对的技术分析,计算详情暂不列出.</p>
									<table class="table">
										<thead>
										<tr>
											<th>#</th>
											<th>货币对</th>
											<th>时间</th>
											<th>移动平均线</th>
											<th>其他指标</th>
										</tr>
										</thead>
										<tbody>
										<c:forEach items="${technicals}" var="entry" varStatus="loop">
											<tr>
												<td>${loop.index}</td>
												<td>${entry.value.produtcName}</td>
												<td>${entry.value.period}</td>
												<td>${entry.value.maBuy} / ${entry.value.maSell}</td>
												<td>${entry.value.tiBuy} / ${entry.value.tiSell}</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</section>
						</div>
						</div>

						<!-- sidebar section -->
						<div class="col-md-4 no-padding right-sidebar">
							<div id="sidebar" class="sidebar-alignment">
								<!-- contact info -->
								<div class="sidebar-section">
								<div class="title"><i class="awe-pushpin"></i> 订阅并提醒</div>
								<ul class="content">
									<!-- row #1 -->
									<li>
                                        <div class="details">
                                            <form method="post" class="contact-form" action="/sub_price.html" id="subpriceId">
                                                <div class="row">
                                                    <div class="col-md-12">
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
                                                <div class="details"><button class="btn btn-primary pull-left btn-flat">订阅</button></div>
                                            </form>
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
	<script src="js/custom.js"></script>
    <script src="js/service/user.js"></script>

	<script type="text/javascript">
		$(document).ready(function () {
			$("#subpriceId").submit(function(e) {
				//prevent Default functionality
				e.preventDefault();
				var requestData =   { "product": this.product.value,"email":this.email.value,"period":this.period.value};
				//do your own request an handle the results
				$.post("sub_technical.html", requestData,
					function(data){
						alert(data);
					});
			});
		});
	</script>
</body>
</html>