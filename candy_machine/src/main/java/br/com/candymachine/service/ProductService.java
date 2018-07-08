package br.com.candymachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.candymachine.model.ProductModel;
import br.com.candymachine.model.ResponseModel;
import br.com.candymachine.repository.ProductRepository;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel insert(@RequestBody ProductModel product) {
		try {

			this.productRepository.save(product);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel update(@RequestBody ProductModel product) {
		try {

			this.productRepository.save(product);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ProductModel> select() {
		return this.productRepository.findAll();
	}

	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ProductModel find(@PathVariable("id") Integer id) {

		return this.productRepository.findById(id);
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id) {

		ProductModel productModel = productRepository.findById(id);
		
		try {
			productRepository.delete(productModel);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
