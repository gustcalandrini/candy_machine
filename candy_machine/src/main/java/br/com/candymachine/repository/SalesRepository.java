package br.com.candymachine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.candymachine.model.SalesModel;

public interface SalesRepository extends Repository<SalesModel, Integer> {

	void save(SalesModel sale);

	void delete(SalesModel sale);

	@Query(value = "SELECT * FROM sales WHERE date BETWEEN CURDATE() - INTERVAL 5 DAY AND CURDATE()", nativeQuery = true)
	List<SalesModel> findAll();

	SalesModel findById(Integer id);
}