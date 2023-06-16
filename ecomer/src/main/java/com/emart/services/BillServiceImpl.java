package com.emart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository bs;

	@Override
	public List<Object[]> BillDetails(String email) {
		// TODO Auto-generated method stub
		return bs.getBill(email);
	}
	
}
