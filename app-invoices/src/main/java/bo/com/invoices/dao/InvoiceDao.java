package bo.com.invoices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.com.invoices.entities.InvoiceEntity;

@Repository
public interface InvoiceDao extends JpaRepository<InvoiceEntity, Long>  {
	
	@Query("Select i from InvoiceEntity i Where i.idInvoice= :idInvoice ")
	public Optional<InvoiceEntity> findById(@Param("idInvoice") Long idInvoice);
	
	/*@Query("Select i from InvoiceEntity i ")
	public List<InvoiceEntity> findAll();*/

}
