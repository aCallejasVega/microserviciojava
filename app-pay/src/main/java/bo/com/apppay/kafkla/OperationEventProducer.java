package bo.com.apppay.kafkla;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bo.com.apppay.entities.OperationEntity;
import bo.com.apppay.services.OperationServ;



@Component
public class OperationEventProducer {
	private Logger log = LoggerFactory.getLogger(OperationEventProducer.class);
	String topic = "transaction-events";
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private OperationServ operationServ;
	
	
	public ListenableFuture<SendResult<Integer, String>> sendInvoicesEvent(OperationEntity operation)
			throws JsonProcessingException {
		log.info("*************** MICROSERVICE PAY *******************");
		Integer key = operation.getIdOperation();
		String value = objectMapper.writeValueAsString(operation);

		ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, topic);
		ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				System.out.println("Inserto bien");
			}
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Algo esta mal");
				handleFailure(key, value, ex);
			}
		});
		return listenableFuture;
	}
	
	
	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
		List<Header> recordHeaders = List.of(new RecordHeader("deposit-event-source", "scanner".getBytes()));
		return new ProducerRecord<>(topic, null, key, value, recordHeaders);
	}

	private void handleFailure(Integer key, String value, Throwable ex) {
		log.error("Error enviando el mensage y el error es {}", ex.getMessage());
		try {

		} catch (Throwable throwable) {
			log.error("Error en OnFailure {}", throwable.getMessage());
		}
	}



}
