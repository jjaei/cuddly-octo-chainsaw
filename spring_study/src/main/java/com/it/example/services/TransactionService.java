package com.it.example.services;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
	public void doInsert(String id, String name);
}
