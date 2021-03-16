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
                            <h2 class="page-title">Apply Voucher</h2>  
                        </div>
                    </div>
            </div>
        </div>
    </header>

    	 <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 ">
                  <form action="./generateBill" method="post">
                     <div class="form-group">
					    <label for="voucher">Please enter your voucher code</label>
					    <input type="text" class="form-control" name="voucher" placeholder="Enter voucher"> 
					    <input type="submit" value="Generate Bill" name="Generate Bill">
  					</div>
                 </form>
                  
                </div>
            </div>
        </div>
</body>
</html>