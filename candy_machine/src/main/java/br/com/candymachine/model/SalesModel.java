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
	@Column
	private Integer sale_id;

	private Integer cost_id;

	private Integer emp_id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "costumer_id")
	private CostumerModel costumer;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private EmployeeModel employee;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
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

	public SalesModel(Integer sale_id, Integer costId, Integer empId, CostumerModel costumer, EmployeeModel employee,
			ProductModel product, int quantity, double value, double change, double finalValue, Date date) {
		super();
		this.sale_id = sale_id;
		this.cost_id = costId;
		this.emp_id = empId;
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

	public Integer getCostId() {
		return cost_id;
	}

	public void setCostId(Integer costId) {
		this.cost_id = costId;
	}

	public Integer getEmpId() {
		return emp_id;
	}

	public void setEmpId(Integer empId) {
		this.emp_id = empId;
	}

	public Integer getId() {
		return sale_id;
	}

	public void setId(Integer id) {
		this.sale_id = id;
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
		return "SalesModel [sale_id=" + sale_id + ", costId=" + cost_id + ", employeeId=" + emp_id + ", costumer="
				+ costumer + ", employee=" + employee + ", product=" + product + ", quantity=" + quantity + ", value="
				+ value + ", change=" + change + ", finalValue=" + finalValue + ", date=" + date + "]";
	}

}
