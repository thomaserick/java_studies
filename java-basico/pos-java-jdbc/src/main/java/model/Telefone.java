package model;

public class Telefone {

	private long id;
	private String numero;
	private String tipo;
	private Long usertel;

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", usertel=" + usertel + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUsertel() {
		return usertel;
	}

	public void setUsertel(Long usertel) {
		this.usertel = usertel;
	}

}
