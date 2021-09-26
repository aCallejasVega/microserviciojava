package bo.com.apptransaction.services;

import java.util.List;

import bo.com.apptransaction.entities.TransactionCollection;

public interface TransactionServ {
	
	public TransactionCollection  findById(String id);
	
	public List<TransactionCollection> findAll();
	
	public TransactionCollection save(TransactionCollection t);

}
