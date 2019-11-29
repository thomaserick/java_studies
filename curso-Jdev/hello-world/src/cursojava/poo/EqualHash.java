package cursojava.poo;

/*Equal / HashCode Diferenciar Objetos*/

public class EqualHash {

	public static void main(String[] args) {

		SetGet aluno = new SetGet();
		aluno.setNome("Thomas");

		SetGet aluno2 = new SetGet();
		aluno2.setNome("Thomas");

		if (aluno.equals(aluno2)) {
			System.out.println("Igual");
		} else {
			System.out.println("Não Igual");
		}

	}

}
