package bo.com.apppay.services;

import java.util.List;

import bo.com.apppay.entities.OperationEntity;

public interface OperationServ {

	public OperationEntity findById(Long id);

	public List<OperationEntity> findAll();

	public OperationEntity save(OperationEntity e);

}
