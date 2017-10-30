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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/colors/blue.css" id="colors"/>

    <!-- ======= STYLE SWITCHER ======= -->
    <link rel="stylesheet" href="/css/styleswitcher.css">
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

                    <!-- section #1 -->
                    <section class="clearfix">

                        <div class="col-md-12">
                            <table class="table">
                                <tbody>
                                <c:forEach items="${data.result}" var="entry" varStatus="loop">

                                    <c:choose>
                                        <c:when test="${entry.profitPips > 0}">
                                            <tr  class="success" >
                                        </c:when>
                                        <c:otherwise>
                                            <tr  class="warning" >
                                        </c:otherwise>
                                    </c:choose>
                                        <td>${entry.currency}</td>
                                        <td>${entry.profitPips}</td>
                                        <td>${entry.type}</td>
                                        <td>${entry.openPrice}</td>
                                        <td>${entry.openTime}</td>
                                        <td>${entry.closePrice}</td>
                                        <td>${entry.closeTime}</td>
                                        <td>${entry.tradingId}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>


                        <c:forEach begin="1" end="${data.totalPages}" varStatus="loop">
                            <a href="/order/list.html?pageNo=${loop.index}">${loop.index}</a>
                        </c:forEach>


                        <!-- contact form -->

                    </section>
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
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.bxslider.min.js"></script>
<script src="/js/jquery.prettyPhoto.js"></script>
<script src="/js/custom.js"></script>
<script src="/js/service/user.js"></script>

</body>
</html>