package javacurso.classes;

import javax.swing.JOptionPane;

import cursojava.classesaux.FuncaoAutenticacao;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		try {

			String login = JOptionPane.showInputDialog("Login");
			String senha = JOptionPane.showInputDialog("Senha");

			// FuncaoAutenticacao auth = new FuncaoAutenticacao();

			if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {
				System.out.println("Logado com Sucesso");

			} else {

				System.out.println("Falha na autenticação");
			}

			if (new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {
				System.out.println("Logado com Sucesso");

			} else {

				System.out.println("Falha na autenticação");
			}

			Aluno aluno = new Aluno();

			aluno.setNome("Thomas");
			aluno.setNomeEscola("Unip");
			aluno.setIdade(25);

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

		} catch (NullPointerException e) {

			/* Imprime erro no Console Java */
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erro Null!");

		} catch (Exception e) {

			/* Imprime erro no Console Java */
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erro ao processar!");

			StringBuilder saida = new StringBuilder();

			for (int pos = 0; pos < e.getStackTrace().length; pos++) {

				saida.append("\n Classe de Erro: " + e.getStackTrace()[pos].getClassName());
				saida.append("\n Método de Erro: " + e.getStackTrace()[pos].getMethodName());
				saida.append("\n Linha de Erro: " + e.getStackTrace()[pos].getLineNumber());
			}
		} finally {

			/* Sempre é executado ocorrendo erros ou não */

			System.out.println("Sempre será executado o finally");

		}

	}

}
