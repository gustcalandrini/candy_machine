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

	@Column(name = "id_product")
	private int idProduct;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "value")
	private float value;

	@Column(name = "`change`")
	private float change;

	@Column(name = "final_value")
	private float finalValue;

	@Column(name = "date")
	private Date date;

	public SalesModel() {
	}

	public SalesModel(Integer id, String quantity, float value, float change, float final_value) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.value = value;
		this.change = change;
		this.finalValue = final_value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
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
		return finalValue;
	}

	public void setFinal_value(float finalValue) {
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
