package br.com.candymachine.service;

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

import br.com.candymachine.model.CostumerModel;
import br.com.candymachine.model.ResponseModel;
import br.com.candymachine.repository.CostumerRepository;

@Service
@RestController
@RequestMapping("/service")
public class CostumerService {

	@Autowired
	private CostumerRepository costumerRepository;

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param costumer
	 * @return
	 */
	@RequestMapping(value = "/costumer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel insert(@RequestBody CostumerModel costumer) {
		try {

			this.costumerRepository.save(costumer);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * 
	 * @param costumer
	 * @return
	 */
	@RequestMapping(value = "/costumer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel update(@RequestBody CostumerModel costumer) {
		try {

			this.costumerRepository.save(costumer);

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
	@RequestMapping(value = "/costumer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<CostumerModel> select() {
		return this.costumerRepository.findAll();
	}

	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/costumer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody CostumerModel find(@PathVariable("id") Integer id) {

		return this.costumerRepository.findById(id);
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/costumer/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id) {

		CostumerModel costumerModel = costumerRepository.findById(id);

		try {

			costumerRepository.delete(costumerModel);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
