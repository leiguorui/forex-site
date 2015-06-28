<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/25
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
  <div class="logo pull-left"><a href="index.html"><img src="images/logo.png" alt="logo" /></a></div>
  <div class="advertisement pull-right"><div class="inline"><a href="#"><img src="images/header_advertisement.png" alt="advertisement" /></a></div></div>
</div>
<!-- navigation -->
<div id="navigation">
  <div class="container">
    <ul>
      <li><a href="index.html">Home</a></li>
      <li><a href="news.html">news</a></li>
      <li class="dropdown">
        <a href="#">tools <i class="fa fa-chevron-down"></i></a>
        <!-- dropdown menu -->
        <ul class="dropdown-menu">
          <li><a href="sub_price.html">sub_price</a></li>
          <li><a href="sub_technical.html">sub_technical</a></li>
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
      <li><a href="forums.html">canlder</a></li>
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
