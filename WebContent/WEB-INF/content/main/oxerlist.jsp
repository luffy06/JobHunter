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
<title>牛人列表页</title>
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
				<div class="panel panel-default">
					<div class="panel-heading">
						<p>全部职位
							<span class="choose">[筛选]</span>
							<c:if test="${! empty salary}">
								<span class="label label-info">
									<a href="oxerlist?type=deletesal"><span class=" glyphicon glyphicon-remove"></span></a>${salary}
								</span>
							</c:if>
							<c:if test="${! empty experience}">
								<span class="label label-info">
									<a href="oxerlist?type=deleteexp"><span class=" glyphicon glyphicon-remove"></span></a>${experience}
								</span>
							</c:if>
							<c:if test="${! empty education}">
								<span class="label label-info">
									<a href="oxerlist?type=deletedip"><span class=" glyphicon glyphicon-remove"></span></a>${education}
								</span>
							</c:if>
						</p> 
						<ul class="list-inline">
							<li>薪水</li>
							<c:forEach items="${slist}" var="sl" varStatus="st">
								<li><a href="oxerlist?type='add'&salary_id=${sl}">${m[sl]}</a></li>
							</c:forEach>
						</ul>
						<ul class="list-inline">
							<li>经验</li>
							<c:forEach items="${elist}" var="el" varStatus="st">
								<li><a href="oxerlist?type='add'&experience_id=${el}">${m[el]}</a></li>
							</c:forEach>
						</ul>
						<ul class="list-inline">
							<li>学历</li>
							<c:forEach items="${dlist}" var="dl" varStatus="st">							
								<li><a href="oxerlist?type='add'&diploma_id=${dl}">${m[dl]}</a></li>
							</c:forEach>                             
						</ul>
					</div>   	
				</div>
				<!--牛人详情-->
				<c:choose>
					<c:when test="${! empty oxerlist}">
						<c:forEach items="${oxerlist}" var="ol" varStatus="st">
							<div class="panel panel-primary">
								<div class="panel-body">
									<div class="row">
										<div class="col-md-2">
											<img class="img-circle" src="public/img/userportrait/${ol.portrait}.png" >
										</div>
										<div class="col-md-6">
											<p>${ol.username}</p>
											<p>期望职位:
												<c:choose>
													<c:when test="${count[st.index] != count[st.index+1]}">
														<c:forEach var="x" begin="${count[st.index]}" end="${count[st.index+1]}" step="1">
															<span class="label label-primary">${ej[x]}</span>
														</c:forEach>
													</c:when>
													<c:otherwise>
														暂无期望职位
													</c:otherwise>
												</c:choose>
												
											</p>
											<p>
												<c:if test="${! empty company[st.index]}">
													<a href="companyinfo?companyid=${company[st.index].id}">${company[st.index].companyname}</a>|
												</c:if>
											联系邮箱：${ol.email}</p>
										</div>
										<div class="col-md-3 col-md-offset-1">
											<a href="oxerinfo?userid=${ol.id}"><button class="btn btn-default">查看简历</button></a>
											<a href="#"><button class="btn btn-default">收藏</button></a>
											<p>
												<c:if test="${bestcity[st.index] != -1}">
													<span class="glyphicon glyphicon-map-marker">${m[bestcity[st.index]]}</span>
												</c:if>
												<c:if test="${workexp[st.index] != -1}">
													<span class="glyphicon glyphicon-briefcase">${m[workexp[st.index]]}</span>
												</c:if>
												<c:if test="${maxdiploma[st.index] != -1}">
													<span class="glyphicon glyphicon-th">${m[maxdiploma[st.index]]}</span>
												</c:if>
											</p>
										</div>
									</div>
								</div>
							</div><!--收藏人end-->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="row">
							<p>暂无牛人</p>
						</div>
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