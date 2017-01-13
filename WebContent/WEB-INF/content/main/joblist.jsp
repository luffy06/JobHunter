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
<title>岗位列表</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<!-- <link rel="stylesheet" href="public/bower_components/dist/css/bootstrap.css"> -->
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<!-- 广告栏 -->
				<div class="joblist-slide">
					<div class="row">
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  	<ol class="carousel-indicators">
							    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						  	</ol>
						
						  <!-- Wrapper for slides -->
						  	<div class="carousel-inner" role="listbox">
							    <div class="item active">
								    <img src="public/img/ad/ad1.png" alt="ad1">
								    <div class="carousel-caption">
								     	<!-- 图片描述 -->
								    </div>
							    </div>
							    <div class="item">
							      	<img src="public/img/ad/ad2.png" alt="ad2">
							      	<div class="carousel-caption">
							        	<!-- 图片描述 -->
							      	</div>
						    	</div>
						    	<div class="item">
							      	<img src="public/img/ad/ad3.png" alt="ad3">
							      	<div class="carousel-caption">
							        	<!-- 图片描述 -->
							      	</div>
						    	</div>
						  	</div>
						
						  <!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							    <span class="glyphicon glyphicon-chevron-left"></span>
							    <span class="sr-only">Previous</span>
							</a>
							<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							    <span class="glyphicon glyphicon-chevron-right"></span>
							    <span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
				
				<!-- 搜索栏 -->
				<div class="joblist-search"> 
					<div class="row">
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
				
				<!-- 岗位搜索 -->	
				<div class="joblist-select">	
					<c:choose>
						<c:when test="${! empty jobtypelist}">
							<c:forEach var="jtl" items="${jobtypelist}" varStatus="st" step="4">
								<div class="row">
									<c:forEach var="y" begin="${st.index}" step="1" end="${fl:min(st.index + 3, fn:length(jobtypelist))}">
										<div class="col-md-3">
											<div class="btn-group">
												<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
													${jobtypelist[y]}
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<c:forEach var="x" begin="${jobtypecount[y]}" end="${jobtypecount[y + 1]}" step="1">
													    <li><a href="joblist?skillid=${skillid[x]}">${skilllist[x]}</a></li>
												    </c:forEach>
												</ul>
											</div>
										</div>
									</c:forEach>
								</div>
								<hr>
							</c:forEach>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- 岗位列表 -->
				<div class="joblist-show">	
					<c:choose>
						<c:when test="${! empty joblist}">
							<c:forEach items="${joblist}" var="jl" varStatus="st">
								<div class="row">
									<div class="panel panel-primary">
										<div class="panel-body">
											<div class="col-md-10">
												<p class="lead"><a href="jobinfo?jobid=${jl.id}">${jl.jobname}</a></p>
												<p>${m[jl.salaryid]}</p>
												<p>${m[jl.cityid]}|${m[jl.experienceid]}|${m[jl.diplomaid]}</p>
											</div>
											<div class="col-md-2 clo-md-offset-10">
												<img src="public/img/userportrait/1.png" alt="头像" class="img-circle">
												<br />
												<p>${hr[st.index].username}</p>
												<c:if test="${! empty hrc[st.index]}">
													<p>${hrc[st.index].shortname}|HR</p>
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="row">
								<p>暂无职位</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="row">
					<nav class="col-md-8 col-md-offset-4">
						<ul class="pagination">
						    <li><a href="#">&laquo;</a></li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li><a href="#">&raquo;</a></li>
						</ul>
					</nav>
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
	<script src="public/bower_components/bootstrap/js/dropdown.js"></script>
	<script src="public/bower_components/bootstrap/js/collapse.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>