package cursojava.matriz;

public class Matriz {

	public static void main(String[] args) {

		int notas[][] = new int[2][3];

		notas[0][0] = 80;
		notas[0][1] = 90;
		notas[0][2] = 70;

		notas[1][0] = 40;
		notas[1][1] = 50;
		notas[1][2] = 30;

		for (int posl = 0; posl < notas.length; posl++) {

			System.out.println("Linha" + posl);

			for (int posc = 0; posc < notas[posl].length; posc++) {

				System.out.println("Coluna" + notas[posl][posc]);

			}

		}

	}

}
