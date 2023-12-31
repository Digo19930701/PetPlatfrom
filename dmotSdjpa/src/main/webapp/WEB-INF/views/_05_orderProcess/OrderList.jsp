<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${empty LoginOK}">
	<c:redirect url="/_02_login/login.jsp" />
</c:if>
<title>訂單列表</title>
<style type="text/css">
#borderA {
   border:1px solid black;
}

</style>
</head>
<body style="background: #EBFFEB;">
<c:set var="funcName" value="ORD" scope="session"/>

	<!-- 引入共同的頁首 -->
	<jsp:include page="/fragment/topMVC.jsp" />
    <p/>
	<table style="margin-left:auto; margin-right:auto; width:810; background:#F5EBFF; border:2px solid blue; border-style: outset; ">

		<tr id='borderA' height='50' >
			<th id='borderA'  colspan="4" align="center">${LoginOK.name}的訂購紀錄</th>
		</tr>
		<tr id='borderA' height='36' >
			<th id='borderA'>訂單編號</th>
			<th id='borderA'>訂購日期</th>
			<th id='borderA'>總金額</th>
			<th id='borderA'>送貨地址</th>
		</tr>
		<c:forEach var="anOrderBean" varStatus="stat" items="${memberOrders}">
			<TR id='borderA' height='30'>
			<TD id='borderA' width="86" align="center">
<%-- 			    <a  href='<c:url value='/_05_orderProcess/orderDetail.do?memberId=${LoginOK.memberId}&orderNo=${anOrderBean.orderNo}' />'> --%>
			    <a  href='<c:url value='/_05_orderProcess/orderDetail?memberId=${LoginOK.memberId}&orderNo=${anOrderBean.orderNo}' />'>
				    ${anOrderBean.orderNo}
			    </a>
			</TD>
			<TD id='borderA' width="100" align="center">${anOrderBean.orderDate}</TD>
			<TD id='borderA' width="80" align="right">${anOrderBean.totalAmount}</TD>
			<TD id='borderA' width="400" align="left">&nbsp;${anOrderBean.shippingAddress}</TD>
							
		</TR>
		</c:forEach>
		<tr height='36' id='borderA'>
<%-- 			<td id='borderA' align="center" colspan="4"><a href="<c:url value='/index.jsp' />">回首頁</a></td> --%>
			<td id='borderA' align="center" colspan="4"><a href="<c:url value='/' />">回首頁</a></td>
		</tr>
	</TABLE>
</body>
</html>