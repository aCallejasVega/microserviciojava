package bo.com.invoices.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.invoices.entities.InvoiceEntity;
import bo.com.invoices.services.InvoiceServ;
import bo.com.invoices.services.InvoiceServImpl;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceServ invoiceServ;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();		
		try {
			InvoiceEntity invoice =  this.invoiceServ.findById(id);
			response.put("status", true);
			response.put("result", invoice);			
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
			List<InvoiceEntity> invoices =  this.invoiceServ.findAll();
			response.put("status", true);
			response.put("result", invoices);
			if(!invoices.isEmpty()) {
				return new ResponseEntity<>(response, HttpStatus.OK);	
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	

}
