package app.service.test.unit;

import static app.test.support.TestUtils.uuid;
import org.testng.annotations.Test;

import app.service.profile.ProfileDto;

public class ProfileServiceUnitTest extends AbstractUnitTest {

	// TODO: Mockito EntityManager

	@Test
	public void testSaveNewProfile() {
		ProfileDto dto = new ProfileDto();
		String first = uuid();
		String last = uuid();

		dto.setFirstName(first);
		dto.setLastName(last);

		// TODO

	}
}
