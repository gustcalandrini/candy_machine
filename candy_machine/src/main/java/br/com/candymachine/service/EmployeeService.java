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

import br.com.candymachine.model.EmployeeModel;
import br.com.candymachine.model.ResponseModel;
import br.com.candymachine.repository.EmployeeRepository;
 
@Service
@RestController
@RequestMapping("/service")
public class EmployeeService {
 
	@Autowired
	private EmployeeRepository employeeRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/employee", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel insert(@RequestBody EmployeeModel employee){
 
 
		try {
 
			this.employeeRepository.save(employee);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/employee", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel update(@RequestBody EmployeeModel employee){
 
		try {
 
			this.employeeRepository.save(employee);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */
	@RequestMapping(value="/employee", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<EmployeeModel> select(){
 
		return this.employeeRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/employee/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody EmployeeModel find(@PathVariable("id") Integer id){
 
		return this.employeeRepository.findById(id);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/employee/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id){
 
		EmployeeModel employeeModel = employeeRepository.findById(id);
 
		try {
 
			employeeRepository.delete(employeeModel);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}
