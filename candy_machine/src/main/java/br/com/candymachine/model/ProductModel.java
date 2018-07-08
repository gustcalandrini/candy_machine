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
 
@Table(name="products")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer product_id;
 
	@Column(name="description")
	private String  description;

	@Column(name="price")
	private double price;

	public ProductModel() {}

	public ProductModel(Integer id, String description, double price) {
		super();
		this.product_id = id;
		this.description = description;
		this.price = price;
	}

	public Integer getId() {
		return product_id;
	}

	public void setId(Integer id) {
		this.product_id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
 
}

