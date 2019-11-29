package cursojava.poo;

import javax.swing.JOptionPane;

public class ToString {

	public static void main(String[] args) {

		String nome = JOptionPane.showInputDialog("Qual o nome do Aluno?");
		String idade = JOptionPane.showInputDialog("Qual o Idade do Aluno?");

		String nota1 = JOptionPane.showInputDialog("Digite a Nota 1");
		String nota2 = JOptionPane.showInputDialog("Digite a Nota 2");
		String nota3 = JOptionPane.showInputDialog("Digite a Nota 3");
		String nota4 = JOptionPane.showInputDialog("Digite a Nota 4");

		SetGet aluno = new SetGet();
		aluno.setNome(nome);
		aluno.setIdade(Integer.valueOf(idade));

		aluno.setNota1(Double.parseDouble(nota1));
		aluno.setNota2(Double.parseDouble(nota2));
		aluno.setNota3(Double.parseDouble(nota3));
		aluno.setNota4(Double.parseDouble(nota4));

		System.out.println(aluno.toString()); /* Descrição do Objeto na Memória */

	}

}
