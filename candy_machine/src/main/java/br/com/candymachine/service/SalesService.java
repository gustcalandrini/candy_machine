package br.com.candymachine.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.candymachine.model.ResponseModel;
import br.com.candymachine.model.SalesModel;
import br.com.candymachine.repository.SalesRepository;

@Service
@RestController
@RequestMapping("/service")
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param sale
	 * @return
	 */
	@RequestMapping(value = "/sales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel insert(@RequestBody SalesModel sale) {
		sale.setDate(new Date());
		System.out.println("SALE: " + sale.toString());
		try {
			this.salesRepository.save(sale);
			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * 
	 * @param sale
	 * @return
	 */
	@RequestMapping(value = "/sales", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel update(@RequestBody SalesModel sale) {

		try {

			this.salesRepository.save(sale);

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
	@RequestMapping(value = "/sales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<SalesModel> select() {

		return this.salesRepository.findAll();
	}

	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sales/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody SalesModel find(@PathVariable("id") Integer id) {

		return this.salesRepository.findById(id);
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id) {

		SalesModel salesModel = salesRepository.findById(id);

		try {

			salesRepository.delete(salesModel);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
