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
<title>公司</title>
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
				<form class="form-horizontal" action="updateusercompany" role="form">
					<!--头像-->
					<div class="form-group">
						<label for="inputecompany" class="col-md-3 control-label">公司全称</label>
						<div class="col-md-9">
							<c:choose>
								<c:when test="${! empty company}">
									<input type="text" class="form-control" name="company.fullname" id="inputecompany" value="${company.fullname}">
								</c:when>
								<c:otherwise>
							   		<input type="text" class="form-control" name="company.fullname" id="inputecompany">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label for="inputecom" class="col-md-3 control-label">公司简称</label>
						<div class="col-md-9">
							<c:choose>
								<c:when test="${! empty company}">
									<input type="text" class="form-control" name="company.shortname" id="inputecom" value="${company.shortname}">
								</c:when>
								<c:otherwise>
								   	<input type="text" class="form-control" name="company.shortname" id="inputecom">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputscale" class="col-md-3 control-label">公司规模</label>
						<div class="col-md-9">
						   	<select class="form-control" name="company.scaleid">
						   		<c:if test="${! empty company}">
						   			<option value="${company.scaleid}">${m[company.scaleid]}</option>
						   		</c:if>
						   		<c:forEach items="${scalelist}" var="sl" varStatus="st">
						   			<option value="${sl}">${m[sl]}</option>
						   		</c:forEach>
						    </select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputesalary" class="col-md-3 control-label">融资规模</label>
						<div class="col-md-9">
						   	<select class="form-control" name="company.finanacestageid">
						   		<c:if test="${! empty company}">
						   			<option value="${company.finanacestageid}">${m[company.finanacestageid]}</option>
						   		</c:if> 
						   		<c:forEach items="${finanacestagelist}" var="fl" varStatus="st">
								    <option value="${fl}">${m[fl]}</option>
						   		</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputeindustry" class="col-md-3 control-label">公司行业</label>
						<div class="col-md-9">
						   	<select class="form-control" name="company.industryid">
						   		<c:if test="${! empty company}">
						   			<option value="${company.industryid}">${m[company.industryid]}</option>
						   		</c:if> 
						   		<c:forEach items="${industrylist}" var="il" varStatus="st">
								    <option value="${il}">${m[il]}</option>					   		
						   		</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputehome" class="col-md-3 control-label">公司主页</label>
						<div class="col-md-9">
							<c:choose>
								<c:when test="${! empty company}">
									<input type="text" class="form-control" name="company.homepage" id="inputehome" value="${company.homepage}">
								</c:when>
								<c:otherwise>
								   	<input type="text" class="form-control" name="company.homepage" id="inputehome">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label for="inputeintro" class="col-md-3 control-label">公司简介</label>
						<div class="col-md-9">
							<c:choose>
								<c:when test="${! empty company}">
									<textarea class="col-md-12" name="company.description" >${company.description}</textarea>
								</c:when>
								<c:otherwise>
								   	<textarea class="col-md-12" name="company.description"></textarea>
								</c:otherwise>
							</c:choose>
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