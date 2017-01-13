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
		<div class="row">
			<div class="col-md-3">
				<s:action name="sidebar_leftframe" executeResult="true"></s:action>
			</div>
			<div class="col-md-8 col-md-offset-1">
				<c:if test="${! empty company}">
					<div class="user-post-resume">
						公司基本信息*
					</div>
					<div class="row">
						<div class="col-md-3">公司全称</div>
						<div class="col-md-3">${company.fullname}</div>
					</div>
					<br/>
					<div class="row">
						<div class="col-md-3">公司简称</div>
						<div class="col-md-3">${company.shortname}</div>
					</div>
				</c:if>
				
				<div class="user-post-resume">
					职位基本信息*
				</div>
				<div class="row">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputejob" class="col-md-2 control-label">职位名称</label>
							<div class="col-md-6">
							   	<input type="text" class="form-control" id="inputejob" placeholder="请填入要发布职位名称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputejobtype" class="col-md-2 control-label">职位类型</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>请选择</option>
									<option>java</option>
									<option>android</option>
							    </select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputskill" class="col-md-2 control-label">技能要求</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>请选择</option>
							    </select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputecity" class="col-md-2 control-label">工作城市</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>请选择</option>
									<option>北京</option>
									<option>武汉</option>
							    </select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputadd" class="col-md-2 control-label">工作具体地点</label>
							<div class="col-md-6">
							   	<input type="text" class="form-control" id="inputeadd" placeholder="请填入工作具体地点">
							</div>
						</div>
						<div class="form-group">
							<label for="inputesalary" class="col-md-2 control-label">薪资范围</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>请选择</option>
									<option>1000-2000</option>
							    </select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<button class="btn btn-primary btn-block" type="submit">保存</button>
							</div>
						</div>
					</form>
				</div>
				<div class="user-post-resume">
					期望职位*
				</div>
				<div class="row">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputeexp" class="col-md-2 control-label">经验要求</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>不限</option>
									<option>应届生</option>
									<option>一年以内</option>
							    </select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputdip" class="col-md-2 control-label">学历要求</label>
							<div class="col-md-6">
							   	<select class="form-control"> 
								    <option>不限</option>
								    <option>大专</option>
							    </select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputeintro" class="col-md-2 control-label">职位描述</label>
							<div class="col-md-6">
							   	<textarea class="col-md-12"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<button class="btn btn-primary btn-block" type="submit">保存</button>
							</div>
						</div>
					</form>
				</div>
				<div class="user-post-resume">
					其他信息*
				</div>
				<div class="row">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputeemail" class="col-md-2 control-label">接收简历邮箱</label>
							<div class="col-md-6">
							   	<input type="email" class="form-control" id="inputeemail" placeholder="请填入要接收简历的邮箱">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<button class="btn btn-primary btn-block" type="submit">保存</button>
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
	<script src="public/js/main.js"></script>
</body>
</html>