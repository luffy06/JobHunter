<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="row">
			<div class="login-content">
				<div class="col-md-3 col-md-offset-8">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h1 class="panel-title">登录</h1>
						</div>
						<div class="panel-body">
							<form class="form-horizontal" action="login" method="post" role="form">
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group">
											<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
											<input class="form-control" type="text" name="user.email" placeholder="邮箱"/>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group">
											<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
											<input class="form-control" type="password" name="user.password" placeholder="密码"/>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<button class="btn btn-primary btn-block" type="submit">登录</button>
									</div>
								</div>	
							</form>
						</div>
						<div class="panel-footer">
							<a href="##">忘记密码</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<hr>
		<div class="row" style="margin-top:500px">
			<s:action name="sidebar_footerframe" executeResult="true"></s:action>
		</div>
	</div>
	
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>