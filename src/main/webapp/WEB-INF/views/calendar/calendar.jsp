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
    <div id="wrapper">
        <div class="clearfix">
            <div class="col-md-12 no-padding">
                <div class="padding">

                    <ol class="breadcrumb">
                        <li><a href="index.html">首页</a></li>
                        <li class="active">财经日历</li>

                        <li class="pull-right">
                            <div class="btn-group pull-right">
                                <a href="#" class="btn btn-primary" data-toggle="tab">全部</a>
                                <a href="#" class="btn btn-primary" data-toggle="tab">重要性高</a>
                                <a href="#" class="btn btn-primary" data-toggle="tab">重要性中</a>
                                <a href="#" class="btn btn-primary" data-toggle="tab">重要性低</a>
                            </div>
                        </li>
                    </ol>

                    <ul class="timeline">
                        <li class="animated-when-visible hidden" data-animation-type='flipInY'>
                            <div class="timeline-badge primary"><a><i class="fa fa-gamepad tip" title="美元"></i></a></div>
                            <div class="timeline-panel">
                                <div class="timeline-body">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>事件</th>
                                            <th>重要性</th>
                                            <th>前值</th>
                                            <th>市场预测</th>
                                            <th>结果</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="timeline-footer">
                                    <span class="pull-left"><i class="fa fa-thumbs-up"></i> 时间 </span>
                                </div>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
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
<script src="js/service/calendar.js"></script>

</body>
</html>