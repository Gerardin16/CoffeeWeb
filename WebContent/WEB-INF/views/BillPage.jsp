<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" />
<title>Group Three Coffee</title>
</head>
<body>
<header>
        <div class="container-fluid">
            <div class="row">
                    <div class="col-lg-8 offset-lg-2 ">
                        <div>
                            <h2 class="page-title">Final Invoice</h2>
                        </div>
                    </div>
            </div>
        </div>
    </header>
    <div class="container-fluid">
            <div class="row">
                <div class="page-title">
                 <p>Your Order number is ${orderNum}</p>
                  <form action="./" method="post" >
                     
					     <table class="tblStyle">
					  	<tr> 
					  		<td>Total Value </td>
					  		<td>${bills.get(0)}</td>
					  	</tr>
					  	<tr>
					  		<td>Discount </td>
					  		<td>${bills.get(1)}</td>
					  	</tr>
					  	<tr>
					  		<td>Net Value </td>
					  		<td>${bills.get(2)}</td>
					  	</tr>
					  	<tr>
					  		<td>GST </td>
					  		<td>${bills.get(3)}</td>
					  	</tr>
					  	<tr>
					  		<td>Service Tax</td>
					  		<td>${bills.get(4)}</td>
					  	</tr>
					  	<tr>
					  		<td>Total Bill</td>
					  		<td>${bills.get(5)}</td>
					  	</tr>
					  </table>
					<div>
  					<input type="submit" name="main" value="Go to Main Page"/>
  					</div>   
                 </form>
                  
                </div>
            </div>
        </div>
                  
              
        
</body>
</html>