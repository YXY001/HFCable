<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/charCount.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/forms.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/dashboard.js"></script>

<link href="${pageContext.request.contextPath}/css/style.default.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/other.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/tanchu.css" rel="Stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.prolist.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$("#example").click(function() {
		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").fadeIn("slow");
		$("#default").fadeIn("slow");
	});

	$(".close_btn").hover(function() {
		$(this).css({
			color : 'black'
		})
	}, function() {
		$(this).css({
			color : '#999'
		})
	}).on('click', function() {
		$("#default").fadeOut("fast");
		$("#mask").css({
			display : 'none'
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#delete").click(function() {
			//获取a链接中的href
			var href = $(this).attr("href");
			//将href赋值给form表单中的action
			$("form").attr("action", href).submit();
			return false;
		});

	})
</script>
<title>公司信息</title>
</head>
<body class="withvernav">
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
	</form>


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
					<img src="${pageContext.request.contextPath}/images/thumbs/avatar.png" alt="" /> <span>${CurrentUser }</span>
				</div>

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="${pageContext.request.contextPath}/images/thumbs/avatarbig.png" alt="" /></a>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>${CurrentUser }</h4>
						<ul>
							<li><a href="${pageContext.request.contextPath }/user/loginOut">退出</a></li>
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
				<li class="l_menu" id="li3"><a href="${pageContext.request.contextPath }/product/toProduct"><span class="icon icon-chart"></span>产品</a></li>
				<li class="l_menu" id="li3"><a href="${pageContext.request.contextPath }/type/toType"><span class="icon icon-message"></span>种类</a></li>
				<li class="current" id="li1"><a href="${pageContext.request.contextPath }/company/list"><span class="icon icon-pencil"></span>公司</a></li>
				<%-- <li id="li0"><a href="${ctx }/program!getAll"><span class="icon icon-flatscreen"></span>首页</a></li>
				<li class="l_menu" id="li1"><a href="${ctx }/program!getUndone1"><span class="icon icon-pencil"></span>项目</a></li>
				<li class="l_menu" id="li2"><a href="${ctx }/task!getUndone"><span class="icon icon-message"></span>任务</a></li>
				<li class="l_menu" id="li3"><a href="workhour-check.jsp"><span class="icon icon-chart"></span>项目审核</a></li>
				<li id="li3"><a href="chart.jsp"><span class="icon icon-message"></span>统计</a></li> --%>
			</ul>
		</div>
		<!--header-->
		<div class="vernav iconmenu">
			<ul>
				<c:if test="${empty sessionScope.company }">
					<li class="current"><a href="${pageContext.request.contextPath }/company/add" class="inbox">添加公司信息</a></li>
				</c:if>
				<c:if test="${!empty sessionScope.company }">
					<li class="current"><a class="drafts" href="${pageContext.request.contextPath }/company/list">公司信息管理</a></li>
				</c:if>
				<li class="inbox"><a class="inbox" href="${pageContext.request.contextPath }/companyImage/add">添加公司图片</a></li>
				<c:if test="${!empty sessionScope.companyimage }">
					<li class="inbox"><a class="drafts" href="${pageContext.request.contextPath }/companyImage/list">公司图片管理</a></li>
				</c:if>	
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		
		
		<div class="centercontent">		
			<c:if test="${ !empty company }">
				<div id="contentwrapper" class="contentwrapper">
					<div class="contenttitle2">
						<h3>公司信息</h3>
					</div>
					<!--contenttitle-->
					<!-- right -->
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable">
						<colgroup>
							<col class="con0" />
							<col class="con1" />
							<col class="con0" />
							<col class="con1" />
							<col class="con0" />
						</colgroup>
						<thead>
							<tr>
								<th class="head0">公司信息</th>
								<th class="head0">数据</th>
								<th class="head1">操作</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach var="company" items="${company }" varStatus="status">
								<tr>

									<td>公司名称</td>
									<td>${company.companyName}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit1/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司介绍</td>
									<td>${company.description}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit3/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司log</td>

									<td><img alt="logo" src="${pageContext.request.contextPath }${company.logo}" width="200px" height="200px"></td>
									<td><a href="${pageContext.request.contextPath }/company/edit2" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司产品介绍</td>
									<td>${company.productIntroduction}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit4/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司地址</td>
									<td>${company.address}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit5/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司电话</td>
									<td>${company.telephone}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit6/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>

								<tr>
									<td>公司邮编</td>
									<td>${company.zipCode}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit7/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
								<tr>
									<td>公司邮箱</td>
									<td>${company.email}</td>
									<td><a href="${pageContext.request.contextPath }/company/edit8/${company.id}" class="btn btn_orange btn_flag"><span>修改</span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
			<c:if test="${empty company }">
				<div id="contentwrapper" class="contentwrapper">
					<div class="contenttitle2">
						<h1>暂时没有公司信息，赶紧去添加吧</h1>
					</div>
				</div>

			</c:if>
		</div>

		<!--contentwrapper-->

	</div>
	<!-- centercontent -->
</body>
</html>