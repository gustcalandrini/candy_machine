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

@Table(name = "sales")
@Entity
public class SalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sales")
	private Integer id;
	
	@Column(name="id_costumer")
	private int idCostumer;
	
	@Column(name="id_employee")
	private int idEmployee;

	@Column(name = "id_product")
	private int idProduct;

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

	public SalesModel(Integer id, int idCostumer, int idEmployee, int idProduct, int quantity, double value,
			double change, double finalValue, Date date) {
		super();
		this.id = id;
		this.idCostumer = idCostumer;
		this.idEmployee = idEmployee;
		this.idProduct = idProduct;
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
	
	public int getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(int idCostumer) {
		this.idCostumer = idCostumer;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
		return "SalesModel [id=" + id + ", idProduct=" + idProduct + ", quantity=" + quantity + ", value=" + value
				+ ", change=" + change + ", finalValue=" + finalValue + ", date=" + date + "]";
	}

}
