<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新产品</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.default.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/other.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/charCount.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/custom/general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/custom/forms.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/custom/dashboard.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>
<body class="withvernav">

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
				<li class="current" id="li3"><a href="${pageContext.request.contextPath }/product/toProduct"><span class="icon icon-chart"></span>产品</a></li>
				<li class="l_menu" id="li3"><a href="${pageContext.request.contextPath }/type/toType"><span class="icon icon-message"></span>种类</a></li>
				<li class="l_menu" id="li1"><a href="${pageContext.request.contextPath }/company/list"><span class="icon icon-pencil"></span>公司</a></li>
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
				<li><a href="${pageContext.request.contextPath }/product/toProduct" class="inbox">新增产品</a></li>
				<li><a href="${pageContext.request.contextPath }/product/get" class="drafts">管理产品</a></li>
				<li class="current"><a href="${pageContext.request.contextPath }/productImage/get" class="current">编辑产品图片</a></li>
			</ul>
			<a class="togglemenu"></a> <br />
			<br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div id="contentwrapper" class="contentwrapper">
				<div class="contenttitle2">
					<h3>编辑产品图片</h3>
				</div>
				<!--contenttitle-->
				<form class="stdform stdform2" method="post" action="${pageContext.request.contextPath }/productImage/update?id=${productImage.id}" enctype="multipart/form-data">
					<%-- <p>
                            <label>产品名称</label>
                            <span class="field"><input readOnly="true" type="text" name="prodectName" id="prodectName" value="${productImage.product.prodectName}" class="smallinput" /></span>
                        </p> --%>
					<p>
						<label>产品图片</label> <span class="field"><input type="file" name="productImg" id="productImg" class="smallinput" /> <img height="100" width="100" src="${pageContext.request.contextPath }${productImage.image }"></span>
					</p>
					<p class="stdformbutton">
						<button class="submit radius2" onclick="return checknull();">确认修改</button>
						<input type="reset" class="reset radius2" value="重置" />
					</p>
				</form>
				<br />
			</div>
		</div>
	</div>
</body>
</html>