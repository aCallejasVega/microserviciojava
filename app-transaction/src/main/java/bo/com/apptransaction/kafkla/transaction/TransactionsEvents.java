package bo.com.apptransaction.kafkla.transaction;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bo.com.apptransaction.dto.OperationDto;
import bo.com.apptransaction.entities.TransactionCollection;
import bo.com.apptransaction.services.TransactionServ;


@Service
public class TransactionsEvents {
	private Logger log = LoggerFactory.getLogger(TransactionsEvents.class);
	@Autowired
	private TransactionServ transactionServ;
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		System.out.println("######################## processTransactionEvent");
		TransactionCollection transaction=new TransactionCollection();
		TransactionCollection operation=objectMapper.readValue(consumerRecord.value(), TransactionCollection.class);

	
		
		log.info("La deuda se almaceno correctamente en transacciones ="+transaction.getIdInvoice());
		this.transactionServ.save(operation);
	}
	

}
