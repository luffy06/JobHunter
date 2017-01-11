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
<title>Insert title here</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		
		<div class="company-all col-md-10 col-md-offset-1">
			<!--公司搜索栏-->
			<div class="company-search"> 
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<form action="companylist" method="post" role="form">
							<div class="col-md-11">
								<input class="form-control" type="text" name="companyname" placeholder="搜索公司"/>
							</div>
							<div class="col-md-1">
								<button class="btn btn-primary" type="submit">搜索</button>
							</div>
						</form>
					</div>
				</div>
			</div>	
			
			<!--公司展示栏-->
			<div class="company-show">	
				<c:forEach items="${companylist}" var="cl" varStatus="st">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="panel panel-primary">
								<div class="panel-body">
									<div class="col-md-3">
										<p class="lead">${cl.shortname}</p>
										<a href="favorite?type='company'&companyid=${cl.id}"><button class="btn btn-info btn-lg">收藏</button></a>
									</div>
									<div class="col-md-5 clo-md-offset-3">
										<p class="lead">${cl.fullname}</p>
										<p>行业：${m[cl.industryid]}</p>
										<p>性质：${m[cl.finanacestageid]}</p>
										<p>规模：${m[cl.scaleid]}</p>
									</div>
									<div class="col-md-4">
										<p>招聘职位：</p>
										<ul>
											<c:forEach var="x" begin="${count[st.index]}" end="${count[st.index + 1]}" step="1">
												<li><a href="jobinfo?jobid=${joblist[x].id}">${joblist[x].jobname}</a></li>
											</c:forEach>
										</ul>
										<ul>
											<li><a href="companyinfo?companyid=${cl.id}">更多</a></li>	
										</ul>
										
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</c:forEach>
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
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/dist/js/bootstrap.min.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>