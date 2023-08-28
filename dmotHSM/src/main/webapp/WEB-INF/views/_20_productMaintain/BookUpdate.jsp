<%@page import="_03_listBooks.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function setFocus()
{
     document.getElementById("title").focus();
}

function confirmDelete(id) {
	if (confirm("確定刪除此項書籍資料(書號:${bookBean.bookId})?") ) {
		document.forms[0].action="<c:url value='/_20_productMaintain/BookDelete/${bookBean.bookId}'  />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	}
}

function updateBook() {
    var hiddenField = document.getElementById("updateOrDelete");
//     hiddenField.value='PUT';
    document.forms[0].method="POST";
	document.forms[0].submit();
}

</script>

</head>
<body onload="setFocus()" background="../images/bookMaintain.jpg">

<!-- 引入共同的頁首 -->  
<jsp:include page="/fragment/topMVC.jsp" />
<div id='main' align='center'>

<div id="backToBookMaintainList">
     <a href="<c:url value='/_20_productMaintain/DisplayPageProducts?pageNo=${param.pageNo}' />" >回維護首頁</a>    
</div>     
<form:form method="post" modelAttribute="bookBean"   
			enctype="multipart/form-data" 
	  >
      
<input type='hidden' id='updateOrDelete' name='_method' > 
  
<table  class="table_color" border="1">
        
   <tr height='40'>
       <td colspan="6" align="center" valign="bottom"> 
           <TABLE style="background:#ffE4C4">
            <TR height='5' >
                <TD width='680' align='center' >&nbsp;</TD>
            </TR>
            <TR height='20' >
                <TD  align='center' >
                   <FONT color='#8000FA' size='+2' style="font-weight:900;" >
                      更新書籍資料
                   </FONT>
                </TD>
            </TR>
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
         </TABLE>
       </td>
   </tr>
   <tr height='36'>
      <td width="45" align="right" class="title_font">書名</td>
      <td colspan="5"> 
          <form:input path="title" size='40'/>
           <form:errors path="title" cssClass="error"/>
      </td>
   </tr>
   <tr height='36'>
      <td width="45" align="right" class="title_font">作者</td>
      <td width="312" colspan="3">     
           <form:input path="author" size='20'/>
           <form:errors path="author" cssClass="error"/>
      </td>
      <td width="52" align="right" class="title_font">價格</td>
      <td width="161">
        <form:input path="listPrice" size='4'/>
           <form:errors path="listPrice" cssClass="error"/>
       </td>
   </tr>
   <tr height='36'>
      <td width="45" class="title_font" ><div align="right">書號</div></td>
      <td width="160">
           <form:input path="bookNo" size='6'/>
           <form:errors path="bookNo" cssClass="error"/>
      </td>
      <td width="45" class="title_font" ><div align="right">類型</div></td>
      <td width="160">
          <form:select path='category' >
            	<form:option value="0" label="請挑選" />
            	<form:options  items="${category}" />
            </form:select>
            <form:errors path="category" cssClass="error"/>
      </td>

      <td width="52" class="title_font" ><div align="right">出版社</div></td>
      
      <td width="161">
       		<form:select path='companyBean.id' >
            	<form:option value="-1" label="請挑選" />
            	<form:options  items="${companyBeanList}"
	   	  	   			itemLabel='name' itemValue='id'/>
            </form:select>
            <form:errors path="companyBean"  cssClass="error" />
       </td>
    </tr>

   <tr height='120'>
      <td width="45" align="right" class="title_font">圖片</td>
      <td colspan='5'>
        <table>  
           <tr>
             <td><img height='120' width='96' 
                     src='${pageContext.servletContext.contextPath}/_00_init/getBookImage?id=${bookBean.bookId}'  />
             </td>
             <td colspan='2'>
                <form:input path="productImage" type='file' />
	   	  	 <form:errors path="productImage"  cssClass="error" />
             </td>
           </tr>
        </table>
      </td>
</tr>

<tr height='35'>
<td colspan='6' align='center'>
        <input type="button" name="update" value="修改" onclick='updateBook()'/>
        &nbsp;&nbsp;&nbsp;
        <input type="button" name="delete" value="刪除" onclick="confirmDelete(${bookBean.bookId})" /> 
  </td>
  </tr>
</table>
  <div id="deleteMsg">
         ${ErrMsg.errDBMessage}		 
        <input type="hidden" name="pageNo" value="${param.pageNo}" />
  </div>
</form:form>
<p>&nbsp;</p>

</div>
</body>
</html>