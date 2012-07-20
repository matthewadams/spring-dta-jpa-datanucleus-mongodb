package app.service.test.integration;

import static app.test.support.TestUtils.uuid;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.domain.repo.ProfileRepository;
import app.domain.repo.impl.ProfileRepositoryImpl;
import app.service.profile.ProfileDto;
import app.service.profile.ProfileService;
import app.service.profile.impl.ProfileServiceImpl;

public class ProfileServiceIntegrationTest extends AbstractIntegrationTest {

	protected ProfileService svc;

	@Override
	@BeforeMethod
	public void beforeMethod() {

		super.beforeMethod();

		ProfileRepository repo = new ProfileRepositoryImpl(em);
		svc = new ProfileServiceImpl(repo);
	}

	@Override
	@AfterMethod
	public void afterMethod() {

		svc = null;
		super.afterMethod();
	}

	@Test
	@Transactional
	public void testProfileService() {
		String first = uuid();
		String last = uuid();

		ProfileDto dto = new ProfileDto();
		dto.setFirstName(first);
		dto.setLastName(last);

		String id = svc.save(dto);

		assertThat(id, notNullValue());
	}
}
