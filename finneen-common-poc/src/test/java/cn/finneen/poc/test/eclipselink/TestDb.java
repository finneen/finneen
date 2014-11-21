package cn.finneen.poc.test.eclipselink;

import cn.finneen.poc.eclipselink.entity.Address;
import cn.finneen.poc.eclipselink.entity.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yaofeng on 2014/11/20.
 */
public class TestDb {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselink");
	EntityManager em = factory.createEntityManager();

	@Before
	public void before() {
		em.getTransaction().begin();
	}

	@After
	public void after() {
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setName("customer" + i);
			customer.setEmail("customer" + i + "@my.com");
			customer.setBirthday(Calendar.getInstance().getTime());

			Address addressHome = new Address();
			addressHome.setName("Home");
			addressHome.setDescription("Home");
			addressHome.setZipcode("123456");
			em.persist(addressHome);

			Address addressOffice = new Address();
			addressOffice.setName("Office");
			addressOffice.setDescription("Office");
			addressOffice.setZipcode("654321");
			em.persist(addressOffice);

			customer.addAddress(addressHome);
			customer.addAddress(addressOffice);
			em.persist(customer);
		}
	}

	@Test
	public void test1() {
		TypedQuery<Customer> q = em.createQuery("select c from Customer c", Customer.class);
		List<Customer> customers = q.getResultList();
		for(Customer c: customers) {
			System.out.println(c);
		}
	}
}
