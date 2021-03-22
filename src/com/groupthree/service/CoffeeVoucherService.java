package com.groupthree.service;

import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.dao.CoffeeVoucherDao;
import com.groupthree.dao.CoffeeVoucherDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CoffeeVoucherService implements CoffeeVoucherServiceInterface{
		@Autowired
        private CoffeeVoucherDaoInterface coffeeVoucherDao;
        @Override
        public ArrayList<CoffeeVoucher> getCoffeeVoucher() {
            return coffeeVoucherDao.getCoffeeVoucher();

        }
}
