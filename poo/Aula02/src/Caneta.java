
public class Caneta {

	String modelo;
	String cor;
	float ponta;
	int carga;
	boolean tampada;

//Void não tem Retorno
	void status() {
		System.out.print("Uma caneta " + this.cor);
		System.out.println("Está tampada ? " + this.tampada);
	}

	void rabiscar() {

		if (this.tampada == true) {
			System.out.println("Erro! Não posso rabiscar");

		} else {
			System.out.println("Estou Rabiscando");
		}

	}

//referência ao próprio objeto
	void tampar() {

		this.tampada = true;

	}

	void destampar() {
		this.tampada = false;

	}

}
