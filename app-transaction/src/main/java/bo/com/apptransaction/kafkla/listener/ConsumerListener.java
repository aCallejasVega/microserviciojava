package bo.com.apptransaction.kafkla.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import bo.com.apptransaction.kafkla.transaction.TransactionsEvents;

@Component
public class ConsumerListener {
	private Logger log = LoggerFactory.getLogger(ConsumerListener.class);

	@Autowired
	private TransactionsEvents transactionEvents;

	@KafkaListener(topics = { "transaction-events" })
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		log.info("*************** MICROSERVICE TRANSACTION *******************");
		log.info("ConsumerRecord : {}", consumerRecord.value());
		this.transactionEvents.processTransactionEvent(consumerRecord);
	}
}
