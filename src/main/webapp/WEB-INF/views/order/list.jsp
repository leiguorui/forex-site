<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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

<!-- wrapper -->
<div class="container">
    <div id="wrapper">
        <div class="clearfix">
            <div class="col-md-8 no-padding">
                <div class="padding">

                    <!-- section #1 -->
                    <section class="clearfix">

                        <p>
                            <c:forEach items="${stat}" var="entryInList" varStatus="loop">
                                <c:forEach items="${entryInList}" var="entry" varStatus="loop">
                                    ${entry.key} = ${entry.value}
                                </c:forEach>
                                <br>
                            </c:forEach>
                        </p>

                        <p>
                            <c:forEach items="${technicals}" var="entry" varStatus="loop">
                                ${entry.key} = ${entry.value}
                            </c:forEach>
                        </p>


                        <div class="col-md-12">
                            <table class="table">
                                <tbody>
                                <c:forEach items="${data.result}" var="entry" varStatus="loop">

                                    <c:choose>
                                        <c:when test="${entry.profitPips > 0}">
                                            <tr  class="success" >
                                        </c:when>
                                        <c:when test="${entry.profitPips < 0}">
                                            <tr  class="warning" >
                                        </c:when>
                                        <c:otherwise>
                                            <tr >
                                        </c:otherwise>
                                    </c:choose>
                                        <td>${entry.currency}</td>
                                        <td>${entry.profitPips} </td>
                                        <td>${entry.maxProfit} </td>
                                        <td>${entry.maxLoss} </td>
                                        <td>${entry.type}</td>
                                        <td>${entry.openPrice}</td>
                                        <td>${entry.closePrice}</td>
                                        <td><fmt:formatDate pattern = "dd" value = "${entry.openTime}" /></td>
                                        <td><fmt:formatDate pattern = "HH:mm:ss" value = "${entry.openTime}" /></td>
                                        <td><fmt:formatDate pattern = "HH:mm:ss" value = "${entry.closeTime}" /></td>
                                        <td>${entry.tradingId}</td>
                                        <td>${entry.signalSrc}</td>
                                        <td>${entry.signalUser}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <!-- contact form -->

                    </section>

                    <c:forEach begin="1" end="${data.totalPages}" varStatus="loop">
                        <a href="/order/list.html?pageNo=${loop.index}">${loop.index}</a>
                    </c:forEach>

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