<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="register-content">
			<div class="row">
				<div class="col-md-5 col-md-offset-3">
					<form class="form-horizontal" action="register" role="form" id="registerform" method="post">
						<div class="form-group">
							<label for="inputname" class="col-md-3 control-label">头像</label>
							<div class="col-md-9">
								<c:forEach var="p" begin="0" end="1" step="1">
									<div class="row">
										<c:forEach var="x" begin="1" end="4" step="1">
											<div class="col-md-3">
												<img class="img-responsive img-rounded" alt="${x +4 * p}" src="public/img/userportrait/${x + 4 * p}.png">
												<input type="radio" name="user.portrait" value="${x + 4 * p}">
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="inputname" class="col-md-3 control-label">姓名</label>
							<div class="col-md-9">
							   	<input type="text" name="user.username" class="form-control" id="inputname" placeholder="姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputpsw" class="col-md-3 control-label">密码</label>
							<div class="col-md-9">
							   	<input type="password" name="user.password" class="form-control" id="inputpsw" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputsex" class="col-md-3 control-label">姓别</label>
							<div class="col-md-9">
							   	<select name="user.sex" class="form-control"> 
								    <option value="1">男</option> 
								    <option value="0">女</option> 
							    </select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputtelnum" class="col-md-3 control-label">手机号码</label>
							<div class="col-md-9">
							   	<input type="text" name="user.telnumber" class="form-control" id="inputtelnum" placeholder="手机号码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputemail" class="col-md-3 control-label">常用邮箱</label>
							<div class="col-md-9">
							   	<input type="email" name="user.email" class="form-control" id="inputemail" placeholder="常用邮箱">
							</div>
						</div>
						<div class="form-group">
							<label for="inputwechat" class="col-md-3 control-label">微信号</label>
							<div class="col-md-9">
							   	<input type="text" name="user.wechat" class="form-control" id="inputwechat" placeholder="微信号">
							</div>
						</div>
						<div class="form-group">
							<label for="inputwork" class="col-md-3 control-label">工作年份</label>
							<div class="col-md-9">
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
							<div class="col-md-9 col-md-offset-3">
								<button class="btn btn-primary btn-block" type="submit">注册</button>
							</div>
						</div>
					</form>
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
	<script type="text/javascript" src="public/js/main.js"></script>
</body>
</html>