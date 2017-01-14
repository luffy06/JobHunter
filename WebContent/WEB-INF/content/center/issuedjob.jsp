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
<title>已发布职位</title>
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
			<div class="col-md-8 col-md-offset-1">
				<!--hr发布已经发布的职位-->
				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							职位类型
							<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<c:forEach items="${skill}" var="s" varStatus="st">
								    <li><a href="getissuedjob?skillid=${s}">${m[s]}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>	
					<%-- <div class="col-md-7">
						发布日期：
						<select name="start">
							<option value="起始时间">2013</option>
						</select>
						~
						<select name="end">
							<option value="终止时间">2014</option>
						</select>
					</div>	 --%>
				</div>
				<hr>
				<div class="row">
					<table class="table">
						<tr>
							<th>职位名称</th>
							<th>职位类型</th>
							<th>薪资</th>
							<th>工作城市</th>
							<th>已在线时间</th>
							<th>对职位感兴趣</th>
							<th>看过我的</th>
							<th>状态</th>
							<th>&nbsp;</th>
						</tr>
						<c:choose>
							<c:when test="${! empty joblist}">
								<c:forEach items="${joblist}" var="j" varStatus="st">
									<tr>
										<td><a href="jobinfo?jobid=${j.id}">${j.jobname}</a></td>
										<td>${m[j.skillid]}</td>
										<td>${m[j.salaryid]}</td>
										<td>${m[j.cityid]}</td>
										<td>1天</td>
										<td>${js[st.index].sharecount}</td>
										<td>${js[st.index].browsecount}</td>
										<td>
											<c:choose>
												<c:when test="${j.isclosed == 0}">
													正常
												</c:when>
												<c:otherwise>
													关闭
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:choose>
												<c:when test="${j.isclosed == 0}">
													<a href="changejobstatus?jobid=${j.id}">
														<button class="btn btn-default btn-xs">关闭</button>
													</a>
												</c:when>
												<c:otherwise>
													<a href="changejobstatus?jobid=${j.id}">
														<button class="btn btn-default btn-xs">开启</button>
													</a>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td>你还未发布职位！</td></tr>
							</c:otherwise>
						</c:choose>
					</table>
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