package bo.com.apptransaction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.com.apptransaction.dao.TransactionDao;
import bo.com.apptransaction.entities.TransactionCollection;

@Service
public class TransactionServImpl implements TransactionServ{

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	public TransactionCollection findById(String id) {		
		return this.transactionDao.findById(id).orElse(null);
	}

	@Override
	public List<TransactionCollection> findAll() {
		
		return this.transactionDao.findAll();
	}

	@Override
	public TransactionCollection save(TransactionCollection t) {		
		return this.transactionDao.save(t);
	}

}
