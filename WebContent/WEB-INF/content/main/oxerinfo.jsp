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
								<img src="public/img/userportrait/${oxer.portrait}.png" class="img-circle">       
							</div>
							<div class="col-md-5">
								<p class="lead">${oxer.username}</p>
								<p>联系邮箱：${oxer.email}</p>
								<c:if test="${! empty resume && resume.ishide == 0}">
									<p>个人主页：${resume.homepage}</p>
								</c:if>
							</div>
							<div class="col-md-3">
								<c:if test="${! empty resume && resume.ishide == 0}">
									<p>${m[resume.statusid]}</p>
								</c:if>
							</div>
						</div>
					</div>
	
					<div class="panel-body">
						<hr>
						<c:choose>
							<c:when test="${! empty resume && resume.ishide == 1}">
								<p>该用户已经隐藏了简历</p>
							</c:when>
							<c:otherwise>
								<span class="glyphicon glyphicon-hand-down">期望职位</span>
								<c:forEach items="${workpp}" var="wp" varStatus="st">
									<div class="row">
										<div class="col-md-2 col-md-offset-1">${m[wp.cityid]}</div>
										<div class="col-md-2">${m[wp.skillid]}</div>
										<div class="col-md-2">${m[wp.salaryid]}</div>
										<div class="col-md-2">${m[wp.industryid]}</div>
									</div>
								</c:forEach>
			
								<hr>
								<span class="glyphicon glyphicon-hand-down">工作经历</span>
								<c:forEach items="${workep}" var="we" varStatus="st">
									<div class="row">
										<div class="col-md-2 col-md-offset-1">${m[we.industryid]}</div>
										<div class="col-md-2">${m.companyname}</div>
										<div class="col-md-2">${we.starttime}~${we.endtime}</div>
										<div class="col-md-2">${m[we.cityid]}</div>
										<div class="col-md-2">${we.jobname}</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-md-offset-1">
											<p>${we.description}</p>
										</div>
									</div>
								</c:forEach>
								<hr>
								<span class="glyphicon glyphicon-hand-down">项目经验</span>
								<c:forEach items="${proexp}" var="pe" varStatus="st">
									<div class="row">
										<div class="col-md-2 col-md-offset-1">${pe.projectname}</div>
										<div class="col-md-2">${pe.starttime}~${pe.endtime}</div>
										<div class="col-md-2">${pe.role}</div>
										<div class="col-md-2">${pe.url}</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-md-offset-1">
											<p>${pe.achievement}</p>
											<p>${pe.description}</p>
										</div>
									</div>
								</c:forEach>
								<hr>
								<span class="glyphicon glyphicon-hand-down">教育经历</span>
								<c:forEach items="${eduexp}" var="ee" varStatus="st">
									<div class="row">
										<div class="col-md-3 col-md-offset-1">${m[ee.schoolid]}</div>
										<div class="col-md-3">${ee.starttime}~${ee.endtime}</div>
										<div class="col-md-3">${ee.major}</div>
										<div class="col-md-2">${m[ee.diplomaid]}</div>
									</div>
								</c:forEach>
								<hr>
								<span class="glyphicon glyphicon-hand-down">我的优势</span>
								<div class="row">
									<div class="col-md-offset-1">
										<c:if test="${! empty resume}">
											<p>${resume.advantage}</p>
										</c:if>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
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