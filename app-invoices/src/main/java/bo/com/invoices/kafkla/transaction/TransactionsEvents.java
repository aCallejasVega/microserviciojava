package bo.com.invoices.kafkla.transaction;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bo.com.invoices.dto.OperationDto;
import bo.com.invoices.entities.InvoiceEntity;
import bo.com.invoices.services.InvoiceServ;

@Service
public class TransactionsEvents {
	private Logger log = LoggerFactory.getLogger(TransactionsEvents.class);
	@Autowired
	private InvoiceServ invoiceServ;
	@Autowired
	private ObjectMapper objectMapper ;	
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		
		InvoiceEntity invoice = new InvoiceEntity();
		OperationDto operation = objectMapper.readValue(consumerRecord.value(), OperationDto.class);
		invoice = this.invoiceServ.findById(operation.getIdInvoice());
		invoice.setState(2);
		
		log.info("Pago la deuda con id ="+invoice.getIdInvoice());
		invoiceServ.save(invoice);
	}

}
