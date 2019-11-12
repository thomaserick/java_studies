package cursojava.constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.poo.Aluno;
import cursojava.poo.ListArray;

public class Main {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Login");
		String senha = JOptionPane.showInputDialog("Senha");

		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {

			List<Aluno> alunos = new ArrayList<Aluno>();

			/*
			 * É uma lista dentro dela temos uma Chave que identifica um sequencia de
			 * valores também
			 *
			 * Muito usado para fazer importação
			 */

			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			/*
			 * List<Aluno> alunosAprovados = new ArrayList<Aluno>(); List<Aluno>
			 * alunosReprovados = new ArrayList<Aluno>(); List<Aluno> alunosRecuperacao =
			 * new ArrayList<Aluno>();
			 */
			for (int qtd = 1; qtd <= 5; qtd++) {

				String nome = JOptionPane.showInputDialog("Qual o nome do Aluno?");
				String idade = JOptionPane.showInputDialog("Qual o Idade do Aluno?");
				Aluno aluno = new Aluno();
				aluno.setNome(nome);
				aluno.setIdade(Integer.valueOf(idade));

				for (int pos = 1; pos <= 4; pos++) {

					String nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina" + pos + ":");
					String notaDisciplina = JOptionPane.showInputDialog("Nota da Disciplina " + pos + ":");

					ListArray disciplina = new ListArray();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno.getDisciplinas().add(disciplina);

				}

				/*
				 * int mbresult = JOptionPane.showConfirmDialog(null,
				 * "Deseja remover alguma Disciplina ?"); if (mbresult == 0) {
				 * 
				 * int contRemover = 0;
				 * 
				 * while (contRemover == 0) {
				 * 
				 * String disciplinaRemover =
				 * JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4?");
				 * aluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() -
				 * 1);
				 * 
				 * contRemover = JOptionPane.showConfirmDialog(null,
				 * "Deseja Remover outra Disciplina?"); }
				 * 
				 * }
				 */

				alunos.add(aluno);
			}

			/* Separados em Listas */

			/* Usando HASH */

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {

				if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);

				} else {
					if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					} else {
						if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
							maps.get(StatusAluno.RECUPERACAO).add(aluno);
						}
					}
				}
			}

			/*
			 * for (Aluno aluno : alunos) {
			 * 
			 * if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
			 * alunosAprovados.add(aluno); } else { if
			 * (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
			 * alunosReprovados.add(aluno); } else { if
			 * (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
			 * alunosAprovados.add(aluno); } } } }
			 */
			System.out.println("Lista dos Aprovados");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Resultado =" + aluno.getNome());
			}
			System.out.println("---------------------------------");

			System.out.println("Lista dos Reprovados");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Resultado = " + aluno.getNome());
			}

		}
	}
}