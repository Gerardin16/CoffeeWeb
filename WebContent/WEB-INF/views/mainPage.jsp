
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
                            <h2 class="page-title">Welcome To Group Three Coffee</h2>
                            <img alt="Coffee" src="<c:url value='/resources/images/CoffeeImage.png'/>" class="coffeeimg">
                            
                        </div>
                    </div>
            </div>
        </div>
    </header>

    	 <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 ">
                  <form action="./searchCust" method="post">
                     <div class="form-group">
					    <label for="personSearch">Please enter your registered phone number</label>
					    <input type="text" class="form-control" name="phoneNo" placeholder="Enter phone number"> 
					    <input type="submit" value="Search" name="Search">
  					</div>
                 </form>
                  
                </div>
            </div>
        </div>
</body>
</html>