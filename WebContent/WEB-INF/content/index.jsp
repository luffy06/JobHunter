<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
		</div>
		<div class="index-content">
			<div class="row">
				<div class="col-md-10 col-md-offset-2">
					<form action="joblist" method="post" role="form">
						<div class="form-group">
							<div class="col-md-8">
								<input class="form-control" type="text" name="jobname" placeholder="搜索公司或职位"/>
							</div>
							<div class="col-md-2">
								<button class="btn btn-primary" type="submit">搜索</button>
							</div>
						</div>	
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/dist/js/bootstrap.min.js"></script>
</body>
</html>