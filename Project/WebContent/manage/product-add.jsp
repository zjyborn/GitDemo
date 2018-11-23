<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="EasyByServlet?org=list">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="EasyByServlet?org=list">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="EasyCateServlet?org=add">新增</a></em><a href="EasyCateServlet?org=list">分类管理</a></dd>
				<dd><em><a href="ProductServlet?org=add">新增</a></em><a href="ProductServlet?org=list">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>添加商品</h2>
		<div class="manage">
			<form id="productAdd" action="ProductServlet?org=save" method="post">
				<table class="form">
					<tr>
						<td class="field">商品名称(*)：</td>
						<td><input type="text" class="text" name="productName" value="铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机" /><span></span></td>
					</tr>
                    <tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="productDetail" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
							  <c:forEach items="${category}" var="item" >
								<option value="${item.epc_id}" disabled="disabled">${item.epc_name}</option>
								 <c:forEach items="${item.categorys}" var="temp" >
								<option value="${temp.epc_id}">${temp.epc_name}</option>
								</c:forEach>
								</c:forEach>
							</select>
						</td>
					</tr>					
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="productPrice" /> 元<span></span></td>
					</tr>
					
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="productNumber" /><span></span></td>
					</tr>
					<tr>
						<td class="field">商品图片(*)：</td>
						<td><input type="file" class="text" name="photo" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>