package br.com.candymachine.repository;
import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.candymachine.model.CostumerModel;

public interface CostumerRepository extends Repository<CostumerModel, Integer> {
 
	void save(CostumerModel costumer);
 
	void delete(CostumerModel costumer);
 
	List<CostumerModel> findAll();
 
	CostumerModel findById(Integer id);
}