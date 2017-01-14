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
<title>简历</title>
<link rel="stylesheet" href="public/css/bootstrap(custom).css">
<link rel="stylesheet" href="public/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
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
				<div class="user-post-resume">
					求职状态*
				</div>
				<!--求职状态-->	
				<div class="row">
					<div class="col-md-8">
						<form class="form-horizontal" role="form" action="saveresume?item=status" method="post">
							<div class="row">
								<div class="form-group col-md-10">
									<select class="form-control col-md-offset-1" name="resume.statusid">
										<c:if test="${! empty resume.statusid}">
											<option value="${resume.statusid}">${m[resume.statusid]}</option>
										</c:if>
										<c:forEach items="${status}" var="s" varStatus="st">
											<option value="${s}">${m[s]}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-md-2">
									<button class="btn btn-primary col-md-offset-10" type="submit">确定</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				
				<div class="user-post-resume">
					参加工作年份*
				</div>
				<!--参加工作年份-->	
				<div class="row">
					<div class="col-md-8">
						<form class="form-horizontal" role="form" action="saveresume?item=wep" method="post">
							<div class="row">
								<div class="form-group col-md-10">
									<select class="form-control col-md-offset-1" name="resume.workexperience">
										<c:if test="${! empty resume.workexperience}">
											<option value="${resume.workexperience}">${m[resume.workexperience]}</option>
										</c:if>
										<c:forEach items="${workexperience}" var="wep" varStatus="st">
											<option value="${wep}">${m[wep]}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-md-2">
									<button class="btn btn-primary col-md-offset-10" type="submit">确定</button>
								</div>
							</div>	
						</form>
					</div>
				</div>
				
				<div class="user-post-resume">
					期望职位*
				</div>
				
				<!--期望职位-->
				<div class="panel panel-default ">
					<div class="panel-heading" role="tab" id="workpp">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#occupation" aria-expanded="true" aria-controls="collapseOne">
							+ 添加期望职位
							</a>
						</h4>
					</div>
					<div id="occupation" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="workpp">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form class="form-horizontal" role="form" action="saveworkpp" method="post">
										<div class="form-group">
											<label for="inputwork" class="col-md-3 control-label">期望职位</label>
											<div class="col-md-9">
												<select class="form-control" name="workpp.skillid">
													<c:forEach items="${skill}" var="s" varStatus="st">
														<option value="${s}">${m[s]}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label for="inputwork" class="col-md-3 control-label">薪资范围</label>
											<div class="col-md-9">
												<select class="form-control" name="workpp.salaryid">
													<c:forEach items="${salary}" var="s" varStatus="st">
														<option value="${s}">${m[s]}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label for="inputwork" class="col-md-3 control-label">期望行业</label>
											<div class="col-md-9">
												<select class="form-control" name="workpp.industryid">
													<c:forEach items="${industry}" var="ind" varStatus="st">
														<option value="${ind}">${m[ind]}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label for="place" class="col-md-3 control-label">期望城市</label>
											<div class="col-md-9">
												<select class="form-control" name="workpp.cityid">
													<c:forEach items="${city}" var="c" varStatus="st">
														<option value="${c}">${m[c]}</option>
													</c:forEach>
												</select>
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
				</div><!--期望职位表单-->
				
				<!--期望职位列表-->
				<c:if test="${! empty workpp}">
					<div class="panel panel-primary">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-10">
									<div class="col-md-3">期望城市</div>
									<div class="col-md-1"><span>|</span></div>
									<div class="col-md-3">期望技能</div>
									<div class="col-md-1"><span>|</span></div>
									<div class="col-md-3">薪资范围</div>
								</div>
							</div>
							<hr>
							<c:forEach items="${workpp}" var="wp" varStatus="st">
								<div class="row">
									<div class="col-md-10">
										<div class="col-md-3">${m[wp.cityid]}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-3">${m[wp.skillid]}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-3">${m[wp.salaryid]}</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				
					
				<div class="user-post-resume">
					我的优势*
				</div>
				<div class="row">
					<div class="col-md-8">
						<form class="form-horizontal" role="form" action="saveresume?item=advantage" method="post">
							<div class="row">
								<div class="form-group col-md-10">
									<c:choose>
										<c:when test="${! empty resume.advantage}">
											<input type="text" class="form-control col-md-offset-1" name="resume.advantage" value="${resume.advantage}" id="advantage" placeholder="填入我的优势">
										</c:when>
										<c:otherwise>
											<input type="text" class="form-control col-md-offset-1" name="resume.advantage" id="advantage" placeholder="填入我的优势">
										</c:otherwise>										
									</c:choose>
								</div>
								<div class="form-group col-md-2">
									<button class="btn btn-primary col-md-offset-10" type="submit">确定</button>
								</div>
							</div>
						</form>
					</div>
				</div><!--我的优势end-->
				
				<div class="user-post-resume">
					工作经历*
				</div>
				
				<!--工作经历-->
				<div class="panel panel-default ">
					<div class="panel-heading" role="tab" id="workpp">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#experience" aria-expanded="true" aria-controls="collapseOne">
								+ 添加工作经历
							</a>
						</h4>
					</div>
					<div id="experience" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="workpp">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form class="form-horizontal" role="form" action="saveworkep" method="post">
										<div class="form-group">
											<label for="inputjobtype" class="col-md-3 control-label">职位类型</label>
											<div class="col-md-9">
												<select class="form-control" name="workep.jobtypeid">
													<c:forEach items="${jobtype}" var="jt" varStatus="st">
														<option value="${jt}">${jobtypename[st.index]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--职位类型-->
										<div class="form-group">
											<label for="jobname" class="col-md-3 control-label">职位名称</label>
											<div class="col-md-9">
											   	<input type="text" class="form-control" name="workep.jobname" id="jobname" placeholder="填入职位名称">
											</div>
										</div><!--职位名称-->
										<div class="form-group">
											<label for="skillmark" class="col-md-3 control-label">城市</label>
											<div class="col-md-9">
												<select class="form-control" name="workep.cityid">
													<c:forEach items="${city}" var="c" varStatus="st">
														<option value="${c}">${m[c]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--城市-->
										<div class="form-group">
											<label for="companyname" class="col-md-3 control-label">公司名称</label>
											<div class="col-md-9">
											   	<input type="text" class="form-control" name="workep.companyname" id="companyname" placeholder="填入公司名称">
											</div>
										</div><!--公司名称-->
										<div class="form-group">
											<label for="companyindustry" class="col-md-3 control-label">公司行业</label>
											<div class="col-md-9">
												<select class="form-control" name="workep.industryid">
													<c:forEach items="${industry}" var="ind" varStatus="st">
														<option value="${ind}">${m[ind]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--公司行业-->
										
										<div class="form-group">
											<label for="skillmark" class="col-md-3 control-label">技能标签</label>
											<div class="col-md-9">
												<select class="form-control" name="workep.skillid">
													<c:forEach items="${skill}" var="s" varStatus="st">
														<option value="${s}">${m[s]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--技能标签-->
										<div class="form-group">
											<label for="partment" class="col-md-3 control-label">所属部门</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="workep.department" id="partment" placeholder="填入职位所属部门">
											</div>
										</div><!--所属部门-->
										<div class="form-group">
											<label for="starttime" class="col-md-3 control-label">开始时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="workep.starttime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--开始时间-->
										<div class="form-group">
											<label for="endtime" class="col-md-3 control-label">结束时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="workep.endtime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--结束时间-->
										<div class="form-group">
											<label for="workcontent" class="col-md-3 control-label">工作内容</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="workep.description" id="workcontent" placeholder="例如： 主要负责新员工入职培训 ">
											</div>
										</div>
										<div class="form-group">
											<label for="skillmark" class="col-md-3 control-label">对该公司隐藏</label>
											<div class="col-md-9">
												<select class="form-control" name="workep.ishide">
													<option value="1">是</option>
													<option value="0">否</option>
												</select>
											</div>
										</div><!--技能标签-->
										
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
				</div><!--工作经历-->
				
				<!--工作经历列表-->
				<c:if test="${! empty workep}">
					<div class="panel panel-primary">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-10">
									<div class="col-md-2">时间段</div>
									<div class="col-md-2">公司名称</div>
									<div class="col-md-2">部门</div>
									<div class="col-md-2">城市</div>
									<div class="col-md-2">职位名称</div>
								</div>
							</div>
							<hr>
							<c:forEach items="${workep}" var="we" varStatus="st">
								<div class="row">
									<div class="col-md-10">
										<div class="col-md-2">${we.starttime}~${we.endtime}</div>
										<div class="col-md-2">${we.companyname}</div>
										<div class="col-md-2">${we.department}</div>
										<div class="col-md-2">${m[we.cityid]}</div>
										<div class="col-md-2">${we.jobname}</div>
									</div>
									<div class="col-md-8">
										<div class="col-md-12">工作内容：${we.description}</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				
				<div class="user-post-resume">
					教育经历*
				</div>
				
				<div class="panel panel-default ">
					<div class="panel-heading" role="tab" id="workpp">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#education" aria-expanded="true" aria-controls="collapseOne">
								+ 添加教育经历
							</a>
						</h4>
					</div>
					<div id="education" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="workpp">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form class="form-horizontal" role="form" action="saveeduexp" method="post">
										<div class="form-group">
											<label for="schoolname" class="col-md-3 control-label">学校名称</label>
											<div class="col-md-9">
												<select class="form-control" name="eduexp.schoolid">
													<c:forEach items="${school}" var="s" varStatus="st">
														<option value="${s}">${m[s]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--学校名称-->
										<div class="form-group">
											<label for="majorname" class="col-md-3 control-label">专业名称</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="eduexp.major" id="schoolname" placeholder="填入专业名称">
											</div>
										</div><!--专业名称-->
										<div class="form-group">
											<label for="inputdip" class="col-md-3 control-label">学历</label>
											<div class="col-md-9">
												<select class="form-control" name="eduexp.diplomaid">
													<c:forEach items="${diploma}" var="d" varStatus="st">
														<option value="${d}">${m[d]}</option>
													</c:forEach>
												</select>
											</div>
										</div><!--学历-->
										<div class="form-group">
											<label for="starttime" class="col-md-3 control-label">开始时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="eduexp.starttime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--开始时间-->
										<div class="form-group">
											<label for="endtime" class="col-md-3 control-label">结束时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="eduexp.endtime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--结束时间-->
										
										<div class="form-group">
											<label for="inputeintro" class="col-md-3 control-label">在校经历</label>
											<div class="col-md-9">
											   	<textarea class="col-md-12" name="eduexp.description"></textarea>
											</div>
										</div><!--在校经历描述-->
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
				</div><!--教育经历-->
				
				<!--教育经历列表-->
				<c:if test="${! empty eduexp}">
					<div class="panel panel-primary">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-10">
									<div class="col-md-3">时间段</div>
									<div class="col-md-1"><span>|</span></div>
									<div class="col-md-2">学校</div>
									<div class="col-md-1"><span>|</span></div>
									<div class="col-md-2">专业</div>
									<div class="col-md-1"><span>|</span></div>
									<div class="col-md-2">学历</div>
								</div>
							</div>
							<hr>
							<c:forEach items="${eduexp}" var="ee" varStatus="st">
								<div class="row">
									<div class="col-md-10">
										<div class="col-md-3">${ee.starttime}~${ee.endtime}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-2">${m[ee.schoolid]}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-2">${ee.major}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-2">${m[ee.diplomaid]}</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				
				<div class="user-post-resume">
					项目经验*
				</div>
				
				<div class="panel panel-default ">
					<div class="panel-heading" role="tab" id="projectexp">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#project" aria-expanded="true" aria-controls="collapseOne">
							+ 添加项目经验
							</a>
						</h4>
					</div>
					<div id="project" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="workpp">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form class="form-horizontal" role="form" action="saveproexp" method="post">
										<div class="form-group">
											<label for="projectname" class="col-md-3 control-label">项目名称</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="proexp.projectname" id="projectname" placeholder="填入项目名称">
											</div>
										</div><!--项目名称-->
										<div class="form-group">
											<label for="role" class="col-md-3 control-label">项目角色</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="proexp.role" id="role" placeholder="填入项目角色">
											</div>
										</div><!--项目角色-->
										<div class="form-group">
											<label for="url" class="col-md-3 control-label">项目网址</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="proexp.url" id="url" placeholder="填入项目主页，可选填">
											</div>
										</div><!--项目URL-->
										<div class="form-group">
											<label for="achievement" class="col-md-3 control-label">项目成就</label>
											<div class="col-md-9">
												<textarea class="col-md-12" name="proexp.achievement"></textarea>
											</div>
										</div><!--项目成就-->
										<div class="form-group">
											<label for="description" class="col-md-3 control-label">项目描述</label>
											<div class="col-md-9">
												<textarea class="col-md-12" name="proexp.description"></textarea>
											</div>
										</div><!--项目描述-->
										<div class="form-group">
											<label for="starttime" class="col-md-3 control-label">开始时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="proexp.starttime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--开始时间-->
										<div class="form-group">
											<label for="endtime" class="col-md-3 control-label">结束时间</label>
											<div class="col-md-9 date form_datetime">
												<input type="text" class="form-control" name="proexp.endtime" readonly="readonly" value=""/>
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-calendar"></i>
												</span>
											</div>
										</div><!--结束时间-->
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
				</div><!--项目经验-->
				
				<!--项目经历列表-->
				<c:if test="${! empty proexp}">
					<div class="panel panel-primary">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-10">
									<div class="col-md-3">
										时间段
									</div>
									<div class="col-md-1">
										<span>|</span>
									</div>
									<div class="col-md-3">
										项目名称
									</div>
									<div class="col-md-1">
										<span>|</span>
									</div>
									<div class="col-md-3">
										担任角色
									</div>
								</div>
							</div>
							<c:forEach items="${proexp}" var="pe" varStatus="st">
								<div class="row">
									<div class="col-md-10">
										<div class="col-md-3">${pe.starttime}~${pe.endtime}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-3">${pe.projectname}</div>
										<div class="col-md-1"><span>|</span></div>
										<div class="col-md-3">${pe.role}</div>
									</div>
								</div>
								<div class="col-md-10">
									<p>项目描述：${pe.description}</p>
									<p>项目业绩：${pe.achievement}</p>
									<p>项目网站：${pe.url}</p>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				<div class="user-post-resume">
					社交主页*
				</div>
				<div class="panel panel-default ">
					<div class="panel-heading" role="tab" id="workpp">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" href="#home" aria-expanded="true" aria-controls="collapseOne">
								+ 社交主页
							</a>
						</h4>
					</div>
					<div id="home" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="workpp">
						<div class="panel-body">
							<div class="row">
								<p>建议添加能突出你个人实力的主页，如微博，github，dribble，lofter等</p>
								<form class="form-horizontal" role="form" action="saveresume?item=url" method="post">
									<div class="form-group">
										<div class="col-md-9">
											<c:choose>
												<c:when test="${! empty resume.homepage}">
													<input type="text" class="form-control" name="resume.homepage" value="${resume.homepage}" id="homepage" placeholder="请填写个人作品网页地址">
												</c:when>
												<c:otherwise>
													<input type="text" class="form-control" name="resume.homepage" id="homepage" placeholder="请填写个人作品网页地址">
												</c:otherwise>
											</c:choose>
										</div>
									</div><!--个人主页-->
									<div class="form-group">
										<div class="col-md-2 col-md-offset-4">
											<button class="btn btn-primary btn-block" type="submit">确定</button>
										</div>
									</div>
								</form>	
							</div>	
						</div>
					</div>
				</div><!--社交主页-->
			</div>
		</div>
		<hr>
		<div class="row">
			<s:action name="sidebar_footerframe" executeResult="true"></s:action>
		</div>
	</div>
	<script src="public/bower_components/jquery/jquery.js"></script>
	<script src="public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="public/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="public/js/main.js"></script>
</body>
</html>