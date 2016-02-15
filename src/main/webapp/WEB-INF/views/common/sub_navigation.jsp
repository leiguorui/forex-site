<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/25
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
  <ul id="user-interface">

      <c:choose>
          <c:when test="${empty sessionScope.session_user}">
              <li>
                  <a href="#signin" data-toggle="modal">登录</a>
              </li>
              <li>
                  <a href="#register" data-toggle="modal">免费注册</a>
              </li>
          </c:when>
          <c:otherwise>
              <li>
                  <a href="/user/account.html">${sessionScope.session_user.name}</a>
              </li>
              <li>
                  <a href="/user/logout.html">退出</a>
              </li>
          </c:otherwise>
      </c:choose>

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
