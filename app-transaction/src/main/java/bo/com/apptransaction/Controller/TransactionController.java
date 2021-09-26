package bo.com.apptransaction.Controller;

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

import bo.com.apptransaction.entities.TransactionCollection;
import bo.com.apptransaction.services.TransactionServ;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

	@Autowired
	private TransactionServ transactionServ;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Map<String, Object> response = new HashMap<>();
		try {
			TransactionCollection invoice = this.transactionServ.findById(id);
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
			List<TransactionCollection> invoices = this.transactionServ.findAll();
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
	public ResponseEntity<?> save(@RequestBody TransactionCollection t) {
		Map<String, Object> response = new HashMap<>();
		try {
			TransactionCollection transaction = this.transactionServ.save(t);
			response.put("status", true);
			response.put("result", transaction);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
