package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		Thread threadNfe = new Thread(thread2);
		threadNfe.start();

		System.out.println("Chegou o fim da Thread ");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o Usuário");

	}

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {

				System.out.println("Executanto rotina Validação");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	};

	private static Runnable thread2 = new Runnable() {
		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {

				System.out.println("Executanto rotina E-mail");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
}
