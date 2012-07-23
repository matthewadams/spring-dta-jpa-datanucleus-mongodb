package app.domain.test.integration;

import static app.test.support.TestUtils.uuid;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import app.domain.Profile;

public class ProfileIntegrationTest extends AbstractIntegrationTest {

	@Test
	@Transactional
	public void testHelloProfile() throws IOException {

		Profile p = new Profile();

		assertThat(p, notNullValue());

		String first = uuid();
		p.setFirstName(first);

		String last = uuid();
		p.setLastName(last);

		persist(p);

		String id = p.getId();

		flush();
		log.info("flushed");

		assertThat(id, notNullValue());

		clear();
		log.info("cleared");

		Profile p2 = em.find(Profile.class, id);
		log.info("find by id attempted");

		assertThat(p, not(sameInstance(p2)));
		assertThat(p, notNullValue());
		assertThat(p.getFirstName(), equalTo(first));
		assertThat(p.getLastName(), equalTo(last));
	}
}
