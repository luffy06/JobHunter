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
						<form class="form-horizontal" role="form" action="postjob" method="post">
							<div class="form-group">
								<label for="inputejob" class="col-md-2 control-label">职位名称</label>
								<div class="col-md-6">
								   	<input type="text" class="form-control" id="inputejob" name="job.jobname" placeholder="请填入要发布职位名称">
								</div>
							</div>
							<div class="form-group">
								<label for="inputejobtype" class="col-md-2 control-label">职位类型</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.jobtypeid"> 
										<c:forEach items="${jobtypelist}" var="jtl" varStatus="st">
											<option value="${jtil[st.index]}">${jtl}</option>
										</c:forEach>
								    </select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputskill" class="col-md-2 control-label">技能要求</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.skillid"> 
									    <c:forEach items="${skilllist}" var="sl" varStatus="st">
										    <option value="${sl}">${m[sl]}</option>
									    </c:forEach>
								    </select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputecity" class="col-md-2 control-label">工作城市</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.cityid"> 
									    <c:forEach items="${citylist}" var="cl" varStatus="st">
										    <option value="${cl}">${m[cl]}</option>
									    </c:forEach>
								    </select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputadd" class="col-md-2 control-label">工作具体地点</label>
								<div class="col-md-6">
								   	<input type="text" class="form-control" id="inputeadd" name="job.workaddress" placeholder="请填入工作具体地点">
								</div>
							</div>
							<div class="form-group">
								<label for="inputesalary" class="col-md-2 control-label">薪资范围</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.salaryid"> 
									    <c:forEach items="${salarylist}" var="sl" varStatus="st">
										    <option value="${sl}">${m[sl]}</option>
									    </c:forEach>
								    </select>
								</div>
							</div>
							
							<div class="user-post-resume">
								期望职位*
							</div>

							<div class="form-group">
								<label for="inputeexp" class="col-md-2 control-label">经验要求</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.experienceid"> 
									    <c:forEach items="${experiencelist}" var="el" varStatus="st">
										    <option value="${el}">${m[el]}</option>
									    </c:forEach>
								    </select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputdip" class="col-md-2 control-label">学历要求</label>
								<div class="col-md-6">
								   	<select class="form-control" name="job.diplomaid">
								   		<c:forEach items="${diplomalist}" var="dl" varStatus="st">
										    <option value="${dl}">${m[dl]}</option>
								   		</c:forEach> 
								    </select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputeintro" class="col-md-2 control-label">职位描述</label>
								<div class="col-md-6">
								   	<textarea class="col-md-12" name="job.description"></textarea>
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