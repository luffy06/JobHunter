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
<title>工作</title>
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
				<!--右侧内容简历-->
					<div class="user-post-resume">
						<c:choose>
							<c:when test="${pass == 0}">
								已投递的工作
							</c:when>
							<c:otherwise>
								已收到的Offer
							</c:otherwise>
						</c:choose>
					</div>
					<!--信息列表-->
					<c:choose>
						<c:when test="${! empty userposted}">
							<c:forEach items="${userposted}" var="up" varStatus="st">
								<div class="panel panel-primary">
									<!--工作面板-->
									<div class="panel-body">
										<div class="col-md-10">
											<p class="lead">${up.jobname}</p>
											<p>${m[up.salaryid]}</p>
											<p>${m[up.cityid]}|${m[up.experienceid]}|${m[up.diplomaid]}|${m[up.skillid]}</p>
										</div>
									</div>		
									<div class="panel-footer">
										<a href="jobinfo?jobid=${up.id}">详情</a>
									</div>	
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>无内容</p>
						</c:otherwise>
					</c:choose>
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