<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="<c:url value='/resources/css/main.css' />" rel="stylesheet" />
 
<meta charset="ISO-8859-1">
<title>Group Three Coffee</title>
</head>
<body>
<header>
        <div class="container-fluid">
            <div class="row">
                    <div class="col-lg-8 offset-lg-2 ">
                        <div>
                            <h2 class="page-title">Do you want more Add-ons?</h2>
                            <img alt="Coffee" src="<c:url value='/resources/images/menu.png'/>" class="coffeeimg">
                            
                        </div>
                    </div>
            </div>
        </div>
    </header>
    <section>
    	
    	<div >
    		<form action="./processOrder" method="post" >
                     <div class="form-group">
					    <label for="coadd">Choose your Add on&nbsp;</label>					    
						 <input type="radio" name="coadd" value="Butter">Butter
					   	 <input type="radio" name="coadd" value="Cream">Cream
					   	 <input type="radio" name="coadd" value="Hazelnuts">Hazelnuts
  					</div>
  					
  					<div class="form-group">
  						<br><br>
					    <input type="submit" name="AddOne" value="Add AddOn"/>
					    <input type="submit" name="AddAgainOrder" value="Add a new coffee"/>
					    <input type="submit" name="PlaceOrder" value="Place Order"/>
  					</div>
     
           </form>
    	</div>
    	

    </section>
</body>
</html>