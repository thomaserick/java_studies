package cursojava.poo;

public class Construtor {

	String nome;
	int idade;
	String dataNascimento;
	String numeroCpf;
	String nomeMae;
	String nomePai;
	String dataMatricula;
	String nomeEscola;
	String serieMatriculada;

	/* Cria os dados na mamória */
	public Construtor() {

	}

	/* Receber valor */
	public Construtor(String nomePadrao) {
		nome = nomePadrao;
	}

	public Construtor(String nomePadrao, int idadePadrao) {
		nome = nomePadrao;
		idade = idadePadrao;

	}

}
