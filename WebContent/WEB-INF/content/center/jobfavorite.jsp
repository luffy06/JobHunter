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
<title>收藏-岗位</title>
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
					<c:when test="${! empty joblist}">
						<c:forEach items="${joblist}" var="jl" varStatus="st">
							<div class="panel panel-primary">
								<div class="panel-body">
									<div class="col-md-10">
										<p class="lead"><a href= "jobinfo?jobid=${jl.id}">${jl.jobname}</a></p>
										<p>${m[jl.salaryid]}</p>
										<p>${m[jl.cityid]}|${m[jl.experienceid]}|${m[jl.diplomaid]}</p>
									</div>
									<div class="col-md-2">
										<img src="public/img/userportrait/${hrlist[st.index].portrait}.png" alt="头像" class="img-circle">
										<br />
										<p>${hrlist[st.index].username}</p>
										<c:if test="${! empty clist[st.index]}">
											<p>${clist[st.index]}</p>
										</c:if>
									</div>
								</div>
							</div><!--收藏职位end-->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>你还没有收藏的岗位呢！</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>