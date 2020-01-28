package project.spring.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project.spring.data.dao.InterfaceSpringData;
import project.spring.data.dao.InterfaceTelefone;
import project.spring.data.model.Telefone;
import project.spring.data.model.UserSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })

public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringData interfaceSpringData;

	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	public void testeInsert() {
		UserSpringData userSpringData = new UserSpringData();
		userSpringData.setName("Jaque");
		userSpringData.setPassword("123");
		userSpringData.setLogin("jaque");
		userSpringData.setEmail("jaqueline@gmail.com");
		userSpringData.setAge("27");
		interfaceSpringData.save(userSpringData);
	}

	@Test
	public void testeConsulta() {

		Optional<UserSpringData> userSpringData = interfaceSpringData.findById(1L);

		System.out.println(userSpringData.get().getId());
		System.out.println(userSpringData.get().getName());
		System.out.println(userSpringData.get().getLogin());
		System.out.println(userSpringData.get().getEmail());

		for (Telefone telefone : userSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}

	}

	@Test
	public void testeConsultaAll() {

		Iterable<UserSpringData> lista = interfaceSpringData.findAll();

		for (UserSpringData userSpringData : lista) {

			System.out.println(userSpringData.getId());
			System.out.println(userSpringData.getName());
			System.out.println(userSpringData.getLogin());
			System.out.println(userSpringData.getEmail());

			System.out.println("-----------------------------------");
		}

	}

	@Test
	public void testeUpdate() {

		Optional<UserSpringData> userSpringData = interfaceSpringData.findById(3L);

		UserSpringData data = userSpringData.get();
		data.setName("Jaqueline");

		interfaceSpringData.save(data);

	}

	@Test
	public void testeDelete() {

		interfaceSpringData.deleteById(4L);

	}

	@Test
	public void testeConsultaNome() {

		List<UserSpringData> list = interfaceSpringData.buscaPorNome("Tho");

		for (UserSpringData userSpringData : list) {

			System.out.println(userSpringData.getId());
			System.out.println(userSpringData.getName());
			System.out.println(userSpringData.getLogin());
			System.out.println(userSpringData.getEmail());

			System.out.println("-----------------------------------");
		}

	}

	@Test
	public void testeConsultaNomeParam() {

		UserSpringData userSpringData = interfaceSpringData.buscaPorNomeParam("Thomas");

		System.out.println(userSpringData.getId());
		System.out.println(userSpringData.getName());
		System.out.println(userSpringData.getLogin());
		System.out.println(userSpringData.getEmail());

	}

	@Test
	public void testeDeletePorNome() {

		interfaceSpringData.deletePorNome("Jaqueline");

	}

	@Test
	public void testeUpdatePorNome() {
		interfaceSpringData.updateEmailPorNome("thomaserick@gmail.com", "Thomas");
	}

	@Test
	public void testeInsertTelefone() {

		Optional<UserSpringData> userSpringData = interfaceSpringData.findById(1L);

		Telefone telefone = new Telefone();
		telefone.setNumero("14981050203");
		telefone.setTipo("Celular");
		telefone.setUserSpringData(userSpringData.get());

		interfaceTelefone.save(telefone);

	}

}
