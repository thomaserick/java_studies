package cursojava.array;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor2 {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Thomas");
		aluno.setNomeEscola("Unip");

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Jaque");
		aluno2.setNomeEscola("Unip");

		double[] notas = { 6, 8, 9, 10 };
		double[] notasJava = { 5, 9, 7, 9 };

		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		disciplina.setNota(notas);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Php");
		disciplina2.setNota(notasJava);

		aluno.getDisciplinas().add(disciplina);
		aluno.getDisciplinas().add(disciplina2);

		aluno2.getDisciplinas().add(disciplina);
		aluno2.getDisciplinas().add(disciplina2);

		System.out.println("Nome do Aluno: " + aluno.getNome() + " Faculdade: " + aluno.getNomeEscola());

		System.out.println("---------Disciplina do Aluno--------");

		for (Disciplina disc : aluno.getDisciplinas()) {

			System.out.println("Disciplina:" + disc.getDisciplina());

			System.out.println("Notas da Disciplina:");

			double notaMax = 0.0;

			double notaMin = 0.0;

			for (int pos = 0; pos < disc.getNota().length; pos++) {

				System.out.println("Nota " + (pos + 1) + ": " + disc.getNota()[pos]);

				/* Maior Nota */
				if (pos == 0) {
					notaMax = disc.getNota()[pos];
				} else {
					if (disc.getNota()[pos] > notaMax) {
						notaMax = disc.getNota()[pos];
					}

				}

				/* Menor Nota */
				if (pos == 0) {
					notaMin = disc.getNota()[pos];
				} else {
					if (disc.getNota()[pos] < notaMin) {
						notaMin = disc.getNota()[pos];
					}

				}

			}

			System.out.println("Nota Maior:" + notaMax);
			System.out.println("Nota Maior:" + notaMin);
		}

		Aluno[] arrayAlunos = new Aluno[2];

		arrayAlunos[0] = aluno;
		arrayAlunos[1] = aluno2;

		for (int pos = 0; pos < arrayAlunos.length; pos++) {

			System.out.println("Nome do Aluno: " + arrayAlunos[pos].getNome());

			for (Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("Nome da Disciplina é:" + d.getDisciplina());
				for (int pos1 = 0; pos1 < d.getNota().length; pos1++) {
					System.out.println("Nota " + (pos + 1) + ": " + d.getNota()[pos1]);
				}

			}

		}

	}
}
