/**
 * 
 */
package br.com.candymachine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Table(name="employee")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer employee_id;
 
	@Column(name="name")
	private String  name;

	public EmployeeModel() {}

	public EmployeeModel(Integer id, String name) {
		this.employee_id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return employee_id;
	}

	public void setId(Integer id) {
		this.employee_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
}

