
public class Caneta {

	String modelo;
	String cor;
	float ponta;
	int carga;
	boolean tampada;

//Void n�o tem Retorno
	void status() {
		System.out.print("Uma caneta " + this.cor);
		System.out.println("Est� tampada ? " + this.tampada);
	}

	void rabiscar() {

		if (this.tampada == true) {
			System.out.println("Erro! N�o posso rabiscar");

		} else {
			System.out.println("Estou Rabiscando");
		}

	}

//refer�ncia ao pr�prio objeto
	void tampar() {

		this.tampada = true;

	}

	void destampar() {
		this.tampada = false;

	}

}
