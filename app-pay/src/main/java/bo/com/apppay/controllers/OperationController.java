package bo.com.apppay.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.apppay.entities.OperationEntity;
import bo.com.apppay.kafkla.OperationEventProducer;
import bo.com.apppay.services.OperationServ;

@RestController
@RequestMapping("api/pay")
public class OperationController {

	@Autowired
	private OperationServ operationServ;
	@Autowired
	private OperationEventProducer eventProducer;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			OperationEntity operation = this.operationServ.findById(id);
			
			response.put("status", true);
			response.put("result", operation);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<OperationEntity> invoices = this.operationServ.findAll();
			response.put("status", true);
			response.put("result", invoices);
			if (!invoices.isEmpty()) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody OperationEntity o) {
		Map<String, Object> response = new HashMap<>();
		try {
			OperationEntity operation = this.operationServ.save(o);
			this.eventProducer.sendInvoicesEvent(operation);
			response.put("status", true);
			response.put("result", operation);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
