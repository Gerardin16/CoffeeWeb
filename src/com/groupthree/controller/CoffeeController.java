package com.groupthree.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;
import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.bean.PersonDetails;
import com.groupthree.service.BillTransactionServiceInterface;
import com.groupthree.service.CoffeeAddonServiceInterface;
import com.groupthree.service.CoffeeSizeServiceInterface;
import com.groupthree.service.CoffeeTypeServiceInterface;
import com.groupthree.service.CoffeeVoucherServiceInterface;
import com.groupthree.service.PersonDetailsServiceInterface;
import com.groupthree.util.BeverageHelper;
import com.groupthree.util.OrderDetails;






@Controller
@SessionAttributes({"custid","type","size","addon","custName","secondtype","secondsize","secondaddon"})

public class CoffeeController {
	
	@Autowired
    private BillTransactionServiceInterface transactionService;
	@Autowired
    private PersonDetailsServiceInterface personDetails;
	@Autowired
    private CoffeeAddonServiceInterface coffeeAddon;
	@Autowired
    private CoffeeVoucherServiceInterface coffeeVoucher;
	@Autowired
    private CoffeeSizeServiceInterface coffeeSize;
	@Autowired
    private CoffeeTypeServiceInterface coffeeType;
	


    String OrderNum;
    Integer selectedCoffeeType=0;
	Integer  selectedCoffeeSize=0;
	 Integer selectedAddon=0;
	Integer selectedVoucher=0;
	 String typeChoice=null;
	 String sizeChoice=null;
	 String addOnChoice=null;
	 String voucherCode=null;
	 String personName;
	@RequestMapping("/")
	public ModelAndView mainPageController() {
//		searchPersonController();
		return new ModelAndView("mainPage");
	}
	
	
	
	

		@RequestMapping(path="/searchCust",method=RequestMethod.POST)
	public ModelAndView searchPersonController(HttpServletRequest request,HttpSession session) {
			OrderNum=transactionService.createRandomOrderNumber();
		ArrayList<PersonDetails> person;
		ModelAndView mv=new ModelAndView();
		long phnum=Long.parseLong(request.getParameter("phoneNo"));
		
		int pid;
		
			person=personDetails.searchRecordByPhoneno(phnum);
			if(person.size()!=0) 
			{
				 for(PersonDetails per:person){
					personName=per.getPersonName();
					pid=per.getpId();
//					mv.addObject("custName",personName);
					session.setAttribute("custName",personName);
//					mv.addObject("custid",pid);
    				mv.setViewName("order");
    				session.setAttribute("custid",pid);
    		       }
			
			}
			
					
			
		else
		{
			 mv.addObject("custNo",phnum);
			 mv.setViewName("addCustomer");
		}
			
		
		
		
		return mv;
	}
		
		
		@RequestMapping("/addCustomer")
		public ModelAndView addCustomerPageController(HttpServletRequest request) {
			return new ModelAndView("addCustomer");

		}
		
		@RequestMapping(path="/newCust",method=RequestMethod.POST)
		public ModelAndView newCustOrderController(HttpServletRequest request,HttpSession session) {
			ArrayList<PersonDetails> person;
			ModelAndView mv=new ModelAndView();
			long phnum=Long.parseLong((String)request.getParameter("custNo"));
			String personName=request.getParameter("newPerson");
			int pid;
			
				personDetails.insertPerson(personName,phnum);
				person=personDetails.searchRecordByPhoneno(phnum);
				if(person.size()!=0) 
				{
					 for(PersonDetails per:person){
						personName=per.getPersonName();
						pid=per.getpId();
//						mv.addObject("custName",personName);
						session.setAttribute("custName",personName);
//						mv.addObject("custid",pid);
	    				mv.setViewName("order");
	    				session.setAttribute("custid",pid);
	    		       }
				
				}
				
				
			
			
			
			return mv;
		}
	
		@RequestMapping(path="/processOrder",params="AddOrder", method=RequestMethod.POST)
		public ModelAndView addOrderController(HttpServletRequest request,HttpSession session) {
			try {
				checkOrder(request, session);
			}
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ModelAndView("order");

		}
		@RequestMapping(path="/processOrder",params="AddOn", method=RequestMethod.POST)
		public ModelAndView addAddOnController(HttpServletRequest request,HttpSession session) {
			try {
				checkOrder(request, session);
			}
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("AddAddon");

		}
		@RequestMapping(path="/processOrder",params="PlaceOrder", method=RequestMethod.POST)
		public ModelAndView placeOrderController(HttpServletRequest request,HttpSession session) {
			try {
				checkOrder(request, session);
			}      
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("Voucher");
			

		}





		private void checkOrder(HttpServletRequest request, HttpSession session)
				throws ClassNotFoundException, SQLException {
			ArrayList<CoffeeType> coffeeTypeList=coffeeType.getCoffeeType();
			 ArrayList<CoffeeSize> coffeeSizeList=coffeeSize.getCoffeeSize();
			 ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
			 Integer userid = Integer.parseInt(session.getAttribute("custid").toString());
			 typeChoice=request.getParameter("cotype");
			 sizeChoice=request.getParameter("cosize");
			 addOnChoice=request.getParameter("coadd");
			 if(!typeChoice.isEmpty() && !sizeChoice.isEmpty() && !addOnChoice.isEmpty() )
			 {
					 for(CoffeeType type:coffeeTypeList){
				            if (typeChoice.equalsIgnoreCase(type.getCoffeeName().toString())) {
				                selectedCoffeeType=type.getCoffeeId();

				            }
					 }
				            for(CoffeeSize size:coffeeSizeList){
				                if  (sizeChoice.equalsIgnoreCase(size.getCoffeeSizeName().toString()))  {
				                   selectedCoffeeSize=size.getCoffeeSizeId();
				                }
				            }
				            if(!addOnChoice.isEmpty())
				            {
					            for(CoffeeAddon addon:coffeeAddonList){
					                if (addOnChoice.equalsIgnoreCase(addon.getCoffeeAddonName().toString()))  {
					                    selectedAddon=addon.getCoffeeAddonId();
					                }
				               
					            }
				            }
				            else
				            	selectedAddon=0;
			 }
			 else
			 {
				 selectedCoffeeType = Integer.parseInt(session.getAttribute("type").toString());
				  selectedCoffeeSize = Integer.parseInt(session.getAttribute("size").toString());
				  selectedAddon = Integer.parseInt(session.getAttribute("addon").toString());
			 }       
			        transactionService.createCoffeeOrder(userid,OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
			        session.setAttribute("type",selectedCoffeeType);
					session.setAttribute("size",selectedCoffeeSize);
					session.setAttribute("addon",selectedAddon);
		}
		@RequestMapping(path="/processAddon",params="AddOne", method=RequestMethod.POST)
		public ModelAndView addAddOnMoreController(HttpServletRequest request,HttpSession session) {
		
//				selectedCoffeeType = Integer.parseInt(session.getAttribute("type").toString());
//				 selectedCoffeeSize = Integer.parseInt(session.getAttribute("size").toString());
				 ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
				 addOnChoice=request.getParameter("coadd");
				 Integer userid = Integer.parseInt(session.getAttribute("custid").toString());
			            if(!addOnChoice.isEmpty())
			            {
				            for(CoffeeAddon addon:coffeeAddonList){
				                if (addOnChoice.equalsIgnoreCase(addon.getCoffeeAddonName().toString()))  {
				                    selectedAddon=addon.getCoffeeAddonId();
				                }
			               
				            }
			            }
			            else
			            	selectedAddon=0;
			            
			            transactionService.createCoffeeOrder(userid,OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
//			            session.setAttribute("type",selectedCoffeeType);
//						session.setAttribute("size",selectedCoffeeSize);
//						session.setAttribute("size",selectedAddon);
//				checkOrder(request, session);
			
			return new ModelAndView("AddAddon");

		}
		@RequestMapping(path="/processAddon",params="AddAgainOrder", method=RequestMethod.POST)
		public ModelAndView addAgainNewOrderController(HttpServletRequest request) {
			return new ModelAndView("order");

		}
		@RequestMapping(path="/processAddon",params="PlaceOrder", method=RequestMethod.POST)
		public ModelAndView placeOrderAddonController(HttpServletRequest request,HttpSession session) {
			
			return new ModelAndView("Voucher");
			

		}
		@RequestMapping(path="/generateBill", method=RequestMethod.POST)
		public ModelAndView generateBillController(HttpServletRequest request,HttpSession session,SessionStatus status) {
			 
			ModelAndView mv=new ModelAndView();
			
			
				 ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
				 voucherCode=request.getParameter("voucher");
				 Integer userid = Integer.parseInt(session.getAttribute("custid").toString());
				 String userName = session.getAttribute("custName").toString();
			            if(!voucherCode.isEmpty())
			            {
			            	for(CoffeeVoucher voucher:coffeeVoucherList)
			                    if (voucherCode.equalsIgnoreCase(voucher.getVoucherCode().toString())) {
			                    	selectedVoucher=voucher.getVoucherId();
		                    
			                    }
			            }
			            else
			            	selectedVoucher=0;
			            List<OrderDetails> orders=transactionService.getDetailedOrders(userid,OrderNum);
			            ArrayList bill =transactionService.generateBill(userid,OrderNum,selectedVoucher);
			            if (voucherCode!=null)
			            mv.addObject("voucher",voucherCode);
			            mv.addObject("allOrders", orders);
			            mv.addObject("orderNum",OrderNum);
			            mv.addObject("bills",bill);
			            mv.addObject("name",userName);
			            mv.setViewName("BillPage");
			            status.setComplete();
			            
			
			return mv;

		}
	
}
