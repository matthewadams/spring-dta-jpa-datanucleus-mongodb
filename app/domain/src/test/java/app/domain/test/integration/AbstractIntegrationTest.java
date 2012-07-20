package app.domain.test.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

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

	protected void persist(Object... objects) {
		for (Object object : objects) {
			em.persist(object);
		}
	}

	protected void flush() {
		em.flush();
	}

	protected void clear() {
		em.clear();
	}
}
