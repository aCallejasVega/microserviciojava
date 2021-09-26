package bo.com.apppay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.com.apppay.dao.OperationDao;
import bo.com.apppay.entities.OperationEntity;

@Service
public class OperationServImpl implements OperationServ {
	@Autowired
	private OperationDao operationDao;

	@Override
	public OperationEntity findById(Long id) {
		
		return this.operationDao.findById(id).orElse(null);
	}

	@Override
	public List<OperationEntity> findAll() {		
		return this.operationDao.findAll();
	}

	@Override
	public OperationEntity save(OperationEntity e) {
		
		return this.operationDao.save(e);
	}

}
