package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		new Thread() {

			public void run() { /* Executa */
				/* Código da Rotina */

				/* Executar rotinas com uma faixa de tempo */

				for (int pos = 0; pos < 10; pos++) {

					System.out.println("Executanto rotina E-mail");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			};

		}.start(); /* Liga a Thread que ficara processando */

		System.out.println("Chegou o fim da Thread ");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o Usuário");

	}

}
