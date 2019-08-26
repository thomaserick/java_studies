public class Main {

// Método Principal
	public static void main(String[] args) {

		Caneta c1 = new Caneta();

		c1.cor = "azul;";
		c1.ponta = 0.5f;
		c1.destampar();

		c1.status();
		c1.rabiscar();

		Caneta c2 = new Caneta();

		c2.cor = "Preta";
		c2.modelo = "Fib";
		c2.destampar();
		c2.status();
		c2.rabiscar();

	}

}
