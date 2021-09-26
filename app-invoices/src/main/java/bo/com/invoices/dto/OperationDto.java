package bo.com.invoices.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OperationDto {

	private Integer idOperation;
	private Long idInvoice;
	private BigDecimal amount;
	private Date date;

	public OperationDto() {

	}

	public OperationDto(Integer idOperation, Long idInvoice, BigDecimal amount, Date date) {

		this.idOperation = idOperation;
		this.idInvoice = idInvoice;
		this.amount = amount;
		this.date = date;
	}

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
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
