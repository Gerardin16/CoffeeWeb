package com.groupthree.dao;
import com.groupthree.bean.CoffeeVoucher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CoffeeVoucherDao implements CoffeeVoucherDaoInterface{

private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Override
    public ArrayList<CoffeeVoucher> getCoffeeVoucher()  {

		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		
		Query<CoffeeVoucher> query = session.createQuery("from CoffeeVoucher where  voucherId <> 0");
		       
		List<CoffeeVoucher> coffeeVouchers=query.getResultList();
		transaction.commit();
		session.close();
		return  (ArrayList<CoffeeVoucher>) coffeeVouchers;


    }
}
