/**
 * 
 */
package br.com.candymachine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "sales")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sales")
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_costumer")
	private CostumerModel costumer;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employee")
	private EmployeeModel employee;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private ProductModel product;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "value")
	private double value;

	@Column(name = "`change`")
	private double change;

	@Column(name = "final_value")
	private double finalValue;

	@Column(name = "date")
	private Date date;

	public SalesModel() {
	}

	public SalesModel(Integer id, CostumerModel costumer, EmployeeModel employee, ProductModel product, int quantity,
			double value, double change, double finalValue, Date date) {
		super();
		this.id = id;
		this.costumer = costumer;
		this.employee = employee;
		this.product = product;
		this.quantity = quantity;
		this.value = value;
		this.change = change;
		this.finalValue = finalValue;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CostumerModel getCostumer() {
		return costumer;
	}

	public void setCostumer(CostumerModel costumer) {
		this.costumer = costumer;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "SalesModel [id=" + id + ", costumer=" + costumer + ", employee=" + employee + ", product=" + product
				+ ", quantity=" + quantity + ", value=" + value + ", change=" + change + ", finalValue=" + finalValue
				+ ", date=" + date + "]";
	}

}
