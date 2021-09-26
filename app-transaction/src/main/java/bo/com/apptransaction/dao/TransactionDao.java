package bo.com.apptransaction.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bo.com.apptransaction.entities.TransactionCollection;

@Repository
public interface TransactionDao extends MongoRepository<TransactionCollection, String>{

}
