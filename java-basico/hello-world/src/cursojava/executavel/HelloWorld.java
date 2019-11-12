package cursojava.executavel;

import javax.swing.JOptionPane;

public class HelloWorld {

	/* Teste do primeiro Projeto */

	public static void main(String[] args) {

		String nota1 = JOptionPane.showInputDialog("Digite a Nota 1");
		String nota2 = JOptionPane.showInputDialog("Digite a Nota 2");
		String nota3 = JOptionPane.showInputDialog("Digite a Nota 3");
		String nota4 = JOptionPane.showInputDialog("Digite a Nota 4");

		double nota1d = Double.parseDouble(nota1);
		double nota2d = Double.parseDouble(nota2);
		double nota3d = Double.parseDouble(nota3);
		double nota4d = Double.parseDouble(nota4);

		int media = (int) (nota1d + nota2d + nota3d + nota4d) / 4;

		System.out.println("A média é: " + media);

		JOptionPane.showMessageDialog(null, "A média é: " + media);

	}

}
