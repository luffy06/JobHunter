<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位详情页</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		
		<!--搜索公司等-->
		<div class="jobinfo-search"> 
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form action="joblist" method="post" role="form">
						<div class="col-md-11">
							<input class="form-control" type="text" name="jobname" placeholder="搜索公司或职位"/>
						</div>
						<div class="col-md-1">
							<button class="btn btn-primary" type="submit">搜索</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<!--工作详情列表-->
		<div class="jobinfo-content">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-primary">
						<!--工作面板-->
						<div class="panel-body">
							<div class="col-md-10">
								<p class="lead">${job.jobname}</p>
								<p>${m[job.salaryid]}</p>
								<p>${m[job.cityid]}|${m[job.experienceid]}|${m[job.diplomaid]}|${m[job.skillid]}</p>
							</div>
						</div>
						<c:if test="${! empty user}">
							<div class="panel-footer">
								<a href="clickzan?jobid=${job.id}"><span class="glyphicon glyphicon-thumbs-up">喜欢就点个赞把</span></a>
							</div>
						</c:if>
					</div>
					
					<!--HR面板-->
					<div class="panel panel-primary">
						<div class="panel-body">
							<div class="col-md-2">
								<img src="public/img/userportrait/${hr.portrait}.png" class="img-circle"/>
							</div>
							<div class="col-md-3">
								<p>HR:${hr.username}</p>
								<c:if test="${! empty company}">
									<p>${company.shortname}</p>
								</c:if>
								<span class="label label-success">在线</span>
							</div>
							<c:if test="${! empty user}">
								<c:choose>
									<c:when test="${job.isclosed == 1}">
										<div class="col-md-3 col-md-offset-4">
											<button class="btn btn-warning btn-lg" disabled="disabled">职位关闭</button>
										</div>
									</c:when>
									<c:when test="${!posted}">
										<div class="col-md-3 col-md-offset-4">
											<a href="postresume?jobid=${job.id}"><button class="btn btn-warning btn-lg">投递简历</button></a>
										</div>
									</c:when>
									<c:when test="${!has}">
										<div class="col-md-3 col-md-offset-4">
											<a href="getuserresume"><button class="btn btn-warning btn-lg">填写简历</button></a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="col-md-3 col-md-offset-4">
											<button class="btn btn-warning btn-lg" disabled="disabled">已经投递</button>
										</div>
									</c:otherwise>
								</c:choose>
							</c:if>
						</div>
					</div>
					
					<!--描述面板-->
					<div class="panel panel-primary">
						<div class="panel-body">
							<p class="lead"><span class="glyphicon glyphicon glyphicon-bullhorn">职位描述</span></p>
							<p>描述详情--工作地点在${job.workaddress}</p>
							<p><span class="label label-success">职位类型:${m[job.skillid]}</span></p>
							<c:if test="${! empty company}">
								<p class="lead"><span class="glyphicon glyphicon glyphicon-bullhorn">公司简介</span></p>
								<p>${company.description}</p>
								<span class="glyphicon glyphicon-tree-deciduous">${m[company.industryid]}|${m[job.cityid]}|${m[company.scaleid]}</span>
								<br />
								<span class="glyphicon glyphicon-globe"><a href="${company.homepage}">公司主页</a></span>
							</c:if>
							<br />
							<span class="glyphicon glyphicon-map-marker">${job.workaddress}</span>
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
</body>
</html>