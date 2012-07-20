package app.domain.test.integration;

import static app.test.support.TestUtils.uuid;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import app.domain.Profile;
import app.domain.repo.ProfileRepository;
import app.domain.repo.impl.ProfileRepositoryImpl;

public class ProfileRepositoryIntegrationTest extends AbstractIntegrationTest {

	ProfileRepository repo;

	public void beforeTest() {
		repo = new ProfileRepositoryImpl(em);
	}

	@Test
	@Transactional
	public void testHelloProfileRepository() throws IOException {

		beforeTest();

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

		clear();
		log.info("cleared");

		Profile p2 = repo.findOne(id);
		log.info("find by id attempted");

		assertThat(p, not(sameInstance(p2)));
		assertThat(p, notNullValue());
		assertThat(p.getFirstName(), equalTo(first));
		assertThat(p.getLastName(), equalTo(last));
	}
}
