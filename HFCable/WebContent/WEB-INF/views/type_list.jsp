<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>管理种类</title>
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
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/tanchu.css" />
<link href="${pageContext.request.contextPath }/css/style.prolist.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugins/jquery-2.1.1.min.js"></script>
<!--  <script type="text/javascript">
 	$("#example").click(function (){
 		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").fadeIn("slow");
		$("#default").fadeIn("slow");
 	});
		
	
   $(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
			$("#default").fadeOut("fast");
			$("#mask").css({ display: 'none' });
		});
   
   
   
	</script>  -->
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
				<li class="l_menu" id="li3"><a href="${pageContext.request.contextPath }/product/toProduct"><span class="icon icon-chart"></span>产品</a></li>
				<li class="current" id="li3"><a href="${pageContext.request.contextPath }/type/toType"><span class="icon icon-message"></span>种类</a></li>
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
				<li><a href="${pageContext.request.contextPath }/type/toType" class="inbox">新增种类</a></li>
				<li class="current"><a href="${pageContext.request.contextPath }/type/get" class="drafts">管理种类</a></li>
			</ul>
			<a class="togglemenu"></a> <br />
			<br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div id="contentwrapper" class="contentwrapper">
				<div class="contenttitle2">
					<h3>种类列表</h3>
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
							<th class="head0">种类名称</th>
							<!--  <th class="head1">客户</th>
                            <th class="head0">需求状态</th> -->
							<th class="head1">操作</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach varStatus="states" items="${typeList}" var="type">
							<tr class="xt-bg">
								<td>${type.typeName }</td>
								<td><a href="${pageContext.request.contextPath }/type/delete?id=${type.id}" class="btn btn_orange btn_flag"><span>删除</span></a> <a href="${pageContext.request.contextPath }/type/toUpdate?id=${type.id}" class="btn btn_orange btn_link"><span>修改</span></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<%-- <div id="xt-right">
   
    <div class="xt-input">
        <span>项目名称</span>
        <input type="text" class="int-text" />
        <input type="button" value="查询" class="green-int" />
    </div>
   <div class="xt-table"> 
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th>需求名称</th>
            <th>客户</th>
            <th>需求状态</th>
            <th>操作</th>
            
            </tr>
            <s:iterator value="reqList" id="req">
            	<tr class="xt-bg">
            	<td>${req.rname }</td>
            	<td>${req.cus.cname }</td>
                <c:if test="${req.rstate ==0 }">
					<td>待审批</td>
				</c:if>
				<c:if test="${req.rstate ==1 }">
					<td>待关联项目</td>
				</c:if>
				<c:if test="${req.rstate ==2 }">
					<td>已关联项目</td>
				</c:if>
                <td>
                <c:if test="${req.rstate ==1 }"></c:if>
                <c:if test="${req.rstate ==0 }">
                <a href="#" class="yellow-xt" id="example" >删除</a>
                <a href="#" class="yellow-xt" id="example">修改</a>
                </c:if>
                </td>
            	</tr>
            </s:iterator>
        </table>
     </div> --%>
				<div id="default">
					<div class="row1">
						审批意见<a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="closeBtn">×</a>
					</div>
					<div class="row">
						<span class="inputBox"> <textarea cols="80" rows="5" name="location" id="txtName" class="longinput"></textarea>
						</span><a href="javascript:void(0)" title="提示" class="warning" id="warn">*</a>
					</div>

					<div class="row">
						<a href="#" id="loginbtn">确定</a>
					</div>
				</div>
			</div>

		</div>
		<!--contentwrapper-->

	</div>
	<!-- centercontent -->
</body>
</html>