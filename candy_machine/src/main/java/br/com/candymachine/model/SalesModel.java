/**
 * 
 */
package br.com.candymachine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "sales")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer sale_id;

	@Column(name = "costumer")
	private String costumer;

	@Column(name = "employee")
	private String employee;

	@Column(name = "product")
	private String product;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "value")
	private double value;

	@Column(name = "`change`", nullable = true)
	private double change;

	@Column(name = "final_value")
	private double finalValue;

	@Column(name = "date")
	private Date date;

	public SalesModel() {
	}

	public SalesModel(Integer sale_id, String costumer, String employee, String product, int quantity, double value,
			double change, double finalValue, Date date) {
		this.sale_id = sale_id;
		this.costumer = costumer;
		this.employee = employee;
		this.product = product;
		this.quantity = quantity;
		this.value = value;
		this.change = change;
		this.finalValue = finalValue;
		this.date = date;
	}

	public Integer getSale_id() {
		return sale_id;
	}

	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}

	public String getCostumer() {
		return costumer;
	}

	public void setCostumer(String costumer) {
		this.costumer = costumer;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public double getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(double finalValue) {
		this.finalValue = finalValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SalesModel [sale_id=" + sale_id + ", costumer=" + costumer + ", employee=" + employee + ", product="
				+ product + ", quantity=" + quantity + ", value=" + value + ", change=" + change + ", finalValue="
				+ finalValue + ", date=" + date + "]";
	}
	
}
