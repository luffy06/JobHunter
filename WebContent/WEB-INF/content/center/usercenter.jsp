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
<title>个人中心</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="row">
			<div class="col-md-3">
				<s:action name="sidebar_leftframe" executeResult="true"></s:action>
			</div>
			<div class="col-md-6 col-md-offset-1">
				<div class="row">
					<!--右侧内容投递简历-->
					<div class="user-post-resume">
						已投递的工作<a href="getuserposted"><small>更多</small></a>
					</div>
					<!--投递信息列表-->
					<c:choose>
						<c:when test="${! empty posted}">
							<div class="panel panel-primary">
								<!--投递工作面板-->
								<div class="panel-body">
									<div class="col-md-10">
										<p class="lead">${posted.jobname}</p>
										<p>${m[posted.salaryid]}</p>
										<p>${m[posted.cityid]}|${m[posted.experienceid]}|${m[posted.diplomaid]}|${m[posted.skillid]}</p>
									</div>
									<div class="col-md-2">
										<p class="lead">${status}</p>
									</div>
								</div>		
								<div class="panel-footer">
									<a href="jobinfo?jobid=${posted.id}">详情</a>
								</div>	
							</div>
						</c:when>
						<c:otherwise>
							<p>你还未投递简历</p>
						</c:otherwise>
					</c:choose>
					
					<div class="user-post-resume">
						收到的offer<a href="getuserposted?pass=1"><small>更多</small></a>
					</div>
					<!--offer信息列表-->
					<c:choose>
						<c:when test="${! empty offer}">
							<div class="panel panel-primary">
								<!--工作面板-->
								<div class="panel-body">
									<div class="col-md-10">
										<p class="lead">${offer.jobname}</p>
										<p>${m[offer.salaryid]}</p>
										<p>${m[offer.cityid]}|${m[offer.experienceid]}|${m[offer.diplomaid]}|${m[offer.skillid]}</p>
									</div>
								</div>		
								<div class="panel-footer">
									<a href="jobinfo?jobid=${offer.id}">详情</a>
								</div>	
							</div>
						</c:when>
						<c:otherwise>
							<p>你还未收到offer</p>
						</c:otherwise>
					</c:choose>
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
</body>
</html>