package com.tef.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Product implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	@NotNull(message = "O campo descrição não pode ser nulo!")	
	@Size(min = 3, message = "O campo descrição precisa ter no mínimo 3 caracteres!")
    private String description;
	
	@NotNull(message = "O campo preço não pode ser nulo!")
	@Min(value = 0,message = "O campo preço não pode ser negativo.")
    private Double price;    

    @ManyToOne()    
    private Category category;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<MovementProduct> movementProducts;

    public Product(){}

   
    public List<MovementProduct> getMovementProducts() {
		return movementProducts;
	}


	public void setMovementProducts(List<MovementProduct> movementProducts) {
		this.movementProducts = movementProducts;
	}


	public Product(Integer id, String description, Double price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;	
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
	
    
}
