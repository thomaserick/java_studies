package cursojava.poo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		/*
		 * 1 Pesso SetGet setget = new SetGet(); setget.setNome("TEF");
		 * setget.setIdade(10); setget.setDataNascimento("09-11-1989");
		 * 
		 * setget.setNota1(90); setget.setNota2(70); setget.setNota3(80);
		 * setget.setNota4(100);
		 * 
		 * System.out.println("Nome é : " + setget.getNome());
		 * System.out.println("Média da Nota é :" + setget.getMediaNota());
		 * System.out.println("Aluno :" + setget.getNome() + " " +
		 * (setget.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		 * 
		 * 2 Pessoa SetGet setget2 = new SetGet(); setget2.setNome("Jaque");
		 * setget2.setIdade(25); setget2.setDataNascimento("09-11-1994");
		 * setget2.setNota1(60); setget2.setNota2(60); setget2.setNota3(60);
		 * setget2.setNota4(60);
		 * 
		 * System.out.println(" "); System.out.println("Nome é : " + setget2.getNome());
		 * System.out.println("Média da Nota é :" + setget2.getMediaNota());
		 * 
		 * Média de Notas
		 * 
		 * System.out .println("Aluno:" + setget2.getNome() + " " +
		 * (setget2.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		 * 
		 */

		/*
		 * Aluno aluno = new Aluno(); aluno.setNome("Jaque"); aluno.setIdade(25);
		 * aluno.setDataNascimento("09-11-1994"); aluno.setNota1(60);
		 * aluno.setNota2(60); aluno.setNota3(60); aluno.setNota4(60);
		 * 
		 * System.out.println(" "); System.out.println("Nome é : " + aluno.getNome());
		 * 
		 * ListArray disciplina1 = new ListArray();
		 * disciplina1.setDisciplina("Banco de Dados"); disciplina1.setNota(50);
		 * 
		 * ListArray disciplina2 = new ListArray();
		 * disciplina2.setDisciplina("Matemática"); disciplina2.setNota(50);
		 * 
		 * ListArray disciplina3 = new ListArray(); disciplina3.setDisciplina("Inglês");
		 * 
		 * disciplina3.setNota(70);
		 * 
		 * aluno.getDisciplinas().add(disciplina1);
		 * aluno.getDisciplinas().add(disciplina2);
		 * aluno.getDisciplinas().add(disciplina3);
		 * 
		 * System.out.println("Média da Nota é :" + aluno.getMediaNota());
		 */

		List<Aluno> alunos = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 2; qtd++) {

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

			int mbresult = JOptionPane.showConfirmDialog(null, "Deseja remover alguma Disciplina ?");
			if (mbresult == 0) {

				int contRemover = 0;

				while (contRemover == 0) {

					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4?");
					aluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - 1);

					contRemover = JOptionPane.showConfirmDialog(null, "Deseja Remover outra Disciplina?");
				}

			}

			alunos.add(aluno);
		}

		/*
		 * for (Aluno aluno : alunos) {
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("Thomas")) {
		 * 
		 * alunos.remove(aluno); break;
		 * 
		 * } else { System.out.println(aluno); System.out.println("Média do Aluno: " +
		 * aluno.getMediaNota()); System.out.println(aluno.getAlunoAprovado2());
		 * System.out.println("-------------------------------------------------------")
		 * ;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * for (Aluno aluno : alunos) {
		 * 
		 * System.out.println(aluno.getNome()); System.out.println("Matérias");
		 * 
		 * for (ListArray disciplina : aluno.getDisciplinas()) {
		 * 
		 * System.out.println(disciplina.getDisciplina());
		 * 
		 * }
		 * 
		 * }
		 */

		/* Percorrer lista por posições */

		for (int pos = 0; pos < alunos.size(); pos++) {

			Aluno aluno = alunos.get(pos);

			if (aluno.getNome().equalsIgnoreCase("Thomas")) {
				Aluno trocar = new Aluno();
				trocar.setNome("Aluno Trocado");

				ListArray disciplina = new ListArray();
				disciplina.setDisciplina("Matemática");
				disciplina.setNota(10);

				trocar.getDisciplinas().add(disciplina);

				alunos.set(pos, trocar);

				aluno = alunos.get(pos);

			}

			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Média do aluno: " + aluno.getMediaNota());
			System.out.println("Resultado: " + aluno.getAlunoAprovado2());
			System.out.println("-----------------------------------------");

			for (ListArray disc : aluno.getDisciplinas()) {
				System.out.println("Máterias :" + disc.getDisciplina());
			}

		}

	}

}
