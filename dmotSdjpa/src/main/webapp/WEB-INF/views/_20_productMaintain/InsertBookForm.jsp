<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
	span.error {
		color: red;
		display: inline-block;
		font-size: 11pt;
	}
	
	.fieldset-auto-width {
		display: inline-block;
	}
	
</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新建員工資料</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel='stylesheet' href="<spring:url value='/css/styles.css' />"  type="text/css" />
    <script>
       let inputFileToLoad = null;
       let image = null;
       let image2 = null;
       let img = null;
       window.addEventListener('load', function(){
	        inputFileToLoad = document.getElementById("inputFileToLoad");
	        image = document.getElementById("image");
	        image2 = document.getElementById("image2");
	        img = document.getElementById("img");
	        inputFileToLoad.addEventListener('change', loadImageFileAsURL);
       }
       );
       function loadImageFileAsURL(){
    	   
          let filesSelected = inputFileToLoad.files;
          if (filesSelected.length > 0)
          {
              let fileReader = new FileReader();
              let fileToLoad = filesSelected[0];
              
              fileReader.onload = function(fileLoadedEvent) 
              {
            	  if (image != null) {
                  	image.value = fileLoadedEvent.target.result;
	                  console.log("image.value=" + image.value );
            	  } else {
            		image2.value = fileLoadedEvent.target.result;
            		console.log("image2.value=" + image2.value );
            	  }
                  img.src 		= fileLoadedEvent.target.result;
              };
              fileReader.readAsDataURL(fileToLoad);
          }
     }
    </script>
</head>

<body>
    <div class='container'>
    <div class='alert alert-success'><h2 align='center'>新增書籍資料</h2></div>
    <c:url var='insertUrl' value='/_20_productMaintain/BookInsert' />
    <form:form method='POST' modelAttribute="book" action="${insertUrl}">
        <div class='row mb-3'>
            <label class='col-sm-1' >書名</label>
            <div class='col-sm-3'>
                <form:input type='text' class='form-control' path='title'  
                       placeholder="請輸入書籍名稱" />
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='title' />
            </div>
            <label class='col-sm-1'>作者</label>
            <div class='col-sm-3'>
                <form:input type='text' class='form-control' path='author' 
                       placeholder="請輸入作者"   />
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='author' />
            </div>
        </div> 
        
        <div class='row mb-3'>
            <label class='col-sm-1' >價格</label>
            <div class='col-sm-3'>
                <form:input type='text' class='form-control' path='listPrice'  
                       placeholder="請輸入價格" />
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='listPrice' />
            </div>
            <label class='col-sm-1'>書號</label>
            <div class='col-sm-3'>
                <form:input type='text' class='form-control' path='bookNo' 
                       placeholder="請輸入書號"   />
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='bookNo' />
            </div>
            
        </div>
       
        <div class='row mb-3'>
            <label class='col-sm-1'>出版社</label>
            <div class='col-sm-3'>
                <form:select class='form-control' path='publisher.id' >
                       <form:option value="-1" label="請挑選出版社" />
				       <form:options  items="${publisherList}"
	   	  	   			     itemLabel='name' itemValue='id'/>
                </form:select>       
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='publisher' />
            </div>
            <label class='col-sm-1'>類型</label>
            <div class='col-sm-3'>
                <form:select class='form-control' path='category'>
                       <form:option value="-1" label="請挑選類型" />
                        <form:options  items="${categoryList}" />
                </form:select>       
            </div>
            <div class='col-sm-2'>
            	<form:errors cssClass="error" path='category' />
            </div>
        </div>

        <div class='row mb-3'>
            <label class='col-sm-1'>圖片</label>
            <div class='col-sm-4	'>
                <form:input type='file' id='inputFileToLoad' class='form-control' path='coverImage'
                       placeholder="請挑選圖片"   />
            </div>
            <div class='col-sm-1'>
                <c:choose>
                   <c:when test='${empty image}' >
		                <img id='img' width='60' height='80'>
		                <input type='hidden' id='image' name='image' >
                   </c:when>
                   <c:otherwise>
                        <img id='img' width='60' height='80' src='${image}' >
                        <input type='hidden' id='image2' name='image' value='${image}'>
                   </c:otherwise>
                </c:choose>
            </div>    
            <div class='col-sm-6'>
            	<form:errors cssClass="error" path='coverImage' />
            </div>
        </div>
        <c:if test="${not empty exception}">
	        ${exception}
        </c:if>
        <div class='row mb-3'>
            <div class='offset-sm-3 col-sm-3 d-grid'>
                <button type='submit' class='btn btn-primary'>提交</button>
            </div>
            <div class='col-sm-3 d-grid'>
                <a class='btn btn-outline-primary' href="<c:url value='/_20_productMaintain/DisplayPageProducts' />" role='button'>放棄新增</a>
            </div>
        </div>
        </form:form>
        <hr>
    </div>
</body>
</html>
