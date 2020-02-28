package com.tef.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class MovementProduct implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotNull(message = "A data e hora da movimentaçao é obrigatório!")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo da movimentação é obrigatorio!")
	private TypeMovement type;
	
	@NotNull(message = "A quantidade da movimentação é obrigatório!")
	private Double quantity;
	
	@ManyToOne	
	private Product product;	
		

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MovementProduct() {}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public TypeMovement getType() {
		return type;
	}

	public void setType(TypeMovement type) {
		this.type = type;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	
	
}
