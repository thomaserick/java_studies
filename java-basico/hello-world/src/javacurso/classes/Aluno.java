package javacurso.classes;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

public class Aluno extends Pessoa {

	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Aluno() {

	}

	public Aluno(String nomePadrao) {
		super.nome = nomePadrao;
	}

	public Aluno(String nomePadrao, int idadePadrao) {
		super.nome = nomePadrao;
		idade = idadePadrao;
	}

	@Override
	public String toString() {
		return "SetGet [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", numeroCpf="
				+ numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", dataMatricula=" + dataMatricula
				+ ", nomeEscola=" + nomeEscola + ", serieMatriculada=" + serieMatriculado + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	/* Média do Aluno */
	public double getMediaNota() {

		double somaNotas = 0.0;

		for (Disciplina disciplina : disciplinas) {

			somaNotas += disciplina.getMediaNotas();
		}
		return somaNotas / disciplinas.size();

	}

	/* Retorna True/false */
	public boolean getAlunoAprovado() {

		double media = this.getMediaNota();
		if (media >= 7) {
			return true;
		} else {
			return false;
		}
	}

	public String getAlunoAprovado2() {

		double media = this.getMediaNota();
		if (media >= 5) {
			if (media >= 7) {
				return StatusAluno.APROVADO;
			} else
				return StatusAluno.RECUPERACAO;
		} else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public boolean pessoaMaiorIdade() {

		return idade >= 21;
	}

	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "Aluno maior de Idade" : "Aluno menor de Idade";
	}

	@Override
	public double salario() {
		return 1000;
	}

}
