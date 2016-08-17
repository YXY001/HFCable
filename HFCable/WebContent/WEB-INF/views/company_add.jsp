<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--日历-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/other.css" type="text/css" />
<link rel="Stylesheet" href="${pageContext.request.contextPath}/css/tanchu.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.prolist.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendar.css" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.slimscroll.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/charCount.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/chosen.jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/forms.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/dashboard.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/kalendar.js"></script>
<script type="text/javascript">
	$(function() {

		if ($(".error").val().length != 0) {
			alert($(".error").val());
		}
	})
	/*判断输入是否为合法的手机号码*/
	function isphone(inputString) {
		var partten = /^1[3,5,8]\d{9}$/;
		if (partten.test(inputString)) {
			return true;
		} else {
			return false;
		}
	}
	/*判断输入是否为合法的邮箱*/
	function isemail(email) {
		var partten = /(^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z0-9_-]+$)|(^$)/;
		if (partten.test(email)) {
			return true;
		} else {
			return false;
		}
	}
	/*判断输入是否为合法的邮编*/
	function iszipCode(zipCode) {
		var partten = /^[0-9]\d{5}$/;
		if (partten.test(zipCode)) {
			return true;
		} else {
			return false;
		}
	}

	function checknull() {
		$(document)
				.keydown(
						function(e) {
							document.getElementById("companyName1").style.display = "none";
							document.getElementById("logo1").style.display = "none";
							document.getElementById("description1").style.display = "none";
							document.getElementById("productIntroduction1").style.display = "none";
							document.getElementById("address1").style.display = "none";
							document.getElementById("telephone1").style.display = "none";
							document.getElementById("zipCode1").style.display = "none";
							document.getElementById("email1").style.display = "none";
						});
		var companyName = $("#companyName");
		var logo = $("#logo");
		var description = $("#description");
		var productIntroduction = $("#productIntroduction");
		var address = $("#address");
		var telephone = $("#telephone");
		var zipCode = $("#zipCode");
		var email = $("#email");
		if (companyName.val() == '' || companyName.val() == 0) {
			document.getElementById("companyName1").style.display = "block";
			document.getElementById('companyName').focus();
			/* $('#companyName1').html("111111"); */
			return false;
		} else if (description.val() == '' || description.val() == 0) {
			document.getElementById("description1").style.display = "block";
			document.getElementById('description').focus();
			return false;
		} else if (productIntroduction.val() == ''
				|| productIntroduction.val() == 0) {
			document.getElementById("productIntroduction1").style.display = "block";
			document.getElementById('productIntroduction').focus();
			return false;

		} else if (address.val() == '' || address.val() == 0) {
			document.getElementById("address1").style.display = "block";
			document.getElementById('address').focus();
			return false;

		} else if (telephone.val() == '' || telephone.val() == 0) {
			document.getElementById("telephone1").style.display = "block";
			document.getElementById('telephone').focus();
			return false;

		} else if (!isphone(telephone.val())) {
			document.getElementById("telephone1").style.display = "block";
			document.getElementById('telephone').focus();
			$('#telephone1').html("手机格式不正确");
			return false;
		} else if (zipCode.val() == '' || zipCode.val() == 0) {
			document.getElementById("zipCode1").style.display = "block";
			document.getElementById('zipCode').focus();
			return false;

		} else if (!iszipCode(zipCode.val())) {
			document.getElementById("zipCode1").style.display = "block";
			document.getElementById('zipCode').focus();
			$('#zipCode1').html("邮编格式不正确");
			return false;
		} else if (email.val() == '' || email.val() == 0) {
			document.getElementById("email1").style.display = "block";
			document.getElementById('email').focus();
			return false;
		} else if (!isemail(email.val())) {
			document.getElementById("email1").style.display = "block";
			document.getElementById('email').focus();
			$('#email1').html("邮箱格式不正确");
			return false;
		}
	}
</script>
<title>添加公司信息</title>
</head>
<body>
	<input type="hidden" class="error" value="${error }" />

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
				<c:if test="${empty sessionScope.company}">
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

			<div class="pageheader">
				<div class="contenttitle2">
					<h3>公司信息</h3>
				</div>
				<!--contenttitle-->
				<form class="stdform" action="${pageContext.request.contextPath}/company/save" method="post" enctype="multipart/form-data">
					<p>
						<label>公司名称</label> <span class="field"><input type="text" id="companyName" name="companyName" class="smallinput" /></span><span class="field" id="companyName1" style="display: none; color: red; font-weight: bold">请填写公司名称</span>
					</p>

					<p>
						<label>公司地址</label> <span class="field"><input type="text" id="address" name="address" class="smallinput" /></span><span class="field" id="address1" style="display: none; color: red; font-weight: bold">请填写公司地址</span>
					</p>
					<p>
						<label>公司电话</label> <span class="field"><input type="text" id="telephone" name="telephone" class="smallinput" /></span><span class="field" id="telephone1" style="display: none; color: red; font-weight: bold">请填写公司电话</span>
					</p>
					<p>
						<label>公司邮编</label> <span class="field"><input type="text" id="zipCode" name="zipCode" class="smallinput" /></span><span class="field" id="zipCode1" style="display: none; color: red; font-weight: bold">请填写公司邮编</span>
					</p>
					<p>
						<label>公司邮箱</label> <span class="field"><input type="text" id="email" name="email" class="smallinput" /></span><span class="field" id="email1" style="display: none; color: red; font-weight: bold">请填写公司邮箱</span>
					</p>
					<p>
						<label>公司介绍</label> <span class="field"><textarea cols="80" rows="5" id="description" name="description" class="longinput"></textarea></span><span class="field" id="description1" style="display: none; color: red; font-weight: bold">请填写公司介绍</span>
					</p>
					<p>
						<label>公司产品介绍</label> <span class="field"><textarea cols="80" rows="5" id="productIntroduction" name="productIntroduction" class=""longinput""></textarea></span><span class="field" id="productIntroduction1" style="display: none; color: red; font-weight: bold">请填写公司产品介绍</span>
					</p>
					<p>
						<label>公司logo</label> <span class="field"><input type="hidden" name="logo" class="smallinput" value="" /><input type="file" name="file" class="smallinput" /></span><span class="field" id="logo1" style="display: none; color: red; font-weight: bold"> asda的</span>
					</p>
					<br clear="all" /> <br />
					<p class="stdformbutton">
						<input type="submit" class="submit radius2" value="完成创建" onclick="return checknull();" /> <input type="reset" class="reset radius2" value="重置" />
					</p>
				</form>
			</div>
			<!--contentwrapper-->
		</div>
		<!--centercontent-->

	</div>
</body>
</html>