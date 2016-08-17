<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--日历-->
<link rel="stylesheet" href="../css/style.default.css" type="text/css" />
<link type="text/css" rel="stylesheet" href="../css/kalendar.css" /> 

<script type="text/javascript" src="../js/custom/jquery.min.js"></script>
<script type="text/javascript" src="../js/custom/kalendar.js"></script>
<script type="text/javascript" src="../js/custom/general.js"></script>
<script type="text/javascript" src="../js/custom/dashboard.js"></script>
<script type="text/javascript" src="../js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.slimscroll.js"></script>
<title>首页</title>
</head>
<body>
	<div class="bodywrapper">
		<div class="topheader">
			<!--left-->
			<div class="left">
				<h1 class="logo">
					弘飞电缆APP<span>后台</span>
				</h1>
				<br clear="all" />
			</div>
			<!--userinfo-->
			<div class="right">
				<div class="userinfo">
					<img src="../images/thumbs/avatar.png" alt="" /> <span>${CurrentUser }</span>
				</div>

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="../images/thumbs/avatarbig.png" alt="" /></a>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>${CurrentUser}</h4>
						<ul>
							<li><a href="admin-login.jsp">退出</a></li>
						</ul>
					</div>
					<!--userdata-->
				</div>
				<!--userinfodrop-->
			</div>
			<!--right-->
		</div>
		<!--topheader-->


		<div class="header">
			<ul class="headermenu">
				<li class="current" id="li0"><a href="${ctx }/program!getAll"><span
						class="icon icon-flatscreen"></span>首页</a></li>
				<li class="l_menu" id="li1"><a
					href="${pageContext.request.contextPath}/company/list"><span
						class="icon icon-pencil"></span>公司</a></li>
				<li class="l_menu" id="li2"><a href="${ctx }/task!getUndone"><span
						class="icon icon-message"></span>任务</a></li>
				<li class="l_menu" id="li3"><a href="workhour-check.jsp"><span
						class="icon icon-chart"></span>项目审核</a></li>
				<li class="" id="li3"><a href="work-hour.jsp"><span
						class="icon icon-chart"></span>工时表</a></li>
				<li id="li3"><a href="require.jsp"><span
						class="icon icon-message"></span>需求</a></li>
				<li id="li3"><a href="require.jsp"><span
						class="icon icon-message"></span>统计</a></li>
			</ul>
		</div>
		<!--header-->

		<div class="tabcon">
			<div class="centercontent">
				<div id="contentwrapper" class="contentwrapper">
					<div class="two_third dashboard_left">
						<br clear="all" />

						<div class="contenttitle2 nomargintop">
							<h3>我的项目</h3>
						</div>
						<!--contenttitle-->

						<table cellpadding="0" cellspacing="0" border="0"
							class="stdtable stdtablecb overviewtable2">
							<colgroup>
								<col class="con0" style="width: 4%" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
							</colgroup>
							<thead>
								<tr>
									<th class="head0">序号</th>
									<th class="head1">项目名称</th>
									<th class="head0">开始时间</th>
									<th class="head1">结束时间</th>
									<th class="head1">当前阶段</th>
									<th class="head0">经历天数</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach varStatus="status" items="${programList }"
									var="program">
									<tr>
										<td>${status.count }</td>
										<td>${program.pname }</td>
										<td>${program.planstart }</td>
										<td>${program.planend }</td>
										<td class="center">${program.stage.name }</td>
										<td class="center">${program.days }</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>

						<br />

						<!-- 图形 -->
					</div>
					<!--two_third dashboard_left-->


					<div class="one_third last dashboard_right">
						<%-- <c:if test="#session.role=='项目经理 '"> --%>
						<div class="contenttitle2 nomargintop">
							<h3>待办事项</h3>
						</div>
						<!--contenttitle-->
						<ul class="toplist">
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="desc">我的任务</span>
									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last">
										<div class="notification">
											<a class="count" href="ajax/notifications.html"><span>${task }</span></a>
										</div>
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="desc">待审核的工时</span>

									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last">
										<div class="notification">
											<a class="count" href="ajax/notifications.html"><span>${hnum }</span></a>
										</div>
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="desc">待审核的任务</span>
									</span> <!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last">
										<div class="notification">
											<a class="count" href="ajax/notifications.html"><span>${progress }</span></a>
										</div>
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
						</ul>
						<%-- </c:if> --%>
						<div class="widgetbox">
							<div class="widgetoptions">

								<div id='wrap'>
									<!-- 因为日历初始显示的内容要根据js获得的日期-时间来确定，所以html中不写，在js中用另一种形式添加 -->
								</div>
							</div>
						</div>
					</div>
					<!--one_third last-->


				</div>
				<!--#updates-->

				<div id="activities" class="subcontent" style="display: none;">
					&nbsp;</div>
				<!--#activities-->

			</div>
			<!--contentwrapper-->

			<br clear="all" />

		</div>
		<!-- centercontent -->
	</div>
</body>
</html>