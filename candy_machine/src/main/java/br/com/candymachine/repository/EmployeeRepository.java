package br.com.candymachine.repository;
import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.candymachine.model.EmployeeModel;

public interface EmployeeRepository extends Repository<EmployeeModel, Integer> {
 
	void save(EmployeeModel employee);
 
	void delete(EmployeeModel employee);
 
	List<EmployeeModel> findAll();
 
	EmployeeModel findById(Integer id);
}