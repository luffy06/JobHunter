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
<title>左导航栏</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/css/main.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row user-left">
			<div class="panel-group" id="user_nav" role="tablist" aria-multiselectable="true">
				<div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      	<h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#user_nav" href="#collapseOne" 
					        		aria-expanded="true" aria-controls="collapseOne">
					        	<img src="public/img/userportrait/${user.portrait}.png" class="img-circle" />
					        </a>
				      	</h4>
				    </div>
				     <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
				      	<div class="panel-body">
							<div class="list-group">
								<a href="getuserinfo" class="list-group-item">
									我的资料
								</a>
							</div>
				      	</div>
				    </div>
				</div><!--头像和资料部分-->
				<div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingTwo">
				      	<h4 class="panel-title">
				       		<a class="collapsed" data-toggle="collapse" data-parent="#user_nav" href="#collapseTwo" 
				       			aria-expanded="false" aria-controls="collapseTwo">
				         		简历
				        	</a>
				      	</h4>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				      	<div class="panel-body">
							<div class="list-group">
								<a href="getuserresume"  class="list-group-item">
									微简历
								</a>
							</div>
							<div class="list-group">
								<a href="#"  class="list-group-item">
									上传简历
								</a>
							</div>
							<div class="list-group">
								<a href="getuserpost"  class="list-group-item">
									我的投递
								</a>
							</div>
				      	</div>
				    </div>
			  	</div><!--简历部分-->
			  	<div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingFour">
				      	<h4 class="panel-title">
				       		<a class="collapsed" data-toggle="collapse" data-parent="#user_nav" href="#collapseFour" 
				       			aria-expanded="false" aria-controls="collapseFour">
				         		收藏夹
				        	</a>
				      	</h4>
				    </div>
				    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
				      	<div class="panel-body">
							<div class="list-group">
								<a href="getcomanyfavorite"  class="list-group-item">
									收藏公司
								</a>
							</div>
							<div class="list-group">
								<a href="getoxerfavorite"  class="list-group-item">
									收藏人
								</a>
							</div>
							<div class="list-group">
								<a href="getjobfavorite"  class="list-group-item">
									收藏职位
								</a>
							</div>
				      	</div>
				    </div>
			  	</div><!--收藏夹-->
			  	
			  	<div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingFive">
				      	<h4 class="panel-title">
				       		<a class="collapsed" data-toggle="collapse" data-parent="#user_nav" href="#collapseFive" 
				       			aria-expanded="false" aria-controls="collapseFive">
				         		职位
				        	</a>
				      	</h4>
				    </div>
				    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
				      	<div class="panel-body">
				      		<div class="list-group">
								<a href="getusercompany"  class="list-group-item">
									我的公司
								</a>
							</div>
							<div class="list-group">
								<a href="getissuedjob"  class="list-group-item">
									职位列表
								</a>
							</div>
							<div class="list-group">
								<a href="getpostjob"  class="list-group-item">
									发布新岗位
								</a>
							</div>
							<div class="list-group">
								<a href="getcandidate"  class="list-group-item">
									候选人
								</a>
							</div>
				      	</div>
				    </div>
			  	</div><!--我的求职状态-->
			  	
			 	<div class="panel panel-default">
			    	<div class="panel-heading" role="tab" id="headingSix">
			      		<h4 class="panel-title">
			        		<a class="collapsed" data-toggle="collapse" data-parent="#user_nav" href="#collapseSix"
			        		 aria-expanded="false" aria-controls="collapseSix">
			          			<a href="getuserupdatepwd">修改密码</a>
			        		</a> 
			      		</h4>
			    	</div>
			 	</div><!--修改密码-->
			</div>
		</div>
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>