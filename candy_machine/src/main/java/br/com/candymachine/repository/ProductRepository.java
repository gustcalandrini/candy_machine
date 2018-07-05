package br.com.candymachine.repository;
import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.candymachine.model.ProductModel;

public interface ProductRepository extends Repository<ProductModel, Integer> {
 
	void save(ProductModel product);
 
	void delete(ProductModel product);
 
	List<ProductModel> findAll();
 
	ProductModel findById(Integer id);
}