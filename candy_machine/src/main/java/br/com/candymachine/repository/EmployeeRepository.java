package br.com.candymachine.repository;
import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.candymachine.model.EmployeeModel;

public interface EmployeeRepository extends Repository<EmployeeModel, Integer> {
 
	void save(EmployeeModel pessoa);
 
	void delete(EmployeeModel pessoa);
 
	List<EmployeeModel> findAll();
 
	EmployeeModel findById(Integer id);
}