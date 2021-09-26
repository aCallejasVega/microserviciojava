package bo.com.apptransaction.entities;

import java.math.BigDecimal;
import java.util.Date;



import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class TransactionCollection {

	@BsonId
	private String id ; 
	private Long idInvoice;
	private BigDecimal amount;
	private Date date;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getIdInvoice() {
		return idInvoice;
	}
	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
