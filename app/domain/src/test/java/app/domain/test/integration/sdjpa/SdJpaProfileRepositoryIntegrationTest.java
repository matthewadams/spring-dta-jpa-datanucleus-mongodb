package app.domain.test.integration.sdjpa;

import static app.test.support.TestUtils.uuid;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import app.domain.Profile;
import app.domain.repo.sdjpa.ProfileRepository;
import app.test.support.AbstractDataSourcelessTransactionalTestNGSpringContextTests;

@ContextConfiguration("classpath*:META-INF/spring/*.xml")
public class SdJpaProfileRepositoryIntegrationTest extends
		AbstractDataSourcelessTransactionalTestNGSpringContextTests {

	protected static final Logger log = LoggerFactory
			.getLogger(SdJpaProfileRepositoryIntegrationTest.class);

	@Resource
	ProfileRepository repo;

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	public void testSaveProfile() {

		Profile p = new Profile();

		assertThat(p, notNullValue());

		String first = uuid();
		p.setFirstName(first);

		String last = uuid();
		p.setLastName(last);

		repo.save(p);

		String id = p.getId();

		repo.flush();
		log.info("flushed");

		assertThat(id, notNullValue());

		em.clear();
		log.info("cleared");

		Profile p2 = repo.findOne(id);
		log.info("find by id attempted");

		assertThat(p, not(sameInstance(p2)));
		assertThat(p, notNullValue());
		assertThat(p.getFirstName(), equalTo(first));
		assertThat(p.getLastName(), equalTo(last));
	}
}
