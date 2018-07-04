package br.com.candymachine.repository;
import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.candymachine.model.SalesModel;

public interface SalesRepository extends Repository<SalesModel, Integer> {
 
	void save(SalesModel sale);
 
	void delete(SalesModel sale);
 
	List<SalesModel> findAll();
 
	SalesModel findById(Integer id);
}