package cursojava.classesaux;

import cursojava.interfaces.PermitirAcesso;

/*Receber alguem que tem o contrato da interface de PermitirAcesso e chamar o autenticado*/

public class FuncaoAutenticacao {

	private PermitirAcesso permitirAcesso;

	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}

	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}

}
