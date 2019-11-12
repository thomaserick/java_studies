package javacurso.classes;

import javax.swing.JOptionPane;

import cursojava.interfaces.PermitirAcesso;

public class Main {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Login");
		String senha = JOptionPane.showInputDialog("Senha");

		PermitirAcesso permitirAcesso = new Secretario(login, senha);

		if (permitirAcesso.autenticar()) {
			System.out.println("Logado com Sucesso");

		} else {

			System.out.println("Falha na autenticação");
		}

		Aluno aluno = new Aluno();

		aluno.setNome("Thomas");
		aluno.setNomeEscola("Unip");
		aluno.setIdade(22);

		Diretor diretor = new Diretor();
		diretor.setNome("Lucas");
		diretor.setRegistroGeral("1231321");
		diretor.setIdade(25);

		Secretario secretario = new Secretario();
		secretario.setNome("Thaila");
		secretario.setExperiencia("Financeiro");
		secretario.setIdade(18);

		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);

		System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());

		System.out.println("Salário do Aluno: " + aluno.getNome() + " = " + aluno.salario());
		System.out.println("Salário do Diretor: " + diretor.getNome() + " = " + diretor.salario());
		System.out.println("Salário da Secretaria: " + secretario.getNome() + " = " + secretario.salario());

	}

}
