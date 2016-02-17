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

                        <ol class="breadcrumb">
                            <li><a href="index.html">首页</a></li>
                            <li class="active">新手教程</li>
                        </ol>

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

</body>
</html>