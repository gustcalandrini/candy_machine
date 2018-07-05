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
 
@Table(name="costumer")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CostumerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_costumer")
	private Integer id;
 
	@Column(name="name")
	private String  name;

	public CostumerModel() {}

	public CostumerModel(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
}

