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
<title>个人信息</title>
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
				<!--我的详细信息-->
				<form class="form-horizontal" action="updateuserinfo" role="form" method="post">
					<div class="form-group">
						<label for="inputname" class="col-md-3 control-label">头像</label>
						<div class="col-md-9">
							<c:forEach var="p" begin="0" end="1" step="1">
								<div class="row">
									<c:forEach var="x" begin="1" end="4" step="1">
										<div class="col-md-3">
											<img class="img-responsive img-rounded" alt="${x +4 * p}" src="public/img/userportrait/${x + 4 * p}.png">
											<c:choose>
												<c:when test="${user.portrait != x + 4 * p}">
													<input type="radio" name="user.portrait" value="${x + 4 * p}">
												</c:when>
												<c:otherwise>
													<input type="radio" name="user.portrait" value="${x + 4 * p}" checked="checked">
												</c:otherwise>
											</c:choose>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="form-group">
						<label for="inputname" class="col-md-3 control-label">姓名</label>
						<div class="col-md-9">
						   	<input type="text" name="user.username" class="form-control" id="inputname" value="${user.username}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputsex" class="col-md-3 control-label">姓别</label>
						<div class="col-md-9">
						   	<select name="user.sex" class="form-control">
						   		<c:choose>
						   			<c:when test="${user.sex == 1}">
						   				<option value="1">男</option> 
							    		<option value="0">女</option>
						   			</c:when>
						   			<c:otherwise>
							    		<option value="0">女</option>
						   				<option value="1">男</option> 
						   			</c:otherwise>
						   		</c:choose>  
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputtelnum" class="col-md-3 control-label">手机号码</label>
						<div class="col-md-9">
						   	<input type="text" name="user.telnumber" class="form-control" id="inputtelnum" value="${user.telnumber}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputwechat" class="col-md-3 control-label">微信号</label>
						<div class="col-md-9">
						   	<input type="text" name="user.wechat" class="form-control" id="inputwechat" value="${user.wechat}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputwork" class="col-md-3 control-label">工作年份</label>
						<div class="col-md-9">
							<!-- 无法显示用户信息 -->
						   	<select name="user.workingtime" class="form-control"> 
								<option value="应届生">应届生</option>
								<option value="2017">2017年</option>
								<option value="2016">2016年</option>
								<option value="2015">2015年</option>
								<option value="2014">2014年</option>
								<option value="2013">2013年</option>
								<option value="2012">2012年</option>
								<option value="2011">2011年</option>
								<option value="-2011">2011年以前</option>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4 col-md-offset-5">
							<button class="btn btn-primary btn-block" type="submit">保存</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>