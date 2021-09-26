package bo.com.invoices.services;

import java.util.List;

import bo.com.invoices.entities.InvoiceEntity;

public interface InvoiceServ {
	
	 public InvoiceEntity findById(Long id); 
	 
	 public List<InvoiceEntity> findAll();
	 
	 public InvoiceEntity save(InvoiceEntity e);

}
