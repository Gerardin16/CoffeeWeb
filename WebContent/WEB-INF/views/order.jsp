<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" />
  
<title>Group Three Coffee</title>
</head>
<body>
<header>
        <div class="container-fluid">
            <div class="row">
                    <div class="col-lg-8 offset-lg-2 ">
                        <div>
                            <h2 class="page-title">Place your order</h2>
                            <img alt="Coffee" src="<c:url value='/resources/images/menu.png'/>" class="coffeeimg">
                            
                        </div>
                    </div>
            </div>
        </div>
    </header>
    <section>
    <%String name=(String)session.getAttribute("custName");  
    	out.print("Welcome "+name);%> 
    	<div >
    		<form action="./processOrder" method="post"> 
                     <div class="form-group">
					    <label for="cotype">Choose your Coffee&nbsp;</label>					    
						 <input type="radio" name="cotype" value="Mocha">Mocha
					   	 <input type="radio" name="cotype" value="Latte">Latte
					   	 <input type="radio" name="cotype" value="Americano">Americano
  					</div>
  					 <div class="form-group">
					    <label for="cosize">Choose your Size &nbsp; &nbsp;</label>					    
						 <input type="radio" name="cosize" value="Small">Small
					   	 <input type="radio" name="cosize" value="Medium">Medium
					   	 <input type="radio" name="cosize" value="Large">Large
  					</div>
  					<div class="form-group">
					    <label for="coadd">Choose your Add on &nbsp;</label>					    
						 <input type="radio" name="coadd" value="Butter">Butter
					   	 <input type="radio" name="coadd" value="Cream">Cream
					   	 <input type="radio" name="coadd" value="Hazelnuts">Hazelnuts
  					</div>
  					<div class="form-group">
  						<br><br>
					    <input type="submit" name="AddOn" value="Add more Addons"/>
					    <input type="submit" name="AddOrder" value="Add a new coffee"/>
					     <input type="submit" name="PlaceOrder" value="Place Order"/>
  					</div>
     
           </form>
    	</div>
    	

    </section>
</body>
</html>