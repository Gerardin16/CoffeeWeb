package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public interface BillTransactionServiceInterface {

    double GST_TAX=0.18;
    double SERVICE_TAX=0.18;


    public ArrayList generateBill(int person,String initialOrderNum, int selectedVoucher);

    public String createRandomOrderNumber();

   
	public void createCoffeeOrder(int person, String orderNum, int selectedCoffeeType, int selectedCoffeeSize,
			int selectedAddon) ;

	public List getDetailedOrders(int person, String initialOrderNum);


}
