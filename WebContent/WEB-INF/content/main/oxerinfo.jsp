<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@taglib prefix="fl" uri="/WEB-INF/fl.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>牛人详情页</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				
				<!--人才详情-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-2">
								<img src="img/头像.png" class="img-circle">       
							</div>
							<div class="col-md-5">
								<p class="lead">张三</p>
								<p>期望职位：java</p>
								<p>曾任 JAVA|中软国际|联系邮箱123456789@163.com</p>
							</div>
							<div class="col-md-3">
								<p>离职 -随时到岗</p>
								<p>
								<span class="glyphicon glyphicon-map-marker">武汉</span>
								<span class="glyphicon glyphicon-briefcase">两年</span>
								<span class="glyphicon glyphicon-book">本科</span>
								</p>
							</div>
						</div>
					</div>
	
					<div class="panel-body">
						<hr>
						<span class="glyphicon glyphicon-hand-down">期望职位</span>
						<div class="row">
							<div class="col-md-2 col-md-offset-1">JAVA</div>
							<div class="col-md-2">￥3k-4k</div>
							<div class="col-md-2">行业不限</div>
						</div>
	
						<hr>
						<span class="glyphicon glyphicon-hand-down">工作经历</span>
						<div class="row">
							<div class="col-md-2 col-md-offset-1">互联网</div>
							<div class="col-md-2">中软国际</div>
							<div class="col-md-2">JAVA</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-md-offset-1 ">
								<span class="label label-info">后端开发</span>
								<span class="label label-info">JavaScript</span>
								<span class="label label-info">JAVA</span><br/>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-md-offset-1">
								<span class="glyphicon glyphicon-briefcase"></span>
								<ol>
									<li>进行过网站和后台系统软件的开发</li>
									<li>并对系统进行测试和维护</li>
								</ol>
							</div>
						</div>
						<hr>
						<span class="glyphicon glyphicon-hand-down">项目经验</span>
						<div class="row">
							<div class="col-md-2 col-md-offset-1">项目内容：</div>
							<div class="col-md-2">订餐系统</div>
							<div class="col-md-2">软件工程师</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-md-offset-1">
								<span class="glyphicon glyphicon-briefcase"></span>
								<ol>
									<li>进行过网站和后台系统软件的开发</li>
									<li>并对系统进行测试和维护</li>
								</ol>
							</div>
						</div>
						<hr>
						<span class="glyphicon glyphicon-hand-down">教育经历</span>
						<div class="row">
							<div class="col-md-3 col-md-offset-1">华中师范大学</div>
							<div class="col-md-3">2010-2013</div>
							<div class="col-md-3">计算机科学与技术</div>
							<div class="col-md-2">本科</div>
						</div>
						<hr>
						<span class="glyphicon glyphicon-hand-down">我的优势</span>
						<div class="row">
							<div class="col-md-offset-1">
								<p>聪明，有J2EE开发经验</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<s:action name="sidebar_footerframe" executeResult="true"></s:action>
		</div>
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>