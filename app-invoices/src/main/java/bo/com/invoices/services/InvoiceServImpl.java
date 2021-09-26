package bo.com.invoices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.com.invoices.dao.InvoiceDao;
import bo.com.invoices.entities.InvoiceEntity;

@Service
public class InvoiceServImpl implements InvoiceServ{
	
	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public InvoiceEntity findById(Long id) {		
		return this.invoiceDao.findById(id).orElse(null);
	}

	@Override
	public List<InvoiceEntity> findAll() {		
		return this.invoiceDao.findAll();
	}

	@Override
	public InvoiceEntity save(InvoiceEntity e) {		
		return this.invoiceDao.save(e);
	}

}
