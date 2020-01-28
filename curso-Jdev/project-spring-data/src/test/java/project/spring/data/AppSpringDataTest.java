package project.spring.data;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project.spring.data.dao.InterfaceSpringData;
import project.spring.data.model.UserSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })

public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringData interfaceSpringData;

	@Test
	public void testeInsert() {
		UserSpringData userSpringData = new UserSpringData();
		userSpringData.setName("Lucas");
		userSpringData.setPassword("123");
		userSpringData.setLogin("lucas");
		userSpringData.setEmail("lucas@gmail.com");
		userSpringData.setAge("25");
		interfaceSpringData.save(userSpringData);
	}

	@Test
	public void testeConsulta() {

		Optional<UserSpringData> userSpringData = interfaceSpringData.findById(4L);

		System.out.println(userSpringData.get().getId());
		System.out.println(userSpringData.get().getName());
		System.out.println(userSpringData.get().getLogin());
		System.out.println(userSpringData.get().getEmail());

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

}
