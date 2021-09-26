package bo.com.apppay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.com.apppay.entities.OperationEntity;

@Repository
public interface OperationDao extends JpaRepository<OperationEntity, Long> {

}
