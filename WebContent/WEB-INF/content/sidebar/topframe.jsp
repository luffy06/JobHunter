<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<nav class="navbar navbar-default " role="navigation">
 		<div class="container-fluid">
			<div class="navbar-header">
			    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			    </button>
	     			<a class="navbar-brand" href="#">
	     				JobHunter
	     			</a>
	  			</div>
	
		    <div class="collapse navbar-collapse" id="bs-example">
		      <ul class="nav navbar-nav">
		        <li><a href="index">首页</a></li>
		        <li><a href="joblist">岗位</a></li>
		        <li><a href="companylist">企业</a></li>
		        <li><a href="oxer">人才</a></li>
		      </ul>
		      <c:choose>
				<c:when test="${empty user}">
			     	<ul class="nav navbar-nav navbar-right">
			        	<li><a href="getlogin">登录</a></li>
			        	<li><a href="getregister">注册</a></li>
					</ul>
			    </c:when>
			    <c:otherwise>
			    	<ul class="nav navbar-nav navbar-right">
			        	<li><a href="getusercenter">${user.username}</a></li>
			        	<li><a href="logout">登出</a></li>
			    	</ul>
			    </c:otherwise>
		      </c:choose>
		    </div>
		</div>
	</nav>
	
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>