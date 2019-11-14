package cursojava.thread;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(2000);

		/* Executar rotinas com uma faixa de tempo */

		for (int pos = 0; pos < 10; pos++) {

			System.out.println("Executanto rotina E-mail");
		}

	}

}
