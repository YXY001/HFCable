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
<script type="text/javascript" language="javascript">
	$(document).keydown(function(e) {
		document.getElementById("prodectNameNull").style.display = "none";
		/* 	document.getElementById("productImgNull").style.display = "none"; */
		document.getElementById("priceNull").style.display = "none";
		document.getElementById("priceNull1").style.display = "none";
		document.getElementById("specificationsNull").style.display = "none";
		document.getElementById("modelNull").style.display = "none";
		document.getElementById("lineCoreTypeNull").style.display = "none";
		document.getElementById("detailNull").style.display = "none";

	});
	function checknull() {
		var prodectName = $("#prodectName");
		var productImg = $("#productImg");

		var price = document.getElementById('price').value.trim();
		var specifications = $("#specifications");
		var model = $("#model");
		var lineCoreType = $("#lineCoreType");
		var detail = $("#detail");
		var reg = /^\d+(\.\d*)?$/
		if (prodectName.val() == '' || prodectName.val() == 0) {
			document.getElementById("prodectNameNull").style.display = "block";
			document.getElementById('prodectName').focus();
			return false;
		}
		/* else if(productImg.val()==''|| productImg.val==0){
			document.getElementById("productImgNull").style.display = "block";
			document.getElementById('productImg').focus();
			return false;
		} */
		else if (price.length == 0) {
			document.getElementById("priceNull1").style.display = "block";
			document.getElementById('price').focus();
			return false;
		} else if (price.length != 0) {
			if (!reg.test(price)) {
				document.getElementById("priceNull").style.display = "block";
				document.getElementById('price').focus();
				return false;
			}
		} else if (specifications.val() == '' || specifications.val == 0) {
			document.getElementById("specificationsNull").style.display = "block";
			document.getElementById('specifications').focus();
			return false;
		} else if (model.val() == '' || model.val == 0) {
			document.getElementById("modelNull").style.display = "block";
			document.getElementById('model').focus();
			return false;
		} else if (lineCoreType.val() == '' || lineCoreType.val == 0) {
			document.getElementById("lineCoreTypeNull").style.display = "block";
			document.getElementById('lineCoreType').focus();
			return false;
		} else if (detail.val() == '' || detail.val == 0) {
			document.getElementById("detailNull").style.display = "block";
			document.getElementById('detail').focus();
			return false;
		}

	}
</script>


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
				<li class="current"><a href="${pageContext.request.contextPath }/product/get" class="current">编辑产品</a></li>
				<li><a href="${pageContext.request.contextPath }/productImage/get" class="drafts">产品图片管理</a></li>
			</ul>
			<a class="togglemenu"></a> <br />
			<br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div id="contentwrapper" class="contentwrapper">
				<div class="contenttitle2">
					<h3>编辑产品</h3>
				</div>
				<!--contenttitle-->
				<form class="stdform stdform2" method="post" action="${pageContext.request.contextPath }/product/update?id=${product.id}" enctype="multipart/form-data">

					<p>
						<label>产品名称</label> <span class="field"><input type="text" name="prodectName" id="prodectName" value="${product.prodectName}" class="smallinput" /> <span id="prodectNameNull" style="display: none; color: red; font-weight: bold">请填写产品名称</span></span>
					</p>
					<p>
						<label>所属种类</label> <span class="field"> <select id="selection2" height="30" name="typeid" value="${product.type.typeName}">
								<c:forEach var="type" items="${typeList }">
									<option value="${type.id }">${type.typeName}</option>
								</c:forEach>
						</select>
						</span>
					</p>
					<%--  <p>
                            <label>产品图片</label>
                          <span class="field"><input type="file" name="productImg" id="productImg" value="${product.productImg}" class="smallinput" />
                          <img height="100" width="100"  src="${pageContext.request.contextPath }${product.productImg }">
                           <span id="productImgNull" style="display: none; color: red; font-weight: bold">请上传图片</span></span>
                            <span class="field"><input type="text" name="productImg" value="${product.productImg}" class="smallinput" /></span>
                        </p> --%>
					<p>
						<label>产品价格</label> <span class="field"><input type="text" name="price" id="price" value="${product.price}" class="smallinput" /> <span id="priceNull" style="display: none; color: red; font-weight: bold">请输入正确格式（整数或小数）</span> <span id="priceNull1" style="display: none; color: red; font-weight: bold">请填写价格</span> </span>
					</p>
					<p>
						<label>产品规格</label> <span class="field"><input type="text" name="specifications" id="specifications" value="${product.specifications}" class="smallinput" /> <span id="specificationsNull" style="display: none; color: red; font-weight: bold">请填写产品规格</span></span>
					</p>
					<p>
						<label>产品型号</label> <span class="field"><input type="text" name="model" id="model" value="${product.model}" class="smallinput" /> <span id="modelNull" style="display: none; color: red; font-weight: bold">请填写产品型号</span> </span>
					</p>
					<p>
						<label>线芯种类</label> <span class="field"><input type="text" id="lineCoreType" name="lineCoreType" value="${product.lineCoreType}" class="smallinput" /> <span id="lineCoreTypeNull" style="display: none; color: red; font-weight: bold">请填写线芯种类</span> </span>
					</p>
					<p>
						<label>产品说明</label> <span class="field"><input type="text" id="detail" name="detail" value="${product.detail}" class="smallinput" /> <span id="detailNull" style="display: none; color: red; font-weight: bold">请填写详细说明</span> </span>
					</p>
					<p class="stdformbutton">
						<button class="submit radius2" onclick="return checknull();">确认修改</button>
						<input type="reset" class="reset radius2" value="重置" />
					</p>
				</form>
				<br />

			</div>
			<!--subcontent-->

		</div>
		<!--contentwrapper-->

	</div>
	<!-- centercontent -->
</body>
</html>