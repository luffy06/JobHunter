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
<title>收藏-公司</title>
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
			<div class="col-md-8">
				<c:choose>
					<c:when test="${! empty companylist}">
							<c:forEach items="${companylist}" var="cl" varStatus="st">
								<div class="panel panel-primary">
									<div class="panel-body">
										<div class="col-md-4">
											<p class="lead">${cl.shortname}</p>
										</div>
										<div class="col-md-8">
											<p class="lead">${cl.fullname}</p>
											<p>行业：${m[cl.industryid]}</p>
											<p>性质：${m[cl.finanacestageid]}</p>
											<p>规模：${m[cl.scaleid]}</p>
											<a href="companyinfo?companyid=${cl.id}">更多</a>
										</div>
									</div>
								</div><!--收藏公司end-->
							</c:forEach>
					</c:when>
					<c:otherwise>
						<p>你还没有收藏的公司呢！</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>