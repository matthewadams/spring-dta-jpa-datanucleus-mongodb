package app.service.test.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import app.test.support.AbstractDataSourcelessTransactionalTestNGSpringContextTests;

@ContextConfiguration("classpath*:META-INF/spring/*.xml")
public abstract class AbstractIntegrationTest extends
		AbstractDataSourcelessTransactionalTestNGSpringContextTests {

	protected static final Logger log = LoggerFactory
			.getLogger(AbstractIntegrationTest.class);

	@PersistenceUnit
	protected EntityManagerFactory emf;

	@PersistenceContext
	protected EntityManager em;

	@BeforeMethod
	public void beforeMethod() {
		Assert.assertNotNull(emf);

		// EntityManager em = EntityManagerFactoryUtils
		// .getTransactionalEntityManager(emf);

		Assert.assertNotNull(em);
	}

	@AfterMethod
	public void afterMethod() {
	}
}
