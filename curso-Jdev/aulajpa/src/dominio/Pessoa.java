package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String name;
	private String email;

	public Pessoa() {

	}

	public Pessoa(Long id, String name, String email) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
