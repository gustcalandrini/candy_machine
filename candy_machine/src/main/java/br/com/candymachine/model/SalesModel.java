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
 
@Table(name="sales")
@Entity
public class SalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sales")
	private Integer id;
 
	@Column(name="quantity")
	private String  quantity;

	@Column(name="value")
	private float  value;
	
	@Column(name="change")
	private float change;
	
	@Column(name="final_value")
	private float  final_value;
	
	public SalesModel() {}
	
	public SalesModel(Integer id, String quantity, float value, float change, float final_value) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.value = value;
		this.change = change;
		this.final_value = final_value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public float getFinal_value() {
		return final_value;
	}

	public void setFinal_value(float final_value) {
		this.final_value = final_value;
	}

	
	
 
}

