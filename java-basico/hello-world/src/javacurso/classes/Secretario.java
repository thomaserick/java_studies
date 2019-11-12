package javacurso.classes;

import cursojava.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargoString;
	private String experiencia;

	private String login;
	private String senha;

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargoString=" + nivelCargoString + ", experiencia="
				+ experiencia + ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento
				+ ", registroGeral=" + registroGeral + ", numeroCpf=" + numeroCpf + ", nomePai=" + nomePai
				+ ", nomeMae=" + nomeMae + "]";
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargoString() {
		return nivelCargoString;
	}

	public void setNivelCargoString(String nivelCargoString) {
		this.nivelCargoString = nivelCargoString;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public double salario() {
		return 1736.36;
	}

	@Override
	public boolean autenticar() {
		// TODO Auto-generated method stub
		return login.equals("admin") && senha.equals("admin");
	}

}
