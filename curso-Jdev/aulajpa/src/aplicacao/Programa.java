package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		/*
		 * Pessoa p1 = new Pessoa(null, "Thomas Erick", "thomas@gmail.com"); Pessoa p2 =
		 * new Pessoa(null, "Jaqueline", "jaque@gmail.com");
		 * entityManager.getTransaction().begin(); entityManager.persist(p1);
		 * entityManager.persist(p2); entityManager.getTransaction().commit();
		 */

		Pessoa p = entityManager.find(Pessoa.class, 2L);
		entityManager.getTransaction().begin();
		entityManager.remove(p);
		entityManager.getTransaction().commit();

		System.out.println(p);
		System.out.println("Tudo ok!");
		entityManager.close();
		entityManagerFactory.close();

	}

}
