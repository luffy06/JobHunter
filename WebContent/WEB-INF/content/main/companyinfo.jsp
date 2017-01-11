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
		
		<div class="companyinfo-all col-md-8 col-md-offset-2">
			
			<div class="companyinfo-head">
				<div class="col-md-3">
					<img src="public/img/1.png" class="img-circle"/>
					<p class="lead">${company.shortname}</p>
				</div>
				<div class="col-md-5">
					<p class="lead">${company.fullname}</p>
					<p>公司收藏数：${fcount}|公司岗位数：${jcount}|公司职位申请数：${acount}</p>
					<a href="favorite?type='company'&companyid=${company.id}"><button class="btn btn-info btn-lg">收藏</button></a>
				</div>
				<div class="col-md-4">	
					<p>行业：${m[company.industryid]}</p>
					<p>性质：${m[company.finanacestageid]}</p>
					<p>规模：${m[company.scaleid]}</p>
				</div>
			</div>	
			
			<div class="companyinfo-content">
				
				<div class="companyinfo-title">
					<p class="lead">公司简介</p>
				</div>
				<p>${company.description}</p>
				
				<div class="companyinfo-title">
					<p class="lead">联系方式</p>
				</div>
				<p>HR姓名：${hr.username}</p>
				<p>HR电话：${hr.telnumber}</p>
				<p>HR邮箱：${hr.email}</p>
				
				<div class="companyinfo-title">
					<p class="lead">招聘职位</p>
				</div>
				<table class="table table-hover">
					<tr>
						<th>IT技术实习生</th>
					</tr>
					<tr>
						<td>工作城市：武汉</td>
					     <td>经验：应届毕业生</td> 
					     <td>学历：不限</td>
					     <td>薪资：4000——5000</td>
					</tr>
					
				</table>
			</div>
		</div>
		
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/dist/js/bootstrap.min.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>