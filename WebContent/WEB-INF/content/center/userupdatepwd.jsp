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
<title>更新密码</title>
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
				<!--右侧内容修改密码-->
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<form class="form-horizontal" role="form" action="updatepwd" method="post">
							<div class="form-group">
								<label for="inputopsw" class="col-md-3 control-label">旧密码</label>
								<div class="col-md-9">
								   	<input type="password" class="form-control" id="inputopsw" name="opwd" placeholder="旧密码">
								</div>
							</div>
							<div class="form-group">
								<label for="inputnpsw" class="col-md-3 control-label">新密码</label>
								<div class="col-md-9">
								   	<input type="password" class="form-control" id="inputnpsw" name="npwd" placeholder="新密码">
								</div>
							</div>
							<div class="form-group">
								<label for="inputnpsw" class="col-md-3 control-label">确认新密码</label>
								<div class="col-md-9">
								   	<input type="password" class="form-control" id="inputnpsw" placeholder="再来一遍新密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-9 col-md-offset-3">
									<button class="btn btn-primary btn-block" type="submit">确定</button>
								</div>
							</div>
						</form>
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